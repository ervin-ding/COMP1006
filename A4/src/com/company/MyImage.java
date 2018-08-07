package com.company;

public class MyImage extends Image {
    private boolean[][] visited;
    private int size;
    private boolean colorIsBlack;
    private boolean pinHoleIsBlack;
    private int counter;
    private Position pinHolePosition;

    public MyImage(int rows, int cols){
        super(rows,cols);
    }
    public MyImage(boolean[][] data){
        super(data);
    }

    //loops through the array of array and returns the first position that returns true;
    @Override
    public Position find() {
        for(int r=0; r<this.rows; r+=1){
            for(int c=0; c<this.cols; c+=1){
                if (this.pixels[r][c]){
                    Position position = new Position(r,c);
                    return position;
                }
            }
        }
        return null;
    }
    //same as find() but looks for a white pixel
    public Position findWhitePixel() {
        for(int r=0; r<this.rows; r+=1){
            for(int c=0; c<this.cols; c+=1){
                if (!this.pixels[r][c]){
                    Position position = new Position(r,c);
                    return position;
                }
            }
        }
        return null;
    }
    //reset private attributes, sets the if target is black or white and calls the recursive function, navigate(x,y)
    @Override
    public int sizeOfConnectedComponent(Position p) {
        int x = p.getX();
        int y = p.getY();
        visited = new boolean[getRows()][getCols()]; // reset visited array
        size = 1; // reset size
        colorIsBlack=false;
        if (checkColor(x,y)){
            colorIsBlack=true;
        }
        visited[x][y] = true; //set current position as visited.
        navigate(x,y);
        return size;
    }

    /* navigate(x,y) will check if up, down, left, right are within the array of array. Then it will check if the
     * adjacent pixel is the same as the target and if that position has been visited or not. Then it will set the
     * adjacent position as visited, increment size by 1 and recursively calls navigate on the adjacent position */
    public void navigate(int x, int y) {
        if ((x + 1) <= getCols() - 1) {
            if (checkColor(x + 1, y) == colorIsBlack && !visited[x + 1][y]) {
                int adjacent = x + 1;
                visited[x + 1][y] = true;
                size += 1;
                navigate(adjacent, y);
            }
        }
        if ((x - 1) >= 0) {
            if (checkColor(x - 1, y) == colorIsBlack && !visited[x - 1][y]) {
                int adjacent = x - 1;
                visited[x - 1][y] = true;
                size += 1;
                navigate(adjacent, y);
            }
        }
        if ((y + 1) <= getCols() - 1) {
            if (checkColor(x, y + 1) == colorIsBlack && !visited[x][y + 1]) {
                int adjacent = y + 1;
                visited[x][y + 1] = true;
                size += 1;
                navigate(x, adjacent);
            }
        }
        if ((y - 1 >= 0)) {
            if (checkColor(x, y - 1) == colorIsBlack && !visited[x][y - 1]) {
                int adjacent = y - 1;
                visited[x][y - 1] = true;
                size += 1;
                navigate(x, adjacent);
            }
        }
    }

    //check if the current pixel is true or false (black or white)
    public boolean checkColor(int x, int y){
        return this.getPixel(x, y);
    }

    /* sets a startingPosition by finding a pixel that is true (black). Call sizeOfConnectedComponent on
     * startingPosition to get a size of black pixels. Compares that to the total number of pixels minus
     * the number of connected white pixels (false). */
    @Override
    public boolean isConnectedWithoutHoles() {
        int sizeofData = (getRows()*getCols());
        int sizeofBlackPixels = 0, sizeofWhitePixels = 0;
        if (find() != null) {
            sizeofBlackPixels = sizeOfConnectedComponent(find());
        }
        if (findWhitePixel() != null){
            sizeofWhitePixels = sizeOfConnectedComponent(findWhitePixel());
        }
        return (sizeofData - sizeofWhitePixels) == sizeofBlackPixels;
    }

    /* check if the current position is black or white and set colorIsBlack as the opposite. Based on that,
     * find the first pixel that is opposite. Reset counter and pinHolePosition and call checkIfPinHole which
     * will set pinHolePosition.
     * Black p (true) mean find a white position (false) surrounded by black (true)
     */
    @Override
    public Position findPinHole(Position p) {
        int x = p.getX();
        int y = p.getY();
        Position target;
        //if true, p is black
        if (checkColor(x,y)) {
            pinHoleIsBlack = false; //use as flag to check if surroundings are black
            //null check to make sure the pixels are not all false
            if (findWhitePixel() != null) {
                target = findWhitePixel();
            }
            else {
                target = null;
            }
        }
        else {
            pinHoleIsBlack = true; //use as flag to check if surroundings are white
            //null check to make sure the pixels are not all true
            if (find() != null) {
                target = find();
            }
            else {
                target = null;
            }
        }
        this.counter = 0;
        pinHolePosition=null;
        if (target != null) {
            checkIfPinHole(target);
        }
        return pinHolePosition;
    }
    // create an array of all the pixels that matches what we're looking for (based on pinHoleIsBlack).
    public Position[] findAll() {
        int counter = 0;
        int arraySize = 0;
        for(int r=0; r<this.rows; r+=1) {
            for (int c = 0; c < this.cols; c += 1) {
                if (this.pixels[r][c] == pinHoleIsBlack) {
                    arraySize += 1;
                }
            }
        }
        Position[] arrayOfMatchingPositions = new Position[arraySize];
        for(int r=0; r<this.rows; r+=1) {
            for (int c = 0; c < this.cols; c += 1) {
                if (this.pixels[r][c] == pinHoleIsBlack) {
                    arrayOfMatchingPositions[counter] = new Position(r,c);
                    counter += 1;
                }
            }
        }
        return arrayOfMatchingPositions;
    }

    /* starting from target position, check if right, left, up, down are opposite of the pinHoleIsBlack. If not,
     * recursively call checkIfPinHole again with next position from the arrayOfMatchingPositions.*/
    public void checkIfPinHole(Position p) {
        boolean up = false, down = false, right = false, left = false;
        int x = p.getX();
        int y = p.getY();
        Position[] arrayOfMatchingPositions = findAll();
        if (sizeOfConnectedComponent(p) == 1 ) {
            //check if in bounds
            if ((x + 1) <= getCols() - 1) {
                //if adjacent position is opposite, set direction as true
                if (checkColor(x + 1, y) != pinHoleIsBlack) {
                    right = true;
                    //check if counter is within bounds of the array
                } else if(counter < arrayOfMatchingPositions.length-1) {
                    this.counter += 1;
                    checkIfPinHole(arrayOfMatchingPositions[counter]);
                }
            }
            if ((x - 1) >= 0) {
                if (checkColor(x - 1, y) != pinHoleIsBlack) {
                    left = true;
                } else if(counter < arrayOfMatchingPositions.length-1) {
                    this.counter += 1;
                    checkIfPinHole(arrayOfMatchingPositions[counter]);
                }
            }
            if ((y + 1) <= getCols() - 1) {
                if (checkColor(x, y + 1) != pinHoleIsBlack) {
                    up = true;
                } else if(counter < arrayOfMatchingPositions.length-1) {
                    this.counter += 1;
                    checkIfPinHole(arrayOfMatchingPositions[counter]);
                }
            }
            if ((y - 1 >= 0)) {
                if (checkColor(x, y - 1) != pinHoleIsBlack) {
                    down = true;
                } else if(counter < arrayOfMatchingPositions.length-1) {
                    this.counter += 1;
                    checkIfPinHole(arrayOfMatchingPositions[counter]);
                }
                //if in bounds but adjacent is not opposite of pinHoleIsBlack
            } else if(counter < arrayOfMatchingPositions.length-1) {
                this.counter += 1;
                checkIfPinHole(arrayOfMatchingPositions[counter]);
            }
        }
        //if position is not size 1, check the next position in the array
        else if (counter < arrayOfMatchingPositions.length-1) {
            this.counter += 1;
            if (arrayOfMatchingPositions[counter] != null) {
                checkIfPinHole(arrayOfMatchingPositions[counter]);
            }
        }
        if (up && down && left && right) {
            pinHolePosition = p;
        }
    }
}
