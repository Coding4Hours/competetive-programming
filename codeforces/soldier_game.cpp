#include <bits/stdc++.h>
using namespace std;

const int MAXN = 5000005;
vector<int> spf; // smallest prime factor
vector<long long> answers; // to store all answers

// Precompute smallest prime factors using sieve
void precompute() {
    spf.resize(MAXN);
    for(int i = 0; i < MAXN; i++) spf[i] = i;
    
    for(int i = 2; i * i < MAXN; i++) {
        if(spf[i] == i) {
            for(int j = i * i; j < MAXN; j += i) {
                if(spf[j] == j) spf[j] = i;
            }
        }
    }
}

// Get prime factorization count for n!
long long getFactorCount(int n) {
    long long count = 0;
    vector<int> temp(n + 1, 0);
    
    // Count occurrences of each number
    for(int i = 2; i <= n; i++) {
        int num = i;
        while(num > 1) {
            temp[spf[num]]++;
            num /= spf[num];
        }
    }
    
    // Sum up all prime factor counts
    for(int i = 2; i <= n; i++) {
        count += temp[i];
    }
    
    return count;
}

int main() {
    // Precompute smallest prime factors
    precompute();
    
    int t;
    scanf("%d", &t);
    
    // Process all test cases and store answers
    for(int i = 0; i < t; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        
        // For n = a!/b!, total factors = factors(a!) - factors(b!)
        long long ans = getFactorCount(a) - getFactorCount(b);
        answers.push_back(ans);
    }
    
    // Output all answers at once
    for(long long ans : answers) {
        printf("%lld\n", ans);
    }
    
    return 0;
}
