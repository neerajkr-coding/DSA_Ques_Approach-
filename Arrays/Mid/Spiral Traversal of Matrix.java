//******************************************************OPTIMAL APPROACH**********************************************************

// Intuition:
// // The traversal starts from the top-left corner and moves towards the right. Once the end of the row is reached, the traversal continues down the rightmost column, then moves left along the bottom row, and finally, it moves up the leftmost column. 
// // This process repeats by reducing the boundaries until all elements are visited.

// Algorithm:
// // Initialize Boundaries:
// // // start (left boundary) = 0,
// // // end (right boundary) = last column index,
// // // top = 0,
// // // bottom = last row index.

// // Traverse in a Spiral Order: O(N * M) 
// // // Traverse from start to end across the top row, then increment top.
// // // Traverse from top to bottom down the end column, then decrement end.
// // // If top is within bottom, traverse from end to start across the bottom row, then decrement bottom.
// // // If start is within end, traverse from bottom to top up the start column, then increment start.

// // Repeat the Above Steps: 
// // // Continue until start exceeds end or top exceeds bottom.

// TC: O(N * M)  
// SC: O(1)

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> spiral = new ArrayList<>();        
        int start = 0;
        int end = matrix[0].length - 1;

        int top = 0;
        int bottom = matrix.length - 1;

        while(start <= end && top <= bottom ){

            for(int i = start; i <= end; i++){
                spiral.add(matrix[top][i]);
            }
            top++;

            for(int i = top; i <= bottom; i++ ){
                spiral.add(matrix[i][end]);
            }
            end--;

            if(bottom >= top){
                for(int i = end; i >= start; i--){
                spiral.add(matrix[bottom][i]);
            }
            bottom--;
            }
            

            if(end >= start){
            for(int i = bottom; i >= top; i--){
                spiral.add(matrix[i][start]);
            }
            start++;
            }
        }

        return spiral;
    }

