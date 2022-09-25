class Solution {
    public int countPrimes(int n) {
        int primeCount = 0;
        
        if (n >= 2) {
            byte[] primes = new byte[n + 1];
            
            final int SQRT_N = (int) Math.sqrt(n);
            for (int x = 2 ; x <= SQRT_N ; x++) {
                if (primes[x] == 0) {
                    int m = x * x;
                    while (m < n) {
                        primes[m] = -1;
                        m += x;
                    }
                }
            }
            
            for(int i = 2 ; i < n ; i++) {
                if (primes[i] == 0) {
                    ++primeCount;
                }
            }
        }
        
        
        return primeCount;
    }
}