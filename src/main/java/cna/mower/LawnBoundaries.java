// created at 2017/02/12
package cna.mower;

/**
 * Describe the boundaries of a lawn. The boundaries are defined by 2 {@link Position}, the origin and the max. The
 * origin are always the position (0,0).
 * 
 * @author cnagat
 * @since 1.0.0
 */
public class LawnBoundaries {

	private static final Position ORIGIN = new Position(0, 0);

	private final Position max;

	/**
	 * Constructs the lawn boundaries.
	 * 
	 * @param max The max position.
	 */
	public LawnBoundaries(Position max) {
		this.max = max;
	}

	// -----------------------------------------------------------------------------------------------------------------
	// Behavior.
	// -----------------------------------------------------------------------------------------------------------------

	/**
	 * Asserts that a {@link Position} is in the boundaries of the lawn. All acceptable positions are not less than
	 * the origin and not more than the max.
	 * 
	 * @param position The position to assert.
	 * @throws PositionOutOfLawnBoundariesException if the position is outside of the lawn.
	 */
	public void assertPositionIsInBoundaries(Position position) throws PositionOutOfLawnBoundariesException {
		if (position.getX() < ORIGIN.getX() || position.getX() > max.getX() || position.getY() < ORIGIN.getY() || position.getY() > max.getY()) {
			throw new PositionOutOfLawnBoundariesException();  
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	// Getter.
	// -----------------------------------------------------------------------------------------------------------------

	/**
	 * @return the max
	 */
	public Position getMax() {
		return max;
	}
	
}
