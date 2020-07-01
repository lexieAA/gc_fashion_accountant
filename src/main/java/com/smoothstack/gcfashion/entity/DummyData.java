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
		data.add(new ReportElement("Swimwear", BigDecimal.valueOf(400)));
		data.add(new ReportElement("Shoes", BigDecimal.valueOf(650)));
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
	
	public Report getFakeTaxes() {
		List<ReportElement> data = new ArrayList<ReportElement>();
		data.add(new ReportElement("Online", BigDecimal.valueOf(520)));
		data.add(new ReportElement("Store 1", BigDecimal.valueOf(320)));
		data.add(new ReportElement("Store 2", BigDecimal.valueOf(250)));
		data.add(new ReportElement("Store 3", BigDecimal.valueOf(110)));
		data.add(new ReportElement("Store 4", BigDecimal.valueOf(280)));
		return new Report("Taxes by Location", data);
	}
	
	public Report getFakeTotalSales() {
		List<ReportElement> data = new ArrayList<ReportElement>();
		data.add(new ReportElement("Online", BigDecimal.valueOf(13580.52)));
		return new Report("Total Sales", data);
	}
	
	public Report getFakeTotalTaxes() {
		List<ReportElement> data = new ArrayList<ReportElement>();
		data.add(new ReportElement("Online", BigDecimal.valueOf(814.80)));
		return new Report("Total Taxes", data);
	}

}
