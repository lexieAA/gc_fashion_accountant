package com.smoothstack.gcfashion.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DummyData {

	public Report getFakeSalesByCat() {
		List<ReportElement> data = new ArrayList<ReportElement>();
		data.add(new ReportElement("Sweaters", BigDecimal.valueOf(520)));
		data.add(new ReportElement("Tops", BigDecimal.valueOf(890)));
		data.add(new ReportElement("Dresses", BigDecimal.valueOf(1200)));
		data.add(new ReportElement("Skirts", BigDecimal.valueOf(600)));
		data.add(new ReportElement("Pants", BigDecimal.valueOf(500)));
//		data.add(new ReportElement("Swimwear", BigDecimal.valueOf(400)));
//		data.add(new ReportElement("Shoes", BigDecimal.valueOf(650)));
		return new Report("Sales by Category", data);
	}
	
	public Report getFakeSalesByLoc() {
		List<ReportElement> data = new ArrayList<ReportElement>();
		data.add(new ReportElement("Online", BigDecimal.valueOf(5200)));
		data.add(new ReportElement("Store 1", BigDecimal.valueOf(3200)));
		data.add(new ReportElement("Store 2", BigDecimal.valueOf(2500)));
		data.add(new ReportElement("Store 3", BigDecimal.valueOf(1100)));
		data.add(new ReportElement("Store 4", BigDecimal.valueOf(2800)));
		return new Report("Sales by Location", data);
	}
	
	public Report getFakeVolByLoc() {
		List<ReportElement> data = new ArrayList<ReportElement>();
		data.add(new ReportElement("Online", BigDecimal.valueOf(340)));
		data.add(new ReportElement("Store 1", BigDecimal.valueOf(270)));
		data.add(new ReportElement("Store 2", BigDecimal.valueOf(120)));
		data.add(new ReportElement("Store 3", BigDecimal.valueOf(65)));
		data.add(new ReportElement("Store 4", BigDecimal.valueOf(150)));
		return new Report("Volume by Location", data);
	}
	
	public Report getFakeTaxes() {
		List<ReportElement> data = new ArrayList<ReportElement>();
		data.add(new ReportElement("Jul", BigDecimal.valueOf(3100)));
		data.add(new ReportElement("Aug", BigDecimal.valueOf(2900)));
		data.add(new ReportElement("Sep", BigDecimal.valueOf(3500)));
		data.add(new ReportElement("Oct", BigDecimal.valueOf(2700)));
		data.add(new ReportElement("Nov", BigDecimal.valueOf(2300)));
		data.add(new ReportElement("Dec", BigDecimal.valueOf(3700)));
		data.add(new ReportElement("Jan", BigDecimal.valueOf(2800)));
		data.add(new ReportElement("Feb", BigDecimal.valueOf(2300)));
		data.add(new ReportElement("Mar", BigDecimal.valueOf(2700)));
		data.add(new ReportElement("Apr", BigDecimal.valueOf(2900)));
		data.add(new ReportElement("May", BigDecimal.valueOf(2700)));
		data.add(new ReportElement("Jun", BigDecimal.valueOf(3300)));
		return new Report("Sales by Month", data);
	}
	
	public Report getFakeTotalSales() {
		List<ReportElement> data = new ArrayList<ReportElement>();
		data.add(new ReportElement("Sales", BigDecimal.valueOf(36580.52)));
		return new Report("Total Sales", data);
	}
	
	public Report getFakeTotalTaxes() {
		List<ReportElement> data = new ArrayList<ReportElement>();
		data.add(new ReportElement("Taxes", BigDecimal.valueOf(814.80)));
		return new Report("Taxes Collected", data);
	}
	
	public Report getFakeSalesPerDay() {
		List<ReportElement> data = new ArrayList<ReportElement>();
		data.add(new ReportElement("Online", BigDecimal.valueOf(36580.52/30)));
		return new Report("Sales / Day", data);
	}
	
	public Report getFakeSalesPerTransaction() {
		List<ReportElement> data = new ArrayList<ReportElement>();
		data.add(new ReportElement("Online", BigDecimal.valueOf(36580.52/500)));
		return new Report("Sales / Transaction", data);
	}

}
