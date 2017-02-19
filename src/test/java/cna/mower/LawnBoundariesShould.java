// created at 2017/02/12
package cna.mower;

import org.junit.Assert;
import org.junit.Test;

import cna.mower.LawnBoundaries;
import cna.mower.Position;
import cna.mower.PositionOutOfLawnBoundariesException;

/**
 * Test of {@link LawnBoundaries} class.
 * 
 * @author cnagat
 * @since 1.0.0
 */
public class LawnBoundariesShould {

	@Test
	public void not_throw_an_exception_when_a_position_is_inside_of_boundaries() throws PositionOutOfLawnBoundariesException {
		// Given
		int maxX = 5, maxY = 5, x = 3, y = 3;
		LawnBoundaries lawnBoundaries = new LawnBoundaries(new Position(maxX, maxY));
		// When
		lawnBoundaries.assertPositionIsInBoundaries(new Position(x, y));
		// Then
		// no exception thrown.
	}
	
	@Test
	public void not_throw_an_exception_when_a_position_is_the_origin_of_boundaries() throws PositionOutOfLawnBoundariesException {
		// Given
		int maxX = 5, maxY = 5, x = 0, y = 0;
		LawnBoundaries lawnBoundaries = new LawnBoundaries(new Position(maxX, maxY));
		// When
		lawnBoundaries.assertPositionIsInBoundaries(new Position(x, y));
		// Then
		// no exception thrown.
	}
	
	@Test
	public void not_throw_an_exception_when_a_position_is_the_max_of_boundaries() throws PositionOutOfLawnBoundariesException {
		// Given
		int maxX = 5, maxY = 5, x = maxX, y = maxY;
		LawnBoundaries lawnBoundaries = new LawnBoundaries(new Position(maxX, maxY));
		// When
		lawnBoundaries.assertPositionIsInBoundaries(new Position(x, y));
		// Then
		// no exception thrown.
	}

	@Test(expected = PositionOutOfLawnBoundariesException.class)
	public void throw_an_exception_when_a_position_is_above_the_boundaries() throws PositionOutOfLawnBoundariesException {
		// Given
		int maxX = 5, maxY = 5, x = 3, y = 6;
		LawnBoundaries lawnBoundaries = new LawnBoundaries(new Position(maxX, maxY));
		// When
		lawnBoundaries.assertPositionIsInBoundaries(new Position(x, y));
		// Then
		Assert.fail();
	}
	
	@Test(expected = PositionOutOfLawnBoundariesException.class)
	public void throw_an_exception_when_a_position_is_to_the_rigth_of_the_boundaries() throws PositionOutOfLawnBoundariesException {
		// Given
		int maxX = 5, maxY = 5, x = 6, y = 3;
		LawnBoundaries lawnBoundaries = new LawnBoundaries(new Position(maxX, maxY));
		// When
		lawnBoundaries.assertPositionIsInBoundaries(new Position(x, y));
		// Then
		Assert.fail();
	}
	
	@Test(expected = PositionOutOfLawnBoundariesException.class)
	public void throw_an_exception_when_a_position_is_below_the_boundaries() throws PositionOutOfLawnBoundariesException {
		// Given
		int maxX = 5, maxY = 5, x = 3, y = -1;
		LawnBoundaries lawnBoundaries = new LawnBoundaries(new Position(maxX, maxY));
		// When
		lawnBoundaries.assertPositionIsInBoundaries(new Position(x, y));
		// Then
		Assert.fail();
	}
	
	@Test(expected = PositionOutOfLawnBoundariesException.class)
	public void throw_an_exception_when_a_position_is_to_the_left_of_the_boundaries() throws PositionOutOfLawnBoundariesException {
		// Given
		int maxX = 5, maxY = 5, x = -1, y = 3;
		LawnBoundaries lawnBoundaries = new LawnBoundaries(new Position(maxX, maxY));
		// When
		lawnBoundaries.assertPositionIsInBoundaries(new Position(x, y));
		// Then
		Assert.fail();
	}
	

}
