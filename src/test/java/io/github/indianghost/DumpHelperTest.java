package io.github.indianghost;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * 
 * @author <a href="mailto:achraf.bellaali@gmail.com">Achraf BELLAALI</a>
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public class DumpHelperTest {

	private final static String ENCODING_TYPE = "UTF-8";
	private final static String RESOURCE_OF_ENTITY_1 = "io/github/indianghost/entity1.txt";
	private final static String RESOURCE_OF_ENTITY_2 = "io/github/indianghost/entity2.txt";
	private final static String RESOURCE_OF_ENTITY_3 = "io/github/indianghost/entity3.txt";
	private final static String RESOURCE_JSON_OF_ENTITY_1 = "io/github/indianghost/entity1.json";
	private final static String RESOURCE_JSON_OF_ENTITY_2 = "io/github/indianghost/entity2.json";
	private final static String RESOURCE_JSON_OF_ENTITY_3 = "io/github/indianghost/entity3.json";

	private EntityForDemo entity1;
	private EntityForDemo entity2;
	private EntityForDemo entity3;

	@BeforeAll
	public void init() {
		entity1 = new EntityForDemo();
		entity1.setName("Achraf Bellaali");
		entity1.setAge(28);
		entity1.addMark(12.5);
		entity1.addMark(3.74);

		entity2 = new EntityForDemo();
		entity2.setName("Lorem ipsum");
		entity2.setAge(30);
		entity2.addMark(9.62);
		entity2.addMark(11.14);
		entity2.addMark(17.00);

		entity3 = new EntityForDemo();
		entity3.setName("dolor sit");
	}

	@DisplayName(value = "test dumpAsJson() method")
	@Test
	public void should_dump_as_json() {
		testDumpAsJson(entity1, RESOURCE_JSON_OF_ENTITY_1);
		testDumpAsJson(entity2, RESOURCE_JSON_OF_ENTITY_2);
		testDumpAsJson(entity3, RESOURCE_JSON_OF_ENTITY_3);
	}

	@DisplayName(value = "test dumpProperties() method")
	@Test
	public void should_dump_as_properties() throws Exception {
		testDumpProperties(entity1, RESOURCE_OF_ENTITY_1);
		testDumpProperties(entity2, RESOURCE_OF_ENTITY_2);
		testDumpProperties(entity3, RESOURCE_OF_ENTITY_3);
	}

	private void testDumpProperties(EntityForDemo entityForDemo, String resourcePath) {
		String result = DumpHelper.dumpProperties(entityForDemo);
		// We make this substring to exclude the part containing the hashcode of the object (See .txt files in resources)
		result = StringUtils.substringAfter(result, "[");
		assertExpectedEqualsResult(result, resourcePath, false);
	}

	private void testDumpAsJson(EntityForDemo entityForDemo, String resourceJsonOfEntity) {
		String result = DumpHelper.dumpAsJSON(entityForDemo);
		assertExpectedEqualsResult(result, resourceJsonOfEntity, true);
	}

	private void assertExpectedEqualsResult(String result, String resourcePath, boolean isJson) {
		InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
		String expected = "";
		try {
			expected = IOUtils.toString(inStream, ENCODING_TYPE);
			if (!isJson) {
				expected = StringUtils.substringAfter(expected, "[");
			}
		} catch (IOException e) {
			fail("Test failed because we could not get resource: " + e.getMessage());
		}
		assertEquals(expected, result);
	}
}
