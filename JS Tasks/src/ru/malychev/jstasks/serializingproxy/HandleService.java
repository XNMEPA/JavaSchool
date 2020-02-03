package ru.malychev.jstasks.serializingproxy;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HandleService implements InvocationHandler {
	private final Service service;
	private Storage storage;

	public HandleService(Service service, String rootDir) {
		this.service = service;
		try {
			if (service.getClass().getDeclaredMethod("calc", Result.class).
					getDeclaredAnnotation(Cache.class).cacheType() == CacheType.FILE) {
				File cacheFile = new File(rootDir, service.getClass().getDeclaredMethod("calc", Result.class).
						getDeclaredAnnotation(Cache.class).fileName());
				this.storage = new Storage(cacheFile);
			} else this.storage = new Storage();
		} catch (NoSuchMethodException e) {
			System.err.println("Ошибка аннотирования метода \"calc\".\n" +
								"Метод или аннотация к нему пропали из сервиса Исполнения Желаний.");
		}
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
		Result result;
		Cache cache = method.getDeclaredAnnotation(Cache.class);
		if (cache.cache()) {
			result = storage.get(new Result(method.getName(), (Double) args[0]));
			if (result == null) {
				System.out.println("Данные в кеше не найдены.");
				System.out.println("Вычисление произведено оригинальным методом.");
				result = (Result) method.invoke(service, args);
				storage.push(result);
			} else System.out.println("Результат выбран из кеша.");
		} else {
			System.out.println("Метод не кешируется в соответствии с аннотацией.");
			System.out.println("Вычисление произведено оригинальным методом.");
			result = (Result) method.invoke(service, args);
		}
		return result;
	}
}
