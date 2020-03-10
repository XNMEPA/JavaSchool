package ru.malychev.jstasks.patterns.singleton;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

public class TestSuperman {
	public static void main(String[] args) {
//		Superman kentClark = new Superman();
		Superman kentClark = Superman.getSuperman();

		System.out.println("Кто такой супермен? \n" + kentClark);
		System.out.println("Чего боится супермен? " + kentClark.getFearOfSuperman());

		Superman secondKentClark = Superman.getSuperman();
		System.out.println("Одна ли личность скрывается под масками kentClark и secondKentClark");
		if (kentClark == secondKentClark) System.out.println("Да. Это одна личность.");
		else System.out.println("Нет. Случилось страшное. Суперман отдуплился.");
	}
}
