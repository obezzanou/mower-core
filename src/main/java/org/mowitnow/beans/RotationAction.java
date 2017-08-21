package org.mowitnow.beans;

public enum RotationAction {
	R('D', 1),
	L('G', -1),
	A('A', 0);
	
	
	private Character mCode;
	private int mActionValue;
	private RotationAction(char pCode, int pActionValue) {
		mCode = pCode;
		mActionValue = pActionValue;
	}
	@Override
	public String toString() {
		return mCode.toString();
	}
	
	public int getActionValue() {
		return mActionValue;
	}
}
