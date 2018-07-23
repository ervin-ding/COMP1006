public class SudokuChecker{

    /** sample valid game */
    public static byte[][] example1 = new byte[][]{
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}};

    /** sample invalid game */
    public static byte[][] example2 = new byte[][]{
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,3},
            {2,8,7,4,1,9,6,2,6},
            {3,4,5,2,8,6,1,8,8}};

    /** checks if row 'row' is OK in the grid */
    public static boolean checkRow(int row, byte[][] grid) {
        int[] nums = new int [9];
        boolean correct = true;
        int counter = 0;
        //save in single array
        for (int i = 0; i < 9; i += 1) {
            nums[i] = grid[row][i];
        }
        //use e as value to compare value of each element of the array to see if the value is present in the array
        for (int e = 1; e < 10; e+=1) {
            for (int j = 0; j < 9; j += 1) {
                if (nums[j] > 9 || nums[j] <= 0) {
                    correct = false;
                    break;
                }
                if (e == nums[j]) {
                    counter += 1; //add if the element is present
                    break;
                }
            }
        }
        //check to see is counter is 9, if all 9 numbers are present in the array.
        if (counter != 9) {
            correct = false;
        }
        return correct;
    }

    /** checks if column 'col' is OK in the grid */
    public static boolean checkColumn(int col, byte[][] grid){
        int[] nums = new int [9];
        boolean correct = true;
        int counter = 0;
        //save in single array
        for (int i = 0; i < 9; i += 1) {
            nums[i] = grid[i][col];
        }
        //use e as value to compare value of each element of the array to see if the value is present in the array
        for (int e = 1; e < 10; e+=1) {
            for (int j = 0; j < 9; j += 1) {
                if (nums[j] > 9 || nums[j] <= 0) {
                    correct = false;
                    break;
                }
                if (e == nums[j]) {
                    counter += 1; //add if the element is present
                    break;
                }
            }
        }
        //check to see is counter is 9, if all 9 numbers are present in the array.
        if (counter != 9) {
            correct = false;
        }
        return correct;
    }
    /** checks if the subregion 'region' is OK in the grid */
    public static boolean checkSubregion(int region, byte[][] grid) {
        int[] nums = new int [9]; //
        boolean correct = true;
        int counter = 0;
        int rowofRegion, colofRegion;
        int i = 0; //index of the nums array
        //save in single array depending on region
        switch(region) {
            case 0:
                for (rowofRegion = 0; rowofRegion < 3; rowofRegion += 1) {
                    for (colofRegion = 0; colofRegion < 3; colofRegion += 1) {
                        nums[i] = grid[rowofRegion][colofRegion];
                        i += 1;
                    }
                }
                break; // exit switch
            case 1:
                for (rowofRegion = 0; rowofRegion < 3; rowofRegion += 1) {
                    for (colofRegion = 3; colofRegion < 6; colofRegion += 1) {
                        nums[i] = grid[rowofRegion][colofRegion];
                        i += 1;
                    }
                }
                break; // exit switch
            case 2:
                for (rowofRegion = 0; rowofRegion < 3; rowofRegion += 1) {
                    for (colofRegion = 6; colofRegion < 9; colofRegion += 1) {
                        nums[i] = grid[rowofRegion][colofRegion];
                        i += 1;
                    }
                }
                break; // exit switch
            case 3:
                for (rowofRegion = 3; rowofRegion < 6; rowofRegion += 1) {
                    for (colofRegion = 0; colofRegion < 3; colofRegion += 1) {
                        nums[i] = grid[rowofRegion][colofRegion];
                        i += 1;
                    }
                }
                break; // exit switch
            case 4:
                for (rowofRegion = 3; rowofRegion < 6; rowofRegion += 1) {
                    for (colofRegion = 3; colofRegion < 6; colofRegion += 1) {
                        nums[i] = grid[rowofRegion][colofRegion];
                        i += 1;
                    }
                }
                break; // exit switch
            case 5:
                for (rowofRegion = 3; rowofRegion < 6; rowofRegion += 1) {
                    for (colofRegion = 6; colofRegion < 9; colofRegion += 1) {
                        nums[i] = grid[rowofRegion][colofRegion];
                        i += 1;
                    }
                }
                break; // exit switch
            case 6:
                for (rowofRegion = 6; rowofRegion < 9; rowofRegion += 1) {
                    for (colofRegion = 0; colofRegion < 3; colofRegion += 1) {
                        nums[i] = grid[rowofRegion][colofRegion];
                        i += 1;
                    }
                }
                break; // exit switch
            case 7:
                for (rowofRegion = 6; rowofRegion < 9; rowofRegion += 1) {
                    for (colofRegion = 3; colofRegion < 6; colofRegion += 1) {
                        nums[i] = grid[rowofRegion][colofRegion];
                        i += 1;
                    }
                }
                break; // exit switch
            case 8:
                for (rowofRegion = 6; rowofRegion < 9; rowofRegion += 1) {
                    for (colofRegion = 6; colofRegion < 9; colofRegion += 1) {
                        nums[i] = grid[rowofRegion][colofRegion];
                        i += 1;
                    }
                }
                break; // exit switch
        }
        //use e as value to compare value of each element of the array to see if the value is present in the array
        for (int e = 1; e < 10; e+=1) {
            for (int j = 0; j < 9; j += 1) {
                if (e == nums[j]) {
                    counter += 1; //add if the element is present
                    break;
                }
            }
        }
            //check to see is counter is 9, if all 9 numbers are present in the array.
            if (counter != 9) {
                correct = false;
            }
    return correct;
    }


    public static boolean check(byte[][] grid){
        for(int row=0; row<9; row+=1){                    // check the rows
            if( !checkRow(row, grid) ){
                return false;
            }
        }
        for(int col=0; col<9; col+=1){                    // check the rows
            if( !checkColumn(col, grid) ){
                return false;
            }
        }
        for(int subregion=0; subregion<9; subregion+=1){  // check the subregions
            if( !checkSubregion(subregion, grid) ){
                return false;
            }
        }

        // if we get this far then we conclude that the grid
        // must be valid (because if it was not, we would have
        // returned false somewhere above)
        return true;
    }



    public static void main(String[] args){

        System.out.print("exmample1 | expected output is true  | actual output is ");
        System.out.println(check(example1));

        System.out.print("exmample2 | expected output is false | actual output is ");
        System.out.println(check(example2));



    }

}