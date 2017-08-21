package org.mowitnow.managers.impl;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

import org.mowitnow.beans.RotationAction;
import org.mowitnow.beans.Area;
import org.mowitnow.beans.MovementAction;
import org.mowitnow.beans.Mower;
import org.mowitnow.beans.Orientation;
import org.mowitnow.beans.Position;
import org.mowitnow.managers.IMowerActionManager;


public class MowerActionManagerImpl implements IMowerActionManager {
	
	private static final String ERROR_NEXT_MOVE_CALC = "Error can t calculate next move from {0} with action {1}";
	private static final String ERROR_NO_MOWER = "No Mower to manage";
	
	private Mower mMower;
	private Area mArea;
	
	public MowerActionManagerImpl(Area pArea){
		mArea = pArea;
	}
	
	public MowerActionManagerImpl(int pRows, int pCols){
		mArea = new Area(pRows, pCols);
	}
	
	@Override
	public Position createMowerAt(Position pPosition, Orientation pOrientationCode) {
		if(mMower == null){
			mMower = new Mower(pPosition, pOrientationCode);
		}else{
			mMower.setOrientation(pOrientationCode);
			mMower.setPosition(pPosition);
		}
		return adjustMowerPosition();
	}
	
	@Override
	public Position createMowerAt(int pX, int pY, Orientation pOrientationCode) {
		return createMowerAt(new Position(pX, pY), pOrientationCode);
	}

	public Position actionMower(RotationAction pActionCode) throws Exception {
		Position lPosition = null;
		if(mMower != null){
			Orientation lOriginOrientation = mMower.getOrientation();
			Orientation lNextOrientation = getMowerNextOrientation(lOriginOrientation, pActionCode);
			
			// rotate or move
			if(lNextOrientation.equals(lOriginOrientation)){ // MOVE
				moveMower(lNextOrientation.getMovementAction());
			}else{ // ROTATE
				mMower.setOrientation(lNextOrientation);
			}
			
			lPosition = mMower.getPosition();
		}else{
			throw new Exception("No Mower to manage");
		}
		return lPosition;
	}
	
	@Override
	public Position moveMower(MovementAction pMovementAction) throws Exception {
		mMower.getPosition().setX(mMower.getPosition().getX() + pMovementAction.getXValue());
		mMower.getPosition().setY(mMower.getPosition().getY() + pMovementAction.getYValue());
		return adjustMowerPosition();
	}
	
	private Position adjustMowerPosition(){
		Position lPosition = mMower.getPosition();
		
		if(lPosition.getX() > mArea.getColSize()){
			lPosition.setX(mArea.getColSize());
		}
		if(lPosition.getX() < 0){
			lPosition.setX(0);
		}
		
		if(lPosition.getY() > mArea.getRowSize()){
			lPosition.setY(mArea.getRowSize());
		}
		if(lPosition.getY() < 0){
			lPosition.setY(0);
		}
		
		return lPosition;
	}
	
	// to bad we have to call it each time :'(
	private Orientation getMowerNextOrientation(Orientation pOrientationCode, RotationAction pActionCode) throws Exception {
		Orientation lNextOrientation = null;
		int lNextOrientationIndex = pOrientationCode.getIndex();
		
		List<Orientation> lOrientations = Arrays.asList(Orientation.values());
		
		// calculating the next Orientation index
		lNextOrientationIndex = pOrientationCode.getIndex() + pActionCode.getActionValue();

		// let s not get out of bound :'( not elegant, will see this later
		if(lNextOrientationIndex < 0){
			lNextOrientationIndex = lOrientations.size() - 1;
		}
		if(lNextOrientationIndex >= lOrientations.size()){
			lNextOrientationIndex = 0;
		}
		
		// let s say that the lNextOrientation will never be null ;)
		int fNextIndex = lNextOrientationIndex;
		lNextOrientation = lOrientations.stream()
			.filter(lOrientation -> lOrientation.getIndex() == fNextIndex)
			.findAny()
			.orElse(null);
		
		if(lNextOrientation == null) {
			throw new Exception(MessageFormat.format(ERROR_NEXT_MOVE_CALC, pOrientationCode.toString(), pActionCode.toString()));
		}
		
		return lNextOrientation;
	}
	
	@Override
	public Position getMowerPosition() throws Exception {
		Position lPosition = null;
		if(mMower != null){
			lPosition = mMower.getPosition();
		}else{
			throw new Exception(ERROR_NO_MOWER);
		}
		return lPosition;
	}
	
	public Mower getMower() {
		return mMower;
	}
	
	public void setMower(Mower pMower) {
		mMower = pMower;
	}
}
