/**
 * 
 */
package cc.sosonline.tutorial.liferay.jsf.service;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import com.liferay.mail.kernel.service.MailService;

/**
 * @author Jose Luis Moya Sobrado
 *
 */
public class MailServiceTracker extends ServiceTracker<MailService, MailService> {

	public MailServiceTracker(BundleContext bundleContext) {
		super(bundleContext, MailService.class, null);
	}
}
