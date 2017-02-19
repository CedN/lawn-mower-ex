// created at 2017/02/12
package cna.mower;

import org.junit.Assert;
import org.junit.Test;

import cna.mower.CardinalOrientation;
import cna.mower.Position;

/**
 * Tests of {@link Position} class.
 * 
 * @author cnagat
 * @since 1.0.0
 */
public class PositionShould {

	// -----------------------------------------------------------------------------------------------------------------
	// Move tests.
	// -----------------------------------------------------------------------------------------------------------------
	
	@Test
	public void return_a_new_position_a_new_position_whose_the_y_coordinate_has_increased_when_it_move_north() {
		// Given
		int x = 0, y = 0;
		Position position = new Position(x, y);
		// When
		Position newPosition = position.move(CardinalOrientation.NORTH);
		// Then
		Assert.assertEquals(0, newPosition.getX());
		Assert.assertEquals(1, newPosition.getY());
	}

	@Test
	public void return_a_new_position_a_new_position_whose_the_x_coordinate_has_increased_when_it_move_east() {
		// Given
		int x = 0, y = 0;
		Position position = new Position(x, y);
		// When
		Position newPosition = position.move(CardinalOrientation.EAST);
		// Then
		Assert.assertEquals(x + 1, newPosition.getX());
		Assert.assertEquals(y, newPosition.getY());
	}

	@Test
	public void return_a_new_position_a_new_position_whose_the_y_coordinate_has_decreased_when_it_move_south() {
		// Given
		int x = 0, y = 0;
		Position position = new Position(x, y);
		// When
		Position newPosition = position.move(CardinalOrientation.SOUTH);
		// Then
		Assert.assertEquals(x, newPosition.getX());
		Assert.assertEquals(y - 1, newPosition.getY());
	}

	@Test
	public void return_a_new_position_a_new_position_whose_the_x_coordinate_has_decreased_when_it_move_west() {
		// Given
		int x = 0, y = 0;
		Position position = new Position(x, y);
		// When
		Position newPosition = position.move(CardinalOrientation.WEST);
		// Then
		Assert.assertEquals(x - 1, newPosition.getX());
		Assert.assertEquals(y, newPosition.getY());
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	// Utilities test.
	// -----------------------------------------------------------------------------------------------------------------

	@Test
	public void be_equal_to_another_position_that_has_the_same_coordinates() {
		// Given
		int x = 0, y = 0;
		Position position = new Position(x, y);
		// When
		Position anotherPosition = new Position(x, y);
		// Then 
		Assert.assertEquals(position, anotherPosition);
	}
	
	@Test
	public void be_not_equal_to_another_position_that_has_not_the_same_coordinates() {
		// Given
		int x1 = 0, y1 = 0, x2 = 1, y2 = 1;
		Position position = new Position(x1, y1);
		// When
		Position anotherPosition = new Position(x2, y2);
		// Then 
		Assert.assertNotEquals(position, anotherPosition);
	}
	
	
}
