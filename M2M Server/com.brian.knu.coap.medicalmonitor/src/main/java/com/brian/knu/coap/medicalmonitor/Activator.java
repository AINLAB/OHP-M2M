package com.brian.knu.coap.medicalmonitor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.om2m.core.service.SclService;
import org.eclipse.om2m.ipu.service.IpuService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;


/*
 * 
 * This contains the implementation of the start() and stop() method used to activate and 
 * deactivate the IPU plugin.
In the start() method, the Activator registers the IPU Controller service on the registry 
to make it available for the CORE plugin. Then, it starts tracking the CORE SCL service to
use it once it the CORE plugin is activated.
In the Stop() method, the Activator can execute some process to make a clean before deactivation
such as stopping threads, handle exceptions, etc. 
* */

public class Activator implements BundleActivator {

	private static Log logger = LogFactory.getLog(Activator.class);
	private ServiceTracker<Object, Object> sclServiceTracker;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception
	{
		Activator.context = bundleContext;
		logger.info("TPS start");
		logger.info("Register TPS");
		context.registerService(IpuService.class.getName(), new Controller(),
				null);
		logger.info("Registered");
		sclServiceTracker = new ServiceTracker<Object, Object>(context,
				SclService.class.getName(), null) {
			public void removedService(ServiceReference<Object> reference,
					Object service)
			{
				logger.info("SclService removed");
			}

			public Object addingService(ServiceReference<Object> reference) {
				logger.info("SclService discovered");
				SclService sclService = (SclService) this.context
						.getService(reference);
				final MedicationMonitor medicationMonitor = new MedicationMonitor(
						sclService);
				new Thread() {
					public void run() {
						try 
						{
							NetworkConfig
									.getStandard()
									.setInt(NetworkConfig.Keys.MAX_MESSAGE_SIZE,
											64)
									.setInt(NetworkConfig.Keys.PREFERRED_BLOCK_SIZE,
											64);
							medicationMonitor.start();
						
						} catch (Exception e) {
							logger.error("IpuMonitor error", e);
						}
					}
				}.start();
				return sclService;
			}
		};
		sclServiceTracker.open();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

	

}
