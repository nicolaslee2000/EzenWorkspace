package java0404_exercise5;
/*
 * Class hierarchy: Interface Beverage -> Abstract class Alcohol, Coffee -> class Americano, Beer, Latte, Wine... 
 */
public class Main {
	public static void main(String[] args) {
		Beer beer = new Beer(500, 8000);
		checkAlcohol(beer);
		purchaseBeverage(beer);
		Americano americano = new Americano(30, 2000);
		addMilk(americano);
		purchaseBeverage(americano);
		Latte latte = new Latte(0, 3000);
		addMilk(latte);
		purchaseBeverage(latte);
		Vodka vodka = new Vodka(10000, 6);
		checkAlcohol(vodka);
		purchaseBeverage(vodka);
	}
	
	static void purchaseBeverage(Beverage beverage) {
		beverage.purchase();
	}
	static void addMilk(Coffee coffee) {
		coffee.addMilk();
	}
	static void checkAlcohol(Alcohol alcohol) {
		alcohol.checkDrunk();
	}
}
