package main.java.com.insurance.integration.context;


/**
 * Class <code>BusinessServiceClientFactory</code> is the factory for access to
 * the business service (web service) client entities.
 * Revision information:
 * @author Shivanand Kumbhar
 */
public class BusinessServiceClientFactory {
	/**
	 * Default constructor. Private to prevent instantiation.
	 */
	private BusinessServiceClientFactory() {
		super();
	}
			
	/**
	 * Get the policy search business service client.
	 * 
	 * @return {@link RemotePolicySearchBusinessService}
	 */
	public static Object getBusinessService(String beanName) {
		return  ClientBeanManagerFactory.getBean(beanName);
	}
	
	
}
