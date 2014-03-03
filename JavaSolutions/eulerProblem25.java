import java.math.BigInteger;
public class eulerProblem25{
	public static void main(String[] args){
		final long startTime = System.currentTimeMillis();
		//loop through fib numbers until length is equal to 1000 digits.
		int i = 1;
		while(true){
			BigInteger temp = fastFibonacciDoubling(i);
			System.out.println(temp.toString().length());
			if(temp.toString().length() >= 1000){
				System.out.println("First fib-number to have 1000 digits:");
				System.out.println("I = " + i);
				System.out.println(temp);
				break;
			}
			i++;
		}
		final long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) );
	}

	private static BigInteger fastFibonacciDoubling(int n) {
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		int m = 0;
		for (int i = 31; i >= 0; i--) {
			// Loop invariant: a = F(m), b = F(m+1)
			//assert a.equals(slowFibonacci(m));
			//assert b.equals(slowFibonacci(m+1));
			
			// Double it
			BigInteger d = karatsuba(a, b.shiftLeft(1).subtract(a));
			BigInteger e = karatsuba(a, a).add(karatsuba(b, b));
			a = d;
			b = e;
			m *= 2;
			//assert a.equals(slowFibonacci(m));
			//assert b.equals(slowFibonacci(m+1));
			
			// Advance by one conditionally
			if (((1 << i) & n) != 0) {
				BigInteger c = a.add(b);
				a = b;
				b = c;
				m++;
				//assert a.equals(slowFibonacci(m));
				//assert b.equals(slowFibonacci(m+1));
			}
		}
		return a;
	}

	// Multiplies two BigIntegers
	private static BigInteger karatsuba(BigInteger x, BigInteger y) {
		// cutoff to brute force
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) return x.multiply(y);                // optimize this parameter

        // number of bits divided by 2, rounded up
        N = (N / 2) + (N % 2);

        // x = a + 2^N b,   y = c + 2^N d
        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        // compute sub-expressions
        BigInteger ac    = karatsuba(a, c);
        BigInteger bd    = karatsuba(b, d);
        BigInteger abcd  = karatsuba(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
	}
}