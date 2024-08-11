QUESTION: Given an unsorted array arr[] of size n. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer.

***************************************************************BRUTE FORCE APPROCH********************************************
//rotate array by one from d time 
static void rotateArr(int arr[], int d, int n) {   
        for(int i = 0; i < d; i++){
            rotateOnce(arr,n);
        }
    }

//  Rotate array by one
    static void rotateOnce(int arr[], int n){
        int first = arr[0];
        
        for(int i = 0; i < n-1; i++){
            arr[i] = arr[i+1];
        }
        
        arr[n-1] = first;
    }


***************************************************************BETTER APPROCH***************************************************
  static void rotateArr(int arr[], int d, int n) { 
        d %= n;
        
        int[] temp = new int[d];
        for(int i = 0; i < d; i++){
            temp[i] = arr[i];
        }
        
        int j = 0;
        for(int i = d; i < n; i++){
            arr[j++] = arr[i];
        }
        
        int i = 0;
        while(j < n){
            arr[j++] = temp[i++];
        }
    }

****************************************************************OPTIMAL APPROCCH*****************************************************
static void rotateArr(int arr[], int d, int n) {
         d %= n;
         reverse(arr,0,n-1);
         reverse(arr,0,n-1-d);
         reverse(arr,n-d,n-1);  
     }
     
     static void reverse(int arr[], int start, int end){  
         while(start < end){
             int temp = arr[start];
             arr[start++] = arr[end];
             arr[end--] = temp;
         }
     }
