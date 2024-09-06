//******************************************************BRUTE FORCE APPROACH******************************************************

// Initialize: Create an empty ArrayList for storing leader elements.
// Iterate: For each element in the array:
// // Check all subsequent elements.
// // If an element is greater than the current element, mark it as not a leader.
// // Add Leaders: If no greater element is found after the current element, add it to the ArrayList.
// Return: Return the ArrayList containing all leader elements.

// TC: O(n^2)  SC: O(n)

    static ArrayList<Integer> leaders(int n, int arr[]) {

        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            
            int j = i + 1;
            while(j < n){
                if(arr[i] < arr[j]) break;
                j++;
            }
            
            if(j == n) ans.add(arr[i]);
        }
        
        return ans;
    }

//******************************************************OPTIMAL APPROACH**********************************************************

//Initialize: Start with an empty ArrayList to store leaders and set the last element of the array as the initial leader.

//Traverse: Iterate through the array from right to left.
// //For each element, if it is greater than or equal to the current leader, add the current leader to the list and update leader with this element.

//Finalize: After the loop, add the last identified leader to the list.
// TC: O(n)  SC: O(n)
static ArrayList<Integer> leaders(int n, int arr[]) {

        ArrayList<Integer> ans = new ArrayList<>();
        int leader = arr[n-1];
        
        for(int i = n - 2; i >= 0; i--){
            
            if(arr[i] >= leader){
                ans.add(leader);
                leader = arr[i];
            }
        }
        ans.add(leader);
        
        Collections.reverse(ans);
        return ans;
    }
