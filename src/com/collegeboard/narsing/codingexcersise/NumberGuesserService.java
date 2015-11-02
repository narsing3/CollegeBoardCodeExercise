package com.collegeboard.narsing.codingexcersise;

import org.apache.log4j.Logger;

public class NumberGuesserService {
	private NumberGuesserUtils utils = new NumberGuesserUtils();

	private static org.apache.log4j.Logger log = Logger.getLogger(NumberGuesserService.class);
		
	/**
	 * findGuessedNumber method will find the guessed number in between the number range set in the Constants.java file using MAX and MIN numbers.
	 * NumberGuessing works same as searching a number by the application. Assuming we have a range in which we want
	 * search, we can use the binary search approach with O(log n) in which we calculate pivot with the 
	 * updated values of left and right ends of the number range, which we get us to the final value. 
	 * 
	 * @param sBean
	 * @return
	 */
	public int findGuessedNumber(BinarySearchBean sBean) {
		boolean isGuessnumberFound = false;
		boolean isMaxCountNotExceeded = true;
		
		while (!isGuessnumberFound) {
			
			//Validate Max Count. If limit exceeded, EXIT with a message to the user. Else, 
			if(!isMaxCountNotExceeded){	
				log.debug("Current Attempt Count: "+sBean.getAttemptCount());
				log.debug("Max Attempt Count: "+sBean.getMAX_COUNT());
				log.warn("MAX ATTEMPT EXCEED. The user may have entered inconsistent reply. Exiting the game.... Please start again. ");
				break;
			}
			
			sBean = binarySearchPivot(sBean);
			sBean.setUserAnswer(utils.getUserResponseforPivot(sBean.getPivot()));
		    
			switch (sBean.getUserAnswer()) {
		         case Constants.YES:
		        	 	log.info("Found it :). The Number Guessed is "+sBean.getPivot());
		        	 	log.info("Current Attempt Count: " + sBean.getAttemptCount() + "\n");
		        	 	isGuessnumberFound = true;
		        	 	break;
		         case Constants.END:
		        	 	log.info("User Quit");
		        	 	isGuessnumberFound = true;
		        	 	break;
		         case Constants.HIGHER:		
		        	 	isMaxCountNotExceeded = validAttemptCount(sBean.getAttemptCount(), sBean.MAX_COUNT);
		        	 	break;
		         case Constants.LOWER:
		        	 	isMaxCountNotExceeded = validAttemptCount(sBean.getAttemptCount(), sBean.MAX_COUNT);
		        	 	break;		        	 	
		         default:
						log.warn("Invalid input !!!.\n");
		     }
			
			
		}
		
		return sBean.getPivot();
	}
	
	/**
	 * binarySearchNewPivotLeftandRight is a testable service method which calculates the pivot and updates the left and right ends of the number range as per Binary Search Algorithm and 
	 * searches in the time of O(log n).
	 * 
	 * @param sBean
	 * @return
	 */
	
	public BinarySearchBean binarySearchPivot(BinarySearchBean sBean){
		sBean.toString();
		if(sBean.getAttemptCount() == 0){
			sBean.setPivot((sBean.getLeft() + sBean.getRight()) / 2);
			sBean.incrementAttemptCount();//attemptCount++;
		}else if(sBean.getAttemptCount() > 0){
			switch (sBean.getUserAnswer()) {
	        case Constants.HIGHER:
	       	 	sBean.setLeft(sBean.getPivot() + 1);
	       	 	sBean.setPivot((sBean.getLeft() + sBean.getRight()) / 2);
	       	 	sBean.incrementAttemptCount();
	       	 	break;
	        case Constants.LOWER:
	       	 	sBean.setRight(sBean.getPivot() - 1);
	       	 	sBean.setPivot((sBean.getLeft() + sBean.getRight()) / 2);
	       	 	sBean.incrementAttemptCount();
	       	 	break;
	       	 	default: break;
			}			
		}
		return sBean;
	}
	
	/**
	 * Validates the current count if it is <= the Max count of O(log N) 
	 * @param curentCount
	 * @param maxCount
	 * @return
	 */
	private boolean validAttemptCount(int curentCount, double maxCount){
		return curentCount<=maxCount;
	}

	
}