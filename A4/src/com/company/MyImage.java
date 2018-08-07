package com.company;

import java.util.NavigableMap;

public class MyImage extends Image {
    public boolean[][] visited = new boolean[getRows()][getCols()];
    public int size;
    boolean colorisBlack;
    boolean colorisWhite;

    public MyImage(int rows, int cols){
        super(rows,cols);
    }
    public MyImage(boolean[][] data){
        super(data);
    }
    /** Finds some position in the image that has a black pixel
     * or returns null of there are none.
     *
     * You do not need to use recursion for this. Any position with
     * a black pixel value will be accepted.
     */
    @Override
    public Position find() {
        for(int r=0; r<this.rows; r+=1){
            for(int c=0; c<this.cols; c+=1){
                if (this.pixels[r][c] == true){
                    Position position = new Position(r,c);
                    return position;
                }
            }
        }
        return null;
    }
    public Position findWhitePixel() {
        for(int r=0; r<this.rows; r+=1){
            for(int c=0; c<this.cols; c+=1){
                if (this.pixels[r][c] == false){
                    Position position = new Position(r,c);
                    return position;
                }
            }
        }
        return null;
    }
    /** computes the size (area/number of positions) of the
     * connected component containing position p.
     *
     * Two pixels are connected if
     *  1) they are the same colour
     *  2) there is a path (sequence of up/down/left/right steps) from
     *     one pixel to the other, where all pixels on the path are the
     *     same colour as the two pixels
     *
     * A connected component containing a position p consists of all pixels that
     * are connected to the pixel at position p. (If p is black then all pixels
     * in the connected component are blask; if p is white then all pixels in the connected
     * component are white.)
     *
     * This method MUST be recursive.
     */
    @Override
    public int sizeOfConnectedComponent(Position p) {
        //check if false, if false, find all adjacent positions that are false and recursively call sizeOfConnectedComponent.
        //if true, find all adjacent positions that are true and recursively call sizeofConnectedComponent.
        //NOTE: Remember to clear size when complete
        int x = p.getX();
        int y = p.getY();
        //reset visited array everytime sizeOfConnectComponent gets called
        for (int i = 0; i<this.rows; i+=1) {
            for (int j = 0; j<this.cols; j+=1){
                visited[i][j] = false;
            }
        }
        size = 1;
        colorisBlack=false;
        if (checkColor(x,y)){
            colorisBlack=true;
        }
        visited[x][y] = true;
        navigate(x,y);
        System.out.println("size = " + size);
        return size;
    }


    //when navigating: need to know 1.what color to look for (checkColor) 2. visited = false, otherwise set it to true 3.
//    public void startcount(int x, int y){
//        //if looking for black
//        if (colorisBlack){
//           navigate(x,y);
//        }
//        else {
//            navigate(x,y);//looking for white.
//        }
//    }

    //TODO make the insides a method with x,y,and boolean value
    public void navigate(int x, int y) {
        //if looking for black
//        if (colorisBlack) {
            if ((x + 1) <= getCols() - 1) {
                if (checkColor(x + 1, y) == colorisBlack && !visited[x + 1][y]) {
                    int adjacent = x + 1;
                    visited[x + 1][y] = true;
                    size += 1;
                    navigate(adjacent, y);
                }
            }
            if ((x - 1) >= 0) {
                if (checkColor(x - 1, y) == colorisBlack && !visited[x - 1][y]) {
                    int adjacent = x - 1;
                    visited[x - 1][y] = true;
                    size += 1;
                    navigate(adjacent, y);
                }
            }
            if ((y + 1) <= getCols() - 1) {
                if (checkColor(x, y + 1) == colorisBlack && !visited[x][y + 1]) {
                    int adjacent = y + 1;
                    visited[x][y + 1] = true;
                    size += 1;
                    navigate(x, adjacent);
                }
            }
            if ((y - 1 >= 0)) {
                if (checkColor(x, y - 1) == colorisBlack && !visited[x][y - 1]) {
                    int adjacent = y - 1;
                    visited[x][y - 1] = true;
                    size += 1;
                    navigate(x, adjacent);
                }
            }
//        } else if (!colorisBlack) {
//            if ((x + 1) <= getCols() - 1) {
//                if (!checkColor(x + 1, y) && !visited[x + 1][y]) {
//                    int adjacent = x + 1;
//                    visited[x + 1][y] = true;
//                    size += 1;
//                    navigate(adjacent, y);
//                }
//            }
//            if ((x - 1) >= 0) {
//                if (!checkColor(x - 1, y) && !visited[x - 1][y]) {
//                    int adjacent = x - 1;
//                    visited[x - 1][y] = true;
//                    size += 1;
//                    navigate(adjacent, y);
//                }
//            }
//            if ((y + 1) <= getCols() - 1) {
//                if (!checkColor(x, y + 1) && !visited[x][y + 1]) {
//                    int adjacent = y + 1;
//                    visited[x][y + 1] = true;
//                    size += 1;
//                    navigate(x, adjacent);
//                }
//            }
//            if ((y - 1 >= 0)) {
//                if (!checkColor(x, y - 1) && !visited[x][y - 1]) {
//                    int adjacent = y - 1;
//                    visited[x][y - 1] = true;
//                    size += 1;
//                    navigate(x, adjacent);
//                }
//            }
//        }
    }
//    public boolean inBounds(int x, int y){
//
//        if ((x+1)>getCols()-1 || (x-1) < 0 || (y+1)>getRows()-1 || (y-1) < 0){
//            return false;
//        }
//        else {
//            return true;
//        }
//    }
    //check if the current pixel is true or false (black or white)
    public boolean checkColor(int x, int y){
        if (this.getPixel(x,y)){
            return true;
        }
        else {
            return false;
        }
    }
    /** checks if the image consists of a single connected component
     * that is black without any white "holes" in it or not.
     * That is, it returns true if the image consists of a single
     * black connected component and a single white connected component.
     * (One or the other might have size 0)
     */
    @Override
    public boolean isConnectedWithoutHoles() {
        Position startingPosition=find();
        System.out.println("rows: " + getRows() + " cols " + getCols());
        int sizeofData = (getRows()*getCols());
        int sizeofBlackPixels = sizeOfConnectedComponent(startingPosition);
        //All black, return true
        if (sizeofBlackPixels == sizeofData){
            return true;
        }
        else if (sizeofData-sizeOfConnectedComponent(findWhitePixel()) == sizeofBlackPixels){
            return true;
        }
        else {
            return false;
        }
    }
    /** Tries to find a "pin hole" in the connected component that
     * contains the input position p.
     *
     * If the pixel at position p is black then it tries to find a
     * white pixel that is completely surrounded by black pixels in
     * the connected component.
     * If the pixel at position p is white then it tries to find a
     * black pixel that is completely surrounded by white pixels in
     * the connected component.
     *
     * If there is more than one pixel that is a pin hole then returning any
     * is suficient.
     *
     * Returns null if it cannot find a pin hole.
     *
     * This method MUST use recursion.
     *
     * Note: If isConnectedWithoutHoles is true then findPinHole(p) should
     *       return null for all positions in the image.
     *       If there is a position p such that findPinHole(p) finds a pin hole
     *       then isConnectedWithoutHoles should be false.
     */
    @Override
    public Position findPinHole(Position p) {
        if (isConnectedWithoutHoles()){
            return null;
        }
        else {
            int x = p.getX();
            int y = p.getY();
            Position target;
            //if true, p is black and must look for white pinhole
            if (checkColor(x,y)) {
                colorisBlack = false; //use as flag to check if surroundings are white
                target=findWhitePixel();
            }
            else {
                colorisBlack = true; //use as flag to check if surroundings are black
                target=find();
            }
            return checkIfPinHole(target.getX()+1, target.getY());
        }
    }
    //starting from target position, check if right,left,up,down are opposite of the target. if not, call checkIfPinHole again with new position.
    public Position checkIfPinHole(int x, int y) {
        Position foundPinHole = null;
        int xCoord, yCoord;
        visited[x][y] = true;
        int counter = 0;
        if ((x + 1) <= getCols() - 1) {
            if (checkColor(x + 1, y) == colorisBlack) { //if same color, call checkIfPinHole
                int adjacent = x + 1;
                if (!visited[adjacent][y]) {
                    checkIfPinHole(adjacent, y);
                }
            }
            counter += 1;
        }
        if ((x - 1) >= 0) {
            if (checkColor(x - 1, y) == colorisBlack) {
                int adjacent = x - 1;
                if (!visited[adjacent][y]) {
                    checkIfPinHole(adjacent, y);
                }
            }
            counter += 1;
        }
        if ((y + 1) <= getCols() - 1) {
            if (checkColor(x, y + 1) == colorisBlack) {
                int adjacent = y + 1;
                if (!visited[x][adjacent]) {
                    checkIfPinHole(x, adjacent);
                }
            }
            counter += 1;
        }
        if ((y - 1 >= 0)) {
            if (checkColor(x, y - 1) == colorisBlack) {
                int adjacent = y - 1;
                if (!visited[x][adjacent]) {
                    checkIfPinHole(x, adjacent);
                }
            }

            counter += 1;
        }
        foundPinHole=new Position(x,y);
        return foundPinHole;
    }


    @Override
    public String toString() { return this.pixels + " " + this.pixels;}
}
