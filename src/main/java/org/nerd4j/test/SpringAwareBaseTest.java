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

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * Abstract class useful for the support of JUnit test with transactional
 * behavior and dependency injection provided by the <tt>Spring</tt> framework.
 * 
 * <p>
 * <b>Test runner</b>: {@link SpringJUnit4ClassRunner}<br> provides the environment
 *                     that allows the execution of the test into the <tt>Spring</tt>
 *                     context. It also provides support for the following annotations:
 * <ul>
 *  <li>{@link org.junit.Test &#64;Test}</li>
 *  <li>{@link org.springframework.test.annotation.ExpectedException &#64;ExpectedException}</li>
 *  <li>{@link org.springframework.test.annotation.Timed &#64;Timed}</li>
 *  <li>{@link org.springframework.test.annotation.Repeat &#64;Repeat}</li>
 *  <li>{@link org.junit.Ignore &#64;Ignore}</li>
 *  <li>{@link org.springframework.test.annotation.ProfileValueSourceConfiguration &#64;ProfileValueSourceConfiguration}</li>
 *  <li>{@link org.springframework.test.annotation.IfProfileValue &#64;IfProfileValue}</li>
 * </ul>
 * 
 * <p>
 * <b>Execution listener</b>: {@link DependencyInjectionTestExecutionListener}<br>
 *                            provides base support for the dependency injection
 *                            when other listeners are involved.
 *                            If there are no other listeners involved this can be removed.
 * 
 * <p>
 * <b>Execution listener</b>: {@link DirtiesContextTestExecutionListener}<br>
 *                            allows the management of a <i>dirty context</i>.
 *                            A <i>dirty</i> context is closed and removed
 *                            after the test execution.
 *                            It also provides support for the following annotation:
 * <ul>
 *  <li>{@link org.springframework.test.annotation.DirtiesContext &#64;DirtiesContext}</li>
 * </ul>
 * 
 * <p>
 * <b>Execution listener</b>: {@link TransactionalTestExecutionListener}<br>
 *                            provides support for transactions and allows test
 *                            to be executed in a transactional environment.
 *                            It also provides support for the following annotations:
 * <ul>
 *  <li>{@link org.springframework.transaction.annotation.Transactional &#64;Transactional}</li>
 *  <li>{@link org.springframework.test.annotation.Rollback &#64;Rollback}</li>
 *  <li>{@link org.springframework.test.context.transaction.BeforeTransaction &#64;BeforeTransaction}</li>
 *  <li>{@link org.springframework.test.context.transaction.AfterTransaction &#64;AfterTransaction}</li>
 * </ul>
 * 
 * The behavior of the transactions can be handled at a class levelusing
 * {@link org.springframework.test.context.transaction.TransactionConfiguration &#64;TransactionConfiguration} or at
 * a method level using {@link org.springframework.test.annotation.Rollback &#64;Rollback}.
 * 
 * @author Nerd4j Team
 */

/* Spring context aware test runner. */
@RunWith( SpringJUnit4ClassRunner.class )

/* Default Spring context test configuration file. */
@ContextConfiguration( locations = {"classpath:/spring-test.xml"} )

/* Execution listener to be used. */
@TestExecutionListeners( {
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class } )
public abstract class SpringAwareBaseTest extends BaseTest
{}
