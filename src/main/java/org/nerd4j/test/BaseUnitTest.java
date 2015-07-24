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

import java.lang.reflect.Field;

import org.nerd4j.util.ReflectionUtil;

/**
 * Abstract class useful for the support of JUnit based mock tests.
 * 
 * <p>
 *  This class provides the support methods for the injection of
 *  mock objects into the methods of the test classes.
 * </p> 
 * 
 * @author Nerd4j Team
 */
public abstract class BaseUnitTest extends BaseTest
{
    
    
    /**
     * Default constructor.
     * 
     */
    public BaseUnitTest()
    {
        
        super();
        
    }
    

    /**
     * Sets the given field of the given target object with the given value.
     * This method works also in private fields.
     *  
     * @param target    target object to modify.
     * @param fieldName field to be changed.
     * @param subject   object to inject.
     * 
     * @throws SecurityException
     */
    protected void inject( Object target, String fieldName, Object subject )
    {
    	
    	if ( logger.isDebugEnabled() )
    		logger.debug( "Injecting " + subject.getClass().getCanonicalName()
    				+ " into " + target.getClass().getCanonicalName() + "." + fieldName + "." );
    	
		try {
			
			// Search the field to change.
			Field field = ReflectionUtil.findField( subject.getClass(), fieldName, target.getClass() );
			
			if ( field == null )
				throw new NullPointerException( "No field " + fieldName + " found in " + target.getClass().getSimpleName() );
				
			
			/*
			 * If the field is private will temporarily set to public
			 * to be able to apply the injection.
			 */
			
			boolean wasAccessible = field.isAccessible();
			
			if( !wasAccessible )
				field.setAccessible(true);
			
			field.set( target, subject );
			
			if( !wasAccessible )
				field.setAccessible(false);
			
		} catch ( IllegalAccessException e ) {
			
			if ( logger.isErrorEnabled() )
				logger.error( "Field was inaccessible. This exception shouldn't come up at all." );
			
		}
    	
    }
    
}
