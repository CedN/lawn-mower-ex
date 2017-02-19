// created at 2017/02/17
package cna.mower;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A <tt>MowerFileProcessor</tt> reads a file that contains the lawn definition and the instructions of one or more
 * mowers.
 * 
 * @author cnagat
 * @since 1.0.0
 */
public class MowerFileProcessor {
	
	/**
	 * MowerFileProcessor class logger.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(MowerFileProcessor.class);

	/**
	 * Regular expression for the lawn dimension line.
	 */
	private static final Pattern LAWN_DIMENSION_LINE_PATTERN = Pattern.compile("^(\\d+) (\\d+)$");

	/**
	 * Regular expression for a mower initial position line.
	 */
	private static final Pattern MOWER_LINE_PATTERN = Pattern.compile("^(\\d+) (\\d+) ([NESW]{1})$");

	/**
	 * Regular expression for a mower's instructions line.
	 */
	private static final Pattern INSTRUCTION_LINE_PATTERN = Pattern.compile("^[ADG]+$");

	/**
	 * Runs mower's instructions on a lawn described into a file.
	 * 
	 * @param filePath the file path.
	 * @return the mower final position.
	 * @throws IOException if the file reading fails.
	 * @throws PositionOutOfLawnBoundariesException if the initial position of a mower is outside of the lawn.
	 */
	public String run(String filePath) throws IOException, PositionOutOfLawnBoundariesException {
		LOGGER.info("Reads instructions file '{}'", filePath);
		List<String> lines = Files.readAllLines(Paths.get(filePath));

		LawnBoundaries lawnBoundaries = createLawnBoudaries(lines.remove(0));
		List<MowerProgrammation> mowerProgrammations = createMowerProgrammations(lines, lawnBoundaries);
		
		return mowerProgrammations.stream()
			.map(MowerProgrammation::run)
			.map(Mower::summarize)
			.collect(Collectors.joining(String.format("%n")));
	}

	/**
	 * Creates the lawn boundaries from the line that defines the right superior corner.
	 * 
	 * @param line the line.
	 * @return the created <tt>LawnBoundaries</tt>.
	 * @throws IllegalArgumentException if the line does not define a correct lawn's right superior corner.
	 */
	private LawnBoundaries createLawnBoudaries(String line) {
		LOGGER.info("Reads lawn boundaries as '{}'", line);
		Matcher m = LAWN_DIMENSION_LINE_PATTERN.matcher(line);
		if (!m.matches()) {
			throw new IllegalArgumentException(
					String.format("The line '%s' does not define a correct lawn's right superior corner!", line));
		}
		int x = Integer.parseInt(m.group(1), 10);
		int y = Integer.parseInt(m.group(2), 10);
		return new LawnBoundaries(new Position(x, y));
	}
	
	private List<MowerProgrammation> createMowerProgrammations(List<String> lines, LawnBoundaries lawnBoundaries) throws PositionOutOfLawnBoundariesException {
		List<MowerProgrammation> mowerProgrammations = new ArrayList<>();
		while (lines.size() > 1) {
			Mower mower = createMower(lines.remove(0), lawnBoundaries);
			List<Action> instructions = createInstructions(lines.remove(0));
			mowerProgrammations.add(new MowerProgrammation(mower, instructions));
		}
		if (lines.size() == 1) {
			throw new IllegalStateException(String.format("The processing of the file provided fails because it contains this extra line '%s'!", lines.get(0)));
		}
		return mowerProgrammations;
	}

	/**
	 * Creates a mower from the line that defines its initial position.
	 * 
	 * @param line the line.
	 * @param lawnBoundaries the <tt>LawnBoundaries</tt>.
	 * @return the created <tt>Mower</tt>.
	 * @throws PositionOutOfLawnBoundariesException if the initial position of a mower is defined outside of the lawn. 
	 * @throws IllegalArgumentException if the line does not define a correct mower's initial position.
	 */
	private Mower createMower(String line, LawnBoundaries lawnBoundaries) throws PositionOutOfLawnBoundariesException {
		LOGGER.info("Reads mower position as '{}'", line);
		Matcher m = MOWER_LINE_PATTERN.matcher(line);
		if (!m.matches()) {
			throw new IllegalArgumentException(
					String.format("The line '%s' does not define a correct mower's initial position!", line));
		}
		int x = Integer.parseInt(m.group(1), 10);
		int y = Integer.parseInt(m.group(2), 10);
		Position mowerPosition = new Position(x, y);
		lawnBoundaries.assertPositionIsInBoundaries(mowerPosition);
		CardinalOrientation orientation = CardinalOrientation.valueOf(m.group(3).charAt(0));
		return new Mower(mowerPosition, orientation, lawnBoundaries);
	}

	/**
	 * Creates the list of <tt>Action</tt> defined by the instruction's line.
	 * 
	 * @param line the line.
	 * @return the list of <tt>Action</tt>.
	 * @throws IllegalArgumentException if the line does not define a correct sequence of mower instructions.
	 */
	private List<Action> createInstructions(String line) {
		LOGGER.info("Reads instruction as '{}'", line);
		Matcher m = INSTRUCTION_LINE_PATTERN.matcher(line);
		if (!m.matches()) {
			throw new IllegalArgumentException(
					String.format("The line '%s' does not define a correct sequence of mower instructions!", line));
		}
		return line.chars()
			.mapToObj(c -> Action.valueOf((char)c))
			.collect(Collectors.toList());
	}
}
