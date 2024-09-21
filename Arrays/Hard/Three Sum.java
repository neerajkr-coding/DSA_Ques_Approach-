//******************************************************BRUTE FORCE APPROACH******************************************************

//CHECK ALL THE POSSIBLE TRIPLETS

// Intuition:
// The brute-force approach would be to check all possible triplets and store the ones that satisfy the condition. 
// However, to avoid duplicates, we must ensure that each triplet is unique before adding it to the result.

// Algorithm:
// Brute-force Triplet Search: Iterate over every possible triplet using three nested loops. Check if the sum of the triplet equals zero.
// Avoid Duplicates: To avoid adding duplicate triplets, first sort each triplet and store it in a set. This ensures that only unique triplets are added to the result.
// Convert Set to List: Once all triplets are found, convert the set into a list for the final result.

// Algorithm:
// Use three nested loops to find all possible triplets (i, j, k) such that nums[i] + nums[j] + nums[k] == 0.
// For each valid triplet, sort the triplet and add it to a set to avoid duplicates.
// Convert the set into a list and return it as the result.

// TC: O(N^3) 
// SC: O(K), K is the number of unique triplet

public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < n; i++){

            for(int j = i + 1; j < n; j++){

                for(int k = j + 1; k < n; k++){

                    if(nums[i] + nums[j] + nums[k] == 0 ){
                        List<Integer> l = Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(l);
                        set.add(l);

                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(List<Integer> l: set){
            ans.add(l);
        }
        
        return ans;
    }

//******************************************************BETTER APPROACH***********************************************************

//BRUTE FORCE USING A HASHSET

// Intuition:
// // The key idea is to reduce the time complexity of a brute-force approach (which would involve three nested loops) 
// // by using a HashSet to track the third number required to make the sum zero while iterating through pairs.

// ALGORITHM
// // Loop through each element nums[i].
// // Use a HashSet track to store elements as you iterate over nums[j] (where j > i).
// // Calculate the required third element to make the sum zero (target = -(nums[i] + nums[j])).
// // If the target exists in the HashSet, add the triplet to the result set.
// // Ensure the triplet is sorted before adding it to avoid duplicates.
// // Convert the set to a list and return it.

        public List<List<Integer>> threeSum(int[] nums) {
        
        

        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            Set<Integer> track = new HashSet<>();
            
            for(int j = i + 1; j < nums.length; j++){

                int target = -(nums[i] + nums[j]);

                if(track.contains(target)){
                    ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], target));
                    Collections.sort(triplet);
                    set.add(triplet);
                }

                track.add(nums[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

// TC: O(N^2)  
// SC: O(2 * t) + O(N) , t is the number of unique triplet.

//******************************************************OPTIMAL APPROACH**********************************************************

// USING TWO POINTER APPROCH

// INTUITION
// // Sort the array to easily apply the two-pointer technique and handle duplicates.
// // For each element, use two pointers to find two other elements that sum to zero.
// // Skip duplicates while searching to avoid repeating the same triplets.

// ALGORITHM:
// // Sort the array: Sorting makes it easier to avoid duplicates and apply the two-pointer technique.

// // Loop through the array: For each element nums[i]:
// // // Skip it if it's the same as the previous element to avoid duplicates.
// // // Use two pointers left and right to find two elements that, when summed with nums[i], result in zero.
        
// // Two-pointer technique:
// // // If the sum of nums[i] + nums[left] + nums[right] is zero, add the triplet to the result.
// // // Move both pointers inward, skipping over duplicate values to avoid repeating triplets.


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){

                int sum = nums[i] + nums[right] + nums[left];

                if(sum < 0){
                    left++;
                }else if(sum > 0){
                    right--;
                }else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    left++; right--;

                    while(nums[left] == nums[left - 1] && left < right) left++;
                    while(nums[right] == nums[right + 1] && left < right) right--;
                }
            }    
        }

        return result;
    }
}


// TC: O(N^2)  
// SC: O(t), q is the number of triplet, no extra space used to solve the problem.
