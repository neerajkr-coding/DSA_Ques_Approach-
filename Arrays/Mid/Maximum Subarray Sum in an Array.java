//******************************************************OPTIMAL APPROACH**********************************************************

//USING KANADE'S ALGORITHM
//Initialize maxSum to Integer.MIN_VALUE, sum to 0.
//Loop through each element e in the array:
//-Add e to sum.
//-Update maxSum to be the maximum of maxSum and sum.
//-If sum becomes negative, reset sum to 0.
//Return maxSum as the maximum sum of a contiguous subarray.
// TC: O(n)  SC: O(1)
    public int maxSubArray(int[] nums) {
        
        int maxSum = Integer.MIN_VALUE;


        int start = 0;
        int end = -1;

        int sum = 0;
        for(int e: nums){
            sum += e;

            maxSum = Math.max(maxSum, sum);

            if(sum < 0){
                sum = 0;
            }


        }
            return maxSum;
    }
