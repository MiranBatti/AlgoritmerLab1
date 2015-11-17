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
		testQueue.enqueue(fixture[0]);
		assertFalse ("Containing an item but empty!", testQueue.isEmpty ());
	}
	
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
	
	@Test
	public void testQueueIsEmptyAfterDequeue ()
	{
		testQueue.enqueue(fixture[0]);
		testQueue.dequeue();
		assertEquals(true, testQueue.isEmpty());
	}
	
	@Test
	public void testQueueOrder ()
	{
		for (int i = 0; i < fixture.length; i++) {
			testQueue.enqueue(fixture[i]);
		}
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
		for (int i = 0; i < fixture.length; i++) {
			testQueue.enqueue(fixture[i]);
		}
		testQueue.clear();
		assertEquals(true, testQueue.isEmpty());
	}


}
