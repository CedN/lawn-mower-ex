// created at 2017/02/12.
package cna.mower;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Describe a mower. A Mower is defined by its position and ist orientation.
 * 
 * @author Cedric
 * @since 1.0.0
 */
public class Mower {

	/**
	 * Mower class logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(Mower.class);
	
	/**
	 * The position.
	 */
	private Position position;

	/**
	 * The orientation.
	 */
	private CardinalOrientation orientation;
	
	/**
	 * The lawn's boundaries
	 */
	private final LawnBoundaries lawnBoundaries;

	/**
	 * Construct a mower with its position.
	 * 
	 * @param position The initial position.
	 * @param cardinalOrientation The initial orientation.
	 * @param lawnBoundaries the boundaries of the lawn.
	 */
	public Mower(Position position, CardinalOrientation cardinalOrientation, LawnBoundaries lawnBoundaries) {
		this.position = position;
		this.orientation = cardinalOrientation;
		this.lawnBoundaries = lawnBoundaries;
	}

	// -----------------------------------------------------------------------------------------------------------------
	// Behavior.
	// -----------------------------------------------------------------------------------------------------------------

	/**
	 * Apply an action to the mower.
	 * 
	 * @param action The action to apply.
	 */
	public void apply(Action action) {
		LOGGER.info(String.format("Mower %s try to %s", this, action));
		switch (action) {
		case TURN_LEFT:
			orientation = orientation.turnCounterclockwise();
			break;
		case TURN_RIGHT:
			orientation = orientation.turnClockwise();
			break;
		case MOVE_FORWARD:
			moveForward();
			break;
		default:
			throw new IllegalArgumentException(String.format("The action %s is unknown!", action));
		}
		LOGGER.info(String.format("New state of the Mower@%s %s", hashCode(), this));
	}
	
	private void moveForward() {
		Position newPosition = position.move(orientation);
		try {
			lawnBoundaries.assertPositionIsInBoundaries(newPosition);
			position = newPosition;
		} catch (PositionOutOfLawnBoundariesException e) {
			LOGGER.info(String.format("Mower@%s can't move outside of the lawn", hashCode()));
		}
	}
	
	public String summarize() {
		return String.format("%s %s %s", getPosition().getX(), position.getY(), orientation.getValue());
	}

	// -----------------------------------------------------------------------------------------------------------------
	// Getters, Setters and utilities.
	// -----------------------------------------------------------------------------------------------------------------

	public Position getPosition() {
		return position;
	}

	public CardinalOrientation getOrientation() {
		return orientation;
	}
	
	public LawnBoundaries getLawnBoundaries() {
		return lawnBoundaries;
	}

	@Override
	public String toString() {
		return String.format("[id=Mower@%s, position=%s, orientation=%s]", hashCode(), position, orientation);
	}

	
}
