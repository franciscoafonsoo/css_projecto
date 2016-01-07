package ui.web.helpers;

import business.ApplicationException;
import business.InvoiceDTO;
import business.handlers.ProcessSaleHandlerRemote;

public class PaymentHelper extends Helper {
	
	private String saleId;
	
	private ProcessSaleHandlerRemote processSaleHandler;
	
	public void setProcessSaleHandler(ProcessSaleHandlerRemote processSaleHandler){
			this.processSaleHandler = processSaleHandler;
		}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}
	

	public void clearValues() {
		saleId = "";
	}

}
