//******************************************************BRUTE FORCE APPROACH******************************************************

//Overwrite the array:
//-First with all 0s based on the zeros count.
//-Then with all 1s based on the ones count.
//-Finally with all 2s based on the twos count.
public void sortColors(int[] nums) {
      
    int zeros = 0;
    int ones = 0;
    int twos = 0;

    for(int e: nums){

        if(e == 0){
            zeros++;
        }else if(e == 1){
            ones++;
        }else{
            twos++;
        }
    }

    for(int i = 0; i < zeros; i++ ){
        nums[i] = 0;
    }

    for(int i = 0; i < ones; i++){
        nums[zeros + i] = 1;
    }

    for(int i = 0; i < twos; i++){
        nums[zeros + ones + i] = 2;
    }

    }

//******************************************************BETTER APPROACH***********************************************************

//******************************************************OPTIMAL APPROACH**********************************************************

//Using Dutch National Flag Algorithm (DNF)
//or Three pointers Approch 


//Initialize Pointers:
//-Set low and mid to 0.
//-Set high to the last index (n - 1).
//-Partition the Array:

//Iterate while mid is less than or equal to high:
//-Case1: If the element at mid is 0, swap it with the element at low, and increment both low and mid.
//-Case2: If the element at mid is 1, move mid to the next position.
//-Case3: If the element at mid is 2, swap it with the element at high and decrement high.


class Solution {
    public void sortColors(int[] nums) {
      
        int n = nums.length;

        int low = 0;
        int mid = 0;
        int high = n - 1;

        while(mid <= high){

            if(nums[mid] == 0){
                swap(nums, low++, mid++);
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(nums, mid, high--);
            }
        }

    }

    public void swap(int A[], int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


}
