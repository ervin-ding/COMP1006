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
    public boolean equals(Object other){
        if( !(other instanceof Position) ){ return false; }
        Position that = (Position)other;
        return this.x==that.x && this.y==that.y;
    }

    @Override
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
}