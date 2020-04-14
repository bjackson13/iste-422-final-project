import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EdgeFieldTest {
	EdgeField testObj;

	@Before
	public void setUp() throws Exception {
		testObj = new EdgeField("1|testName");
	}
   
   @Test
   public void testGetNumFigure() {
      assertEquals("numFigure was intialized to 1",1,testObj.getNumFigure());
   }
   
   @Test
   public void testGetName() {
      assertEquals("name was intialized to \"testName\"","testName",testObj.getName());
   }
   
   @Test
   public void testGetTableID() {
      assertEquals("tableID was intialized to 0",0,testObj.getTableID());
   }
   
   @Test
   public void testGetTableBound() {
      assertEquals("tableBound was intialized to 0",0,testObj.getTableBound());
   }
   
   @Test
   public void testGetFieldBound() {
      assertEquals("fieldBound was intialized to 0",0,testObj.getFieldBound());
   }
   
   @Test
   public void testGetDisallowNull() {
      assertEquals("disallowNull was intialized to false",false,testObj.getDisallowNull());
   }
   
   @Test
   public void testGetIsPrimaryKey() {
      assertEquals("isPrimaryKey was intialized to false",false,testObj.getIsPrimaryKey());
   }
   
   @Test
   public void testGetDefaultValue() {
      assertEquals("defaultValue was intialized to \"\"","",testObj.getDefaultValue());
   }
   
   @Test
   public void testGetVarcharValue() {
      assertEquals("varcharValue was intialized to 1",1,testObj.getVarcharValue());
   }
   
   @Test
   public void testGetDataType() {
      assertEquals("dataType was intialized to 0",0,testObj.getDataType());
   }
   
   @Test
	public void testSetTableID() {
		testObj.setTableID(1);
		assertEquals("tableID should be 1",1,testObj.getTableID());
	}
   
   @Test
	public void testSetTableBound() {
		testObj.setTableBound(1);
		assertEquals("tableBound should be 1",1,testObj.getTableBound());
	}
   
   @Test
	public void testSetFieldBound() {
		testObj.setFieldBound(1);
		assertEquals("fieldBound should be 1",1,testObj.getFieldBound());
	}
   
   @Test
	public void testSetDisallowNull() {
		testObj.setDisallowNull(true);
		assertEquals("disallowNull should be true",true,testObj.getDisallowNull());
	}
   
   @Test
	public void testSetIsPrimaryKey() {
		testObj.setIsPrimaryKey(true);
		assertEquals("isPrimaryKey should be true",true,testObj.getIsPrimaryKey());
	}
   
   @Test
	public void testSetDefaultValue() {
		testObj.setDefaultValue("test");
		assertEquals("defaultValue should be \"test\"","test",testObj.getDefaultValue());
	}
   
   @Test
	public void testSetVarcharValueValid() {
		testObj.setVarcharValue(2);
		assertEquals("varcarValue should be 2",2,testObj.getVarcharValue());
	}
   
   @Test
	public void testSetVarcharValueInvalid() {
		testObj.setVarcharValue(0);
		assertEquals("varcarValue should be 1",1,testObj.getVarcharValue());
	}
   
   @Test
	public void testSetDataTypeValid() {
		testObj.setDataType(2);
		assertEquals("dataType should be 2",2,testObj.getDataType());
	}
   
   @Test
	public void testSetDataTypeInvalid() {
		testObj.setDataType(-1);
		assertEquals("dataType should be 0",0,testObj.getDataType());
	}
   
   @Test
	public void testToStringDefault() {
		assertEquals("should be \"1|testName|0|0|0|0|1|false|false|\"","1|testName|0|0|0|0|1|false|false|",testObj.toString());
	}
   
   @Test
	public void testToStringChanged() {
		testObj.setDefaultValue("test");
      testObj.setIsPrimaryKey(true);
      assertEquals("should be \"1|testName|0|0|0|0|1|true|false|test\"","1|testName|0|0|0|0|1|true|false|test",testObj.toString());
	}

   @Test
	public void testGetStrDataType() {
      String[] expectedOutput = {"Varchar", "Boolean", "Integer", "Double"};
      assertArrayEquals("strDataType should be {\"Varchar\", \"Boolean\", \"Integer\", \"Double\"}",expectedOutput,testObj.getStrDataType());
	}

 }