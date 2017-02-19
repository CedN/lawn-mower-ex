// created at 2017/02/17
package cna.mower;

import java.util.List;

/**
 * Describes a {@link Mower} and its instructions to execute.
 * 
 * @author cnagat
 * @since 1.0.0
 */
public class MowerProgrammation {

	/**
	 * The <tt>Mower</tt>.
	 */
	private final Mower mower;

	/**
	 * The mower's instructions.
	 */
	private final List<Action> instructions;

	/**
	 * Constructs a <tt>MowerProgrammation</tt>.
	 * 
	 * @param mower the <tt>Mower<tt>.
	 * @param instructions the mower's instructions.
	 */
	public MowerProgrammation(final Mower mower, final List<Action> instructions) {
		this.mower = mower;
		this.instructions = instructions;
	}

	/**
	 * Executes the programmation and returns the mower after all instructions applying.
	 * 
	 * @return the mower after all instructions applying.
	 */
	public Mower run() {
		Mower mower = new Mower(this.mower.getPosition(), this.mower.getOrientation(), this.mower.getLawnBoundaries());
		instructions.stream().forEach(action -> mower.apply(action));
		return mower;
	}
}
