QUESTION
Find out the maximum sub-array of non negative numbers from an array.

The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:
a = [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]

NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length.
If there is still a tie, then return the segment with minimum starting index.
If no such subarray is present return "-1"

SOLUTION
//******************************************************OPTIMAL APPROACH**********************************************************

//Initialize Variables:
//-maxStart, maxEnd, maxSum to -1.
//-start to 0 and sum to 0.

//Traverse the Array:
//For each element a[i] in the array:
//-If a[i] is non-negative, add it to sum.
//-If the current sum is greater than maxSum, or if sum equals maxSum and the current segment length is greater than the previous, update maxStart, maxEnd, and maxSum.
//-If a[i] is negative, reset start to i + 1 and sum to 0.

//Build Result:
//-If maxStart remains -1, return [-1].
//-Otherwise, construct and return the sub-array from maxStart to maxEnd.
// TC: O(n)  SC: O(m),m is the length of resultant array

    ArrayList<Integer> findSubarray(int n, int a[]) {
       
       int maxStart = -1;
       int maxEnd = -1;
       int maxSum = -1;
       
       int start = 0;
       int sum = 0;
       for(int i = 0; i < n; i++){
           
           if(a[i] >=0 ){
               sum += a[i];
               
               if(sum > maxSum || (sum == maxSum && (i - start ) > (maxEnd - maxStart) ) ){
                    maxStart = start;
                    maxEnd = i;
                    maxSum = sum;
               }
           }else{
               start = i + 1;
               sum = 0;
           }
           
       }
       
       ArrayList<Integer> ans;
       if(maxStart == -1){
           ans = new ArrayList<>(Arrays.asList(-1));
           return ans;
       }
       
       
       ans = new ArrayList<>();
       for(int i = maxStart; i <= maxEnd; i++){
           ans.add(a[i]);
       }
       
       return ans;
       
    }
