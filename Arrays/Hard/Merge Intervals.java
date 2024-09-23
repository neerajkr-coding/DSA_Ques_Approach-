//******************************************************BRUTE FORCE APPROACH******************************************************

// .


// INTUITION


// ALGORITHM


// TC: O()  SC: O()



//******************************************************OPTIMAL APPROACH**********************************************************

//


// INTUITION
// // The idea is to first sort the intervals based on their starting points. 
// // Once sorted, overlapping intervals will appear consecutively. 
// // By iterating through the sorted intervals, we can merge them if they overlap or add them as separate intervals if they don't.


// ALGORITHM
// // Sort the intervals: Use a comparator to sort the intervals based on their starting points.
  
// // Initialize a result list: Add the first interval to this list.
  
// // Iterate through the remaining intervals:
// // // If the current interval doesn't overlap with the last interval in the result list, add it as a new interval.
// // // If they do overlap, merge them by updating the end of the last interval in the result list.


public int[][] overlappedInterval(int[][] Intervals)
    {
        
        
        Comparator<int[]> c = new Comparator<>(){
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0], b[0]);
            }
        };
        
        Arrays.sort(Intervals,c);  // O(N*logN)
        
        List<int[]> list = new ArrayList<>();
        list.add(Intervals[0]);
        
        for(int i = 1; i < Intervals.length; i++){  // O(N)
            int[] arr = list.get(list.size() - 1);
            
            if(Intervals[i][0] > arr[1]){
                list.add(Intervals[i]);
            }else{
                
                if(Intervals[i][1] > arr[1]){
                    arr[1] = Intervals[i][1];
                }
            }
        }
        
        int[][] res = new int[list.size()][];
        int i = 0;
        
        for(int[] e: list){
            res[i++] = e;
        }
        
        return res;
    }


// TC: O(N*logN) + O(N) = O(N*logN)
// SC: O(N)
