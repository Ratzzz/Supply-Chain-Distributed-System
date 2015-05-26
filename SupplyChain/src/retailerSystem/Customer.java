/**
 * 
 */
package retailerSystem;

import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;

/**
 * @author Ting Zhang
 * @date 2015-05-25
 */
public class Customer {
	int customerReferenceNumber;
	String name;
	String street1="";
	String street2="";
	String city;
	String state;
	String zip;
	String country;
	
	public Customer(){
		
	}
	public Customer(int crn, String nm, String st1, String st2, String ct, String sta, String zp, String cun){
		customerReferenceNumber = crn;
		name = nm;
		street1 = st1;
		street2 = st2;
		city = ct;
		state = sta;
		zip = zp;
		country = cun;
	}
	
	public int getCustomerReferenceNumber(){
		return customerReferenceNumber;
	}
	
	@Override
	/**
	 * Overridden method.
	 * @see Object.toString().
	 */
	
	public String toString(){
		
		
		return "customerReferenceNumber:"+this.customerReferenceNumber+"\n"
				+"name: "+this.name+"\n"
				+"street1: "+this.street1+"\n"
				+"street2: "+this.street2+"\n"
				+"city: "+this.city+"\n"
				+"state: "+this.state+"\n"
				+"zip: "+this.zip+"\n"
				+"country: "+this.country+"\n"
				;
				
				
	}
	/**
	 * save Item into the format of an XML element
	 * 
	 * @return XML element which stores the contents of this Item
	 */
	
	public Element saveToElement() {
		//System.out.println("unit price: "+ unitPrice);

		DefaultElement nc = new DefaultElement("client");
		Element crn = nc.addElement("customerReferenceNumber");
		crn.setText(String.valueOf(customerReferenceNumber));
		Element nm = nc.addElement("name");
		nm.setText(name);
		Element st1 = nc.addElement("street1");
		st1.setText(street1);
		Element st2 = nc.addElement("street2");
		st2.setText(street2);
		Element ct = nc.addElement("city");
		ct.setText(city);
		Element sta = nc.addElement("state");
		sta.setText(state);
		Element zp = nc.addElement("zip");
		zp.setText(zip);
		Element cun = nc.addElement("country");
		cun.setText(country);
		return nc;
	}
	
	/**
	 * Parse XML element and generate a Customer object 
	 * 
	 * @param root 
	 * @return the PurchaseOrder object which is initialized by the given XML element
	*/
	public static Customer loadElement(Element root){
		int crn;
		String nm;
		String st1;
		String st2;
		String ct;
		String sta;
		String zp;
		String cun;
		crn=Integer.parseInt(root.element("customerReferenceNumber").getText());
		
		nm=root.element("name").getText();
		st1=root.element("street1").getText();
		st2=root.element("street2").getText();
		ct=root.element("city").getText();
		sta=root.element("state").getText();
		zp=root.element("zip").getText();
		cun=root.element("country").getText();
		Customer nc = new Customer(crn,nm,st1,st2,ct,sta,zp,cun);
		return nc;
	}
	
	
}
