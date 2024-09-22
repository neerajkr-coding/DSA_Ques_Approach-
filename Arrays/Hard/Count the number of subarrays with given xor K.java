//******************************************************BRUTE FORCE APPROACH******************************************************

//GENERATE EACH SUBARRAY THAN COMPUTE XOR


// TC: O(N^3)  
// SC: O(1)



//******************************************************BETTER APPROACH***********************************************************

//GENERATE AND COMPUTE XOR OF SUBARRAYS


// TC: O(N^2)  
// SC: O(1)



//******************************************************OPTIMAL APPROACH**********************************************************

// USING XOR PROPERTY


// INTUITION
// // The XOR operation has a useful property: if A ^ B = C, then A = B ^ C. This property can help us find subarrays with the desired XOR in an efficient way. 
// // As we iterate through the array, we compute the XOR of the subarray ending at the current element and check if the XOR of any previous subarray, when XORed with B, equals the current XOR. 
// // This can be tracked efficiently using a HashMap.

// ALGORITHM
  
// // Initialize Variables:
// // // // XOR to keep track of the cumulative XOR of elements from the start.
// // // // ans to count the number of valid subarrays.
// // // // map to store the frequency of XOR values encountered.
  
// // Iterate through the Array:
// // // For each element e, update the cumulative XOR (XOR ^= e).
// // // // Check if XOR ^ B exists in the map. If it does, it means there is a previous subarray whose XOR makes the current subarray's XOR equal to B, so add the count to ans.
// // // // Update the frequency of the current XOR in the map.

public class Solution {
    public int solve(int[] A, int B) {
       
       int ans = 0;
       int XOR = 0;
       
       Map<Integer, Integer> map = new HashMap<>();
       map.put(0,1);
       
       for(int e: A){
           XOR ^= e;
           
           if(map.containsKey(XOR ^ B)){
               ans += map.get(XOR ^ B);
           }
           
           if(!map.containsKey(XOR)) map.put(XOR, 0);
           
           map.put(XOR, map.get(XOR) + 1);
       } 
       
       return ans;
    }
}

// TC: O(N)  SC: O(N)
