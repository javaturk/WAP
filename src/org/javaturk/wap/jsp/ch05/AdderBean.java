
package org.javaturk.wap.jsp.ch05;

public class AdderBean {
	private int firstArgument;
	private int secondArgument;
	private int total;

	public AdderBean() {
		System.out.println("in AdderBean()");
	}

	public int getFirstArgument() {
		return firstArgument;
	}

	public void setFirstArgument(int firstArgument) {
		System.out.println("in setFirstArgument()");
		this.firstArgument = firstArgument;
	}

	public int getSecondArgument() {

		return secondArgument;
	}

	public void setSecondArgument(int secondArgument) {
		System.out.println("in setSecondArgument()");
		this.secondArgument = secondArgument;
	}

	public int getTotal() {
		System.out.println("in getTotal()");
		total = firstArgument + secondArgument;
		return total;
	}
}
