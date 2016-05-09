package main.java.com.insurance.integration.context;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Class <code>ClientBeanManagerFactory</code> is the Spring context manager
 * singleton class for Guidewire plugins to access the services required
 * for implementing the needed functionality.
 * 
 * Revision information:
 * @author Shivanand Kumbhar
 */
public class ClientBeanManagerFactory {

	private static final String[] CONTEXT_FILES = new String[] {
		"Integration-client-cc.xml"
	};
	private static ClientBeanManagerFactory factory;
	
	public BeanFactory beanFactory;

	/**
	 * Constructor for class BeanManagerFactory
	 */
	private ClientBeanManagerFactory() {
		 super();
		 ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(CONTEXT_FILES);	
		 appContext.setClassLoader(Thread.currentThread().getContextClassLoader());
		 beanFactory = (BeanFactory) appContext;
	}
	
	/**
	 * Get an instance of the bean.
	 * @return BeanManagerFactory
	 */
	public static synchronized ClientBeanManagerFactory getInstance() {
		
		if(factory == null) {
			factory = new ClientBeanManagerFactory();
		}
		return factory;
	}
	
	/**
	 * @return Returns the beanFactory.
	 */
	private BeanFactory getBeanFactory() {
		return beanFactory;
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
