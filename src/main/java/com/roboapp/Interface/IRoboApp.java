package com.roboapp.Interface;

import com.roboapp.entities.BarCode;
import com.roboapp.entities.Robot;
import com.roboapp.exception.LowBatteryException;
import com.roboapp.exception.OverweightException;
import com.roboapp.exception.ScanFailureException;

public interface IRoboApp {
	public Double scanBarCode(BarCode barCode) throws ScanFailureException;

	Double batteryPercentageLeftWhilewalkAround(Robot robot) throws LowBatteryException;

	Double handlePhysicalObjects(Robot robot) throws OverweightException;
}
