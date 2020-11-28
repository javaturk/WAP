package org.javaturk.wap.ch11.asynch.primeNumber;

import java.util.Arrays;

public class SieveOfEratosthenes {

	public static int listPrimes(int upperBound) {
		// initially assume all integers are prime
		boolean[] isPrime = new boolean[upperBound + 1];
		Arrays.fill(isPrime, true);

		int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
		
		// mark non-primes <= upperBound using Sieve of Eratosthenes
		for (int i = 2; i <= upperBoundSquareRoot; i++) {
			// if i is prime, then mark multiples of i as nonprime
			// suffices to consider mutiples i, i+1, ..., upperBound/i
			if (isPrime[i]) {
				for (int j = i; i * j <= upperBound; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		
		// count primes
		int numberOfPrimes = 0;
		for (int i = 2; i <= upperBound; i++) {
			if (isPrime[i]) {
				//System.out.println(i);
				numberOfPrimes++;
			}
		}
		return numberOfPrimes;
	}
}