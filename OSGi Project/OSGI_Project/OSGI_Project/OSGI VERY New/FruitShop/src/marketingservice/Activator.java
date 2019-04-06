package marketingservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


import ImplementClass.FruitsImpl;
import MarketingInterface.MarketingInterFa;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}


	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Fruit Shop Opening...");
		
		this.Callservice();
		
		System.out.println("Fruit Shop is Open");
	}

	private void Callservice() {
		MarketingInterFa ms=new FruitsImpl();
		context.registerService(MarketingInterFa.class, ms, null);
	}

	
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Fruit shop closed!");
	}

}
