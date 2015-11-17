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


}
