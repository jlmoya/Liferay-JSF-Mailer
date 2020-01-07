/**
 * 
 */
package cc.sosonline.tutorial.liferay.jsf.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import com.liferay.faces.util.context.FacesContextHelperUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailService;

import cc.sosonline.tutorial.liferay.jsf.service.MailServiceTracker;

/**
 * @author Jose Luis Moya Sobrado
 *
 */
@ManagedBean
@RequestScoped
public class MailHelper {

	private static Logger log = LogManager.getLogger(MailHelper.class);

	private MailServiceTracker mailServiceTracker;
	private MailMessage mailMessage;
	private String from;
	private String to;
	private InternetAddress _from;
	private InternetAddress _to;
	private String subject;
	private String body;
	private boolean htmlFormat;

	/**
	 * Creates a new instance of MailHelper
	 */
	public MailHelper() {
		log.info("MailHelper Constructor");
	}

	@PostConstruct
	public void postConstruct() {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		BundleContext bundleContext = bundle.getBundleContext();
		mailServiceTracker = new MailServiceTracker(bundleContext);
		mailServiceTracker.open();
	}

	@PreDestroy
	public void preDestroy() {
		mailServiceTracker.close();
	}

	public void submit(ActionEvent actionEvent) {
		log.info("Submit button pressed");
		mailMessage = new MailMessage(_from, _to, subject, body, htmlFormat);
		MailService mailService = mailServiceTracker.getService();
		log.info("Sending email...");
		mailService.sendEmail(mailMessage);
		FacesContextHelperUtil.addGlobalSuccessInfoMessage();
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) throws AddressException {
		InternetAddress internetAddress = new InternetAddress(from);
		this._from = internetAddress;
		this.from = from;
	}
	
	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) throws AddressException {
		InternetAddress internetAddress = new InternetAddress(to);
		_to = internetAddress;
		this.to = to;
	}
	
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the htmlFormat
	 */
	public boolean isHtmlFormat() {
		return htmlFormat;
	}

	/**
	 * @param htmlFormat the htmlFormat to set
	 */
	public void setHtmlFormat(boolean htmlFormat) {
		this.htmlFormat = htmlFormat;
	}
	
	public String toString() {
		return "\nFrom: " + this.getFrom() + "\n" + 
			"To: " + this.getTo() + "\n" +
			"Subject: " + this.getSubject() + "\n" + 
			"Body: " + this.getBody() + "\n" +
			"Html Format:" + this.isHtmlFormat() + "\n";
	}
}
