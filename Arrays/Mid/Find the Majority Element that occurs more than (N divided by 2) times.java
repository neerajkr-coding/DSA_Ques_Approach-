QUESTION
Given an array arr. Find the majority element in the array. If no majority exists, return -1.
A majority element in an array of size n is an element that appears strictly more than n/2 times in the array.

//******************************************************BRUTE FORCE APPROACH******************************************************

//Two Loop approch
//Loop one to choose a element
//Loop two to count the occurance of the chosen element
// TC: O(n^2)  SC: O(1)

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

//Set candidate to the first element of the array a.
//Set vote to 0.
//Iterate through each element e in array a:
//-If e is equal to candidate, increment vote.
//-If e is different from candidate, decrement vote.
//-If vote becomes negative, update candidate to e and reset vote to 0.
//Verify Candidate
// TC: O(n)  SC: O(1)

static int majorityElement(int a[], int size)
    {
        
        
        int candidate = a[0];
        int vote = 0;
        
        for(int e: a){
            
            if(e == candidate){
                vote++;
            }else{
                vote--;
            }
            
            if(vote < 0){
                candidate = e;
                vote = 0;
            }
        }
        
        int cnt = 0;
        for(int e: a){
            if(e == candidate){
                cnt++;
            }
        }
        
        if(cnt > size/2) return candidate;
        
        return -1;
    }
