package transportservice;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Delivery service starting...");
		this.CallDressService();
		System.out.println("Delivery service started....");
	}
	
	private void CallDressService() {
		TransportInterFa Ds=new Dress_delivery();
		context.registerService(TransportInterFa.class, Ds, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
