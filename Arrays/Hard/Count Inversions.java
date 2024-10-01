//******************************************************BRUTE FORCE APPROACH******************************************************

// COUNTING ALL POSSIBLE PAIR USING TWO LOOPS


// INTUITION
// // This problem can be solved by simply comparing every possible pair of elements in the array, 
// // and counting how many such pairs exist where the first element is greater than the second.


// ALGORITHM
// // Initialize a counter (cnt) to zero.
  
// // Loop through each element i of the array.
// // For each element i, loop through the elements that come after it (j where j > i).
// // // If arr[i] > arr[j], increment the inversion counter.


static long inversionCount(long arr[]) {
        
        long cnt = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j] ) cnt++;
            }
        }
        
        return cnt;
    }


// TC: O(n ^ 2)  SC: O(1)



//******************************************************OPTIMAL APPROACH***********************************************************

// USING MERGESORT

// INTUITION
// // we can optimize this by using merge sort, 
// // where during the merge step, we count how many elements in the right subarray are smaller than elements in the left subarray (because this would represent inversions).


// ALGORITHM
  
// // Divide the Array:
// // // Split the array into two halves recursively using the merge sort approach.

// // Count Inversions during Merge:
// // // When merging two sorted halves
// // // // if left half element is smaller than the right half 
// // // // // add number of element before the right half current element to the count as those elements are smaller yet greater index than left half current element
// // // // Merge the two halves while counting inversions and maintain a sorted order.

class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[]) {
      return mergeSort(arr, 0, arr.length - 1);
    }
    
    static long mergeSort(long arr[], int start, int end){
        long cnt = 0;
        
        if(start < end){
            int mid = (start + end)/2;
            
            cnt += mergeSort(arr, start, mid);
            cnt += mergeSort(arr, mid + 1, end);
            cnt += merge(arr, start, mid, end);
        }
        
        return cnt;
    }
    
    
    static long merge(long arr[], int start,int mid, int end){
        
        int n1 = mid - start + 1;
        int n2 = end - mid;
        
        long[] a1 = new long[n1];
        for(int i = 0; i < n1; i++){
            a1[i] = arr[start + i]; 
        }
        
        long[] a2 = new long[n2];
        for(int i = 0; i < n2; i++){
            a2[i] = arr[mid + 1 + i];
        }
        
        int p1 = 0;
        int p2 = 0;
        int k = start;
        
        long cnt = 0;
        
        while(p1 < n1 && p2 < n2){
            
            if(a1[p1] <= a2[p2]){
                cnt += p2;
                
                arr[k++] = a1[p1++];
            }else{
                arr[k++] = a2[p2++];
            }
            
        }
        
        while( p1 < n1 ){
            cnt += p2;
            arr[k++] = a1[p1++];
        }
        
        while( p2 < n2){
            arr[k++] = a2[p2++];
        }
        
        return cnt;
        
    }
}

// TC: O(N LogN)  SC: O(N)

