package se.hig.aod.lab1;

//Fredrik is in da house
//mera

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

	@Test
	public void testNewStackIsEmpty ()
	{
		assertEquals(true, testStack.isEmpty());
	}

	@Test
	public void testStackWithItemNotEmpty ()
	{
		testStack.push ('a');
		assertFalse ("Containing an item but empty!", testStack.isEmpty ());
	}

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

	@Test
	public void testStackIsEmptyAfterPop ()
	{
		testStack.push('a');
		testStack.pop();
		assertEquals(true, testStack.isEmpty());
	}

	@Test
	public void testPopOrder ()
	{
		testStack.push('a');
		testStack.push('b');
		char b = testStack.pop();
		assertEquals('b', b);
	}

	@Test
	public void testClearEmptyStack ()
	{
		testStack.clear();
		assertEquals(true, testStack.isEmpty());
	}

	@Test
	public void testClearPopulatedStack ()
	{
		testStack.push('a');
		testStack.push('b');
		testStack.clear();
		assertEquals(true, testStack.isEmpty());
	}
}
