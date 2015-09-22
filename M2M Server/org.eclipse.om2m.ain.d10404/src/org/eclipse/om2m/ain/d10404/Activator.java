package org.eclipse.om2m.ain.d10404;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.core.service.SclService;
import org.eclipse.om2m.ipu.service.IpuService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

	private static BundleContext context;
	private static Log logger = LogFactory.getLog(Activator.class);
	private ServiceTracker<Object, Object> sclServiceTracker;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		logger.info("Register IpuService..");
        bundleContext.registerService(IpuService.class.getName(), new Controller(), null);
        logger.info("IpuService is registered.");
        
        sclServiceTracker = new ServiceTracker<Object, Object>(bundleContext, SclService.class.getName(), null){
        	@Override
        	public void removedService(ServiceReference<Object> reference,
        			Object service) {
        		// TODO Auto-generated method stub
        		logger.info("SclService removed");
        	}
        	@Override
        	public Object addingService(ServiceReference<Object> reference) {
        		// TODO Auto-generated method stub
        		logger.info("SclService discovered");
        		SclService sclService = (SclService) this.context.getService(reference);
        		final D10404Monitor dMonitor = new D10404Monitor(sclService);
        		new Thread(){
        			public void run(){
        				try{
        					dMonitor.start();
        				}catch(Exception e){
        					logger.error("D10404Monitor error", e);
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
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
