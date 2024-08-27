//******************************************************BRUTE FORCE APPROACH******************************************************

//Two Loop approch
//Loop one to choose a element
//Loop two to count the occurance of the chosen element

static int majorityElement(int a[], int size)
    {
        for(int e: a){
            
            int cnt = 0;
            for(int e1: a){
                if(e1 == e) cnt++;
                
                 if(cnt > size/2){
                     return e;
                 } 
            }
            
        }     
        return -1;
    }

//******************************************************BETTER APPROACH***********************************************************

//For each element e in the array:
// Case1: e is equal to currElem, increment currCnt.
// Case2: If e is not equal to currElem:
// -Update currElem to e.
// -Reset currCnt to 1.
// If currCnt exceeds size / 2, return currElem as the majority element.
// TC: O(n Logn)  SC: O(1)

static int majorityElement(int a[], int size)
    {
        
        Arrays.sort(a);
        
        int currElem = a[0];
        int currCnt = 0;
        
        for(int e: a){
            
            if(e == currElem){
                currCnt++;
                
            }else{
                currElem = e;
                currCnt = 1;
                
            }
            if(currCnt > size/2) return currElem;
        }
        
        return -1;
    }

//******************************************************OPTIMAL APPROACH**********************************************************
