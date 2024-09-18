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

//******************************************************OPTIMAL APPROACH**********************************************************

// TC: O()  SC: O()
