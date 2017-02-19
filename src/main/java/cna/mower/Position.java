// created at 2017/02/12
package cna.mower;

/**
 * Describe a position. A position is defined by an x coordinate and a y coordinate.
 * 
 * @author cnagat
 * @since 1.0.0
 */
public class Position {

	/**
	 * The X coordinate.
	 */
	private final int x;

	/**
	 * The Y coordinate.
	 */
	private final int y;

	/**
	 * Constructs a position from an X coordinate and a Y coordinate.
	 * 
	 * @param x The X coordinate.
	 * @param y The Y coordinate.
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// -----------------------------------------------------------------------------------------------------------------
	// Behavior.
	// -----------------------------------------------------------------------------------------------------------------
	
	/**
	 * Calculates the new position after a movement in a direction.
	 * 
	 * @param orientation The direction.
	 * @return The new position.
	 */
	public Position move(CardinalOrientation orientation) {
		switch (orientation) {
		case NORTH:
			return new Position(x, y + 1);
		case EAST:
			return new Position(x + 1, y);
		case SOUTH:
			return new Position(x, y - 1);
		case WEST:
			return new Position(x - 1, y);
		default:
			throw new IllegalArgumentException(String.format("Orientation %s unknown!", orientation));
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------
	// Getters, setters ans utilities.
	// -----------------------------------------------------------------------------------------------------------------
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return String.format("[x=%s, y=%s]", x, y);
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Position)) {
			return false;
		}
		Position position = (Position) object;
		return x == position.x && y == position.y; 
	}
}
