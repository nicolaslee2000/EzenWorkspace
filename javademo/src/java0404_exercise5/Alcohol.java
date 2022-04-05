package java0404_exercise5;

public abstract class Alcohol implements Beverage{
	protected int price;
	protected int alcoholContent;
	
	abstract void checkDrunk();
	void Cheers() {
		System.out.println("Cheers!");
	}
}
