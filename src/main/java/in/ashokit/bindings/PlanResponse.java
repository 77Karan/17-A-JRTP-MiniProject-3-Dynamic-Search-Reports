package in.ashokit.bindings;

import lombok.Data;

@Data
public class PlanResponse 
{
	private Integer planId;
	private String planName;
	private String planStatus;
	private String planHolder;
	private Long planHolderssn;

}
