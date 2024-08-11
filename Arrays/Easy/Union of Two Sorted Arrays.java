//******************************************************BRUTE FORCE APPROACH******************************************************
  public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        Set<Integer> unique = new TreeSet<>();
        
        
        for(int elem: arr1){
            unique.add(elem);
        }
        
        for(int elem: arr2){
            unique.add(elem);
        }
        
        
        for(int elem: unique){
            ans.add(elem);
        }
        
        
        return ans;
        
    }
//******************************************************BETTER APPROACH***********************************************************

//******************************************************OPTIMAL APPROACH**********************************************************
//Traverse Both Arrays:
  //While Loop: Iterate as long as both pointers (i and j) are within bounds.
    //Compare Elements:
      //If arr1[i] ≤ arr2[j], add arr1[i] to ans if it's not a duplicate and move i forward.
      //If arr1[i] > arr2[j], add arr2[j] to ans if it's not a duplicate and move j forward.

//Process Remaining Elements:
  //After the loop, add any leftover elements from arr1 and arr2 to ans, ensuring no duplicates.


//CODE
public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m){
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        
        while( i < n && j < m){
            //If arr1[i] ≤ arr2[j], add arr1[i] to ans if it's not a duplicate and move i forward.
            if(arr1[i] <= arr2[j]){   
                
                if(ans.isEmpty() || ans.get(ans.size()-1) != arr1[i]){
                    ans.add(arr1[i]);
                }
                
                i++;
            }else{  
                 //If arr1[i] > arr2[j], add arr2[j] to ans if it's not a duplicate and move j forward.
                if(ans.isEmpty() || ans.get(ans.size()-1) != arr2[j]){
                    ans.add(arr2[j]);
                }
                j++;
            }
        }
        
        
            //add any leftover elements from arr1 and arr2 to ans, ensuring no duplicates.
            while(i < n){
                if(ans.isEmpty()|| ans.get(ans.size()-1) != arr1[i]){
                    ans.add(arr1[i]);
                }
                i++;  
            }
            
            while(j < m){
                if(ans.isEmpty() || ans.get(ans.size()-1) != arr2[j]){
                    ans.add(arr2[j]);
                }
                j++;
            }
            
         return ans;
    }
