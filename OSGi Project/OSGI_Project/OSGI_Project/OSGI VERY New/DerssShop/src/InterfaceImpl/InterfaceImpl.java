package InterfaceImpl;

import Interface.Dress;

public class InterfaceImpl implements Dress {

	@Override
	public int Sales(int qty, int prices) {
		return qty * prices;
	}

	public void printmenu() {
		System.out.println("Shirt " + Dress.shirt + " LKR");
		System.out.println("T-shirt " + Dress.t_shirt + " LKR");
		System.out.println("Jeans " + Dress.pant + " LKR");

	}
}
