package ru.malychev.jstasks.patterns.prototype;

import ru.malychev.jstasks.patterns.builder.Human;

public class FactoryClones {
	private Human clone;

	public FactoryClones(Human human) {
		clone = human;
	}

}

