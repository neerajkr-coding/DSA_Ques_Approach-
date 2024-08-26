//******************************************************BRUTE FORCE APPROACH******************************************************

//two loop approch
//For each nums[i], loop through the array again to find if there is another element nums[j] such that nums[i] + nums[j] == target and i != j.

public int[] twoSum(int[] nums, int target) {
        
        for(int i = 0; i < nums.length; i++){

            for(int j = 0; j < nums.length; j++){

                if(j != i && nums[j] == (target - nums[i])){
                    return new int[]{i,j};
                }
            }
        }

        return new int[0];
    }

//******************************************************OPTIMAL APPROACH**********************************************************

//For each number in the array:
//-Compute the complement (the value that, when added to the current number, equals the target).
//-Check if the complement is already in the HashMap.
//-If found, return the indices of the complement and the current number.
//-Otherwise, store the current number and its index in the HashMap.

public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){

            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }

