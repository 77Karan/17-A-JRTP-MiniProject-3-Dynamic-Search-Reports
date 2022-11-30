package in.ashokit.entitiy;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="INSURANCE_PLANS")
public class InsurancePlanEntity 
{
	@Id
	@GeneratedValue
	@Column(name="PLAN_ID")
	private Integer planId;
	
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	
	@Column(name="PLAN_STATUS")
	private String planStatus;
	
	
	@Column(name="PLAN_HOLDER")
	private String planHolder;
	
	
	@Column(name="PLAN_HOLDERSSN")
	private Long planHolderssn;

}
