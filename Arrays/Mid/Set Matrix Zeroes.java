//******************************************************BRUTE FORCE APPROACH 1******************************************************
//USING A EXTRA ARRAY

// Intuition:
// //It's a straightforward approach involves creating a copy of the matrix 
// //to track the original positions of zeroes and then using this copy to modify the original matrix. 
// //This approach ensures that we do not inadvertently overwrite necessary information while
// //modifying the matrix.

// Algorithm:

// // Create a Copy of the Matrix:
// // //Start by copying the original matrix to a new matrix (clone). 
// // //This copy will help us remember the original state of the matrix before any modifications.

// // Iterate Over the clone:
// // //If an element is zero, call helper methods to set the corresponding row and column to zero in the original matrix.

// // Helper Methods:

// // //setRow0(matrix, row): Sets all elements in the specified row to zero.
// // //setCol0(matrix, col): Sets all elements in the specified column to zero.
// // //These methods modify the original matrix based on the positions of zeroes found in the clone matrix.

// TC: O(M * N)  SC: O(M * N)

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] clone = new int[m][n];

        copy2Darray(matrix,clone);

        for(int i = 0; i < m; i++){

            for(int j = 0;j < n; j++){

                if(clone[i][j] == 0){
                    setRow0(matrix, i);
                    setCol0(matrix, j);
                }
            }
        }


    }

    public void copy2Darray(int[][] A,int[][] B){
        int m = A.length;
        int n = A[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                B[i][j] = A[i][j];
            }
        }    
    }

    public void setRow0(int[][] A, int row){
        int n = A[0].length;

        for(int i = 0; i < n; i++) A[row][i] = 0;
    }

    public void setCol0(int[][] A, int col){
        int m = A.length;

        for(int i = 0; i < m; i++) A[i][col] = 0;
    }
}

//******************************************************BRUTE FORCE APPROACH 2******************************************************

//USING MARKING MODIFIED TECHNIQUE

// Intuition:
// //The challenge is to do this in place without using extra space. 
// //The approach involves marking the rows and columns that need to be set to zero by using a marker value (in this case, -1). 
// //After marking, the matrix is scanned again to set the marked rows and columns to zero.

// Algorithm:

// // Identify Rows and Columns to be Zeroed:
// // // Traverse the matrix to find elements that are 0.
// // // //For each 0 found, mark its entire row and column by setting non-zero elements in that row and column to -1.

// // Update the Matrix:
// // // Traverse the matrix again.
// // // //Convert all marked -1 elements to 0, thereby setting the required rows and columns to zero.

//Helper Methods:
// //markRow(matrix, row): Sets all elements in the specified row to -1 if they are not already 0.
// //markCol(matrix, col): Sets all elements in the specified col to -1 if they are not already 0.

// TC: O((M*N)*(M+N)) + O(M * N)  = O((M * N)*(M + N))
// SC: O(1)

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;


        for(int i = 0; i < m; i++){
            for(int j = 0;j < n; j++){
                if(matrix[i][j] == 0){
                    markRow(matrix, i);
                    markCol(matrix, j);
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == -1)matrix[i][j] = 0; 
            }
        }


    }


    public void markRow(int[][] A, int row){
        int n = A[0].length;

        for(int i = 0; i < n; i++){       
            if(A[row][i] != 0) A[row][i] = -1;      
        } 
    }

    public void markCol(int[][] A, int col){
        int m = A.length;

        for(int i = 0; i < m; i++){
            if(A[i][col] != 0) A[i][col] = -1;
        } 
    }
}

//******************************************************BETTER APPROACH***********************************************************

//USING TWO ARRAYS

// Intuition:
//First identify all the rows and columns that need to be set to zero and then modify them. 
//This ensures that we do not prematurely overwrite any data that might still be needed for checking other elements in the matrix.

// Algorithm:

// Initialization:
// //Create two arrays, row and col, to keep track of which rows and columns need to be zeroed.

// Marking Rows and Columns: O(M * N)
// // Traverse through the matrix.
// // //Whenever a 0 is found, mark the corresponding row and column in the row and col arrays by setting row[i] = -1 and col[j] = -1.

// Setting Rows to Zero: O(M * N)
// //Iterate through the row array. 
// //For each index marked as -1, set all elements in that row to zero using the setRow0 helper method.

// Setting Columns to Zero: O(M * N)
// //Iterate through the col array. 
// //For each index marked as -1, set all elements in that column to zero using the setCol0 helper method.

// Helper Methods:
// //setRow0(int[][] A, int row): Sets all elements in the given row to 0.
// //setCol0(int[][] A, int col): Sets all elements in the given column to 0.

// TC: O(M * N) + O(M * N) + O(M * N) = O(M * N)
// SC: O(M + N)

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = new int[m];
        int[] col = new int[n];


        //Marking in row and col array
        for(int i = 0; i < m; i++){
            for(int j = 0;j < n; j++){
                if(matrix[i][j] == 0){
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }

        
        //Setting marked row to zero
        for(int i = 0; i < m; i++)
            if(row[i] == -1) setRow0(matrix, i);

        //Setting marked column to zero
        for(int i = 0; i < n; i++)
            if(col[i] == -1) setCol0(matrix, i);



    }


    public void setRow0(int[][] A, int row){
        int n = A[0].length;
        for(int i = 0; i < n; i++) A[row][i] = 0;      
    }

    public void setCol0(int[][] A, int col){
        int m = A.length;
        for(int i = 0; i < m; i++) A[i][col] = 0; 
    }
}

//******************************************************OPTIMAL APPROACH**********************************************************

// TC: O()  SC: O()
