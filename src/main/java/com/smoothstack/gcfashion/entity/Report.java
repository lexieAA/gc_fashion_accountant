package com.smoothstack.gcfashion.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Report implements Serializable {

	private static final long serialVersionUID = 1L;
	private String reportName;
	private List<ReportSeries> reportData;

	public Report(String reportName, List<ReportSeries> reportData) {
		super();
		this.reportName = reportName;
		this.reportData = reportData;
	}
	
	public Report(String reportName) {
		super();
		this.reportName = reportName;
		this.reportData = new ArrayList<>();
	}

	public Report() {
		super();
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public List<ReportSeries> getReportData() {
		return reportData;
	}

	public void setReportData(List<ReportSeries> reportData) {
		this.reportData = reportData;
	}
	
	public void addSeries(ReportSeries series) {
		this.reportData.add(series);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(reportData, reportName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Report)) {
			return false;
		}
		Report other = (Report) obj;
		return Objects.equals(reportData, other.reportData) && Objects.equals(reportName, other.reportName);
	}

}
