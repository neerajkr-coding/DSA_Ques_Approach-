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

// TC: O(NlogN) + O(N)  SC: O()
