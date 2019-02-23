package com.roboapp.impltest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.roboapp.Interface.IRoboApp;
import com.roboapp.entities.BarCode;
import com.roboapp.entities.Robot;
import com.roboapp.exception.LowBatteryException;
import com.roboapp.exception.OverweightException;
import com.roboapp.exception.ScanFailureException;
import com.roboapp.impl.RoboAppImpl;

public class RoboAppImplTest {
	private IRoboApp iroboApp;
	private Robot robot;
	private BarCode barcode;

	@Before
	public void setup() {
		iroboApp = new RoboAppImpl();
		robot = new Robot();
		barcode = new BarCode();
		barcode.setBarCodeId("x5t6&");
		barcode.setBarCodePrice(55.0d);
		robot.setBatteryPercentage(100);
	}

	@Test(expected = OverweightException.class)
	public void testOverWeightException() {
		robot.setWeightToCarry(12.0d);
		iroboApp.handlePhysicalObjects(robot);
	}
	
	@Test(expected = LowBatteryException.class)
	public void testLowBatteryException(){
		robot.setBatteryPercentage(12);
		robot.setDistanceCovers(3.5d);
		iroboApp.batteryPercentageLeftWhilewalkAround(robot);
	}
	
	@Test(expected = ScanFailureException.class)
	public void testScanFailureException(){
		barcode.setBarCodeClear(false);
		iroboApp.scanBarCode(barcode);
	}
	
	@Test
	public void testBatteryLevelWhileWalking() {
		robot.setDistanceCovers(3.5d);
		Double batteryPercentageLeft = iroboApp
				.batteryPercentageLeftWhilewalkAround(robot);
		Assert.assertEquals(30.0, batteryPercentageLeft, 0.0);
		System.out.println(batteryPercentageLeft);
	}

	@Test
	public void testBatteryLevelWhileWalkingAndCarryingWeight() {
		robot.setDistanceCovers(2.0d);
		robot.setWeightToCarry(3.0d);
		Double batteryPercentageLeft = iroboApp.handlePhysicalObjects(robot);
		Assert.assertEquals(54.0, batteryPercentageLeft, 0.0);
		System.out.println(batteryPercentageLeft);
	}
	
	@Test
	public void testBarCodeScanFeature(){
		barcode.setBarCodeClear(true);
		System.out.println("Value of product through barcode scanning is::"+barcode.getBarCodePrice());
		iroboApp.scanBarCode(barcode);
	}
	
	@After
	public void cleanup(){
		iroboApp = null;
		robot = null;
		barcode = null;
	}
}
