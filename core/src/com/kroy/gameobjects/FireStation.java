package com.kroy.gameobjects;

public class FireStation extends GameObject {
	
	FireTruck residentTruck;
	int range;
	double refillAmount;
	double repairAmount;

	public FireStation(int range, double refillAmount, double repairAmount) {
		this.range = range;
		this.refillAmount = refillAmount;
		this.repairAmount = repairAmount;
	}
	
	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update() {
		// TODO Auto-generated method stub
		
	}

}
