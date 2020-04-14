import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EdgeConnectorTest {
	EdgeConnector testObj;

	@Before
	public void setUp() throws Exception {
        testObj = new EdgeConnector("1|2567|34|ritchie|careful");
	}

	@Test
	public void testGetNumConnector() {
		// Example of how a value can be passed into a test
		String opt1Str = System.getProperty("optionone");
		final long opt1;
		if (opt1Str == null) {
			opt1 = 1;
		}
		else {
			opt1 = Long.parseLong(opt1Str);
		}
		assertEquals("numConnector was intialized to 1 so it should be 1",(long)opt1,testObj.getNumConnector());
	}


    @Test
	public void testGetEndPoint1Int() {
		assertEquals("EndPoint1 was intialized to 2567",2567,testObj.getEndPoint1());
	}

   @Test
	public void testGetEndPoint2Int() {
		assertEquals("EndPoint1 was intialized to 34",34,testObj.getEndPoint2());
	}
   
   @Test
	public void testGetEndStyle1String() {
		assertEquals("endStyle1 was intialized to careful","ritchie",testObj.getEndStyle1());
	}
   
   @Test
	public void testGetEndStyle2String() {
		assertEquals("endStyle1 was intialized to ritchie","careful",testObj.getEndStyle2());
	}
   
   @Test
	public void testGetIsEP1FieldTrue() {
		assertEquals("isEP1Field should be false",false,testObj.getIsEP1Field());
	}
   
   @Test
	public void testGetIsEP2FieldTrue() {
		assertEquals("IsEP2Field should be false",false,testObj.getIsEP2Field());
	}
   
	@Test
	public void testGetIsEP1Table() {
		assertEquals("isEP1Table should be false",false,testObj.getIsEP1Table());
	}
   
   @Test
	public void testGetIsEP1TableFalse() {
		assertEquals("isEP1Table should be true",false,testObj.getIsEP1Table());
	}
   
   @Test
	public void testGetIsEP2TableFalse() {
		assertEquals("isEP2Table should be false",false,testObj.getIsEP2Table());
	}
   
   @Test
   public void testSetIsEP1FieldTrue() {
		testObj.setIsEP1Field(true);
		assertEquals("isEP1Field should be what you set it to",true,testObj.getIsEP1Field());
	}

   @Test
	public void testSetIsEP2FieldTrue() {
		testObj.setIsEP2Field(true);
		assertEquals("isEP2Field should be what you set it to",true,testObj.getIsEP2Field());
	}

   @Test
	public void testSetIsEP1TableTrue() {
		testObj.setIsEP1Table(true);
		assertEquals("isEp1Table should be what you set it to",true,testObj.getIsEP1Table());
	}

   @Test
	public void testSetIsEP2TableTrue() {
		testObj.setIsEP2Table(true);
		assertEquals("isEp2Table should be what you set it to",true,testObj.getIsEP2Table());
	}


}
