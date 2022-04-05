package java0404_exercise5;

public class Americano extends Coffee{
	Americano(int suger, int price) {
		this.suger = suger;
		this.price = price;
	}
	private boolean cold;
	
	public boolean isCold() {
		return cold;
	}
	public void setCold(boolean cold) {
		this.cold = cold;
	}
	@Override
	public void getDrink() {
		System.out.printf("Here's your %s Americano!%n", cold ? "cold" : "hot");
		purchase();
	}
	@Override
	public void purchase() {
		System.out.println("Thanks for purchasing. The price is " + price +"Come back to "+RESTAURANT_NAME+"again!");
	}
	@Override
	void addMilk() {
		System.out.println("Can't add milk to Americano.");
	}

}
