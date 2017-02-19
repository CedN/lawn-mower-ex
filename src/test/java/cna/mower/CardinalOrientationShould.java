// created at 2017/02/12.
package cna.mower;

import org.junit.Assert;
import org.junit.Test;

import cna.mower.CardinalOrientation;

/**
 * Tests of {@link CardinalOrientation} enumeration.
 * 
 * @author cnagat
 * @since 1.0.0
 */
public class CardinalOrientationShould {

	// -----------------------------------------------------------------------------------------------------------------
	// Clockwise tests.
	// -----------------------------------------------------------------------------------------------------------------

	@Test
	public void change_to_east_when_it_is_north_and_turn_clockwise() {
		// Given
		CardinalOrientation cardinalOrientation = CardinalOrientation.NORTH;
		// When
		cardinalOrientation = cardinalOrientation.turnClockwise();
		// Then
		Assert.assertEquals(CardinalOrientation.EAST, cardinalOrientation);
	}

	@Test
	public void change_to_south_when_it_is_east_and_turn_clockwise() {
		// Given
		CardinalOrientation cardinalOrientation = CardinalOrientation.EAST;
		// When
		cardinalOrientation = cardinalOrientation.turnClockwise();
		// Then
		Assert.assertEquals(CardinalOrientation.SOUTH, cardinalOrientation);
	}

	@Test
	public void change_to_west_when_it_is_south_and_turn_clockwise() {
		// Given
		CardinalOrientation cardinalOrientation = CardinalOrientation.SOUTH;
		// When
		cardinalOrientation = cardinalOrientation.turnClockwise();
		// Then
		Assert.assertEquals(CardinalOrientation.WEST, cardinalOrientation);
	}

	@Test
	public void change_to_north_when_it_is_west_and_turn_clockwise() {
		// Given
		CardinalOrientation cardinalOrientation = CardinalOrientation.WEST;
		// When
		cardinalOrientation = cardinalOrientation.turnClockwise();
		// Then
		Assert.assertEquals(CardinalOrientation.NORTH, cardinalOrientation);
	}

	// -----------------------------------------------------------------------------------------------------------------
	// Counterclockwise tests.
	// -----------------------------------------------------------------------------------------------------------------

	@Test
	public void change_to_west_when_it_is_north_and_turn_counterclockwise() {
		// Given
		CardinalOrientation cardinalOrientation = CardinalOrientation.NORTH;
		// When
		cardinalOrientation = cardinalOrientation.turnCounterclockwise();
		// Then
		Assert.assertEquals(CardinalOrientation.WEST, cardinalOrientation);
	}

	@Test
	public void change_to_south_when_it_is_west_and_turn_counterclockwise() {
		// Given
		CardinalOrientation cardinalOrientation = CardinalOrientation.WEST;
		// When
		cardinalOrientation = cardinalOrientation.turnCounterclockwise();
		// Then
		Assert.assertEquals(CardinalOrientation.SOUTH, cardinalOrientation);
	}

	@Test
	public void change_to_east_when_it_is_south_and_turn_counterclockwise() {
		// Given
		CardinalOrientation cardinalOrientation = CardinalOrientation.SOUTH;
		// When
		cardinalOrientation = cardinalOrientation.turnCounterclockwise();
		// Then
		Assert.assertEquals(CardinalOrientation.EAST, cardinalOrientation);
	}

	@Test
	public void change_to_north_when_it_is_east_and_turn_counterclockwise() {
		// Given
		CardinalOrientation cardinalOrientation = CardinalOrientation.EAST;
		// When
		cardinalOrientation = cardinalOrientation.turnCounterclockwise();
		// Then
		Assert.assertEquals(CardinalOrientation.NORTH, cardinalOrientation);
	}

}
