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
