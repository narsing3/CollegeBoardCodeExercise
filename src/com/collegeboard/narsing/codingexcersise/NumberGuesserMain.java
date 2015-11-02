package com.collegeboard.narsing.codingexcersise;

import java.util.Scanner;

import org.apache.log4j.Logger;
/**
 * 
 * @author Narsing
 *
 * Main class helpful to run the game.
 */
public class NumberGuesserMain {
	//To test the Number Guesser Game 
	
	private static org.apache.log4j.Logger log = Logger.getLogger(NumberGuesserMain.class);
	
	private static Scanner scanner;
	private static NumberGuesserUtils numGuesserUtil;
	private static NumberGuesserService numGuesser;
	
	public static void main(String[] args) {
			numGuesserUtil = new NumberGuesserUtils();
			numGuesser = new NumberGuesserService();
			
			//Introduce the Game App and accept the User input
			log.info("*** Welcome to NUMBER GUESSING game *** \n"
							+ "Guess a random number (integer) between "
							+ Constants.MIN_NUMBER + " and "
							+ Constants.MAX_NUMBER + " and the app will find it out in least number of attempts possible. \n Type READY to begin play or END to quit. \n");
			
			scanner = new Scanner(System.in);
			boolean isUserReady = false;
			String readyMsg = "";
			
			//Initialize BinarySearchBean
			BinarySearchBean searchBean = new BinarySearchBean();
			searchBean.setPivot(Constants.INIT_PIVOT);
			searchBean.setLeft(Constants.MIN_NUMBER);
			searchBean.setRight(Constants.MAX_NUMBER);
			searchBean.setAttemptCount(Constants.INIT_ATTEMPTCOUNT);
			searchBean.setUserAnswer(Constants.READY);
			searchBean.setMAX_COUNT(numGuesserUtil.getMaxCount(searchBean.getRight()-searchBean.getLeft()));

			//Start the game when user READY. END if requested.
			while(!isUserReady){
				readyMsg = numGuesserUtil.getResonseInUpperCase(scanner.next());
				switch (readyMsg) {
		     	case Constants.READY:
		     			isUserReady = true;
		     			searchBean.setPivot(numGuesser.findGuessedNumber(searchBean));
	        	 		break;
		     	 case Constants.END:
		     		 	isUserReady= true;
		        	 	log.info("User Quit \n\n");
		        	 	break;
		     	 default:
						log.warn("....Invalid input !!! Type READY to begin END to quit \n");
				}
				
			}
			log.debug("The Search final Details are : \n "+searchBean.toString());
			
	}
}
