package in.ashokit.reports;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import in.ashokit.bindings.PlanResponse;

public class ExcelReportGenerator 
{
	public void export(List<PlanResponse> plans,HttpServletResponse response) throws Exception
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Plans");
		XSSFRow headerRow = sheet.createRow(0);
		
		XSSFCell headerCell0 = headerRow.createCell(0);
		headerCell0.setCellValue("PlanId");
		
		XSSFCell headerCell1 = headerRow.createCell(0);
		headerCell1.setCellValue("HeaderName");
		
		XSSFCell headerCell2 = headerRow.createCell(0);
		headerCell2.setCellValue("HolderName");
		
		XSSFCell headerCell3 = headerRow.createCell(0);
		headerCell3.setCellValue("PlanName");
		
		XSSFCell headerCell4 = headerRow.createCell(0);
		headerCell4.setCellValue("PlanStatus");
		
		//headerRow.createCell(0).setCellValue("PlanStatus"); Optimized Code
		
		for(int i =0;i<plans.size();i++)
		{
			PlanResponse plan = plans.get(i);
			XSSFRow dataRow = sheet.createRow(i+1);
			
			XSSFCell cell0 = dataRow.createCell(0);
			cell0.setCellValue(plan.getPlanId());
			
			XSSFCell cell1 = dataRow.createCell(0);
			cell1.setCellValue(plan.getPlanHolder());
			
			XSSFCell cell2 = dataRow.createCell(0);
			cell2.setCellValue(plan.getPlanHolderssn());
			
			XSSFCell cell3 = dataRow.createCell(0);
			cell3.setCellValue(plan.getPlanName());
			
			XSSFCell cell4 = dataRow.createCell(0);
			cell4.setCellValue(plan.getPlanStatus());
			
			//dataRow.createCell(0).cell4.setCellValue(plan.getPlanStatus()); Optimized Code
			
		}
		
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
		
		
		
	}

}
