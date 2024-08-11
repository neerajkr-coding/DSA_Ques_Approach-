//QUESTION: Given an unsorted array arr[] of size n. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer.

//***************************************************************BRUTE FORCE APPROCH********************************************
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


//***************************************************************BETTER APPROCH***************************************************

  static void rotateArr(int arr[], int d, int n) { 
        d %= n;

          
        int[] temp = new int[d];                  // copy element to the a new array
        for(int i = 0; i < d; i++){
            temp[i] = arr[i];
        }
        
        int j = 0;                                // Shifting the remaining element left by d places
        for(int i = d; i < n; i++){
            arr[j++] = arr[i];
        }
        
        int i = 0;                                // put the copied element at the back of the original array
        while(j < n){
            arr[j++] = temp[i++];
        }
    }

****************************************************************OPTIMAL APPROCCH*****************************************************
        
static void rotateArr(int arr[], int d, int n) {
         d %= n;
         reverse(arr,0,n-1);                                    //Reverse the whole array
         reverse(arr,0,n-1-d);                                  //Reverse first n-d elements
         reverse(arr,n-d,n-1);                                  //Reverse remaining element
     }
     
     static void reverse(int arr[], int start, int end){        //Reverse array from start to end index method
         while(start < end){
             int temp = arr[start];
             arr[start++] = arr[end];
             arr[end--] = temp;
         }
     }
