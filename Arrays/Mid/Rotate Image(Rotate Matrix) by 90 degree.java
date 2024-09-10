//******************************************************BRUTE FORCE APPROACH******************************************************

// USING A EXTRA 2D ARRAY

// Intuition:
// // To rotate a matrix by 90 degrees clockwise, the element at the position (i, j) in the original matrix needs to move to the position (j, n-1-i) in the rotated matrix. 
// // My solution leverages this by creating a helper matrix to store the rotated values
// // then it copies the helper matrix back to the original matrix.

// Algorithm:
// // Create a helper matrix of the same size as the original matrix.

// // Traverse each element (i, j) in the original matrix:
// // // Set helper[j][n-1-i] equal to matrix[i][j].

// // Copy the helper matrix back to the original matrix.

public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        int[][] helper = new int[n][n];

        
        for(int i = 0; i < n; i++){ // O(N^2)
            for(int j = 0; j < n; j++){

                helper[j][ ( n - 1 ) - i] = matrix[i][j];
            }
        }

        for(int i = 0; i < n; i++){  // O(N^2)
            for(int j = 0; j < n; j++){
                matrix[i][j] = helper[i][j];
            }
        }

    }

// TC: O(N^2) + O(N^2) = O(2(N^2)) ~ O(N^2)  
// SC: O(N^2)

//******************************************************OPTIMAL APPROACH**********************************************************

// USING TRANSPOSE AND REVERSE 

// Intuition
// // The task is to rotate a given n×n matrix by 90 degrees clockwise. 
// // To achieve this in-place you can break down the problem into two main steps:
// // // Transpose the matrix: Swap elements across the diagonal, converting rows to columns.
// // // Reverse each row: After transposition, reversing each row will give you the desired 90-degree clockwise rotation.

// Algorithm
// // Transpose the matrix: O(N^2)
// // // For each element in the upper triangle of the matrix (excluding the diagonal), swap it with the corresponding element across the diagonal.
// // Reverse each row:   O(N^2)
// // // Reverse the elements in each row of the transposed matrix.

// TC:  O(N^2) +  O(N^2) =  O(2(N^2)) ~  O(N^2)
// SC:  O(N^2)

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;   
        transpose(matrix);

        for(int[] e: matrix){
            reverse(e);
        }
    }

    public void transpose(int[][] A){
        int n = A.length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
    }

    public void reverse(int[] A){
        int n = A.length;

        int i = 0; 
        int j = n - 1;
        while(i < j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;

            i++;
            j--;
        }
    }
}
