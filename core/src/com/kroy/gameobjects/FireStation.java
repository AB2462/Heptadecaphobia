package com.kroy.gameobjects;

import com.kroy.gameobjects.Firetruck;

public class FireStation extends GameObject {
	
	Firetruck residentTruck;
	int range;
	double refillAmount;
	double repairAmount;

	public FireStation(int range, double refillAmount, double repairAmount) {
		this.range = range;
		this.refillAmount = refillAmount;
		this.repairAmount = repairAmount;
	}
}
