package com.smoothstack.gcfashion.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ReportSeries implements Serializable {

	private static final long serialVersionUID = -4060296812715658435L;
	private String seriesName;
	private List<ReportElement> seriesData;

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public List<ReportElement> getSeriesData() {
		return seriesData;
	}

	public void setSeriesData(List<ReportElement> seriesData) {
		this.seriesData = seriesData;
	}

	@Override
	public int hashCode() {
		return Objects.hash(seriesData, seriesName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ReportSeries)) {
			return false;
		}
		ReportSeries other = (ReportSeries) obj;
		return Objects.equals(seriesData, other.seriesData) && Objects.equals(seriesName, other.seriesName);
	}

}
