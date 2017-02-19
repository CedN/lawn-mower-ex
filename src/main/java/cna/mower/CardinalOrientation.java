// Created at 2017/02/12.
package cna.mower;

/**
 * This enumeration represents the cardinal orientations.
 * 
 * @author cnagat
 * @since 1.0.0
 */
public enum CardinalOrientation {

	// Orientation's instances
	NORTH('N'), EAST('E'), SOUTH('S'), WEST('W');

	// The letter representing the orientation.
	private char value;

	/**
	 * The private constructor to associate a letter to an orientation.
	 * 
	 * @param value the letter.
	 */
	private CardinalOrientation(char value) {
		this.value = value;
	}

	/**
	 * Returns the <tt>CardinalOrientation</tt> from a letter as:
	 * <ul>
	 * <li>'N' represents CardinalOrientation.NORTH</li>
	 * <li>'E' represents CardinalOrientation.EAST</li>
	 * <li>'S' represents CardinalOrientation.SOUTH</li>
	 * <li>'W' represents CardinalOrientation.WEST</li>
	 * </ul>
	 * 
	 * @param c the letter.
	 * @return the <tt>CardinalOrientation</tt>.
	 * @throws IllegalArgumentException if the letter does not represent any <tt>CardinalOrientation</tt>.
	 */
	public static CardinalOrientation valueOf(char c) {
		switch (c) {
		case 'N':
			return CardinalOrientation.NORTH;
		case 'E':
			return CardinalOrientation.EAST;
		case 'S':
			return CardinalOrientation.SOUTH;
		case 'W':
			return CardinalOrientation.WEST;
		default:
			throw new IllegalArgumentException(
					String.format("The char '%s' is not known as a cardinal orientation!", c));
		}
	}

	/**
	 * Return the new orientation when turn clockwise.
	 * 
	 * @return The new orientation.
	 */
	public CardinalOrientation turnClockwise() {
		switch (this) {
		case NORTH:
			return EAST;
		case EAST:
			return SOUTH;
		case SOUTH:
			return WEST;
		default:
			return NORTH;
		}
	}

	/**
	 * Return the new orientation when turn counterclockwise.
	 * 
	 * @return The new orientation.
	 */
	public CardinalOrientation turnCounterclockwise() {
		switch (this) {
		case NORTH:
			return WEST;
		case WEST:
			return SOUTH;
		case SOUTH:
			return EAST;
		default:
			return NORTH;
		}
	}

	/**
	 * @return
	 */
	public char getValue() {
		return value;
	}

}
