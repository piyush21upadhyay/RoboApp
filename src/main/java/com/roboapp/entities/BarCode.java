/**
 * 
 */
package com.roboapp.entities;

/**
 * @author PIYUSH
 *
 */
public class BarCode {
	private String barCodeId;
	private double barCodePrice;
	private boolean isBarCodeClear;

	public String getBarCodeId() {
		return barCodeId;
	}

	public void setBarCodeId(String barCodeId) {
		this.barCodeId = barCodeId;
	}

	public double getBarCodePrice() {
		return barCodePrice;
	}

	public void setBarCodePrice(double barCodePrice) {
		this.barCodePrice = barCodePrice;
	}

	public boolean isBarCodeClear() {
		return isBarCodeClear;
	}

	public void setBarCodeClear(boolean isBarCodeClear) {
		this.isBarCodeClear = isBarCodeClear;
	}

}
