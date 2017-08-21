package org.mowitnow.beans;

public class Area {
	private int mRowSize;
	private int mColSize;
	
	public Area(int pRowSize, int pColSize) {
		mRowSize = pRowSize;
		mColSize = pColSize;
	}
	
	public int getRowSize() {
		return mRowSize;
	}
	public void setRowSize(int pRowSize) {
		mRowSize = pRowSize;
	}
	public int getColSize() {
		return mColSize;
	}
	public void setColSize(int pColSize) {
		mColSize = pColSize;
	}
}
