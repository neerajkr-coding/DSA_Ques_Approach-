//******************************************************BRUTE FORCE APPROACH******************************************************

//Two Loop Approch
//##### FAILS WHEN ARRAY CONTAINS -IVE INTEGERS AS WELL ##### 
public static int lenOfLongSubarr (int A[], int N, int K) {
        
        int longestSubArr = 0;
        
      for(int i = 0; i < N; i++){
          int sum = 0;
          
          int j = i;
          while(j < N && sum <= K){
              sum += A[j];
              
              if(sum == K){
                  longestSubArr = Math.max(longestSubArr, (j - i) + 1);
              }
              
              j++;
          }
      }
      
      return longestSubArr;
    }
//******************************************************OPTIMAL APPROACH**********************************************************

//Add the current element to Rsum.
//If Rsum == K, set ans to i + 1.
//If Rsum - K exists in hash, update ans to the maximum of ans and i - hash.get(Rsum - K).
//If Rsum is not in hash, store it with its index.

public static int lenOfLongSubarr (int A[], int N, int K) {
        
        int ans = 0;
        
        Map<Integer, Integer> hash = new HashMap<>();
        
        
        int Rsum = 0;
        for(int i = 0; i < N; i++){
            Rsum += A[i];
            
            if(Rsum == K){
                ans = i + 1;
                
            }else if(hash.containsKey(Rsum - K)){
                ans = Math.max(ans, i - hash.get(Rsum - K));
                
            }
            
            
            if(!hash.containsKey(Rsum)){
                hash.put(Rsum, i);
            }
            
        }
        
        return ans;
    }

