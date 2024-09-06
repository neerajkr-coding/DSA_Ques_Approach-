//******************************************************OPTIMAL APPROACH**********************************************************

// Identify the Break Point:
// //Traverse from the end to find the first index i where nums[i] < nums[i + 1].

// Handle Edge Case:
// //If no such i exists, reverse the entire array as it's the last permutation.

// Find the Next Greater Element:
// //Traverse from the end to find the first index j where nums[j] > nums[i].

// Swap and Reverse:
// //Swap elements at i and j.

// Reverse the subarray from i + 1 to the end

// TC: O(n)  SC: O(1)

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int i = n-2;
        while(i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }

        if( i == -1){
            reverse(nums, i + 1, n - 1);
            return;
        }

        int j = n-1;
        while(j >= 0 && nums[j] <= nums[i]){
            j--;
        }

        swap(nums, i, j);

        reverse(nums, i + 1, n-1);

    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    private void reverse(int[] A, int start, int end){

        while(start < end){
            swap(A, start++, end--);
        }
    }

}
