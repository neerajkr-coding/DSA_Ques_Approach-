//******************************************************BRUTE FORCE APPROACH******************************************************

// PICKING A COUNTING EACH ELEMENT

//******************************************************BETTER APPROACH***********************************************************
    
    // COUNT ELEMENT AFTER SORTING

    // Intuition:
    // // Sorting the array makes it easier to count occurrences of each element consecutively. 
    // // Once sorted, any element that appears more than n/3 times will be grouped together, so you can count how many times each number appears and check if it's greater than n/3.

    // Algorithm:

    // // Sort the array: Sorting arranges the elements so that duplicates are adjacent. O(N log N)

    // // Iterate through the sorted array: O(N)
    // // // Count the occurrences of each element. 
    // // // If the count of an element is greater than n/3, add it to the result list.
    // // // Avoid duplicates: Add the number to the result list only if it hasn't already been added.

    // TC: O(N log N)  SC: O(1)

    public List<Integer> majorityElement(int[] nums) {
        
        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();


        int cnt = 0;
        int curr = nums[0];
        for(int e: nums){
            if( e == curr){
                cnt++;
            }else{
                curr = e;
                cnt = 1;
            }

            if( cnt > nums.length/3){
                if(ans.size() == 0 || ans.get(ans.size() - 1)!= e) ans.add(e);
            }
        }

        return ans;
    }

//******************************************************OPTIMAL APPROACH**********************************************************
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int can1 = -999;
        int cnt1 = 0;

        int can2 = -999;
        int cnt2 = 0;

        for(int e: nums){

            if(can1 == e){
                cnt1++;
            }else if(can2 == e){
                cnt2++;
            }else if(cnt1 == 0){
                can1 = e;
                cnt1 = 1;
            }else if(cnt2 == 0){
                can2 = e;
                cnt2 = 1;
            }else{
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> ans = new ArrayList<>();

        cnt1 = 0;
        cnt2 = 0;

        for(int e:nums){
            if( e == can1) cnt1++;
            if( e == can2) cnt2++;
        }

        if(cnt1 > nums.length/3) ans.add(can1);
        if(cnt2 > nums.length/3) ans.add(can2);

        return ans;
    }
}
// TC: O(N)  SC: O(i)
