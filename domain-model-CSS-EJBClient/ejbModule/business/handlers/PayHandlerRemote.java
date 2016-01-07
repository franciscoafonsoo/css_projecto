package business.handlers;

import javax.ejb.Remote;

import business.ApplicationException;

@Remote
public interface PayHandlerRemote {
	
	public void pay(int id) throws ApplicationException;
}
