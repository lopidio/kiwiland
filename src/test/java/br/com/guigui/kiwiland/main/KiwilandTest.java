package br.com.guigui.kiwiland.main;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple Kiwiland.
 */
public class KiwilandTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public KiwilandTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( KiwilandTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testKiwiland()
    {
        assertTrue( true );
    }
}
