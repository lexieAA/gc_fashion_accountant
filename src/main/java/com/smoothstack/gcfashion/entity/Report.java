package com.smoothstack.gcfashion.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Report implements Serializable {

	private static final long serialVersionUID = 1L;
	private String reportName;
	private List<ReportElement> reportData;

	public Report(String reportName, List<ReportElement> reportData) {
		super();
		this.reportName = reportName;
		this.reportData = reportData;
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

	public List<ReportElement> getReportData() {
		return reportData;
	}

	public void setReportData(List<ReportElement> reportData) {
		this.reportData = reportData;
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
