package se.hig.aod.lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Miran Batti
 * @author Fredrik Lindorf
 * @version 2015-11-18
 *
 */
public class ListStackTest
{
	ListStack<Character> testStack;
	char[] fixture = {'a', 'b', 'c', 'd'};

	@Before
	public void setUp () throws Exception
	{
		testStack = new ListStack<Character> ();
	}

	@After
	public void tearDown () throws Exception
	{
		testStack = null;
	}
	
	/**
	 * Testa om stack är tom när den skapas
	 */
	@Test
	public void testNewStackIsEmpty ()
	{
		boolean isEmpty = true;
		assertEquals(isEmpty, testStack.isEmpty());
	}

	/**
	 * Testa om stack inte är tom efter någonting lagras i stacken
	 */
	@Test
	public void testStackWithItemNotEmpty ()
	{
		testStack.push (fixture[0]);
		assertFalse("Containing an item but empty!", testStack.isEmpty ());
	}

	/**
	 * Testa ta bort från en tom stack.
	 */
	@Test
	public void testPopOnEmptyStack ()
	{
		try
		{
			testStack.pop ();
			fail ("Expected: StackEmptyException!");
		} catch (StackEmptyException e)
		{
			assertNotNull ("Expected: StackEmptyException!", e);
		}
	}

	/**
	 * Testa om stack är tom efter någonting lagras och sedan tas bort.
	 */
	@Test
	public void testStackIsEmptyAfterPop ()
	{
		testStack.push(fixture[0]);
		testStack.pop();
		assertEquals(true, testStack.isEmpty());
	}

	/**
	 * Testa ordningen. Sista elementet i stacken ska ut först.
	 */
	@Test
	public void testPopOrder ()
	{
		for (int i = 0; i < fixture.length; i++) {
			testStack.push(fixture[i]);
		}
		char d = testStack.pop();
		assertEquals('d', d);
	}

	/**
	 * Testa tömma en tom stack.
	 */
	@Test
	public void testClearEmptyStack ()
	{
		testStack.clear();
		assertEquals(true, testStack.isEmpty());
	}

	/**
	 * Testa tömma en stack som innehåller flera objekt.
	 */
	@Test
	public void testClearPopulatedStack ()
	{
		for (int i = 0; i < fixture.length; i++) {
			testStack.push(fixture[i]);
		}
		testStack.clear();
		assertEquals(true, testStack.isEmpty());
	}
}
