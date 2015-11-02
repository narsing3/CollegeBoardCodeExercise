package com.collegeboard.narsing.codingexcersise.test;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.collegeboard.narsing.codingexcersise.BinarySearchBean;
import com.collegeboard.narsing.codingexcersise.Constants;
import com.collegeboard.narsing.codingexcersise.NumberGuesserService;
import com.collegeboard.narsing.codingexcersise.NumberGuesserUtils;

/**
 * @author Narsing
 *
 */
public class NumberGuesserServiceTest {
	
	private static org.apache.log4j.Logger log = Logger.getLogger(NumberGuesserServiceTest.class);

	BinarySearchBean sBean;
	int userGuess;
	NumberGuesserService service;
	NumberGuesserUtils utils;
	double MAX_ATTEMPT;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		userGuess  = 999; // The number we want binary search to find with in O(log n) time.
		sBean = new BinarySearchBean();
		utils = new NumberGuesserUtils();
		sBean.setLeft(0);
		sBean.setRight(1000);
		sBean.setPivot(-1);
		sBean.setAttemptCount(0);
		sBean.setUserAnswer("HIGHER");
		service = new NumberGuesserService();
		MAX_ATTEMPT = utils.getMaxCount(sBean.getRight()-sBean.getLeft());
		log.debug("MAX_ATTEMPT (O(log n )) = "+MAX_ATTEMPT);
		log.debug("Initialized Values::  userGuess:"+userGuess+  sBean.toString());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.collegeboard.narsing.codingexcersise.NumberGuesserService#binarySearchPivot(com.collegeboard.narsing.codingexcersise.BinarySearchBean)}.
	 */
	@Test
	public void testBinarySearchPivot() {
		
		while(userGuess != sBean.getPivot()){
			
			sBean  = service.binarySearchPivot(sBean);
			if(userGuess > sBean.getPivot()){
				sBean.setUserAnswer(Constants.HIGHER);
			}else if (userGuess < sBean.getPivot()){
				sBean.setUserAnswer(Constants.LOWER);
			}
			log.debug("userGuess:"+userGuess+sBean.toString());

			//Avoids any extra iterations than O(log n)
			if(sBean.getAttemptCount()> MAX_ATTEMPT){
				break;
			}
		}
		
		Assert.assertTrue("Pivot was not found in O(log n) time",userGuess == sBean.getPivot());
		Assert.assertTrue("Binary Search took more than 10 iterations. The user may have given incorrect input",sBean.getAttemptCount()<= MAX_ATTEMPT);
	}

		

}