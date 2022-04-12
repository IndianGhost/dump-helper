package io.github.indianghost;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * 
 * @author <a href="mailto:achraf.bellaali@gmail.com">Achraf BELLAALI</a>
 *
 */
public class DumpHelper {

	private static String EXCEPTION = "EXCEPTION";

	private DumpHelper() {
	}

	public static String dumpProperties(Object obj) {
		return ReflectionToStringBuilder.toString(obj, ToStringStyle.MULTI_LINE_STYLE);
	}

	public static String dumpAsJSON(Object obj) {
		StringBuilder result = new StringBuilder();

		try {
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			result.append(ow.writeValueAsString(obj));
		} catch (JsonProcessingException e) {
			result.append(EXCEPTION + ":").append(e.getMessage());
		}

		return result.toString();
	}
}