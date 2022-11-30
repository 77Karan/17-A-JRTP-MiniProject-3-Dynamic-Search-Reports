package in.ashokit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.PlanResponse;
import in.ashokit.bindings.SearchRequest;
import in.ashokit.entitiy.InsurancePlanEntity;
import in.ashokit.repositories.InsurancePlanRepository;
@Service
public class InsurancePlanServiceImpl implements InsurancePlanService
{
	@Autowired
	private InsurancePlanRepository repository;

	@Override
	public List<PlanResponse> searchPlan(SearchRequest req)
	{
		InsurancePlanEntity entity = new InsurancePlanEntity();
		
		if(req.getPlanName() !=null && !req.getPlanName().equals(""))
		{
			entity.setPlanName(req.getPlanName());
		}
		
		if(req.getPlanStatus()!=null && !req.getPlanStatus().equals(""))
		{
			entity.setPlanStatus(req.getPlanStatus());
		}
		
		Example<InsurancePlanEntity> of = Example.of(entity);
		List<InsurancePlanEntity> findAll = repository.findAll(of);
		
		List<PlanResponse> plans = new ArrayList<PlanResponse>();
		
		for(InsurancePlanEntity plan : findAll)
		{
			PlanResponse pres = new PlanResponse();
			BeanUtils.copyProperties(plan, pres);
			plans.add(pres);
		}

	return plans;
	}

	@Override
	public List<String> getUniquePlanNames() 
	{
		return repository.getUniquePlanNames();
	}

	@Override
	public List<String> getUniquePlanStatus()
	{
		return repository.getUniquePlanStatus();

	}

}
