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

// TC: O()  SC: O()
