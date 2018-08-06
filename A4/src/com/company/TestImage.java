package com.company;

public class TestImage {

    public static void main (String [] args){
        boolean[][] data = {{false,false,true},{false,true,true},{false,true,true}};
        Image image = new MyImage(data);
        System.out.println(image.find());
        System.out.println(image.getPixel(2,2));
        Position p = new Position(2,0);
        System.out.println(image.isConnectedWithoutHoles());
    }
}
