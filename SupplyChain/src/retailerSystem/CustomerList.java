/**
 * 
 */
package retailerSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;

import dataIO.FileManager;

/**
 * @author Ting Zhang
 * @date 2015-05-25
 */
public class CustomerList {
	Map<Integer, Customer> customerList = new HashMap<>();
	
	public Map<Integer, Customer>getCustomerList(){
		return customerList;
	}
	
	/**
	 * Save customerList to the XML file
	 * 
	 * @param manufacturer name
	 *            
	 * @throws Exception
	 */
	public void replenish()throws Exception{
		
		String filepath = new String(System.getProperty("user.dir") + "/src/xml/" +"clientInfo.xml");
		FileManager xmlfile = new FileManager(filepath);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		Document document = DocumentHelper.createDocument();
		
		Element root = document.addElement("clients");
		Object[] customers=customerList.values().toArray();
		for (int i = 0; i < customers.length; i++) {
			Customer it = (Customer)customers[i];
			Element ml = it.saveToElement();
			root.add(ml);
		}

		xmlfile.Write(document);
		
	}
	
	/**
	 * Load all the inventory records of a specific warehouse from the XML file
	 * 
	 * @param warehouse name
	 *           
	 * @throws Exception
	 * 
	 * @return an arrayList of Item
	 */
	public void loadCustomers()throws Exception{
		ArrayList<Inventory> il = new ArrayList<>();
		String filepath = new String(System.getProperty("user.dir")
				+ "/src/xml/" +"clientInfo.xml");
		FileManager xmlfile = new FileManager(filepath);
		Element root = xmlfile.Read();
		List<Element> nodes = root.elements("client");
		for (Iterator<Element> it = nodes.iterator(); it.hasNext();) {
			Element me = (Element) it.next();
			Customer nc = new Customer();
			nc = Customer.loadElement(me);
			customerList.put(nc.customerReferenceNumber,nc);
		}
	}
	

}
