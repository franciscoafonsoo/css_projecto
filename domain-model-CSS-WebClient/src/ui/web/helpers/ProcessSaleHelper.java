package ui.web.helpers;

import business.handlers.ProcessSaleHandlerRemote;

public class ProcessSaleHelper extends Helper {

	private String customerVat;
	private ProcessSaleHandlerRemote processSaleHandler;
	
	public void setProcessSaleHandler(ProcessSaleHandlerRemote processSaleHandler){
			this.processSaleHandler = processSaleHandler;
		}

	public String getCustomerVat() {
		return customerVat;
	}

	public void setCustomerVat(String customerVat) {
		this.customerVat = customerVat;
	}

	public void clearValues() {
		customerVat = "";
	}
		
}
