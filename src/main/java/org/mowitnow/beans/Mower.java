package org.mowitnow.beans;

import java.text.MessageFormat;

public class Mower {
	private static final String TO_STRING = "{0} {1} {2}";
	private Position mPosition;
	private Orientation mOrientation;
	
	public Mower(Position pPosition, Orientation pOrientation){
		mPosition = pPosition;
		mOrientation = pOrientation;
	}
	
	public Mower(int pX, int pY, Orientation pOrientation){
		this(new Position(pX, pY), pOrientation);
	}
	
	public Position getPosition() {
		return mPosition;
	}
	
	public void setPosition(Position pPosition) {
		mPosition = pPosition;
	}
	
	public Orientation getOrientation() {
		return mOrientation;
	}
	
	public void setOrientation(Orientation pOrientation) {
		mOrientation = pOrientation;
	}
	
	@Override
	public String toString() {
		return MessageFormat.format(TO_STRING, mPosition.getX(), mPosition.getY(), mOrientation.toString());
	}
}
