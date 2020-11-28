
package org.javaturk.wap.ch04;

/**
 * @author akin
 *
 */
class Account {
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void deposit(int deposit) {
		balance += deposit;
	}

	public void withdraw(int withdraw) {
		balance -= withdraw;
	}
}
