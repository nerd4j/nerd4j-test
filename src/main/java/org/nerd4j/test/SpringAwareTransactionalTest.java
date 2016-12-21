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

import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Abstract class useful for the support of JUnit test with transactional
 * behavior and dependency injection provided by the <tt>Spring</tt> framework.
 * 
 * <p>
 *  In addiction to {@link SpringAwareBaseTest} this class ensures each
 *  method of its subclasses to be transactional avoiding the need to
 *  annotate each transactional method.
 * 
 * @author Nerd4j Team
 */

/*
 * Disables the default rollback behavior at the end the execution.
 * If needed can be overridden.
 */
@TransactionConfiguration( defaultRollback = false )

/** Sets each method of the class as transactional. */
@Transactional( propagation = Propagation.REQUIRED )
public abstract class SpringAwareTransactionalTest extends SpringAwareBaseTest
{}
