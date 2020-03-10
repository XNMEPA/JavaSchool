package ru.malychev.jstasks.patterns.immutable;

public class Stone {
	private final String name;

	public Stone(String name) {
		this.name = name;
	}

	public String getStone() {
		return name;
	}
}
