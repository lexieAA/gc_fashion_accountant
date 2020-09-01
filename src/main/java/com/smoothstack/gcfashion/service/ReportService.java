package com.smoothstack.gcfashion.service;

import java.time.LocalDate;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.gcfashion.dao.ReportingDAO;
import com.smoothstack.gcfashion.dao.SampleDataDAO;
import com.smoothstack.gcfashion.entity.Report;
import com.smoothstack.gcfashion.entity.ReportSeries;

@Service
public class ReportService {
	
	@Autowired ReportingDAO reportsDAO;	
	@Autowired SampleDataDAO samples;
	HashMap<String, String> queryStrings = new HashMap<String, String>();	
	
	public Report getSalesByLoc(LocalDate startDate, LocalDate endDate) {		
		String reportName = "Get Sales by Location";
		String series1Name = "Total Sales";
		
		Report report = new Report(reportName);
		ReportSeries series1 = new ReportSeries(series1Name, reportsDAO.getSeriesData(queryStrings.get("salesbyloc"), startDate, endDate));		
		report.addSeries(series1);
		return report;		
	}

	public Report getTaxesByLoc(LocalDate startDate, LocalDate endDate) {		
		String reportName = "Get Sales by Location";
		String series1Name = "Total Sales";
		
		Report report = new Report(reportName);
		ReportSeries series1 = new ReportSeries(series1Name, reportsDAO.getSeriesData(queryStrings.get("taxesbyloc"), startDate, endDate));		
		report.addSeries(series1);
		return report;		
	}
	
	public Report getSalesByCat(LocalDate startDate, LocalDate endDate) {		
		String reportName = "Get Sales by Location";
		String series1Name = "Total Sales";
		
		Report report = new Report(reportName);
		ReportSeries series1 = new ReportSeries(series1Name, reportsDAO.getSeriesData(queryStrings.get("salesbycat"), startDate, endDate));		
		report.addSeries(series1);
		return report;		
	}
	
	public Report getTotalSales(LocalDate startDate, LocalDate endDate) {		
		String reportName = "Get Sales by Location";
		String series1Name = "Total Sales";
		
		Report report = new Report(reportName);
		ReportSeries series1 = new ReportSeries(series1Name, reportsDAO.getSeriesData(queryStrings.get("totalsales"), startDate, endDate));		
		report.addSeries(series1);
		return report;		
	}
	
	public Report getTotalTaxes(LocalDate startDate, LocalDate endDate) {		
		String reportName = "Get Sales by Location";
		String series1Name = "Total Sales";
		
		Report report = new Report(reportName);
		ReportSeries series1 = new ReportSeries(series1Name, reportsDAO.getSeriesData(queryStrings.get("totaltaxes"), startDate, endDate));		
		report.addSeries(series1);
		return report;		
	}
	
	public Report getSalesByTransaction(LocalDate startDate, LocalDate endDate) {		
		String reportName = "Get Sales by Location";
		String series1Name = "Total Sales";
		
		Report report = new Report(reportName);
		ReportSeries series1 = new ReportSeries(series1Name, reportsDAO.getSeriesData(queryStrings.get("salesbytransaction"), startDate, endDate));		
		report.addSeries(series1);
		return report;		
	}
	
	public Report getAvgSales(LocalDate startDate, LocalDate endDate) {		
		String reportName = "Get Sales by Location";
		String series1Name = "Total Sales";
		
		Report report = new Report(reportName);
		ReportSeries series1 = new ReportSeries(series1Name, reportsDAO.getSeriesData(queryStrings.get("avgsales"), startDate, endDate));		
		report.addSeries(series1);
		return report;		
	}
	
	public Report getVolByLocation(LocalDate startDate, LocalDate endDate) {		
		String reportName = "Get Sales by Location";
		String series1Name = "Total Sales";
		
		Report report = new Report(reportName);
		ReportSeries series1 = new ReportSeries(series1Name, reportsDAO.getSeriesData(queryStrings.get("volbyloc"), startDate, endDate));		
		report.addSeries(series1);
		return report;		
	}

	public Report getReport(String reportName, LocalDate startDate, LocalDate endDate, Boolean isLiveData) {
		switch (reportName.toLowerCase()) {
		case "salesbyloc":
			return isLiveData ? getSalesByLoc(startDate, endDate) : samples.getFakeSalesByLoc();
		case "taxesbyloc":
			return isLiveData ? getTaxesByLoc(startDate, endDate) : samples.getFakeSalesByLoc();
		case "salesbycat":
			return isLiveData ? getSalesByCat(startDate, endDate) : samples.getFakeSalesByLoc();
		case "totalsales":
			return isLiveData ? getTotalSales(startDate, endDate) : samples.getFakeSalesByLoc();
		case "totaltaxes":
			return isLiveData ? getTotalTaxes(startDate, endDate) : samples.getFakeSalesByLoc();
		case "avgsales":
			return isLiveData ? getAvgSales(startDate, endDate) : samples.getFakeSalesByLoc();
		case "salesbytransaction":
			return isLiveData ? getSalesByTransaction(startDate, endDate) : samples.getFakeSalesByLoc();
		case "volbyloc":
			return isLiveData ? getVolByLocation(startDate, endDate) : samples.getFakeSalesByLoc();
		default:
			return samples.getBlankReport();
		}	
	}
	
	@PostConstruct
	public void init() {		
		String query_salesbyloc = "select s.store_name as 'Store Name', SUM(t.total) as 'Total Sales' from store s left join transaction t on s.store_id = t.store_id where t.transactionTime >= :startDate and t.transactionTime <= :endDate and t.status = 'complete' group by s.store_name order by s.store_name";
		String query_taxesbyloc = "select s.store_name as 'Store Name', SUM(t.total) as 'Total Sales' from store s left join transaction t on s.store_id = t.store_id where t.transactionTime >= :startDate and t.transactionTime <= :endDate and t.status = 'complete' group by s.store_name order by s.store_name";
		String query_salesbycat = "select s.store_name as 'Store Name', SUM(t.total) as 'Total Sales' from store s left join transaction t on s.store_id = t.store_id where t.transactionTime >= :startDate and t.transactionTime <= :endDate and t.status = 'complete' group by s.store_name order by s.store_name";
		String query_totalsales = "select s.store_name as 'Store Name', SUM(t.total) as 'Total Sales' from store s left join transaction t on s.store_id = t.store_id where t.transactionTime >= :startDate and t.transactionTime <= :endDate and t.status = 'complete' group by s.store_name order by s.store_name";
		String query_totaltaxes = "select s.store_name as 'Store Name', SUM(t.total) as 'Total Sales' from store s left join transaction t on s.store_id = t.store_id where t.transactionTime >= :startDate and t.transactionTime <= :endDate and t.status = 'complete' group by s.store_name order by s.store_name";
		String query_avgsales = "select s.store_name as 'Store Name', SUM(t.total) as 'Total Sales' from store s left join transaction t on s.store_id = t.store_id where t.transactionTime >= :startDate and t.transactionTime <= :endDate and t.status = 'complete' group by s.store_name order by s.store_name";
		String query_salesbytransaction = "select s.store_name as 'Store Name', SUM(t.total) as 'Total Sales' from store s left join transaction t on s.store_id = t.store_id where t.transactionTime >= :startDate and t.transactionTime <= :endDate and t.status = 'complete' group by s.store_name order by s.store_name";
		String query_volbyloc = "select s.store_name as 'Store Name', SUM(t.total) as 'Total Sales' from store s left join transaction t on s.store_id = t.store_id where t.transactionTime >= :startDate and t.transactionTime <= :endDate and t.status = 'complete' group by s.store_name order by s.store_name";
		
		queryStrings.put("salesbyloc", query_salesbyloc);
		queryStrings.put("taxesbyloc", query_taxesbyloc);
		queryStrings.put("salesbycat", query_salesbycat);
		queryStrings.put("totalsales", query_totalsales);
		queryStrings.put("totaltaxes", query_totaltaxes);
		queryStrings.put("salesbytransaction", query_salesbytransaction);
		queryStrings.put("avgsales", query_avgsales);
		queryStrings.put("volbyloc", query_volbyloc);		
	}
}
