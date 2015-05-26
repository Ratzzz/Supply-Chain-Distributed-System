/**
 * 
 */
package manufacturingSystem;

import retailerSystem.Customer;
import retailerSystem.CustomerList;
import retailerSystem.Inventory;
import retailerSystem.InventoryList;

/**
 * @author Ting Zhang
 * @date 2015-05-24
 */
public class App {
	
	static String warehouseName = "warehouse1";;
	static String manufacturerName = "manufacturer1";
	public static void main(String[] args) throws Exception{
		
		
		InventoryList itl = new InventoryList();
		itl.loadInventoryList(warehouseName);
		System.out.println(itl.getInventoryList());
		int qt = 6000;
		itl.getInventoryList().get(0).setQuantity(qt);
		System.out.println("inventorylist after inserting a new inventory record:");
		itl.replenish(warehouseName);
		itl.loadInventoryList(warehouseName);
		System.out.println(itl.getInventoryList());
		
		
		
		ProductList pl = new ProductList();
		pl.loadProducts(manufacturerName);
		//System.out.println(pl.getProductList());
		//System.out.println("product DVD player info from manufacturer1:\n"+ pl.getProductInfo("DVD player"));
		
		/*
		PurchaseOrderList pol = new PurchaseOrderList();
		pol.loadPurchaseOrders(manufacturerName);
		System.out.println(pol.getPurchaseOrderList());
		Product pt1 = pl.getProductInfo("video camera");
		PurchaseOrder newpo = new PurchaseOrder("55","002",pt1,10,600);
		pol.getPurchaseOrderList().put(newpo.orderNum, newpo);
		pol.replenish(manufacturerName);
		System.out.println("purchase list for  manufacturer1 afther inserting a new purchase order :\n");
		System.out.println(pol.getPurchaseOrderList());
		*/
		
		/*
		CustomerList cl = new CustomerList();
		cl.loadCustomers();
		System.out.println(cl.getCustomerList());
		Customer newc = new Customer(77,"dudu","linclon","","montreal","qc","zip","canada");
		cl.getCustomerList().put(newc.getCustomerReferenceNumber(),newc);
		cl.replenish();
		System.out.println("customerlist after inserting a new inventory record:");
		cl.loadCustomers();
		System.out.println(cl.getCustomerList());
		*/
		
}

	

	
	


}