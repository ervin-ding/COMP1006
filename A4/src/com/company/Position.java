package com.company;


public class Position{
    protected int x;
    protected int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){ return this.x; }
    public int getY(){ return this.y; }

    @Override
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
}