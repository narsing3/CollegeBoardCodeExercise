/**
 * 
 */
package com.collegeboard.narsing.codingexcersise;

/**
 * @author Narsing
 *
 * Bean class acts as a VO for encapsulating the search details. 
 */
public class BinarySearchBean {
	int pivot;
	int left; 
	int right;
	int attemptCount;
	String userReply;
	double MAX_COUNT;
	/**
	 * @return the pivot
	 */
	public int getPivot() {
		return pivot;
	}
	/**
	 * @param pivot the pivot to set
	 */
	public void setPivot(int pivot) {
		this.pivot = pivot;
	}
	/**
	 * @return the left
	 */
	public int getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(int left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public int getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(int right) {
		this.right = right;
	}
	/**
	 * @return the attemptCount
	 */
	public int getAttemptCount() {
		return attemptCount;
	}
	/**
	 * @param attemptCount the attemptCount to set
	 */
	public void setAttemptCount(int attemptCount) {
		this.attemptCount = attemptCount;
	}
	
	public void incrementAttemptCount(){
		setAttemptCount(getAttemptCount()+1);
	}
	/**
	 * @return the userReply
	 */
	public String getUserAnswer() {
		return userReply;
	}
	/**
	 * @param userReply the userReply to set
	 */
	public void setUserAnswer(String userAnswer) {
		this.userReply = userAnswer;
	}
	
	/**
	 * @return the mAX_COUNT
	 */
	public double getMAX_COUNT() {
		return MAX_COUNT;
	}
	/**
	 * @param mAX_COUNT the mAX_COUNT to set
	 */
	public void setMAX_COUNT(double mAX_COUNT) {
		MAX_COUNT = mAX_COUNT;
	}
	public String toString (){
		return (" Pivot:"+getPivot()+"  left:"+getLeft()+"  right:"+getRight()+"  attemptCount:"+getAttemptCount());
	}
}
