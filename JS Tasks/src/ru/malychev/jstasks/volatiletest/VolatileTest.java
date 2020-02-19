package ru.malychev.jstasks.volatiletest;
public class VolatileTest {
	public static void main(String[] args) throws InterruptedException {
		final MyClass myClass = new MyClass();
		new Thread(myClass::addA).start();
		Thread.sleep(1000);
		new Thread(myClass::addA2).start();
	}
}
class MyClass {
	final Integer aInt = 0;
	int a;
	public void addA() {
		synchronized (aInt) {
			System.out.print("addA = ");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(++a);
		}
	}
	public void addA2() {
			System.out.print("addA2 = ");
			System.out.println(a += 2);
	}
}