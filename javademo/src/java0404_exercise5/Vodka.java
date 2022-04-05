package java0404_exercise5;

public class Vodka extends Alcohol{
	private int shots;
	
	Vodka(int price, int shots) {
		this.price = price;
		setShots(shots);
		this.alcoholContent = 40;
	}
	public int getShots() {
		return shots;
	}
	public void setShots(int shots) {
		this.shots = shots;
	}
	@Override
	public void getDrink() {
		System.out.println("Here's your shot!");
	}
	@Override
	public void purchase() {
		System.out.println("That will be "+ price * shots+ ". Come back to "+RESTAURANT_NAME+"again!");
	}

	@Override
	void checkDrunk() {
		if(shots > 5) {
			System.out.println("Should probably stop");
			return;
		}
		System.out.println("fine");
	}

}
