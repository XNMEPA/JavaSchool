package ru.malychev.jstasks.patterns.builder;

public class Human implements Cloneable {
	private String family = "";
	private String name = "";
	private String surname = "";
	private Sex sex = null;
	private int age = 0;
	private int height = 0;
	private int weight = 0;

	protected Human() { }

	@Override
	public Human clone() {
		Human clone = new Human();
		clone.family = this.family;
		clone.name = this.name;
		clone.surname = this.surname;
		clone.sex = this.sex;
		clone.age = this.age;
		clone.height = this.height;
		clone.weight = this.weight;

		return clone;
	}

	@Override
	public String toString() {
		return  "Фамилия:   " + family + "\n" +
				"Имя:       " + name + "\n" +
				"Отчество:  " + surname + "\n" +
				"Пол:       " + sex + "\n" +
				"Возраст:   " + age + "\n" +
				"Рост:      " + height + "\n" +
				"Вес:       " + weight + "\n";
	}

public enum Sex {Мужской, Женский}

	public static class HumanBuilder {
		private Human human;

		public HumanBuilder() {
			human = new Human();
		}

		public HumanBuilder setFamily(String family) {
			human.family = family;
			return this;
		}

		public HumanBuilder setName(String name) {
			human.name = name;
			return this;
		}

		public HumanBuilder setSurname(String surname) {
			human.surname = surname;
			return this;
		}

		public HumanBuilder setSex(Sex sex) {
			human.sex = sex;
			return this;
		}

		public HumanBuilder setAge(int age) {
			human.age = age;
			return this;
		}

		public HumanBuilder setHeight(int height) {
			human.height = height;
			return this;
		}

		public HumanBuilder setWeight(int weight) {
			human.weight = weight;
			return this;
		}

		public Human getHuman() {
			return human;
		}

	}

	public static void main(String[] args) {
		Human vasiliy = new Human.HumanBuilder()
				.setFamily("Васильев")
				.setName("Василий")
				.setSurname("Васильевич")
				.setSex(Sex.Мужской)
				.setAge(32)
				.setHeight(174)
				.setWeight(72)
				.getHuman();

		Human vasilisa = new Human.HumanBuilder()
				.setFamily("Васильева")
				.setName("Василиса")
				.setSurname("Васильевна")
				.setSex(Sex.Женский)
				.setAge(30)
				.setHeight(165)
				.setWeight(63)
				.getHuman();

		Human cloneVasiliy = vasiliy.clone();

		System.out.println("Человек:\n" + vasiliy);
		System.out.println("Человек:\n" + vasilisa);
		System.out.println("Клон человека:\n" + cloneVasiliy);

	}
}