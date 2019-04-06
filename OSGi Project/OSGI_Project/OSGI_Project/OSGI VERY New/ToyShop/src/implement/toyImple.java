package implement;

import Interface.Toy;

public class toyImple implements Toy {

	Toy t;
	@Override
	public int buy(int qty, int prices) {
		return qty*prices;
	}

	@Override
	public void printMenu() {
		System.out.println("***************************");
		System.out.println("TOYSHOP MENU");
		System.out.println("Car ="+t.car+"LKR");
		System.out.println("Doll ="+t.doll+"LKR");
		System.out.println("Bus ="+t.bus+"LKR");

	}

}
