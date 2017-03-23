package facade.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = -4087131153704256744L;

	public final int vatNumber;
	public final String designation;
	public final int id;

	public CustomerDTO(int vatNumber, String designation, int id) {
		this.vatNumber = vatNumber;
		this.designation = designation;
		this.id = id;
	}
}