package org.mowitnow.beans;

public enum MovementAction {
	LEFT(-1, 0), 
	RIGHT(1, 0), 
	TOP(0, 1), 
	DOWN(0, -1);
	
	private int mXValue;
	private int mYValue;
	private MovementAction(int pXValue, int pYValue) {
		mXValue = pXValue;
		mYValue = pYValue;
	}
	
	public int getXValue() {
		return mXValue;
	}
	
	public int getYValue() {
		return mYValue;
	}
}
