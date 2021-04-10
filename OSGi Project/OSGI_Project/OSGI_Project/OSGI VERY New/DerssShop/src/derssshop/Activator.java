package derssshop;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import Interface.Dress;
import InterfaceImpl.InterfaceImpl;

public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Dress shop Opening");
		this.CallInterface();
		System.out.println("Dress shop is Open");
	}

	private void CallInterface() {
		Dress dress = new InterfaceImpl();
		context.registerService(Dress.class, dress, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Dress Shop Closed");
	}

}
