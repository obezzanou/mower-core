package org.mowitnow.beans;

public class Position {
	private int mY;
	private int mX;
	
	public Position() {
		this(0, 0);
	}
	
	public Position(int pX, int pY){
		mX = pX;
		mY = pY;
	}
	
	public int getY() {
		return mY;
	}
	public void setY(int pY) {
		mY = pY;
	}
	public int getX() {
		return mX;
	}
	public void setX(int pX) {
		mX = pX;
	}
}
