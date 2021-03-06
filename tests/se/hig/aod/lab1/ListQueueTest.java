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
public class ListQueueTest {
	ListQueue<Character> testQueue;
	char[] fixture = {'a', 'b', 'c', 'd'};

	@Before
	public void setUp() throws Exception {
		testQueue = new ListQueue<Character>();
	}

	@After
	public void tearDown() throws Exception {
		testQueue = null;
	}

	/**
	 * Testa om kö är tom när den skapas
	 */
	@Test
	public void testNewQueueIsEmpty ()
	{
		assertEquals(true, testQueue.isEmpty());
	}
	
	/**
	 * Testa om kö inte är tom efter någonting lagras i kö
	 */
	@Test
	public void testQueueWithItemNotEmpty ()
	{
		testQueue.enqueue(fixture[0]);
		assertFalse ("Containing an item but empty!", testQueue.isEmpty ());
	}
	
	/**
	 * Testa ta bort från en tom kö
	 */
	@Test
	public void testDequeueOnEmptyQueue ()
	{
		try
		{
			testQueue.dequeue();
			fail("Expected: QueueEmptyException!");
		} catch (QueueEmptyException e)
		{
			assertNotNull("Expected: QueueEmptyException!", e);
		}
	}
	
	/**
	 * Testa om kö är tom efter någonting lagras och sedan tas bort
	 */
	@Test
	public void testQueueIsEmptyAfterDequeue ()
	{
		testQueue.enqueue(fixture[0]);
		testQueue.dequeue();
		assertEquals(true, testQueue.isEmpty());
	}
	
	/**
	 * Testa ordningen. Den första i köen ska ut först.
	 */
	@Test
	public void testDequeueOrder ()
	{
		for (int i = 0; i < fixture.length; i++) {
			testQueue.enqueue(fixture[i]);
		}
		char a = testQueue.dequeue();
		assertEquals('a', a);
	}
	/**
	 * Testa tömma en tom kö.
	 */
	@Test
	public void testClearEmptyQueue ()
	{
		testQueue.clear();
		assertEquals(true, testQueue.isEmpty());
	}
	
	/**
	 * Testa tömma en kö som innehåller flera objekt.
	 */
	@Test
	public void testClearPopulatedQueue ()
	{
		for (int i = 0; i < fixture.length; i++) {
			testQueue.enqueue(fixture[i]);
		}
		testQueue.clear();
		assertEquals(true, testQueue.isEmpty());
	}


}
