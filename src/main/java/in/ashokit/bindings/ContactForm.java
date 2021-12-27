package in.ashokit.bindings;

import java.time.LocalDate;

import lombok.Data;
@Data
public class ContactForm 
{

	private Integer contactId;
	private String contactName;
	private Long contactNumber;
	private String contactEmail;
	private String activeSw;
	private LocalDate createdDate;
	private LocalDate updatedDate;

	
	
}
