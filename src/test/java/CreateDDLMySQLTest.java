import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

public class CreateDDLMySQLTest {
    CreateDDLMySQL testObj;

    @Before
    public void setUp() throws Exception {
        EdgeConvertFileParser edg = new EdgeConvertFileParser(new File("Courses.edg"));
        EdgeTable[] tables = edg.getEdgeTables();
        for (int i = 0; i < tables.length; i++) {
            tables[i].makeArrays();
        }
        EdgeField[] fields = edg.getEdgeFields();
        testObj = new CreateDDLMySQL(tables, fields);
    }

    @Test
    public void testIsMySQLProductName() {
        assertEquals("getProductName should be MySQL", "MySQL", testObj.getProductName());
    }

    @Test
    public void testNonTrueIsZero() {
        assertEquals("convertStrBooleanToInt should be 1 on true", 1, testObj.convertStrBooleanToInt("true"));
    }

    @Test
    public void testTrueIsOne() {
        assertEquals("convertStrBooleanToInt should be 0 on false", 0, testObj.convertStrBooleanToInt("false"));
    }

    @Test
    public void testRandomStringIsZero() {
        assertEquals("convertStrBooleanToInt should be 0 on false", 0, testObj.convertStrBooleanToInt("thisisarandomstring"));
    }

    @Test
    public void testDataTypesNotEmpty() {
        assertNotEquals("DataTypes should not be empty", 0, testObj.strDataType);
    }

    @Test
    public void testStringBufferInitialized() {
        assertNotNull("StringBuffer should be initialized", testObj.sb);
    }

    @Test
    public void testGetDatabaseName() {
        assertEquals("getDatabaseName should be null", null, testObj.getDatabaseName());
    }

    @Test
    public void testExpect3EdgeTables() {
        assertEquals("Tables should have length of 3", 3, testObj.tables.length);
    }

    @Test
    public void testExpect7EdgeFields() {
        assertEquals("Fields should have length of 7", 7, testObj.fields.length);
    }

    @Test
    public void testSetDatabaseName() {
        testObj.setDatabaseName("testName");
        assertEquals("setDatabaseName should be set", "testName", testObj.getDatabaseName());
    }

    @Test
    public void testCreateDDLEmptyName() {
        testObj.setDatabaseName("");
        assertEquals("getSQLString should be empty if no database name is passed", "", testObj.getSQLString());
    }

    @Test
    public void testCreateDDL() throws IOException {
        String expectedSQL = new String(Files.readAllBytes(Paths.get("MySQL.sql")), StandardCharsets.UTF_8).trim();
        testObj.setDatabaseName("MySQLDB");
        String generatedSQL = testObj.getSQLString().trim();
        assertEquals("getSQLString matches expected SQL", expectedSQL, generatedSQL);
    }
}