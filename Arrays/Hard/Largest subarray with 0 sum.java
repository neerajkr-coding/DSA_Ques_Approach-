//******************************************************BRUTE FORCE APPROACH******************************************************

// GENERATE ALL POSSIBLE SUBARRAYS

//******************************************************OPTIMAL APPROACH**********************************************************

// USING PREFIX SUM & HASHMAP

// INTUITION
// // By using a running sum (Rsum) and a HashMap, we can keep track of the sum of elements encountered so far. 
// // If the same running sum is seen again, it means the elements between the two indices sum to zero, 
// // because the difference between the two running sums must be zero. 
// // The HashMap stores the first occurrence of a particular sum, helping us compute the length of such subarrays efficiently.

// ALGORITHM
// // Initialize a HashMap to store the running sum and its index. Add an initial entry with running sum 0 and index -1 to handle cases where the subarray starts from the beginning.
  
// // Iterate through the array and calculate the running sum (Rsum).
// // // Check if the running sum has been seen before:
// // // // If yes, the subarray between the previous index (where this sum was seen) and the current index has a sum of 0. Update maxLen to the maximum length found.
// // // // If no, store the running sum and its index in the HashMap.

// TC: O(N)  
// SC: O(N)


int maxLen(int arr[], int n)
    {
        int maxLen = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        
        int Rsum = 0;
        for(int i = 0; i < n; i++){
            Rsum +=arr[i];
            
            if(map.containsKey(Rsum)){
                maxLen = Math.max(maxLen,i - map.get(Rsum));
            }
            
            if(!map.containsKey(Rsum)) map.put(Rsum,i);
        }
        
        return maxLen;
    }

// TC: O()  SC: O()
