package java0404_exercise5;

public class Beer extends Alcohol{
	private int ml;
	
	public int getMl() {
		return ml;
	}

	public void setMl(int numBottle) {
		this.ml = numBottle;
	}
	Beer(int litre, int price) {
		setMl(litre);
		this.price = price;
		this.alcoholContent = 5;
	}
	@Override
	void checkDrunk() {
		if(alcoholContent*getMl()>1000) {
			System.out.println("Should stop drinking");
			return;
		}
		System.out.println("fine");
	}

	@Override
	public void getDrink() {
		System.out.println("Here's your beer!");
	}
	@Override
	public void purchase() {
		System.out.println("That will be " + price + ". Come back to "+RESTAURANT_NAME+"again!");
	}
}
