import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/*
* Test the EdgeTable class.
*/
public class EdgeTableTest {
	EdgeTable testObj;

	/*
	* Setup the tests by initializing a new EdgeTable object before each test.
	*/
	@Before
	public void setUp() throws Exception {
		testObj = new EdgeTable("1|test");
		testObj.makeArrays();
	}

	/*
	* Test getNumFigure was what we initalized it to in setup (1).
	*/
	@Test
	public void getNumFigure() {
		assertEquals("NumFigure was intialized to 1", 1, testObj.getNumFigure());
	}

	/*
	* Test getName was what we initalized it to in setup ('test').
	*/
	@Test
	public void getName() {
		assertEquals("Name was intialized as 'test'", "test", testObj.getName());
	}

	/*
	* Test addRelatedTable increases the relatedTables size by 1.
	*/
	@Test
	public void addRelatedTable() {
		testObj.addRelatedTable(1);
		testObj.makeArrays();
		assertEquals("relatedTables size should be 1", 1, testObj.getRelatedTablesArray().length);
	}

	/*
	* Test getRelatedTablesArray is empty when no action is taken.
	*/
	@Test
	public void getRelatedTablesArrayEmpty() {
		assertEquals("relatedTables should be empty", 0, testObj.getRelatedTablesArray().length);
	}

	/*
	* Test getRelatedTablesArray returns 1 when relatedTables has 1 entry.
	*/
	@Test
	public void getRelatedTablesArraySizeOne() {
		testObj.addRelatedTable(1);
		testObj.makeArrays();
		assertEquals("relatedTables size should be 1", 1, testObj.getRelatedTablesArray().length);
	}

	/*
	* Test getRelatedFieldsArray is empty when no action is taken.
	*/
	@Test
	public void getRelatedFieldsArrayEmpty() {
		assertEquals("relatedFields should be empty", 0, testObj.getRelatedFieldsArray().length);
	}

	/*
	* Test getRelatedFieldsArray returns 1 when relatedFields has 1 entry.
	*/
	@Test
	public void getRelatedFieldsArraySizeOne() {
		testObj.addNativeField(1);
		testObj.makeArrays();
		assertEquals("relatedFields size should be 1", 1, testObj.getRelatedFieldsArray().length);
	}

	/*
	* Test setRelatedField sets relatedFields[0] to 100 when it was initially set to 1.
	*/
	@Test
	public void setRelatedField() {
		testObj.addNativeField(1);
		testObj.makeArrays();
		testObj.setRelatedField(0, 100);
		assertEquals("relatedFields at 0 should be 100", 100, testObj.getRelatedFieldsArray()[0]);
	}

	/*
	* Test setRelatedField throws an IndexOutOfBoundsException when an index is tried to be set that does not exist in the array.
	*/
	@Test
	public void setRelatedFieldError() {
		try {
			testObj.setRelatedField(0, 1);
		  	fail("Expected an IndexOutOfBoundsException to be thrown for setRelatedField");
		} 
		catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
		  	return;
		}
	}

	/*
	* Test getNativeFieldsArray is empty when no action is taken.
	*/
	@Test
	public void getNativeFieldsArrayEmpty() {
		assertEquals("nativeFields should be empty", 0, testObj.getNativeFieldsArray().length);
	}

	/*
	* Test getNativeFieldsArray returns 1 when nativeFields has 1 entry.
	*/
	@Test
	public void getNativeFieldsArraySizeOne() {
		testObj.addNativeField(1);
		testObj.makeArrays();
		assertEquals("nativeFields size should be 1", 1, testObj.getNativeFieldsArray().length);
	}

	/*
	* Test addNativeField increases the nativeFields size by 1.
	*/
	@Test
	public void addNativeField() {
		testObj.addNativeField(1);
		testObj.makeArrays();
		assertEquals("nativeFields size should be 1", 1, testObj.getNativeFieldsArray().length);
	}

	/*
	* Test moveFieldUp with 0 does nothing.
	*/
	@Test
	public void moveFieldUpZero() {
		testObj.addNativeField(0);
		testObj.addNativeField(1);
		testObj.addRelatedTable(0);
		testObj.addRelatedTable(1);
		testObj.makeArrays();
		testObj.moveFieldUp(0);
		testObj.makeArrays();
		assertEquals("nativeFields should have 0 at position 0", 0, testObj.getNativeFieldsArray()[0]);
		assertEquals("nativeFields should have 1 at position 1", 1, testObj.getNativeFieldsArray()[1]);
		assertEquals("relatedFields should have 0 at position 0", 0, testObj.getRelatedFieldsArray()[0]);
		assertEquals("relatedFields should have 0 at position 1", 0, testObj.getRelatedFieldsArray()[1]);
	}

	/*
	* Test moveFieldUp with -1 throws an IndexOutOfBoundsException.
	*/
	@Test
	public void moveFieldUpError() {
		testObj.addNativeField(0);
		testObj.addNativeField(1);
		testObj.addRelatedTable(0);
		testObj.addRelatedTable(1);
		testObj.makeArrays();
		try {
			testObj.moveFieldUp(-1);
		  	fail("Expected an IndexOutOfBoundsException to be thrown for moveFieldUp");
		} 
		catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
		  	return;
		}
	}

	/*
	* Test moveFieldUp with 1 moves the field at 1 up.
	*/
	@Test
	public void moveFieldUpOne() {
		testObj.addNativeField(0);
		testObj.addNativeField(1);
		testObj.addRelatedTable(0);
		testObj.addRelatedTable(1);
		testObj.makeArrays();
		testObj.moveFieldUp(1);
		testObj.makeArrays();
		assertEquals("nativeFields should have 1 at position 1", 1, testObj.getNativeFieldsArray()[1]);
		assertEquals("nativeFields should have 0 at position 0", 0, testObj.getNativeFieldsArray()[0]);
		assertEquals("relatedFields should have 0 at position 1", 0, testObj.getRelatedFieldsArray()[1]);
		assertEquals("relatedFields should have 0 at position 0", 0, testObj.getRelatedFieldsArray()[0]);
	}

	/*
	* Test moveFieldDown with 0 moves the field at 0 down.
	*/
	@Test
	public void moveFieldDownZero() {
		testObj.addNativeField(0);
		testObj.addNativeField(1);
		testObj.addRelatedTable(0);
		testObj.addRelatedTable(1);
		testObj.makeArrays();
		testObj.moveFieldDown(0);
		testObj.makeArrays();
		assertEquals("nativeFields should have 1 at position 1", 1, testObj.getNativeFieldsArray()[1]);
		assertEquals("nativeFields should have 0 at position 0", 0, testObj.getNativeFieldsArray()[0]);
		assertEquals("relatedFields should have 0 at position 1", 0, testObj.getRelatedFieldsArray()[1]);
		assertEquals("relatedFields should have 0 at position 0", 0, testObj.getRelatedFieldsArray()[0]);
	}

	/*
	* Test moveFieldDown with 99 throws an IndexOutOfBoundsException.
	*/
	@Test
	public void moveFieldDownError() {
		testObj.addNativeField(0);
		testObj.addNativeField(1);
		testObj.addRelatedTable(0);
		testObj.addRelatedTable(1);
		testObj.makeArrays();
		try {
			testObj.moveFieldDown(99);
		  	fail("Expected an IndexOutOfBoundsException to be thrown for moveFieldDown");
		} 
		catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
		  	return;
		}
	}

	/*
	* Test moveFieldDown with 0 does nothing.
	*/
	@Test
	public void moveFieldDownOne() {
		testObj.addNativeField(0);
		testObj.addNativeField(1);
		testObj.addRelatedTable(0);
		testObj.addRelatedTable(1);
		testObj.makeArrays();
		testObj.moveFieldDown(1);
		testObj.makeArrays();
		assertEquals("nativeFields should have 0 at position 0", 0, testObj.getNativeFieldsArray()[0]);
		assertEquals("nativeFields should have 1 at position 1", 1, testObj.getNativeFieldsArray()[1]);
		assertEquals("relatedFields should have 0 at position 0", 0, testObj.getRelatedFieldsArray()[0]);
		assertEquals("relatedFields should have 0 at position 1", 0, testObj.getRelatedFieldsArray()[1]);
	}

	/*
	* Test toString with data entries creates a populated string with data from each table.
	*/
	@Test
	public void toStringValid() {
		testObj.addNativeField(0);
		testObj.addNativeField(1);
		testObj.addRelatedTable(0);
		testObj.addRelatedTable(1);
		testObj.makeArrays();
		testObj.toString();
		assertEquals("Output string should have valid data", "Table: 1\r\n{\r\nTableName: test\r\nNativeFields: 0|1\r\nRelatedTables: 0|1\r\nRelatedFields: 0|0\r\n}\r\n", testObj.toString());
	}

	/*
	* Test toString with no data entries creates the default string without data from each table.
	*/
	@Test
	public void toStringEmptyArrays() {
		testObj.toString();
		assertEquals("Output string should have no data", "Table: 1\r\n{\r\nTableName: test\r\nNativeFields: \r\nRelatedTables: \r\nRelatedFields: \r\n}\r\n", testObj.toString());
	}
}
