package User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Interface.Dress;
import Interface.Toy;
import MarketingInterface.MarketingInterFa;

public class Customer_02 {
	
	public static int countPerShirt=0,countPerT_Shirt=0,countPer_pant=0;
	public static int countApple=0,countJackfruit=0,countPamagram=0;
	public static int countcar=0,countBus=0,countDoll=0;
	public static float TotalPrice=0;
	public static float DelDistance=0;
	public static float HomeDeliveryCharge=0;
	public static  List<Object> stringlist=new ArrayList<Object>();
	public static  List<Object> TotalInvoicelist=new ArrayList<Object>();

	// Method where customer selects the shop
	public static int find() {
		Scanner sc=new Scanner(System.in);
		String whileCon="yes";
		
		System.out.println("Select a shop! \n 1: Dress Shop \n 2: Fruit Shop \n 3: Toy Shop");
	   int details=sc.nextInt();
	   
	   if(details==1) {
		  return 1;
	   }
	   else if(details==2) {
		   return 2;
	   }
	   else if(details==3) {
		   return 3;
	   }
	return 0;
		
		
		
	}
	
	
	
	//Method for Dress Shop
	public static void run2(Dress dr) {
		Scanner scan=new Scanner(System.in);
		//Customer object for getting and setting from an ArrayList
		Customer customer=new Customer();
		
		dr.printmenu();
		int total = 0;
		String whileCon="yes";
		do {
			
			System.out.println("Select Dress! \n 1: Shirt \n 2: T-Shirt \n 3: Jeans");
			int DressName=scan.nextInt();
			   
			if(DressName==1) {
				System.out.println("How many shirt/s do you want?");
				int num =scan.nextInt();
				countPerShirt=countPerShirt+num;
				System.out.println("Current Bill: "+dr.Sales(num, dr.shirt)+"LKR");
             
				customer.setItem("shirt");
				customer.setqty(countPerShirt);
				total+=dr.Sales(num, dr.shirt);
				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());
				
				
				}
			else if(DressName==2) {
				System.out.println("How many T-shirt/s do you want?");
				int num =scan.nextInt();
				countPerT_Shirt=countPerT_Shirt+num;
				
				System.out.println("Current bill: "+dr.Sales(num, dr.t_shirt)+"LKR");
			
				total+=dr.Sales(num, dr.t_shirt);
				customer.setItem("t-shirt");
				customer.setqty(countPerT_Shirt);
				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());
				
				
			}
			else if(DressName==3) {
				System.out.println("How many Jean/s do you want?");
				int num =scan.nextInt();
				countPer_pant=countPer_pant+num;
				System.out.println("Current Bill: "+dr.Sales(num, dr.pant)+"LKR");
				
				total+=dr.Sales(num, dr.pant);
				customer.setItem("pant's");
				customer.setqty(countPer_pant);
				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());
			   
			}
			else 
			 System.out.println("Unexpected error! Please try again");
			 customer.setprice(total);
			 stringlist.add(customer.getprice());
			
			 countPer_pant=0;
			 countPerT_Shirt=0;
			 countPerShirt=0;
			    total=0;
			
			System.out.println("Do you want to continue? 'yes' for YES \n 'no' for NO");
			whileCon=scan.next();

			}while(whileCon.equals("yes")); 
		
		//printing the bill for Dress shop
		System.out.println("*******************************************************");
		System.out.println("                  Dress Shop Bill                                     ");
		System.out.println("*******************************************************");

		System.out.println("	Items 	QTY 	Price        ");
		for(Object obj:stringlist) {

			if(obj.getClass()==Integer.class) {
				 System.out.print(" "+obj+" \t");
			}
			if(obj.getClass()==String.class) {

				 System.out.print(" "+obj+" \t ");

			}
			if(obj.getClass()==Float.class) {

				 System.out.print(" "+obj+"\n ");
				 TotalPrice+=(Float)obj;
			}
			
			
	      }

		System.out.println("--------------------------------------------------------");   
		System.out.println("   	Total : " +TotalPrice+" LKR");
		System.out.println("**********************************************************");
		System.out.println("        Thank you & come again. Have nice day..!             ");
		
		stringlist.clear();
		customer.setItem("Dress Shop");
		customer.setprice(TotalPrice);
		TotalInvoicelist.add(customer.getItem());
		TotalInvoicelist.add(customer.getprice());
		TotalPrice=0;
	}
	
	
 // Method for Fruits shop
	public static void run(MarketingInterFa ms) {
		Scanner scan=new Scanner(System.in);
		Customer customer=new Customer();

		ms.printMenu();
		String whileCon="yes";
		int total=0;
		do {
		System.out.println("Select the fruit you want to buy! \n 1: Apple \n 2: Jackfruit \n 3: Pamagram ");
		int ToyName=scan.nextInt();
		
		if(ToyName==1) {
			System.out.println("How many apple/s do you want?");
			int num =scan.nextInt();
			countApple+=num;
			System.out.println("Current Bill: "+ms.buy(num, ms.Apple)+"LKR");
			total+=ms.buy(num, ms.Apple);
			
			customer.setItem("apple");
			customer.setqty(countApple);
			
			stringlist.add(customer.getItem());
			stringlist.add(customer.getqty());
		}
		else if(ToyName==2) {
			System.out.println("How many jackfruit/s do you want?");
			int num =scan.nextInt();
			countJackfruit+=num;
			System.out.println("Current Bill: "+ms.buy(num, ms.jackfruit)+"LKR");
			total+=ms.buy(num, ms.jackfruit);
			
			customer.setItem("jackfruit");
			customer.setqty(countJackfruit);
			stringlist.add(customer.getItem());
			stringlist.add(customer.getqty());
		}
		else if(ToyName==3) {
			System.out.println("How many pamagram/s do you want?");
			int num =scan.nextInt();
			countPamagram+=num;
			System.out.println("Current Bill: "+ms.buy(num, ms.pamagram)+"LKR");
			total+=ms.buy(num, ms.pamagram);
			
			customer.setItem("pamagram");
			customer.setqty(countPamagram);
			stringlist.add(customer.getItem());
			stringlist.add(customer.getqty());
		}
		else 
			System.out.println("Unexpected error! Please try again");
		
		customer.setprice(total);
		 stringlist.add(customer.getprice());
		
		countPamagram=0;
		countJackfruit=0;
		countApple=0;
		total=0;
		
		
		System.out.println("Do you want to continue? 'yes' for YES \n 'no' for NO");
		whileCon=scan.next();
		
		
		}while(whileCon.equals("yes")); 
		
		System.out.println("*******************************************************");
		System.out.println("                 FRUITS SHOP BILLS                                       ");
		System.out.println("*******************************************************");

		System.out.println("	Items 	QTY 	Price        ");
		for(Object obj:stringlist) {
			if(obj.getClass()==Integer.class) {
				 System.out.print(" "+obj+" \t");
			}
			if(obj.getClass()==String.class) {

				 System.out.print(" "+obj+" \t ");

			}
			if(obj.getClass()==Float.class) {

				 System.out.print(" "+obj+"\n ");
				 TotalPrice+=(Float)obj;
			}
			
			
	      }

		System.out.println("--------------------------------------------------------");   
		System.out.println("   	Total : " +TotalPrice+" LKR");
		System.out.println("**********************************************************");
		System.out.println("        Thank you & come again. Have nice day..!             ");
		
		stringlist.clear();
	     
		customer.setItem("Fruit Shop");
		customer.setprice(TotalPrice);
		TotalInvoicelist.add(customer.getItem());
		TotalInvoicelist.add(customer.getprice());
		TotalPrice=0;
		
	}
	public static void run3(Toy toy) {
		Scanner scan=new Scanner(System.in);
		Customer customer=new Customer();
		toy.printMenu();
		String whileCon="yes";
		int total=0;
		
		do {
			System.out.println("Select the Toy to buy! \n 1: Car \n 2: Doll \n 3: Bus ");
			int ToyName=scan.nextInt();
			
			if(ToyName==1) {
				System.out.println("How many car/s do you want?");
				int num =scan.nextInt();
				countcar+=num;
				System.out.println("Current Bill: "+toy.buy(num, toy.car)+"LKR");
				total+=toy.buy(num, toy.car);
				
				customer.setItem("car");
				customer.setqty(countcar);
				
				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());
			}
			else if(ToyName==2) {
				System.out.println("How many doll/s do you want?");
				int num =scan.nextInt();
				countDoll+=num;
				System.out.println("Current Bill: "+toy.buy(num, toy.doll)+"LKR");
				total+=toy.buy(num, toy.doll);
				
				customer.setItem("doll");
				customer.setqty(countDoll);
				
				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());
			}
			else if(ToyName==3) {
				System.out.println("How many bus/s do you want?");
				int num =scan.nextInt();
				countBus+=num;
				System.out.println("Current Bill: "+toy.buy(num, toy.bus)+"LKR");
				total+=toy.buy(num, toy.bus);
				
				customer.setItem("bus");
				customer.setqty(countBus);
				
				stringlist.add(customer.getItem());
				stringlist.add(customer.getqty());
			}
			else 
				System.out.println("Unexpected error! Please try again");
			   
			customer.setprice(total);
			 stringlist.add(customer.getprice());
			
			 countDoll=0;
			countBus=0;
			countcar=0;
			total=0;
			
			System.out.println("Do you want to continue? 'yes' for YES \n 'no' for NO");
			whileCon=scan.next();
			
			
			}while(whileCon.equals("yes")); 
		     
		System.out.println("*******************************************************");
		System.out.println("                 TOY SHOP BILLS                                       ");
		System.out.println("*******************************************************");

		System.out.println("	Items 	QTY 	Price        ");
		for(Object obj:stringlist) {
			if(obj.getClass()==Integer.class) {
				 System.out.print(" "+obj+" \t");
			}
			if(obj.getClass()==String.class) {

				 System.out.print(" "+obj+" \t ");

			}
			if(obj.getClass()==Float.class) {

				 System.out.print(" "+obj+"\n ");
				 TotalPrice+=(Float)obj;
			}
			
			
	      }

		System.out.println("--------------------------------------------------------");   
		System.out.println("   	Total : " +TotalPrice+" LKR");
		System.out.println("**********************************************************");
		System.out.println("        Thank you & come again. Have nice day..!             ");
		
		stringlist.clear();
		
		customer.setItem("Toy Shop");
		customer.setprice(TotalPrice);
		TotalInvoicelist.add(customer.getItem());
		TotalInvoicelist.add(customer.getprice());
		TotalPrice=0;
	}
	
	public static void PrintTotalInvoice() {
		System.out.println("*******************************************************");
		System.out.println("                 TOTAL INVOICE                                       ");
		System.out.println("*******************************************************");
		System.out.println("	Items 	Price        ");
		for(Object obj:TotalInvoicelist) {
			if(obj.getClass()==Integer.class) {
				 System.out.print(" "+obj+" \t");
			}
			if(obj.getClass()==String.class) {

				 System.out.print(" "+obj+" \t ");

			}
			if(obj.getClass()==Float.class) {

				 System.out.print(" "+obj+"\n ");
				 TotalPrice+=(Float)obj;
			}			
	      }
		if(DelDistance != 0) {
			System.out.println(" Distance 	  "+HomeDeliveryCharge + "   " +DelDistance+"km");
		}
		
		System.out.println("--------------------------------------------------------");   
		System.out.println("   	Total : " +(TotalPrice+HomeDeliveryCharge)+" LKR");
		System.out.println("**********************************************************");
		System.out.println("        Thank you & come again. Have nice day..!             ");
		TotalInvoicelist.clear();
		TotalPrice=0;
	}
}
