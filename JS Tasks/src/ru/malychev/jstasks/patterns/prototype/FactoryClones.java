package ru.malychev.jstasks.patterns.prototype;

import ru.malychev.jstasks.patterns.builder.Human;

public class FactoryClones {
	private Human clone;

	class StrongManClone extends Human {
		private Human strongManClone = new Human.HumanBuilder()
				.setFamily("Безродный")
				.setName("Клоун")
				.setSurname("")
				.setSex(Sex.Мужской)
				.setAge(30)
				.setHeight(194)
				.setWeight(86)
				.getHuman();

		StrongManClone() { }
	}

	class YoungWomanClone extends Human {
		private Human strongManClone = new Human.HumanBuilder()
				.setFamily("Безродная")
				.setName("Клоунеса")
				.setSurname("")
				.setSex(Sex.Женский)
				.setAge(20)
				.setHeight(168)
				.setWeight(54)
				.getHuman();

		YoungWomanClone() { }
	}


	public FactoryClones(Human human) {
		clone = human;
	}

}

