package ui.web.helpers;

import business.handlers.ProcessSaleHandlerRemote;


public class AddProductHelper extends Helper {
	
	private String saleId;
	private String prodId;
	private String quant;
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

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	
	public String getQuant(){
		return quant;
	}
	
	public void setQuant(String quant){
		this.quant = quant;
	}
	
	public void clearValues() {
		saleId = "";
		prodId = "";
	}
}
