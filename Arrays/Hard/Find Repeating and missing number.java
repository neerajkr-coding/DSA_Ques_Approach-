//******************************************************BRUTE FORCE APPROACH******************************************************

// COUNTING EACH ELEMENT


// INTUITION
// // We can solve this problem by counting how many times each number between 1 and n appears in the array.


// ALGORITHM
// // Initialize two variables missing and repeating to store the missing and repeating numbers, respectively.
  
// // Iterate through each number from 1 to n (where n is the size of the array).
// // // For each number i, count how many times it appears in the array.
// // // // If a number appears 0 times, it is the missing number.
// // // // If a number appears 2 times, it is the repeating number.

// TC: O(N^2)  SC: O(1)

int[] findTwoElement(int arr[]) {
        
        int missing = 0;
        int repeating = 0;
        
        for(int i = 1 ; i <= arr.length; i++){
            
            int cnt = 0;
            
            for(int e: arr){
                if(e == i) cnt++;
            }
            
            if( cnt == 0) missing = i;
            if( cnt == 2) repeating = i;
        }
        
        int[] ans = {repeating, missing};
        
        return ans;
    }



//******************************************************BETTER APPROACH***********************************************************

// STORING COUNT OF ELEMENT IN HASHMAP


// INTUITION


// ALGORITHM


// TC: O()  SC: O()



//******************************************************OPTIMAL APPROACH**********************************************************

// MATHEMATICAL APPROACH


// INTUITION


// ALGORITHM
We know the sum of the first n natural numbers (S) and the sum of the squares of the first n natural numbers (S2). 
By comparing these sums with the actual sums (Sn and Sn2) derived from the array, we can deduce the missing (x) and repeating (y) numbers using equations.

int[] findTwoElement(int arr[]) {
        
        int n = arr.length;
        
        long Sn = 0;
        long Sn2 = 0;
        
        for(int e: arr){
            Sn += e;
            Sn2 += e*e;
        }
        
        
        
        long S = ((long)n * ((long)n + 1))/2;
        long S2 = ((long)n * ((long)n + 1)*(2 * n + 1))/6;
        
        if(S == Sn){
            return new int[]{0,0};
        }
        
        long val1 = S - Sn;
        long val2 = S2 - Sn2;
        
        val2 = val2 / val1;
        
        long x = (val1 + val2)/2;
        long y = val2 - x;
        
        int[] ans = {(int)y, (int)x};
        return ans;
        
        
    }
  
// TC: O()  SC: O()



