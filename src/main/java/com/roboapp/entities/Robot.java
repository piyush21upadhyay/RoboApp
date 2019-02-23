/**
 * 
 */
package com.roboapp.entities;

/**
 * @author PIYUSH
 *
 */
public class Robot {
	private double distanceCovers;
	private int batteryPercentage;
	private double weightToCarry;
	private String messageDisplayed;

	public double getDistanceCovers() {
		return distanceCovers;
	}

	public void setDistanceCovers(double distanceCovers) {
		this.distanceCovers = distanceCovers;
	}

	public int getBatteryPercentage() {
		return batteryPercentage;
	}

	public void setBatteryPercentage(int batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}

	public double getWeightToCarry() {
		return weightToCarry;
	}

	public void setWeightToCarry(double weightCarries) {
		this.weightToCarry = weightCarries;
	}

	public String getMessageDisplayed() {
		return messageDisplayed;
	}

	public void setMessageDisplayed(String messageDisplayed) {
		this.messageDisplayed = messageDisplayed;
	}
}
