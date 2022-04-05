package java0404_exercise5;

public abstract class Coffee implements Beverage{
	protected int suger;
	protected int price;

	abstract void addMilk();
	void addSuger() {
		System.out.println(suger+"mg of suger added.");
	}
}
