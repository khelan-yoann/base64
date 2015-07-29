package fr.khelan.utils.base64.config;

/**
 * Configuration class
 * 
 * @author Khelan
 *
 */
public class Configuration {
	/** The way of conversion (true: encode ; false: decode). */
	private boolean isEncode;

	/** The name of the file to convert. */
	private String inputFileName;

	/** The name of the file to write the result of the conversion. */
	private String outputFileName;

	/**
	 * Initialize default values.
	 */
	public Configuration() {
		isEncode = true;
		inputFileName = null;
		outputFileName = "out.txt";
	}

	/**
	 *
	 * Get the way of conversion.
	 *
	 * @return true to encode ; false otherwise
	 */
	public boolean isEncode() {
		return isEncode;
	}

	/**
	 * Set the way of conversion.
	 * 
	 * @param isEncode
	 *            true to encode ; false otherwise.
	 */
	public void setEncode(final boolean isEncode) {
		this.isEncode = isEncode;
	}

	/**
	 * Get the name of the file to convert.
	 * 
	 * @return The name of the file to convert.
	 */
	public String getInputFileName() {
		return inputFileName;
	}

	/**
	 * Set the name of the file to convert.
	 * 
	 * @param inputFileName
	 *            The name of the file to convert.
	 */
	public void setInputFileName(final String inputFileName) {
		this.inputFileName = inputFileName;
	}

	/**
	 * Get the name of the file to write the result of the conversion.
	 * 
	 * @return The name of the file to write the result of the conversion.
	 */
	public String getOutputFileName() {
		return outputFileName;
	}

	/**
	 * Set the name of the file to write the result of the conversion.
	 * 
	 * @param outputFileName
	 *            The name of the file to write the result of the conversion.
	 */
	public void setOutputFileName(final String outputFileName) {
		this.outputFileName = outputFileName;
	}

	/**
	 * Check if the configuration is valid.
	 * 
	 * @return true if the configuration is valid ; false otherwise.
	 */
	public boolean isValid() {
		if (inputFileName == null || outputFileName == null) {
			return false;
		}
		return true;
	}
}
