package fr.khelan.utils.base64.main;

import java.io.IOException;

import fr.khelan.utils.base64.Base64;
import fr.khelan.utils.base64.config.Configuration;

/**
 * The main class to orchestrate processing.
 * 
 * @author Khelan
 *
 */
public class Main {
	/**
	 * The main method to convert the file.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) {
		try {
			process(args);
		} catch (final IllegalArgumentException e) {
			System.out.println(usage());
		} catch (final IOException e) {
			System.out.println("Read/Write file errors.");
		}
	}

	private static void process(final String[] args) throws IOException {
		final Configuration configuration = readConfiguration(args);

		if (!configuration.isValid()) {
			throw new IllegalArgumentException("Paramètres insuffisants");
		}

		if (configuration.isEncode()) {
			Base64.encodeFile(configuration.getInputFileName(), configuration.getOutputFileName());
		} else {
			Base64.decodeFile(configuration.getInputFileName(), configuration.getOutputFileName());
		}
	}

	/**
	 * Loads the configuration from the input command line.
	 * 
	 * @param args
	 *            Arguments from the command line.
	 * 
	 * @return The configuration created from the arguments.
	 */
	private static Configuration readConfiguration(final String[] args) {
		final Configuration configuration = new Configuration();
		int p = 0;
		while (p < args.length) {
			if (args[p].charAt(0) == '-') {
				switch (args[p].charAt(1)) {
					case 'e':
						configuration.setEncode(true);
						break;
					case 'd':
						configuration.setEncode(false);
						break;
					case 'o':
						configuration.setOutputFileName(args[++p]);
						break;
					case 'i':
						configuration.setInputFileName(args[++p]);
						break;
					default:
						break;
				}
			} else {
				configuration.setInputFileName(args[p]);
			}
			p++;
		}
		return configuration;
	}

	private static String usage() {
		final StringBuilder usage = new StringBuilder(200);
		usage.append("Usage: [-e | -d] -i ${INPUT_FILENAME} -o ${OUTPUT_FILENAME}\n")
				.append("     -e : Encode. Default mode.\n").append("     -d : Decode.\n")
				.append("     -i ${INPUT_FILENAME} : Name of the file to convert.\n")
				.append("     -o ${OUTPUT_FILENAME} : Name of the file to write de result of the conversion. Default name : out.txt\n");
		return usage.toString();
	}
}
