/**
 * 
 */
package com.collegeboard.narsing.codingexcersise;

import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * @author Narsing
 *
 */
public class NumberGuesserUtils {
	
	private static org.apache.log4j.Logger log = Logger.getLogger(NumberGuesserUtils.class);
	private Scanner scanner;
	/**
	 * getUserResponseforPivot captures user response using Scanner class and thereby avoiding using any complex
	 * Buffered streams.
	 * 
	 * @param pivot
	 * @return
	 */
	public String getUserResponseforPivot(int pivot){
		scanner = new Scanner(System.in);
		String userAnswer = "";
		
		System.out.println("Did you guess "
				+ pivot
				+ " ? (if yes, then type YES. " +
						"If no, then type if your number is HIGHER or LOWER than " +pivot+"."+
						"Type END to quit the game):\n");
		userAnswer = scanner.next();
		log.debug("User response received: "+userAnswer+ " for pivot value "+pivot);
		
		return getResonseInUpperCase(userAnswer);
	}
	
	/**
	 * getResonseInUpperCase method converts the input string to upper case. Does a NULL check for validation.
	 * 
	 * @param userReply
	 * @return
	 */
	public String getResonseInUpperCase(String userAnswer){
		if(userAnswer!=null && userAnswer.trim()!=""){
			userAnswer = userAnswer.toUpperCase();
		}
		return userAnswer;
	}
	
	/**
	 * getMaxCount returns the order of time for binary search i.e. O(log N) value.
	 * 
	 * @param listSize
	 * @return
	 */
	public double getMaxCount(int listSize){
		return Math.ceil(Math.log10(listSize)/Math.log10(2));
	}
	

}
