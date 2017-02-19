// created at 2017/02/12.
package cna.mower;

/**
 * This enumeration represents all mower's instructions.
 * 
 * @author cnagat
 * @since 1.0.0
 */
public enum Action {

	// Action's instances.
	TURN_LEFT('G'), TURN_RIGHT('D'), MOVE_FORWARD('A');

	// The letter representing the action.
	private final char value;

	/**
	 * The private constructor to associate a letter to an action.
	 * 
	 * @param value the letter.
	 */
	private Action(char value) {
		this.value = value;
	}

	/**
	 * Returns the <tt>Action</tt> from a letter as:
	 * <ul>
	 * <li>'G' represents Action.TURN_LEFT</li>
	 * <li>'D' represents Action.TURN_RIGHT</li>
	 * <li>'A' represents Action.MOVE_FORWARD</li>
	 * </ul>
	 * 
	 * @param c the letter.
	 * @return the <tt>Action</tt>.
	 * @throws IllegalArgumentException if the letter does not represent any <tt>Action</tt>.
	 */
	public static Action valueOf(char c) {
		switch (c) {
		case 'G':
			return Action.TURN_LEFT;
		case 'D':
			return Action.TURN_RIGHT;
		case 'A':
			return Action.MOVE_FORWARD;
		default:
			throw new IllegalArgumentException(String.format("The letter '%s' does not represent any action!", c));
		}
	}
	
	/**
	 * @return the value
	 */
	public char getValue() {
		return value;
	}

}
