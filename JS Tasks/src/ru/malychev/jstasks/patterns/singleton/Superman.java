package ru.malychev.jstasks.patterns.singleton;

import ru.malychev.jstasks.patterns.builder.Human;
import ru.malychev.jstasks.patterns.immutable.Stone;

public class Superman {
	private Human onlyMan;
	private final Stone fearOfSuperman = new Stone("Криптон");
	private static volatile Superman superman;

	private Superman() {
		onlyMan = new Human.HumanBuilder()
			.setFamily("Кларк")
			.setName("Кент")
			.setSurname("Джерриевич")
			.setSex(Human.Sex.Мужской)
			.setAge(30)
			.setHeight(194)
			.setWeight(86)
			.getHuman();
	}

	public static Superman getSuperman() {
		Superman localSuperman = superman;
		if (localSuperman == null) {
			synchronized (Superman.class) {
				localSuperman = superman;
				if (localSuperman == null) {
					superman = localSuperman = new Superman();
				}
			}
		}
		return localSuperman;
	}

	@Override
	public String toString() {
		return onlyMan.toString();
	}

		public Stone getFearOfSuperman() {
		return fearOfSuperman;
	}

}
