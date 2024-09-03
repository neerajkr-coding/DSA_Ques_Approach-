//******************************************************BRUTE FORCE APPROACH******************************************************

// Initialize Lists:
// // Create two lists: positive and negative.
// // Populate Lists:

// Iterate through nums:
// // Add non-negative numbers to positive.
// // Add negative numbers to negative.
// Rearrange Array:
// // For each index i from 0 to nums.length / 2 - 1:
// // Set nums[2 * i] to positive.get(i).
// // Set nums[2 * i + 1] to negative.get(i).  
// Return the modified nums.
// TC: O(n)  SC: O(n)

 public int[] rearrangeArray(int[] nums) {
        
        List<Integer> positive = new ArrayList<>();
        List<Integer> negitive = new ArrayList<>();

        for(int e: nums){

            if( e >= 0){
                positive.add(e);
            }else{
                negitive.add(e);
            }
        }

        for(int i = 0; i < nums.length / 2; i++){
            nums[2 * i] = positive.get(i);
            nums[2 * i + 1] = negitive.get(i); 
        }

        return nums;
    }

//******************************************************BETTER APPROACH***********************************************************

//******************************************************OPTIMAL APPROACH**********************************************************

//Using one arrayList to store element insteads of two

public int[] rearrangeArray(int[] nums) {

        ArrayList<Integer> A = new ArrayList<>();
        for(int e: nums){
            A.add(e);
        }

        int p = 0;
        int n = 1;

        for(int e: A){

            if(e >= 0){
                nums[p] = e;
                p += 2;
            }else{
                nums[n] = e;
                n += 2;
            }
        }

        return nums;
    }

// TC: O(n)  SC: O(n)
