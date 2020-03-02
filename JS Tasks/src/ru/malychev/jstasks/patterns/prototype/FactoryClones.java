package ru.malychev.jstasks.patterns.prototype;

import ru.malychev.jstasks.patterns.builder.Human;

import java.util.ArrayList;
import java.util.List;

public class FactoryClones {
	private Human clone;

	public FactoryClones(Human human) {
		clone = human;
	}

	public Human birthClone() {
		return clone.clone();
	}

	public static void main(String[] args) {
		List<Human> cloneArmy = new ArrayList<>();
		List<Human> amazons = new ArrayList<>();

		FactoryClones menFactoryClone = new FactoryClones(new StrongMan().birthMan());
		FactoryClones womenFactoryClone = new FactoryClones(new YoungWoman().birthWoman());

		for (int i = 0; i++ < 10; cloneArmy.add(menFactoryClone.birthClone()));
		for (int i = 0; i++ < 10; amazons.add(womenFactoryClone.birthClone()));

		System.out.println("В бой идет армия клонов:\n");
		for (Human clone : cloneArmy) System.out.println(clone);
		System.out.println("Им на встречу амазонки:\n");
		for (Human clone : amazons) System.out.println(clone);
	}
}

class StrongMan extends Human {
	private Human strongMan = new Human.HumanBuilder()
			.setFamily("Безродный")
			.setName("Клоун")
			.setSurname("")
			.setSex(Sex.Мужской)
			.setAge(30)
			.setHeight(194)
			.setWeight(86)
			.getHuman();

	public Human birthMan() {
		return strongMan;
	}
}

class YoungWoman extends Human {
	private Human youngWoman = new Human.HumanBuilder()
			.setFamily("Безродная")
			.setName("Клоунеса")
			.setSurname("")
			.setSex(Sex.Женский)
			.setAge(20)
			.setHeight(168)
			.setWeight(54)
			.getHuman();

	public Human birthWoman() {
		return youngWoman;
	}
}

