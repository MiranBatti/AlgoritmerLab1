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

	/*
	 * Testa att ett balanserat uttryck blir sant.
	 */
	@Test
	public void testIfBalancedTrue() {
		boolean check = CheckBalance.isBalanced(balanseratUttryck);
		assertTrue(check);
	}
	
	/*
	 * Testa ett obalanserat uttryck blir falskt.
	 */
	@Test
	public void testIfBalancedFalse() {
		boolean check = CheckBalance.isBalanced(obalanseratUttryck);
		assertFalse(check);
	}

}
