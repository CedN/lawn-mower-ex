// created at 2017/02/17
package cna.mower;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import cna.mower.Action;
import cna.mower.CardinalOrientation;
import cna.mower.LawnBoundaries;
import cna.mower.Mower;
import cna.mower.MowerProgrammation;
import cna.mower.Position;

/**
 * Test of {@link MowerProgrammation} class.
 * 
 * @author cnagat
 * @since 1.0.0
 */
public class MowerProgrammationShould {

	@Test
	public void returns_the_mower_final_position_when_it_run() {
		/* Given */
		LawnBoundaries lawnBoundaries = new LawnBoundaries(new Position(3, 3));
		Mower mower = new Mower(new Position(0, 0), CardinalOrientation.NORTH, lawnBoundaries); 
		List<Action> instructions = new ArrayList<>(1);
		instructions.add(Action.MOVE_FORWARD);
		MowerProgrammation mowerProgrammation = new MowerProgrammation(mower, instructions);
		/* When */
		Mower mowerAfterInstructions = mowerProgrammation.run();
		/* Then */
		Assert.assertNotNull(mowerAfterInstructions);
		Assert.assertEquals(0, mowerAfterInstructions.getPosition().getX());
		Assert.assertEquals(1, mowerAfterInstructions.getPosition().getY());
		Assert.assertEquals(CardinalOrientation.NORTH, mowerAfterInstructions.getOrientation());
	}
	
}
