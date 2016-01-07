package business;

import java.io.Serializable;

public class DiscountDTO implements Serializable {
	
 
	private static final long serialVersionUID = 4232849114219500244L;
	
	private int id;
	
	private String description;
	
	DiscountDTO(){}
	
	public DiscountDTO(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
