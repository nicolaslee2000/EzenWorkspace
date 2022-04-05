package java0404_exercise5;

public class Latte extends Coffee{
	Latte(int suger, int price){
		this.suger = suger;
		this.price = price;
	}
	@Override
	public void getDrink() {
		System.out.println("Here's your Latte! You can add more milk if you like.");
		purchase();
	}

	@Override
	public void purchase() {
		System.out.println("Thanks for purchasing. The price is " + price+"Come back to "+RESTAURANT_NAME+"again!");
	}

	@Override
	void addMilk() {
		System.out.println("Adding more milk...");
	}

}
