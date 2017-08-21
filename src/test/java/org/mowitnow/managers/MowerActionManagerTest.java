package org.mowitnow.managers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mowitnow.beans.RotationAction;
import org.mowitnow.beans.Mower;
import org.mowitnow.beans.Orientation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class MowerActionManagerTest {
	
	@Autowired
	private IMowerActionManager mMowerActionManager; // with area 5 5
	
	@Test
	public void testCreateAt(){
		mMowerActionManager.createMowerAt(0, 0, Orientation.South);

		Mower lMower = mMowerActionManager.getMower();
		
		assert lMower.toString().equals("0 0 S");
	}
	
	@Test
	public void testMowerOutOfBound(){
		mMowerActionManager.createMowerAt(7, 7, Orientation.North);

		Mower lMower = mMowerActionManager.getMower();
		
		assert lMower.toString().equals("5 5 N");
	}
	
	@Test
	public void testActionMowerRotateLeft() throws Exception {
		mMowerActionManager.createMowerAt(1, 1, Orientation.North);

		mMowerActionManager.actionMower(RotationAction.L);
		
		Mower lMower = mMowerActionManager.getMower();
		
		assert lMower.toString().equals("1 1 W");
	}
	
	@Test
	public void testActionMowerRotateRight() throws Exception {
		mMowerActionManager.createMowerAt(3, 5, Orientation.North);

		mMowerActionManager.actionMower(RotationAction.R);
		
		Mower lMower = mMowerActionManager.getMower();
		
		assert lMower.toString().equals("3 5 E");
	}
	
	@Test
	public void testActionMowerMovinNorth() throws Exception {
		mMowerActionManager.createMowerAt(3, 4, Orientation.North);

		mMowerActionManager.actionMower(RotationAction.A);
		
		Mower lMower = mMowerActionManager.getMower();
		
		assert lMower.toString().equals("3 5 N");
	}
	
	@Test
	public void testActionMowerMovinEast() throws Exception {
		mMowerActionManager.createMowerAt(3, 4, Orientation.East);

		mMowerActionManager.actionMower(RotationAction.A);
		
		Mower lMower = mMowerActionManager.getMower();
		
		assert lMower.toString().equals("4 4 E");
	}
	
	@Test
	public void testActionMowerMovinSouth() throws Exception {
		mMowerActionManager.createMowerAt(3, 4, Orientation.South);

		mMowerActionManager.actionMower(RotationAction.A);
		
		Mower lMower = mMowerActionManager.getMower();
		
		assert lMower.toString().equals("3 3 S");
	}
	
	@Test
	public void testActionMowerMovinWest() throws Exception {
		mMowerActionManager.createMowerAt(3, 4, Orientation.West);

		mMowerActionManager.actionMower(RotationAction.A);
		
		Mower lMower = mMowerActionManager.getMower();
		
		assert lMower.toString().equals("2 4 W");
	}
	
	
	@Test
	public void testActionMowerMovinOutOfBoundNorth() throws Exception {
		mMowerActionManager.createMowerAt(5, 5, Orientation.North);

		mMowerActionManager.actionMower(RotationAction.A);
		
		Mower lMower = mMowerActionManager.getMower();
		
		assert lMower.toString().equals("5 5 N");
	}
	
	@Test
	public void testActionMowerMovinOutOfBoundSouth() throws Exception {
		mMowerActionManager.createMowerAt(0, 0, Orientation.South);

		mMowerActionManager.actionMower(RotationAction.A);
		
		Mower lMower = mMowerActionManager.getMower();
		
		assert lMower.toString().equals("0 0 S");
	}
	
	@Test
	public void testComplexOne() throws Exception {
		mMowerActionManager.createMowerAt(1, 2, Orientation.North);
		
		mMowerActionManager.actionMower(RotationAction.L);
		mMowerActionManager.actionMower(RotationAction.A);
		mMowerActionManager.actionMower(RotationAction.L);
		mMowerActionManager.actionMower(RotationAction.A);
		mMowerActionManager.actionMower(RotationAction.L);
		mMowerActionManager.actionMower(RotationAction.A);
		mMowerActionManager.actionMower(RotationAction.L);
		mMowerActionManager.actionMower(RotationAction.A);
		mMowerActionManager.actionMower(RotationAction.A);
		
		Mower lMower = mMowerActionManager.getMower();
		
		assert lMower.toString().equals("1 3 N");
	}
	
	@Test
	public void testComplexTwo() throws Exception {
		mMowerActionManager.createMowerAt(3, 3, Orientation.East);
		
		mMowerActionManager.actionMower(RotationAction.A);
		mMowerActionManager.actionMower(RotationAction.A);
		mMowerActionManager.actionMower(RotationAction.R);
		mMowerActionManager.actionMower(RotationAction.A);
		mMowerActionManager.actionMower(RotationAction.A);
		mMowerActionManager.actionMower(RotationAction.R);
		mMowerActionManager.actionMower(RotationAction.A);
		mMowerActionManager.actionMower(RotationAction.R);
		mMowerActionManager.actionMower(RotationAction.R);
		mMowerActionManager.actionMower(RotationAction.A);
		
		Mower lMower = mMowerActionManager.getMower();
		
		assert lMower.toString().equals("5 1 E");
	}
}
