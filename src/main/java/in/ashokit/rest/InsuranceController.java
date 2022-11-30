package in.ashokit.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.PlanResponse;
import in.ashokit.bindings.SearchRequest;
import in.ashokit.reports.ExcelReportGenerator;
import in.ashokit.reports.PdfGeneratorReport;
import in.ashokit.service.InsurancePlanService;

@RestController
public class InsuranceController 
{
	@Autowired
	private InsurancePlanService service;
	
	@PostMapping("/plans")
	public ResponseEntity<List<PlanResponse>> getPlans(@RequestBody SearchRequest req)
	{
		List<PlanResponse> searchPlans=service.searchPlan(req);
		return new ResponseEntity<List<PlanResponse>>(searchPlans,HttpStatus.OK);
	}
	
	@GetMapping("/getPlanNames")
	public ResponseEntity<List<String>> getPlanNames()
	{
		List<String> uniquePlans = service.getUniquePlanNames();
		return new ResponseEntity<List<String>>(uniquePlans,HttpStatus.OK);
	}
	
	@GetMapping("/getPlanStatus")
	public ResponseEntity<List<String>> getPlanStatus()
	{
		List<String> uniquePlanStatus = service.getUniquePlanStatus();
		return new ResponseEntity<List<String>>(uniquePlanStatus,HttpStatus.OK);
	}
	
	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse response) throws Exception
	{
		response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        
        List<PlanResponse> plans =service.searchPlan(null); // null is because without filtering we need to get data in excel..after filtering also you can give
        ExcelReportGenerator excelReport = new ExcelReportGenerator();
        excelReport.export(plans, response);
         
	}
	
	@GetMapping("/pdf")
    public void exportToPDF(HttpServletResponse response) throws Exception
	{
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=plans.pdf";
        response.setHeader(headerKey, headerValue);
        
        
        List<PlanResponse> plans = service.searchPlan(null);
        PdfGeneratorReport exporter = new PdfGeneratorReport();
         
        exporter.exportPdf(response, plans);
         
    }

}
