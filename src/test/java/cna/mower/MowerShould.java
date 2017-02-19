// Created at 2017/02/12.
package cna.mower;

import org.junit.Assert;
import org.junit.Test;

import cna.mower.Action;
import cna.mower.CardinalOrientation;
import cna.mower.LawnBoundaries;
import cna.mower.Mower;
import cna.mower.Position;


/**
 * Tests of {@link Mower} class.
 * @author cnagat
 * @since 1.0.0
 */
public class MowerShould {
	
	// -----------------------------------------------------------------------------------------------------------------
	// Turn action tests.
	// -----------------------------------------------------------------------------------------------------------------
	
	@Test
	public void change_orientation_when_turn_left_action_recieved() {
		// Given
		LawnBoundaries lawnBoundaries = new LawnBoundaries(new Position(5, 5));
		Position position = new Position(0, 0);
		Mower mower = new Mower(position, CardinalOrientation.NORTH, lawnBoundaries);
		// When
		mower.apply(Action.TURN_LEFT);
		// Then
		Assert.assertEquals(CardinalOrientation.WEST, mower.getOrientation());
	}
	
	@Test
	public void change_orientation_when_turn_right_action_recieved() {
		// Given
		LawnBoundaries lawnBoundaries = new LawnBoundaries(new Position(5, 5));
		Position position = new Position(0, 0);
		Mower mower = new Mower(position, CardinalOrientation.NORTH, lawnBoundaries);
		// When
		mower.apply(Action.TURN_RIGHT);
		// Then
		Assert.assertEquals(CardinalOrientation.EAST, mower.getOrientation());
	}

	// -----------------------------------------------------------------------------------------------------------------
	// Move test.
	// -----------------------------------------------------------------------------------------------------------------
	
	@Test
	public void change_position_when_move_action_received_and_the_new_position_is_inside_the_lawn() {
		// Given
		LawnBoundaries lawnBoundaries = new LawnBoundaries(new Position(5, 5));
		Position position = new Position(0, 0);
		Mower mower = new Mower(position, CardinalOrientation.NORTH, lawnBoundaries);
		// When
		mower.apply(Action.MOVE_FORWARD);
		// Then
		Assert.assertNotEquals(position, mower.getPosition());
	}
	
	@Test
	public void not_change_position_when_move_action_received_and_the_new_position_is_outside_the_lawn() {
		// Given
		LawnBoundaries lawnBoundaries = new LawnBoundaries(new Position(5, 5));
		Position position = new Position(0, 5);
		Mower mower = new Mower(position, CardinalOrientation.NORTH, lawnBoundaries);
		// When
		mower.apply(Action.MOVE_FORWARD);
		// Then
		Assert.assertEquals(position, mower.getPosition());
	}
}
