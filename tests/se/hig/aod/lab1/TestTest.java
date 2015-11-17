package se.hig.aod.lab1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTest {
	String balanseratUttryck, obalanseratUttryck;

	@Before
	public void setUp() throws Exception {
		 balanseratUttryck = "()";
		 obalanseratUttryck = ")(";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIfBalancedTrue() {
		boolean check = CheckBalance.isBalanced(balanseratUttryck);
		assertEquals(true, check);
	}
	
	@Test
	public void testIfBalancedFalse() {
		boolean check = CheckBalance.isBalanced(obalanseratUttryck);
		assertFalse(check);
	}

}
