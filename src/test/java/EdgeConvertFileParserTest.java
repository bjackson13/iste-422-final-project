import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;


public class EdgeConvertFileParserTest {

    EdgeConvertFileParser testObj;
    File file;

    @Before
    public void startup(){
        file = new File("Courses.edg");
        testObj = new EdgeConvertFileParser(file);
    }
    @Test
    public void testReadSuccess(){
        assertEquals("Check if valid file was read successfully",true,EdgeConvertGUI.getReadSuccess());
    }
    @Test
    public void testTablesExist(){
        assertEquals("Check tables are not empty",true,testObj.getEdgeTables().length > 0);
    }
    @Test
    public void testFieldsExist(){
        assertEquals("Check fields are not empty",true,testObj.getEdgeFields().length > 0);
    }
    @Test
    public void testConnectorsExist(){
        assertEquals("Check connectors are not empty",true,testObj.getEdgeConnectors().length > 0);
    }
    @Test
    public void testTableSize(){
        assertEquals("Get the size of the EdgeTable array",3,testObj.getEdgeTables().length);
    }
    @Test
    public void testFieldSize(){
        assertEquals("Get the size of the EdgeField array",7,testObj.getEdgeFields().length);
    }
    @Test
    public void testConnectorSize(){
        assertEquals("Get the size of the EdgeConnector array",10,testObj.getEdgeConnectors().length);
    }
    @Test
    public void testValidConnectorObj(){
        assertEquals("Check instance of connector array",true,testObj.getEdgeConnectors()[0] instanceof EdgeConnector);
    }
    @Test
    public void testValidTableObj(){
        assertEquals("Check instance of table array",true,testObj.getEdgeTables()[0] instanceof EdgeTable);
    }
    @Test
    public void testValidFieldObj(){
        assertEquals("Check instance of field array",true,testObj.getEdgeFields()[0] instanceof EdgeField);
    }
    @Test
    public void testValidConnectors(){
        assertEquals("Check instance of connector array",true,testObj.getEdgeConnectors() instanceof EdgeConnector[]);
    }
    @Test
    public void testValidTables(){
        assertEquals("Check instance of table array",true,testObj.getEdgeTables() instanceof EdgeTable[]);
    }
    @Test
    public void testValidFields(){
        assertEquals("Check instance of field array",true,testObj.getEdgeFields() instanceof EdgeField[]);
    }

}
