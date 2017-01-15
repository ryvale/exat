package com.exa.exat;

import java.io.IOException;

import com.exa.utils.ManagedException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws IOException 
     */
    
    
    public void testGenRAMToRAM() throws ManagedException, IOException {
    	assertTrue("test".equals(TestAlgo.parseRAMTextOutput(new OMHeap(), "test")));
    }
    
    public void testGenRAMToFile() throws ManagedException, IOException {
    	assertTrue("test".equals(TestAlgo.parseRAMTextOutput(new OMFile("C:/recherches/exat/exat/src/test/java/com/exa/exat/output0"), "test")));
    }
    
    public void testGenFileToRAM() throws ManagedException, IOException {    	
    	assertTrue("test".equals(TestAlgo.parseFileTextOutput(new OMHeap(), "C:/recherches/exat/exat/src/test/java/com/exa/exat/test0")));
    }
    
    public void testGenFileToFile() throws ManagedException, IOException {    	
    	assertTrue("test".equals(TestAlgo.parseFileTextOutput(new OMFile("C:/recherches/exat/exat/src/test/java/com/exa/exat/output1"), "C:/recherches/exat/exat/src/test/java/com/exa/exat/test0")));
    }
}
