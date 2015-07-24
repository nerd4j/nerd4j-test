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

import org.hamcrest.StringDescription;
import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Extension of the <code>TestWatcher</code> class that enables to print
 * log messages during the test execution steps such as:
 * <ul>
 *  <li>starting</li>
 *  <li>failed</li>
 *  <li>succeeded</li>
 *  <li>finished</li>
 *  <li>skipped</li>
 * </ul>
 * 
 * @author Nerd4j Team
 */
public class ProcessLoggingTestWatcher extends TestWatcher
{

    /** The {@link Logger} used to print the messages. */
    private final Logger logger;


    /**
     * Default constructor.
     * <p>
     *  A default {@link Logger} will be created.
     * </p>
     */
    public ProcessLoggingTestWatcher()
    {

        logger = LoggerFactory.getLogger( ProcessLoggingTestWatcher.class );

    }

	/**
     * Constructor with parameters.
     * <p>
     *  Messages will be printed on the given {@link Logger}.
     * </p>
     *
     * @param logger {@link Logger} to use.
     */
    public ProcessLoggingTestWatcher( Logger logger )
    {

        this.logger = logger;

    }
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void starting( Description description )
	{
		
		logger.info( formatTestMessage( "{} test running..." ), formatTestName(description) );
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void skipped( AssumptionViolatedException e, Description description )
	{
		
		/*
		 * AssumptionViolatedException.describeTo() does not return
		 * the same Description type... :(
		 */
		org.hamcrest.Description assumption = new StringDescription();
		e.describeTo(assumption);
		
		logger.warn( formatTestMessage( "{} test skipped due to {}." ), formatTestName(description), assumption );
		
	}
    
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void succeeded( Description description )
	{
		
		logger.info( formatTestMessage( "{} test succeeded." ), formatTestName(description) );
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void failed( Throwable e, Description description )
	{
		
		logger.error( formatTestMessage( "{} test failed due to {}." ), new Object[] { formatTestName(description), e.getClass().getSimpleName(), e } );
		
	}
	
	/**
	 * Extracts the test name from the {@link Description}
	 * and formats the related output.
	 * 
	 * @param description description to be parsed.
	 * @return formatted name of the test.
	 */
    private String formatTestName( Description description )
    {

        return description.getTestClass().getSimpleName() + "." + description.getMethodName() + "()";

    }
    
    /**
     * Formats the messaged to be printed by the test.
     * 
     * @param message message to be formatted.
     * @return the formatted message.
     */
    private String formatTestMessage( String message )
    {
    	
    	StringBuilder builder = new StringBuilder(160);
    	
    	builder.append( "\n--------------------------------------------------------------------------------\n" );
    	builder.append( message );
    	builder.append( "\n--------------------------------------------------------------------------------" );
    	
    	return builder.toString();
    	
    }
	
}
