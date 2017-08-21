package org.mowitnow.beans;

public enum Orientation {
	North('N', 0, MovementAction.TOP),
	East('E', 1, MovementAction.RIGHT),
	South('S', 2, MovementAction.DOWN),
	West('W', 3, MovementAction.LEFT);
	
	private Character mCode;
	private Integer mIndex;
	private MovementAction mMovementAction;
	
	Orientation(Character pCode, int pIndex, MovementAction pMovementAction){
		mCode = pCode;
		mIndex = pIndex;
		mMovementAction = pMovementAction;
	}
	
	public MovementAction getMovementAction() {
		return mMovementAction;
	}
	
	public int getIndex() {
		return mIndex;
	}
	
	public Character getCode() {
		return mCode;
	}
	
	@Override
	public String toString() {
		return mCode.toString();
	}
}
