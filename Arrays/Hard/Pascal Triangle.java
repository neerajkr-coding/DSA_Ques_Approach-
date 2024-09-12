//******************************************************OPTIMAL APPROACH 1***********************************************************

    //USING THE PREVIOUS ROW TO GENERATE CURRENT ROW

    // Intuition:
    // // Pascal's Triangle is a triangular array where each element is the sum of the two elements directly  above it from the previous row. 
    // // The first and last elements of each row are always 1. 
    // // You can build the triangle row by row, using the previous row to calculate the current one.

    // Algorithm:

    // // Initialize the first row of Pascal's Triangle with [1].

    // // For each subsequent row, use the previous row to compute the current row, Repeat the process for numRows times:
    // // // Start with and end each row with 1.
    // // // For the inner elements, compute the sum of the two adjacent elements from the previous row.
    // // // Append the row to Pascal's Triangle.
    
    // TC: O(N^2)  SC: O(N^2), N = Number of rows

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(new ArrayList<>(Arrays.asList(1)));

        for(int i = 1; i < numRows; i++){
            List<Integer> prevRow = pascalTriangle.get(i - 1);

            List<Integer> row = new ArrayList<>();
            int n = prevRow.size();
            for(int j = 0; j < n + 1; j++){

                row.add((j == 0 || j == n) ? 1: (prevRow.get(j) + prevRow.get(j - 1)));

                // if(j == 0 || j == n){
                //     row.add(1);
                // }else{
                //     row.add( prevRow.get(j - 1) + prevRow.get(j) );
                // }
            } 

            pascalTriangle.add(row);
        }


        return pascalTriangle;
        
    }

//******************************************************OPTIMAL APPROACH 2***********************************************************

