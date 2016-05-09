package  main.java.com.insurance.integration.common.util;

import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class IntegrationTools {

	private static final Random  r = new Random();
	/**
	 * Generates a 48 random characters string to be used as Transaction Correlation ID HTTP header when calling Service Broker
	 */
	public static String generateCorrellationID (){
		byte bytes[] = new byte[24];
		r.nextBytes(bytes);
		String c = String.format("%048x", new BigInteger(1, bytes));
		return c;
	}

	public static XMLGregorianCalendar getHeaderTimestamp() throws DatatypeConfigurationException{
		GregorianCalendar d1 = new GregorianCalendar();
		d1.setTime(new Date());
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(d1);
	}
	
	public static XMLGregorianCalendar dateToXmlGC(Date d) throws DatatypeConfigurationException{
		GregorianCalendar d1 = new GregorianCalendar();
		d1.setTime(d);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(d1);
	}
	
	/**
	 * 
	 * @param s String to pad with leading zeros (i.e "12345")
	 * @param n Number of total digits the result will have
	 * @return s padded with leading zeros. The result will be n characters long. If s.lenght() greater than n then s is returned
	 */
	public static String paddingLeadingZeros(String s,int n){
		return String.format("%"+Integer.toString(n)+"s", s).replace(' ', '0');
	}
}
