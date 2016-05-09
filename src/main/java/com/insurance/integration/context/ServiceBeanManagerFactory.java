package main.java.com.insurance.integration.context;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

/**
 * Class <code>BeanManagerFactory</code> is the Spring context manager
 * singleton class for the ClaimCenterIntegration server side services.
 * 
 * Revision information:
 * @author Shivanand Kumbhar
 */
public class ServiceBeanManagerFactory {

	private static ServiceBeanManagerFactory factory;
	public BeanFactory beanFactory;

	/**
	 * Constructor for class BeanManagerFactory
	 */
	private ServiceBeanManagerFactory() {
		super();
	}
	
	/**
	 * Get an instance of the bean.
	 * @return BeanManagerFactory
	 */
	public static synchronized void initialize(ApplicationContext ctx) {
		if(factory == null) {
			factory = new ServiceBeanManagerFactory();
			factory.setBeanFactory((BeanFactory)ctx);
		}
	}
	
	/**
	 * Get the instance of the factory.
	 * @return ServiceBeanManagerFactory
	 */
	private static ServiceBeanManagerFactory getInstance() {
		return factory;
	}
	
	/**
	 * Get the bean factory.
	 * @return Returns the beanFactory.
	 */
	private BeanFactory getBeanFactory() {
		return beanFactory;
	}

	/**
	 * Set the bean factory.
	 * @param beanFactory
	 */
	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	/**
	 * <B>Subject:</B> Get the bean from the factory.
	 * @param beanName
	 * @return Object
	 */
	public static Object getBean(String beanName) {
		return getInstance().getBeanFactory().getBean(beanName);
	}
}
