package com.company;

public class TestImage {

    public static void main (String [] args){
        boolean[][] data = {{false,false,false,false,false},
                            {false,true,true,false,false},
                            {false,false,false,true,false},
                            {false,true,false,false,false},
                            {false,false,false,true,false}};
        Image image = new MyImage(data);
        System.out.println(image.find());
        System.out.println(image.getPixel(2,2));
        Position p = new Position(0,0);
        System.out.println(image.isConnectedWithoutHoles());
        System.out.println(image.findPinHole(p));
    }
}
