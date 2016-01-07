package ui.web.helpers;

import business.handlers.PayHandlerRemote;
import business.handlers.ProcessSaleHandlerRemote;

public class PayHelper extends Helper{

	private String payId;
	
	private PayHandlerRemote payHandler;
	
	public void setPayHandler(PayHandlerRemote payHandler){
			this.payHandler = payHandler;
		}
	
	public String getPayId() {
		return payId;
	}
	
	public void setPayId(String payId) {
		this.payId = payId;
	}
	
	public void clearValues() {
		payId = "";
	}
	
}
