// created at 2017/02/12
package cna.mower;

import org.junit.Assert;
import org.junit.Test;

import cna.mower.Action;
import cna.mower.CardinalOrientation;
import cna.mower.LawnBoundaries;
import cna.mower.Mower;
import cna.mower.Position;

/**
 * Nominal test defined in exercice instruction.
 * 
 * @author cnagat
 * @since 1.0.0
 */
public class NominalTestShould {

	@Test
	public void success_when_it_runs() {
		// Given
		LawnBoundaries lawnBoundaries = new LawnBoundaries(new Position(5, 5));
		Mower mower1 = new Mower(new Position(1, 2), CardinalOrientation.NORTH, lawnBoundaries);
		Mower mower2 = new Mower(new Position(3, 3), CardinalOrientation.EAST, lawnBoundaries);
		// When GAGAGAGAA
		mower1.apply(Action.TURN_LEFT);
		mower1.apply(Action.MOVE_FORWARD);
		mower1.apply(Action.TURN_LEFT);
		mower1.apply(Action.MOVE_FORWARD);
		mower1.apply(Action.TURN_LEFT);
		mower1.apply(Action.MOVE_FORWARD);
		mower1.apply(Action.TURN_LEFT);
		mower1.apply(Action.MOVE_FORWARD);
		mower1.apply(Action.MOVE_FORWARD);
		// When AADAADADDA
		mower2.apply(Action.MOVE_FORWARD);
		mower2.apply(Action.MOVE_FORWARD);
		mower2.apply(Action.TURN_RIGHT);
		mower2.apply(Action.MOVE_FORWARD);
		mower2.apply(Action.MOVE_FORWARD);
		mower2.apply(Action.TURN_RIGHT);
		mower2.apply(Action.MOVE_FORWARD);
		mower2.apply(Action.TURN_RIGHT);
		mower2.apply(Action.TURN_RIGHT);
		mower2.apply(Action.MOVE_FORWARD);
		// Then
		Assert.assertEquals(1, mower1.getPosition().getX());
		Assert.assertEquals(3, mower1.getPosition().getY());
		Assert.assertEquals(CardinalOrientation.NORTH, mower1.getOrientation());
		Assert.assertEquals(5, mower2.getPosition().getX());
		Assert.assertEquals(1, mower2.getPosition().getY());
		Assert.assertEquals(CardinalOrientation.EAST, mower2.getOrientation());
	}

}
