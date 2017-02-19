// created at 2017/02/17
package cna.mower;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import cna.mower.MowerFileProcessor;
import cna.mower.PositionOutOfLawnBoundariesException;

/**
 * Tests of {@link MowerFileProcessor}.
 * 
 * @author cnagat
 * @since 1.0.0
 */
public class MowerFileProcessorShould {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void returns_the_mowers_final_position_when_a_valid_instruction_file_is_provided()
			throws IOException, PositionOutOfLawnBoundariesException {
		/* Given */
		String filePath = generateTestFile();
		MowerFileProcessor mowerFileProcessor = new MowerFileProcessor();
		/* When */
		String output = mowerFileProcessor.run(filePath);
		/* Then */
		Assert.assertNotNull(output);
		String expected = String.format("%s%n%s", "1 3 N", "5 1 E");
		Assert.assertEquals(expected, output);
	}

	@Test(expected = Exception.class)
	public void throws_exception_when_the_file_does_not_exist()
			throws IOException, PositionOutOfLawnBoundariesException {
		/* Given */
		String filePath = "foobar";
		MowerFileProcessor mowerFileProcessor = new MowerFileProcessor();
		/* When */
		mowerFileProcessor.run(filePath);
		/* Then */
		Assert.fail();
	}

	@Test(expected = Exception.class)
	public void throws_exception_when_the_file_is_empty() throws IOException, PositionOutOfLawnBoundariesException {
		/* Given */
		String filePath = folder.newFile().getAbsolutePath();
		MowerFileProcessor mowerFileProcessor = new MowerFileProcessor();
		/* When */
		mowerFileProcessor.run(filePath);
		/* Then */
		Assert.fail();
	}

	@Test(expected = Exception.class)
	public void throws_exception_when_the_file_content_is_not_valid()
			throws IOException, PositionOutOfLawnBoundariesException {
		/* Given */
		String filePath = generateIncorrectTestFile();
		MowerFileProcessor mowerFileProcessor = new MowerFileProcessor();
		/* When */
		mowerFileProcessor.run(filePath);
		/* Then */
		Assert.fail();
	}

	@Test(expected = PositionOutOfLawnBoundariesException.class)
	public void throws_exception_when_the_an_initial_mower_position_is_outside_of_the_lawn()
			throws IOException, PositionOutOfLawnBoundariesException {
		/* Given */
		String filePath = generateTestFileWithMowerOutside();
		MowerFileProcessor mowerFileProcessor = new MowerFileProcessor();
		/* When */
		mowerFileProcessor.run(filePath);
		/* Then */
		Assert.fail();
	}

	/**
	 * Allows to generate a temporary test file thats contains this instructions:
	 * 
	 * <pre>
	 * 5 5
	 * 1 2 N
	 * GAGAGAGAA
	 * 3 3 E
	 * AADAADADDA
	 * </pre>
	 * 
	 * @return the temporary file path.
	 * @throws IOException if the temporary file fails.
	 */
	private String generateTestFile() throws IOException {
		File file = folder.newFile();

		List<String> lines = new ArrayList<>();
		lines.add("5 5");
		lines.add("1 2 N");
		lines.add("GAGAGAGAA");
		lines.add("3 3 E");
		lines.add("AADAADADDA");
		Files.write(file.toPath(), lines);

		return file.getAbsolutePath();
	}

	/**
	 * Allows to generate a temporary incorrect test file.
	 * 
	 * @return the temporary file path.
	 * @throws IOException if the temporary file fails.
	 */
	private String generateIncorrectTestFile() throws IOException {
		File file = folder.newFile();

		List<String> lines = new ArrayList<>();
		lines.add("5 5");
		lines.add("1 2 N");
		Files.write(file.toPath(), lines);

		return file.getAbsolutePath();
	}

	/**
	 * Allows to generate a temporary test file where the first the mower's initial position is outside of the lawn.
	 * 
	 * @return the temporary file path.
	 * @throws IOException if the temporary file fails.
	 */
	private String generateTestFileWithMowerOutside() throws IOException {
		File file = folder.newFile();

		List<String> lines = new ArrayList<>();
		lines.add("5 5");
		lines.add("1 6 N");
		lines.add("GAGAGAGAA");
		lines.add("3 3 E");
		lines.add("AADAADADDA");
		Files.write(file.toPath(), lines);

		return file.getAbsolutePath();
	}

}
