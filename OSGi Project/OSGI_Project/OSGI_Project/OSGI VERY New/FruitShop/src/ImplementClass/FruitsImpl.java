package ImplementClass;

import MarketingInterface.MarketingInterFa;

public class FruitsImpl implements MarketingInterFa {
   
	MarketingInterFa ms;
	@Override
	public int buy(int qty, int prices) {
		return qty*prices;
	}

	@Override
	public void printMenu() {
		System.out.println("Apple "+ms.Apple+"LKR");
		System.out.println("Jackfruit"+ms.jackfruit+"LKR");
		System.out.println("Pamagram "+ms.pamagram+"LKR");
		
		
	}

}
