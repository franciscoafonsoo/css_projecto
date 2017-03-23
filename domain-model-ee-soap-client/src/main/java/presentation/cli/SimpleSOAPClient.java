package presentation.cli;

import business.*;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * A simple application client that uses both services.
 *	
 * @author fmartins
 * @version 1.2 (11/02/2015)
 * 
 */
public class SimpleSOAPClient {

	/**
	 * A simple interaction with the application services
	 * 
	 * @param args Command line parameters
	 */
	public static void main(String[] args) throws Exception {

		// Make a service
		AddCustomerHandlerService adService = new AddCustomerHandlerService();
		AddOrderHandlerService aoService = new AddOrderHandlerService();
		ReceiveOrderHandlerService roservice = new ReceiveOrderHandlerService();
		GetOrdersHandlerService goservice = new GetOrdersHandlerService();

		// Now use the service to get a stub which implements the SDI.
		AddCustomerHandler customerHandler = adService.getAddCustomerHandlerPort();
		AddOrderHandler addOrderHandler = aoService.getAddOrderHandlerPort();
		ReceiveOrderHandler receiveOrderHandler = roservice.getReceiveOrderHandlerPort();
		GetOrdersHandler getOrdersHandler = goservice.getGetOrdersHandlerPort();

		// Make the actual call
		try {
			// customerHandler.addCustomer(168027852, "Customer 1", 217500255, 1);
			System.out.println("Cliente adiciondo com sucesso.");

			Scanner sc = new Scanner(System.in);
			boolean input = true;
			while (input) {
				System.out.println();
				System.out.println("1. Make a new order");
				System.out.println("2. Receive an order");
				System.out.println("3. Consult the pending orders");
				System.out.println("0. quit");
				int choose = sc.nextInt();

				switch (choose) {
					case 1:
						System.out.println();
						System.out.println("Insert Supplier (ex: 123456001) :");
						int vat = sc.nextInt();

						SupplierDTO sdto = addOrderHandler.prepareOrder(vat);
						System.out.println("Supplier name: " + sdto.getName());

						System.out.println();
						System.out.println("Insert Product Code (ex: 123) :");
						int prodcode = sc.nextInt();

						System.out.println();
						ProductDTO prod = addOrderHandler.productDetails(prodcode);
						System.out.println("Product Details: Description: " + prod.getDescription() + ", Qty: " + prod.getQty() + ", FaceValue: " + prod.getFaceValue());

						System.out.println("Delivery Date: (yyyy-mm-dd)");
						DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						Date date = format.parse(sc.next());
						GregorianCalendar cal = new GregorianCalendar();
						XMLGregorianCalendar date2;
						cal.setTime(date);

						try {
							date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
						} catch (Exception e) {
							throw new Exception(e);
						}

						System.out.println();
						System.out.println("Quantity to order: ");
						double qty = sc.nextDouble();

						OrdersDTO order = addOrderHandler.addOrder(vat, prodcode, date2, qty);
						System.out.println("Order " + order.getId() + " registered");
						break;
					case 2:
						System.out.println();
						System.out.println("Insert Supplier (ex: 123456001) :");
						int supplier = sc.nextInt();

						Iterable<OrdersDTO> ordersDTOS = receiveOrderHandler.getOrdersBySupplier(supplier);
						System.out.println("Supplier Orders: (Order nº, Supplier id, Order date, Qty, Previous Orders id (0 if none)");
						for(OrdersDTO cenas: ordersDTOS) {
							Date dt = cenas.getOrderDate().toGregorianCalendar().getTime();
							System.out.println(cenas.getId() + " | " + cenas.getSupplierId() + " | "  + dt + " | "
									+ cenas.getQty() + " | " + cenas.getOldOlder());
						}

						System.out.println();
						System.out.println("input the order to recieve : ");
						int orderid = sc.nextInt();
						System.out.println("input the quantity to recieve: ");
						double qtyOrder = sc.nextDouble();

						receiveOrderHandler.receiveOrder(orderid, qtyOrder);
						break;

					case 3:

						System.out.println();
						System.out.println("Insert Product Code (ex: 123) :");
						int prodcode1 = sc.nextInt();

						Iterable<OrdersDTO> orders = getOrdersHandler.getOrdersByProduct(prodcode1);

						System.out.println("Pending Orders: (Order nº, Supplier id, Order date, Qty, Previous Orders id (0 if none)");
						for(OrdersDTO o: orders){
							Date dt = o.getOrderDate().toGregorianCalendar().getTime();
							System.out.println(o.getId() + " | " + o.getSupplierId() + " | "  + dt + " | "
									+ o.getQty() + " | " + o.getOldOlder());
						}
						break;
				default:
					input = false;
					System.out.println();
					System.out.println("quiting...");
			}
		}

			sc.close();
		} catch (ApplicationException_Exception e) {
			System.out.println("Erro ao adicionar cliente.");
			System.out.println("Causa:");
			e.printStackTrace();
		}

	}
}
