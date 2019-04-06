package toyshop;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import Interface.Toy;
import implement.toyImple;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Toy Shop Opening...");
		this.calltoy();
		System.out.println("Toy Shop is Open");
		
	}
	
	private void calltoy() {
		Toy toy=new toyImple();
		context.registerService(Toy.class, toy, null);
	}

	
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Toy Shop closed");

	}

}
