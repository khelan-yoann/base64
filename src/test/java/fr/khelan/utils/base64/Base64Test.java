package fr.khelan.utils.base64;

import org.junit.Assert;
import org.junit.Test;

public class Base64Test {

	@Test
	public void encodeDecodeTest0Modulo3() {
		final String source = "Test@Base64EncodeDecode1";
		final String base64 = "VGVzdEBCYXNlNjRFbmNvZGVEZWNvZGUx";

		Assert.assertEquals(base64, new String(Base64.encode(source.getBytes())));
		Assert.assertEquals(source, new String(Base64.decode(base64)));
	}

	@Test
	public void encodeDecodeTest1Modulo3() {
		final String source = "Test@Base64EncodeDecode01";
		final String base64 = "VGVzdEBCYXNlNjRFbmNvZGVEZWNvZGUwMQ==";

		Assert.assertEquals(base64, new String(Base64.encode(source.getBytes())));
		Assert.assertEquals(source, new String(Base64.decode(base64)));
	}

	@Test
	public void encodeDecodeTest2Modulo3() {
		final String source = "Test@Base64EncodeDecode";
		final String base64 = "VGVzdEBCYXNlNjRFbmNvZGVEZWNvZGU=";

		Assert.assertEquals(base64, new String(Base64.encode(source.getBytes())));
		Assert.assertEquals(source, new String(Base64.decode(base64)));
	}
}
