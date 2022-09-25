class Solution {
    public int countPrimes(int n) {
        int primeCount = 0;
        
        if (n >= 2) {
            byte[] primes = new byte[n + 1];
            
            for (int x = 2 ; x < n ; x++) {
                if (primes[x] == 0) {
                    primes[x] = 1;
                    primeCount++;
                    
                    int m = 2;
                    while (m * x <= n) {
                        primes[m * x] = -1;
                        m++;
                    }
                }
            }
        }
        
        return primeCount;
    }
}