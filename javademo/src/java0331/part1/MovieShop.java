package java0331.part1;

public class MovieShop {
	String name;
	int price;
	int person;

	public MovieShop() {

	}

	public MovieShop(String name, int price, int person) {
		this.name = name;
		this.price = price;
		this.person = person;
	}
	public String getName() {
		return name;
	}

	public int countMoney() {
		return price * person;
	}

	public void prn() {
		System.out.printf("%s %d\n", name, countMoney());
	}
	public static void display(MovieShop[] s) {
		int total = 0;
		for(MovieShop ms:s) {
			System.out.println(ms.getName() + " " + ms.countMoney());
			total += ms.countMoney();
		}
		System.out.println("Total: " + total);
	}
	
}//end class
