//******************************************************BRUTE FORCE APPROACH******************************************************

//GENERATING ALL POSSIBLE QUADRUPLETS USING 4 LOOPS

//******************************************************BETTER APPROACH***********************************************************

//USING SET

// INTUITION
// // By using a hash set, we can efficiently check for the existence of the required complement as we iterate through the numbers.

// ALGORITHM
// // Iterate: Use three nested loops:
// // // // The outer two loops pick the first two numbers (indices i and j).
// // // The innermost loop picks the third number (index k).
// // // // Calculate the needed sum: For each combination of the first three numbers, calculate the required fourth number by subtracting their sum from the target.
// // // // Check for the fourth number: Use a set to check if the required fourth number exists among the numbers processed so far (from index j + 1 to the end).
// // // // // Store unique quadruplets: If found, sort the quadruplet and add it to the set to ensure uniqueness.

// TC: O(N^3)  
// SC: O(N)

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        
        Set<List<Integer>> st = new HashSet<>();

        for(int i = 0; i < n; i++){

            for(int j = i + 1; j < n; j++){

                Set<Long> set = new HashSet<>();
                for(int k = j + 1; k < n; k++){
                    long sum = target - (nums[i] + nums[j] + (long)nums[k]);

                    if(set.contains(sum)){
                        List<Integer> quad = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], (int)sum));
                        Collections.sort(quad);
                        st.add(quad);
                    }

                    set.add((long)nums[k]);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }

//******************************************************OPTIMAL APPROACH**********************************************************

// USING TWO POINTER

// INTUITION
// // We can utilize a two-pointer technique after sorting the array. 
// // By fixing two numbers and using two pointers for the other two numbers, we can efficiently search for the remaining sum, while also skipping duplicates to avoid counting the same quadruplet multiple times.

// ALGORITHM
  
// // Sort the Array: Start by sorting the array to facilitate the two-pointer technique and handle duplicates easily.
  
// // Iterate through the Array:
// // // Use two nested loops to fix the first two numbers (nums[i] and nums[j]).
  
// // // For each pair, initialize two pointers: left (just after j) and right (at the end of the array).  
// // // // Check the Sum:
// // // // // Calculate the sum of the four numbers (nums[i], nums[j], nums[left], nums[right]).
// // // // // If the sum is less than the target, move the left pointer to the right to increase the sum.
// // // // // If the sum is greater than the target, move the right pointer to the left to decrease the sum.
// // // // // If the sum equals the target, add the quadruplet to the result list, then adjust both pointers while skipping duplicates.
// // // // // // Skip Duplicates: Make sure to skip over duplicate values for i and j to ensure uniqueness.

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        
        Arrays.sort(nums);

        List<List<Integer>> quad = new ArrayList<>();

        for(int i = 0; i <n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < n; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;
                while(left < right){
                    long sum = nums[i] + nums[j] + (long)nums[left] + (long)nums[right];

                    if(sum < target){
                        left++;
                    }else if(sum > target){
                        right--;
                    }else{
                        quad.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));

                        left++;
                        right--;

                        while(nums[left] == nums[left - 1] && left < right) left++;
                        while(nums[right] == nums[right + 1] && left < right) right--;
                    }
                }
            }
        }

        return quad;
    }


// TC: O(N^3)  
// SC: O(t * 4)
