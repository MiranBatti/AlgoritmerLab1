package se.hig.aod.lab1;

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
		boolean isEmpty = true;
		assertEquals(isEmpty, testStack.isEmpty());
	}

	@Test
	public void testStackWithItemNotEmpty ()
	{
		testStack.push (fixture[0]);
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
		testStack.push(fixture[0]);
		testStack.pop();
		assertEquals(true, testStack.isEmpty());
	}

	@Test
	public void testPopOrder ()
	{
		for (int i = 0; i < fixture.length; i++) {
			testStack.push(fixture[i]);
		}
		char d = testStack.pop();
		assertEquals('d', d);
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
		for (int i = 0; i < fixture.length; i++) {
			testStack.push(fixture[i]);
		}
		testStack.clear();
		assertEquals(true, testStack.isEmpty());
	}
}
