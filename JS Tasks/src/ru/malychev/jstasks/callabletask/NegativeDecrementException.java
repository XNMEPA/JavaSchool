package ru.malychev.jstasks.callabletask;

public class NegativeDecrementException extends Exception {
	NegativeDecrementException() {
		super("Отрицательный дикремент квадратного уравнения");
	}
}
