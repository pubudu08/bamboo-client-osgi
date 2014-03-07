package org.wso2.carbon.utility.bamboo.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.utility.bamboo.service.CIAdminService;
import org.wso2.carbon.utility.continuousintegration.IContinuousIntegration;

/**
 * Created by pubudu on 2/3/14.
 *
 * @scr.component name="org.wso2.carbon.utility.bamboo"
 * immediate="true"
 */

public class ServiceComponent {
    private ServiceRegistration registration;

    private static CIAdminService adminService;
    private static BundleContext bundleContext;
    private static final Log logger = LogFactory.getLog(ServiceComponent.class);

    protected void activate(ComponentContext context) {
        logger.info("Continuous Integration Service: Bamboo bundle is activated");
        adminService = new CIAdminService();
        bundleContext = context.getBundleContext();
        registration = bundleContext.registerService(IContinuousIntegration.class.getName(),adminService, null);
    }

    protected void deactivate(ComponentContext context) {
        logger.info("Continuous Integration Service: Bamboo bundle is deactivated");
        registration.unregister();
        adminService = null;
        bundleContext = null;
    }

}
