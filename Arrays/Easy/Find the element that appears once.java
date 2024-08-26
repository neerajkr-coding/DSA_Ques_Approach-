//******************************************************BRUTE FORCE APPROACH******************************************************
//Two Loops approch 
    //One loop for selecting the element
    //Second loop for counting the occurance of the element in the array
    public static int search(int n, int arr[]) {
        
        int ans = -1;
        
       for(int e: arr){
           
           int cnt = 0;
           
           for(int a: arr){
               if(a == e){
                   cnt++;
               }
           }
           
           if(cnt == 1){
               ans = e;
           }
       }
       
       return ans;
       
    }

//******************************************************BETTER APPROACH***********************************************************
//Using Hash Table
    //Put the element of array as key and no.of it occurance as value
    //return key those value is 1
    public static int search(int n, int arr[]) {
        
        Map<Integer, Integer> hash = new HashMap<>();
        
        for(int e: arr){
            
            if(!hash.containsKey(e)){
                hash.put(e,0);
            }
            
            hash.put(e, hash.get(e) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry: hash.entrySet()){
            
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        
        return -1;
       
    }

//******************************************************OPTIMAL APPROACH**********************************************************
//Using XOR operator
    //XOR of two same numbers is Zero, so the numbers appearing twice are cancel
    //Final value of XOR of who array is the number which appears only once
    public static int search(int n, int arr[]) {
        
       int Xor = 0;
       
       for(int e: arr){
           Xor ^= e;
       }
       
       return Xor;
    }
