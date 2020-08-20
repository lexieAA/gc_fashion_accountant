package com.smoothstack.gcfashion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class ReportElement implements Serializable {

	private static final long serialVersionUID = -8268208666395268591L;
	private String label;
	private BigDecimal value;

	public ReportElement(String label, BigDecimal value) {
		super();
		this.label = label;
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(label, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ReportElement)) {
			return false;
		}
		ReportElement other = (ReportElement) obj;
		return Objects.equals(label, other.label) && Objects.equals(value, other.value);
	}

}
