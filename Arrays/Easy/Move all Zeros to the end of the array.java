//******************************************************BRUTE FORCE APPROACH******************************************************
void pushZerosToEnd(int[] arr, int n) {   //Brute force approach
    
    ArrayList<Integer> nonZero = new ArrayList<>();
    
    for(int elem: arr){
        
        if(elem != 0){
            nonZero.add(elem);
        }
    }
    
    
    for(int i = 0; i < nonZero.size(); i++){
        arr[i] = nonZero.get(i);
    }
    
    for(int i = nonZero.size(); i < n; i++){
        arr[i] = 0;  
    }
       
    }

//******************************************************OPTIMAL APPROACH**********************************************************
//TWO POINTER APPROACH
//CASE 1: swap the values if arr[j] != 0 and increment i and j
//CASE 2: increment j only if arr[j] == 0


class solution{
    void pushZerosToEnd(int[] arr, int n){ 
            int i = 0;
            int j = 0;
            
            while(j < n){ 
                if(arr[j] != 0){
                    swap(arr,i++,j++);
                }else{
                    j++;
                }
            }
        }
        
        void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
}
