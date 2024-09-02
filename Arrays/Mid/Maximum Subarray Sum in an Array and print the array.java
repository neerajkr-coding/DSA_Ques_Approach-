//Using TWO POINTERS with KADANE'S ALGORITHM

//Initialize Variables:
// // maxSum to the smallest possible integer (Integer.MIN_VALUE).
// // maxStart and maxEnd to -1 (to track the indices of the maximum subarray).
// // start to 0 (to track the start of the current subarray).
// // sum to 0 (to track the current subarray sum).

// Iterate through the array:
// For each element nums[i]:
// //If sum is 0, set start to i.
// //Add nums[i] to sum.
// //If sum > maxSum, update maxSum, maxStart, and maxEnd.
// //If sum < 0, reset sum to 0.

//Print the Maximum Subarray (if found):
// //If maxStart is not -1, iterate from maxStart to maxEnd and print each element.
//Return maxSum.
// TC: O(n)  SC: O(1)


    public int maxSubArray(int[] nums) {
        
        int maxSum = Integer.MIN_VALUE;

        int maxStart = -1;
        int maxEnd = -1;


        int start = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){

            if(sum == 0) start = i;

            sum += nums[i];

            if(sum > maxSum){
                maxStart = start;
                maxEnd = i;
                maxSum = sum;
            }
            
            if(sum < 0){
                sum = 0;
            }
        }

       

            for(int i = maxStart; i <= maxEnd; i++){
                System.out.print(nums[i]+"|");
            }
        
        

            return maxSum;
    }
