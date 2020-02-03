package ru.malychev.jstasks.serializingproxy;

import java.lang.reflect.Proxy;

/**
 *  Created by "XNMEPA" on 03.02.2020.
 *  Сервисный класс исполнения желаний {@link SerializingProxy}
 */

public class SerializingProxy {

    public static void main(String[] args) {
        String rootDir = "/home/gendalf/Загрузки/";
        WishService wishService = new WishService();
        HandleService handleService = new HandleService(wishService, rootDir);

        Service service = (Service) Proxy.newProxyInstance(
                Service.class.getClassLoader(),
                new Class[] {Service.class},
                handleService);

        try {
            System.out.println(service.calc(new Result("sqrt", 4.0)) + "\n");
            System.out.println(service.calc(new Result("sin", Math.PI / 2)) + "\n");
            System.out.println(service.calc(new Result("cos", Math.PI / 2)) + "\n");
            System.out.println(service.simpleSum(10, 15.3, 0.36, 2e+2) + "\n");
            System.out.println("===============================================");
            System.out.println(service.calc(new Result("sqrt", 9.0)) + "\n");
            System.out.println(service.calc(new Result("sin", Math.PI / 4)) + "\n");
            System.out.println(service.calc(new Result("cos", Math.PI / 4)) + "\n");
            System.out.println("===============================================");
            System.out.println(service.calc(new Result("sqrt", 9.0)) + "\n");
            System.out.println(service.calc(new Result("sin", Math.PI / 2)) + "\n");
            System.out.println(service.calc(new Result("cos", Math.PI / 4)) + "\n");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        handleService.safeClose();
    }
}
