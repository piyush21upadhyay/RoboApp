/**
 * 
 */
package com.roboapp.impl;

import com.roboapp.Interface.IConstants;
import com.roboapp.Interface.IRoboApp;
import com.roboapp.entities.BarCode;
import com.roboapp.entities.Robot;
import com.roboapp.exception.LowBatteryException;
import com.roboapp.exception.OverweightException;
import com.roboapp.exception.ScanFailureException;

/**
 * @author PIYUSH
 *
 */
public class RoboAppImpl implements IRoboApp, IConstants {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.roboapp.Interface.IRoboApp#walkAround()
	 */
	public Double batteryPercentageLeftWhilewalkAround(Robot robot)
			throws LowBatteryException {
		if (robot.getBatteryPercentage() < 15) {
			System.out.println("Low Battery");
			throw new LowBatteryException("Low Battery");
		}

		return (100 - (100 * robot.getDistanceCovers())
				/ MAX_DISTANCE_CAN_COVER);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.roboapp.Interface.IRoboApp#handlePhysicalObjects(com.roboapp.entities
	 * .Robot)
	 */
	public Double handlePhysicalObjects(Robot robot) throws OverweightException {
		if (robot.getWeightToCarry() > MAX_WEIGHT_CAN_CARRY) {
			System.out.println("Overweight");
			throw new OverweightException("Overweight");
		}

		return batteryPercentageLeftWhilewalkAround(robot)
				- (robot.getWeightToCarry() * 2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.roboapp.Interface.IRoboApp#scanBarCode(com.roboapp.entities.BarCode)
	 */
	public Double scanBarCode(BarCode barCode) throws ScanFailureException {
		if (!barCode.isBarCodeClear()) {
			System.out.println("Scan Failure");
			throw new ScanFailureException("Scan Failure");
		}
		return barCode.getBarCodePrice();
	}

}
