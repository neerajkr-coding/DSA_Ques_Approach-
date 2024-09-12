//******************************************************BRUTE FORCE APPROACH******************************************************

    //BY GENERATING ALL POSSIBLE SUBARRAYS AND ADDING

    // Intuition
    // // This approach works by iterating over all possible subarray ranges and calculating their sums. 
    // // If the sum matches k, the count is incremented.

    // Algorithm
    // // // Initialize count to 0.
    // // Use three nested loops: O(N^3)
    // // // Outer loop (i): Start at each element of the array.
    // // // Middle loop (j): Extend the subarray from i to j.
    // // // Inner loop (k): Calculate the sum of the subarray from i to j.
    // // // If the sum equals k, increment the count.

    // TC: O(N^3) 
    // SC: O(1)

    public int subarraySum(int[] nums, int x) {
  
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                int sum = 0;
                for(int k = i; k <= j; k++){
                    sum += nums[k];
                }
                if(sum == x) count++;
            }
        }

        return count;   
    }

//******************************************************BETTER APPROACH***********************************************************

    // Intuition
    // // The provided code uses a straightforward approach where it iterates over all possible subarrays, calculates their sum, and checks if the sum matches 𝑘

    // Algorithm
    // //Initialize count to 0. 
      
    // // Iterate through the array: O(N^2) 
    // // // For each starting index i, initialize sum to 0.
    // // // // For each ending index j from i to the end of the array:
    // // // // // Add nums[j] to sum.
    // // // // // If sum equals x, increment count. Return count.

    // TC: O(N^2)  
    // SC: O(1)


    public int subarraySum(int[] nums, int x) {

        int count = 0;

        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == x) count++;
            }
        }

        return count;   
    }

//******************************************************OPTIMAL APPROACH**********************************************************

    // USING PREFIX SUM TECHNIQUE
    
    // Intuition:
    // // The key observation is that if the cumulative sum up to index i is sum, 
    // // and there exists a previous cumulative sum equal to (sum - k), 
    // // then the subarray between these two indices sums up to k.

    // Algorithm:
    // // // Initialize count to 0 and sum to 0.

    // // // Use a hash map hash to store the frequency of prefix sums, 
    // // // Add{0: 1} to the hashmap(to handle the case where the subarray starting from index 0 equals x).

    // // Iterate over each element e in the array:   O(N)
    // // // Add e to sum.
    // // // If sum - x exists in the map, increment count by the frequency of sum - x.
    // // // Add sum to the map or increment its frequency if already exist.

    // TC: O(N)  
    // SC: O(N)

    public int subarraySum(int[] nums, int x) {

        int count = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0,1);

        int sum = 0;
        for(int e: nums){
            sum += e;

            if(hash.containsKey(sum - x)) count += hash.get(sum - x);

            if(!hash.containsKey(sum)){
                hash.put(sum,1);
            }else{
                hash.put(sum, hash.get(sum) + 1);
            }

            
        }

        return count;   
    }

