package customer_02;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import Interface.Dress;
import Interface.Toy;
import MarketingInterface.MarketingInterFa;
import User.Customer_02;
import transportservice.Dress_delivery;
import transportservice.TransportInterFa;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private MarketingInterFa ms;
    private Dress dr;
    private Toy toy;
    private TransportInterFa Trans;
	static BundleContext getContext() {
		return context;
	}

	
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Going to market..... Customer bundle starting");
		Scanner sc=new Scanner(System.in);
		String delivery = "no";
		
		float distance;
		
		ServiceReference serviceTrans =context.getServiceReference(TransportInterFa.class);
		if(serviceTrans!=null) {
			Trans=(TransportInterFa)context.getService(serviceTrans);
			if(Trans!=null) {
				System.out.println("Do you want home delivery?");
				delivery = sc.next();
				if(delivery.equals("yes")) {
					TransportInterFa Dress_Del = new Dress_delivery();
					System.out.println("What is the distance between the market & your home?");
					distance = sc.nextFloat();
					Customer_02.DelDistance = distance;
					Customer_02.HomeDeliveryCharge = Dress_Del.calculate(distance);
					this.MainAction();
				}
				else {
					this.MainAction();
				}
				context.ungetService(serviceTrans);
			}else {
				System.out.println(" Delivery Service cannot run.... ");
			}
		}else {
			System.out.println("Delivery Service cannot be found!");
		}
		
		
		
		System.out.println("Customer bundle started!");
	}
	private void MainAction() {
		Scanner sc=new Scanner(System.in);
		String whileCon="no";
		do {
			int a=Customer_02.find();
			
			if(a==2) {
				ServiceReference service =context.getServiceReference(MarketingInterFa.class);
				if(service!=null) {
					ms=(MarketingInterFa)context.getService(service);
					if(ms!=null) {
						Customer_02.run(ms);
						context.ungetService(service);
					}else {
						System.out.println("Customer bundle cannot run!");
					}
				}else {
					System.out.println("Customer bundle cannot be found....");
				}
			}else if(a==1){
				ServiceReference service =context.getServiceReference(Dress.class);
				if(service!=null) {
					dr=(Dress)context.getService(service);
					if(dr!=null) {
						Customer_02.run2(dr);
						context.ungetService(service);
					}else {
						System.out.println("Customer bundle cannot run! ");
					}
				}else {
					System.out.println("Customer bundle cannot be found!");
				}
			}else if(a==3) {
				ServiceReference service =context.getServiceReference(Toy.class);
				if(service!=null) {
					toy=(Toy)context.getService(service);
					if(toy!=null) {
						Customer_02.run3(toy);
						context.ungetService(service);
					}else 
						System.out.println("Customer bundle cannot run! ");
					}
				else {
					System.out.println("Customer bundle cannot be found!");
				}
			}else {
				System.out.println(" ");
			}
			
			System.out.println("Do you want to exit? \n 'yes' for YES \n 'no' for NO");
			whileCon=sc.next();
		 
			}while(whileCon.equals("no"));
		Customer_02.PrintTotalInvoice();
	}

	
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Customer bundle stopped!");
	}

}
