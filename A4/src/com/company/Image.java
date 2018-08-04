package com.company;

public abstract class Image{

    /* black pixels are true and white pixels are false */
    protected boolean[][] pixels;

    protected int rows;
    protected int cols;

    public Image(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.pixels = new boolean[rows][cols];
    }

    public Image(boolean[][] data){
        this(data.length, data[0].length);
        for(int r=0; r<this.rows; r+=1){
            for(int c=0; c<this.cols; c+=1){
                this.pixels[r][c] = data[r][c];
            }
        }
    }

    public int getRows(){ return this.rows; }
    public int getCols(){ return this.cols; }

    public boolean getPixel(int row, int col){ return this.pixels[row][col]; }
    public boolean getPixel(Position p){ return this.pixels[p.getX()][p.getY()]; }


    /* Finds some position in the image that has a black pixel
     * or returns null of there are none.
     *
     * You do not need to use recursion for this. Any position with
     * a black pixel value will be accepted.
     */
    public abstract Position find();


    /* computes the size (area/number of positions) of the
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
    public abstract int sizeOfConnectedComponent(Position p);


    /* checks if the image consists of a single connected component
     * that is black without any white "holes" in it or not.
     * That is, it returns true of the image consists of a single
     * black connected component and a single white connected component.
     * (One or the other might have size 0)
     */
    public abstract boolean isConnectedWithoutHoles();


    /* Tries to find a "pin hole" in the connected component that
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
    public abstract Position findPinHole(Position p);

}