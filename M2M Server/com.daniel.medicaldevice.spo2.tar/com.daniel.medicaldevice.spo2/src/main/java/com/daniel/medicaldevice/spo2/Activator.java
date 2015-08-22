package com.daniel.medicaldevice.spo2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.californium.core.network.config.NetworkConfig;
import org.eclipse.om2m.core.service.SclService;
import org.eclipse.om2m.ipu.service.IpuService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;



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
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		logger.info("TPS start");
		logger.info("Register TPS");
		context.registerService(IpuService.class.getName(), new Controller(),
				null);
		logger.info("Registered");
		sclServiceTracker = new ServiceTracker<Object, Object>(context,
				SclService.class.getName(), null) {
			public void removedService(ServiceReference<Object> reference,
					Object service) {
				logger.info("SclService removed");
			}

			public Object addingService(ServiceReference<Object> reference) {
				logger.info("SclService discovered");
				SclService sclService = (SclService) this.context
						.getService(reference);
				final Spo2Monitor bloodPressureMonitor = new Spo2Monitor(
						sclService);
				new Thread() {
					public void run() {
						try {
							NetworkConfig
									.getStandard()
									.setInt(NetworkConfig.Keys.MAX_MESSAGE_SIZE,
											64)
									.setInt(NetworkConfig.Keys.PREFERRED_BLOCK_SIZE,
											64);
							bloodPressureMonitor.start();
						
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
