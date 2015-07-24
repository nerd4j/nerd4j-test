/*
 * #%L
 * Nerd4j Test
 * %%
 * Copyright (C) 2011 - 2013 Nerd4j
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */
package org.nerd4j.test;

import org.junit.Rule;
import org.junit.rules.TestRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class useful for the support of JUnit test classes. 
 * 
 * @author Nerd4j Team
 */
public abstract class BaseTest
{
	
    /**
     * Test execution header describing a method
     * supposed to test a situation where the target
     * code works fine.
     */
    private static String GOOD_TEST = "Good-Test ";
    
    /**
     * Test execution header describing a method
     * supposed to test a situation where the target
     * code fails.
     */
    private static String FAIL_TEST = "Fail-Test ";

    /** Test message logging system. */
    protected final Logger logger = LoggerFactory.getLogger( getClass() );

    /** Junit role used to log the test execution process. */
    @Rule
    public TestRule watcher = new ProcessLoggingTestWatcher( logger );
    
    
    /**
     * Default constructor.
     * 
     */
    public BaseTest()
    {
        
        super();
        
    }
    
	
    /**
     * Prints the execution header in for the good-test case.
     * 
     * @param method the method to be tested.
     */
    protected void printGoodTestHeader( String method )
    {

        logger.info( GOOD_TEST + method + " --> " );

    }


    /**
     * Prints the execution header in for the fail-test case.
     * 
     * @param method the method to be tested.
     */
    protected void printFailTestHeader( String method )
    {

    	logger.info( FAIL_TEST + method + " --> " );

    }


    /**
     * Prints the given message when the test ends with success.
     *
     * @param message message to be printed.
     */
    protected void printMessage( String message )
    {

    	logger.info( " " + message + " " );

    }
    
}
