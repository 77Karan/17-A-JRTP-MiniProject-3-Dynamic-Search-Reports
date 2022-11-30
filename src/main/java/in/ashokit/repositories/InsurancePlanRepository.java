package in.ashokit.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entitiy.InsurancePlanEntity;

public interface InsurancePlanRepository extends JpaRepository<InsurancePlanEntity, Serializable>
{
	@Query(value="SELECT DISTINCT PLAN_NAME FROM INSURANCE_PLANS",nativeQuery=true)
	public List<String> getUniquePlanNames();
	
	@Query(value="SELECT DISTINCT PLAN_STATUS FROM INSURANCE_PLANS",nativeQuery=true)
	public List<String> getUniquePlanStatus();

}
