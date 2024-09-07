//******************************************************BRUTE FORCE APPROACH******************************************************
USING 2 LOOP ITERATIVE APPROCH
  
class Solution
{   
// Intuition
// //The problem requires finding the length of the longest subsequence of consecutive integers in an array. 
// //The approach is to iteratively check for each element if a consecutive sequence starts from it. For each element, we try to find the next consecutive elements in the sequence using a linear search, counting the length of the sequence. 
// //Finally, the maximum length of all such sequences is returned.

// Algorithm

// // Initialization:
// // //Initialize maxLen to keep track of the maximum length of consecutive subsequence found.

// // Iterate Through Array:
// // For each element e in the array:
// // //Initialize x to 1 and cnt to 1. x is used to find the next consecutive element, and cnt is used to count the length of the current subsequence.

// // Linear Search:
// // //Use a linear search to check if the element e + x exists in the array.
// // //If found, increment x and cnt to continue checking for the next consecutive element.

// // Update Maximum Length:
// // //After finishing the search for the current element, update maxLen with the maximum of maxLen and cnt.

// // Return maxLen as the length of the longest subsequence of consecutive integers.

// TC: O(N^2) + O(N)  SC: O(1)

	static int findLongestConseqSubseq(int arr[], int N)
	{
	    
	    int maxLen = -1;
	   
	   for(int e: arr){
	       int x = 1;
	       int cnt = 1;
	       
	       while(linearSearch(arr, e + x)){
	           x++;
	           cnt++;
	       }
	       maxLen = Math.max(maxLen, cnt);
	   }
	   
	   return maxLen;
	   
	   
	}
	
	static boolean linearSearch(int a[], int x){
	    
	    for(int e: a){
	        if(e == x) return true;
	    }
	    
	    return false;
	}
}

//******************************************************BETTER APPROACH***********************************************************
USING SORTING
  
// Intuition:
// //The goal is to find the length of the longest subsequence of consecutive integers in a given array.
// //By sorting the array, consecutive elements appear next to each other. The task then becomes counting the longest run of consecutive elements.

// Algorithm:
// // Sort the Array: This puts consecutive elements next to each other.

// // Initialize Variables:
// // //maxLen to track the maximum length of consecutive subsequence.
// // //currLen to track the current consecutive subsequence length.

// // Traverse the Array:
// // //If the next element is exactly one more than the current element, increase currLen.
// // //If it's not consecutive but different, reset currLen to 1.
// // //Update maxLen with the maximum of currLen and maxLen.

// // Return the maximum length of the consecutive subsequence.

// TC: O(NlogN) + O(N)  SC: O(1)


	static int findLongestConseqSubseq(int arr[], int N)
	{
	   
	   int maxLen = -1;
	   
	   Arrays.sort(arr);
	   
	   int currLen = 1;
	   
	   for(int i = 0; i < N - 1; i++){
	       
	       
	       
	       if(arr[i + 1] == arr[i] + 1){
	           currLen++;
	       }else if(arr[i + 1] != arr[i]){
	           currLen = 1;
	       }
	       
	       maxLen = Math.max(maxLen, currLen);
	       
	   }
	   maxLen = Math.max(maxLen, currLen);
	   
	   return maxLen;
	   
	}

//******************************************************OPTIMAL APPROACH**********************************************************
//USING SET DATA STRUCTURE
// TC:  O(N) + O(2*N) ~ O(3*N)  SC: O(N)

// Intuition:
// //The goal is to find the longest subsequence where elements are consecutive integers. 
// //To efficiently check if a number can start a sequence, we use a Set to store all elements of the array. This allows for quick lookups, enabling us to identify potential starting points of sequences. 
// //If a number is the start of a sequence (i.e., e-1 is not in the set), we check how long the sequence can go by incrementing the number and checking for consecutive elements in the set.

// Algorithm:

// Insert Elements into Set: 
// //Start by adding all elements from the array into a Set to allow O(1) lookup time.

// Initialize Variables: 
// //Set maxLen to 0 to store the maximum length of the consecutive subsequence.

// Iterate Through Array: For each element e in the array:
// //Check if e-1 exists in the set. If it does, e cannot start a new sequence, so skip it.
// //If e-1 does not exist, start counting the length of the consecutive sequence starting from e by incrementing e and checking if the next number exists in the set.
// //Keep track of the maximum length sequence found so far.

// Return the Result: 
// //After iterating through the array, return the maximum sequence length found (maxLen).

	static int findLongestConseqSubseq(int arr[], int N)
	{
	    
	    Set<Integer> set = new HashSet<>();
	    
	    for(int e: arr) set.add(e);
	    
	    
	    int maxLen = 0;
	    
	    int currLen = 1;
	    
	    for(int e: arr){
	        
	        if(!set.contains(e-1)){
	            e++;
	            while(set.contains(e)){
	                currLen++;
	                e++;
	            }
	            
	            maxLen = Math.max(maxLen, currLen);
	            currLen = 1;
	        }
	      
	    }
	    
	      
	        return maxLen;
	   
	   
	}
