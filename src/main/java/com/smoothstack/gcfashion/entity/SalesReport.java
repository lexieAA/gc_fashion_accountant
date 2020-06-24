package com.smoothstack.gcfashion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class SalesReport implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8268208666395268591L;
	private String store;
	private BigDecimal sales;
	/**
	 * @param store
	 * @param sales
	 */
	public SalesReport(String store, BigDecimal sales) {
		super();
		this.store = store;
		this.sales = sales;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public BigDecimal getSales() {
		return sales;
	}
	public void setSales(BigDecimal sales) {
		this.sales = sales;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(sales, store);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SalesReport)) {
			return false;
		}
		SalesReport other = (SalesReport) obj;
		return Objects.equals(sales, other.sales) && Objects.equals(store, other.store);
	}	

}
