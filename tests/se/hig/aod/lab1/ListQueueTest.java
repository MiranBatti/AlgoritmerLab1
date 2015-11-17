package se.hig.aod.lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

	@Test
	public void testNewQueueIsEmpty ()
	{
		assertEquals(true, testQueue.isEmpty());
	}
	
	@Test
	public void testQueueWithItemNotEmpty ()
	{
		testQueue.enqueue('a');
		assertFalse ("Containing an item but empty!", testQueue.isEmpty ());
	}
	
	@Test
	public void testEnqueueOnEmptyQueue ()
	{
		try
		{
			testQueue.dequeue();
			fail ("Expected: QueueEmptyException!");
		} catch (QueueEmptyException e)
		{
			assertNotNull ("Expected: QueueEmptyException!", e);
		}
	}
	
	@Test
	public void testQueueIsEmptyAfterDequeue ()
	{
		testQueue.enqueue('a');
		testQueue.dequeue();
		assertEquals(true, testQueue.isEmpty());
	}
	
	@Test
	public void testQueueOrder ()
	{
		testQueue.enqueue('a');
		testQueue.enqueue('b');
		char a = testQueue.dequeue();
		assertEquals('a', a);
	}
	
	@Test
	public void testClearEmptyQueue ()
	{
		testQueue.clear();
		assertEquals(true, testQueue.isEmpty());
	}
	
	@Test
	public void testClearPopulatedStack ()
	{
		testQueue.enqueue('a');
		testQueue.enqueue('b');
		testQueue.clear();
		assertEquals(true, testQueue.isEmpty());
	}


}
