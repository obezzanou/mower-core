package org.mowitnow.managers;

import org.mowitnow.beans.RotationAction;
import org.mowitnow.beans.MovementAction;
import org.mowitnow.beans.Mower;
import org.mowitnow.beans.Orientation;
import org.mowitnow.beans.Position;

public interface IMowerActionManager {
	public Position actionMower(RotationAction pActionCode) throws Exception;
	public Mower getMower();
	public Position getMowerPosition() throws Exception;
	public Position moveMower(MovementAction pMovementAction) throws Exception;
	public Position createMowerAt(int pX, int pY, Orientation pOrientationCode);
	public Position createMowerAt(Position pPosition, Orientation pOrientationCode);
}
