package com.smoothstack.gcfashion.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TaxReport implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String store;
	private BigDecimal taxes;
	/**
	 * @param store
	 * @param taxes
	 */
	public TaxReport(String store, BigDecimal taxes) {
		super();
		this.store = store;
		this.taxes = taxes;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public BigDecimal getTaxes() {
		return taxes;
	}
	public void setTaxes(BigDecimal taxes) {
		this.taxes = taxes;
	}
	

}
