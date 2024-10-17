//******************************************************BRUTE FORCE APPROACH******************************************************

// .


INTUITION


ALGORITHM


// TC: O()  SC: O()



//******************************************************OPTIMAL APPROACH**********************************************************

// USING MODIFIED MERGE SORT




// INTUITION
// // The problem requires counting pairs (i, j) such that 0 <= i < j < N and arr[i] > 2 * arr[j]. 
// // A brute force approach would be inefficient, so we use a modified merge sort algorithm. 
// // The merge sort helps in sorting the array while simultaneously counting reverse pairs, leveraging the sorted order to efficiently find such pairs.


// ALGORITHM

// // Divide and Conquer:
// // // We use a merge sort approach to divide the array into halves until we have single elements (base case).
// // // During the merging step, we count reverse pairs by taking advantage of the partially sorted nature of the two halves.


// // Counting Reverse Pairs:
// // // For each element arr[i] in the left half (low to mid), we count how many elements arr[j] in the right half (mid + 1 to high) satisfy arr[i] > 2 * arr[j].
// // // We use a pointer j that increments when arr[i] > 2 * arr[j], helping us count efficiently.


// // Merge Operation:
// // // The merge operation combines two sorted halves back into the original array while keeping it sorted. 
// // // This step ensures that the array remains sorted at each level of recursion.

KEY TAKEWAYS:
The problem can be efficiently solved by leveraging the properties of sorted arrays.
During the merge step in merge sort, the left and right halves of the array are already sorted.
To find reverse pairs, we check if any element in the left half (i) is greater than twice an element in the right half (j), maintaining the condition 0 <= i < j < N.
If arr[i] > 2 * arr[j], then all elements after i in the left half will also satisfy this condition, as they are greater than arr[i] due to the sorted order. Similarly, all elements before j in the right half are also valid.
This observation helps efficiently count reverse pairs by avoiding unnecessary comparisons, using the properties of the sorted arrays.

QUESTION:
You are given an array of N integers arr, find the count of reverse pairs. 
A pair of indices (i, j) is said to be a reverse pair if both the following conditions are met:
0 <= i < j < N 
arr[i] > 2 * arr[j]


  
CODE:
class Solution {
    public int countRevPairs(int N, int arr[]) {
        return mergeSort(arr, 0, N - 1);
        
        // for(int e: arr){
        //     System.out.print(" "+e);
        // }
        
        // return -1;
    }
    
    //count Reverse O(logN)
    public int countRev(int[] A, int low, int mid, int high){
        
        int cnt = 0;
        
        int j = mid + 1;
        
        for(int i = low; i <= mid; i++){
            
            while(j <= high && A[i] > 2 * (long)A[j]) j++;
            
            cnt += ( j - mid -1 );
        }
        
        return cnt;
    }
    
    
    //mergeSort O(N)
    public int mergeSort(int[] A, int low, int high){
        
        int cnt = 0;
        
        if(low < high){
            
            int mid = (low + high)/2;
            
            cnt += mergeSort(A, low, mid);
            cnt += mergeSort(A, mid + 1, high);
            cnt += countRev(A, low, mid, high);
            merge(A, low, mid, high);
        }
        
        return cnt;
    }
    
    
    //Merge to sorted array  O(N)
    public void merge(int[] A, int low, int mid, int high){
        
        int l1 = mid - low + 1;
        int l2 = high - mid;
        
        int[] A1 = new int[l1];
        for(int i = 0; i < l1; i++) A1[i] = A[low + i];
        
        int[] A2 = new int[l2];
        for(int i = 0; i < l2; i++) A2[i] = A[mid + 1 + i];
        
        int p = low;
        int p1 = 0;
        int p2 = 0;
        
        while(p1 < l1 && p2 < l2){
            
            if(A1[p1] <= A2[p2]){
                A[p] = A1[p1];
                p++;
                p1++;
            }else{
                A[p] = A2[p2];
                p++;
                p2++;
            }
        }
        
        while(p1 < l1){
            A[p] = A1[p1];
            p++;
            p1++;
        }
        
        while(p2 < l2){
            A[p] = A2[p2];
            p++;
            p2++;
        }
        
    }
}


// TC: O(N) + O(N)+  O(logN) =  O(2N * logN) ~ O(N*logN)
// SC: O(N)+ O(N) = O(2N) ~ O(N)
