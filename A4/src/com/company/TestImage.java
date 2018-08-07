package com.company;

public class TestImage{
    static boolean[][] image1 = {{true, true, true},
            {true, false, true},
            {true, true, true}};

    static boolean[][] image2 = {{false, false},
            {false, true}};

    static boolean[][] image3 = {{true, true, !true, false},
            {true, !true, !true, !true},
            {!true, !true, true, true},
            {false, !true, true, true},};



    static void print(boolean[][] image){
        System.out.print("+");
        for(int i=0; i<image[0].length; i+=1){
            System.out.print("-");
        }
        System.out.println("+");
        for(int r=0; r<image.length; r+=1){
            System.out.print("|");
            for(int c=0; c<image[0].length; c+=1){
                System.out.print(image[r][c] == true ? "#" : " ");
            }
            System.out.println("|");
        }
        System.out.print("+");
        for(int i=0; i<image[0].length; i+=1){
            System.out.print("-");
        }
        System.out.println("+");

    }


    public static void main(String[] args){
        System.out.println("Test image1\n-----------");
        print(image1);
        Image i1 = new MyImage(image1);
        Position s1 = i1.find();
        System.out.println("find() expected output is any position that is not 1,1 "); // NOT instead of now
        System.out.println("       actual output is " + s1);

        System.out.println( "size(0,0) expected output is 8");
        System.out.println( "          actual output is " + i1.sizeOfConnectedComponent(s1) );
        System.out.println( "size(1,1) expected output is 1");
        System.out.println( "          actual output is " + i1.sizeOfConnectedComponent(new Position(1,1)) );

        System.out.println( "isConnectedWithoutHoles() expected output is true");
        System.out.println( "                          actual output is " + i1.isConnectedWithoutHoles() );

        System.out.println( "findPinHole(0,0) expected output is 1,1");
        System.out.println( "                 actual outout is " + i1.findPinHole(s1) );
        System.out.println( "findPinHole(1,1) expected output is null");
        System.out.println( "                 actual outout is " + i1.findPinHole(new Position(1,1)) );



        System.out.println("Test image2\n-----------");
        print(image2);
        Image i2 = new MyImage(image2);
        Position s2 = i2.find();
        System.out.println("find() expected output is position 1,1 "); // looks for lone black pixel
        System.out.println("       actual output is " + s2);

        System.out.println( "size(0,0) expected output is 3");
        System.out.println( "          actual output is " + i2.sizeOfConnectedComponent(s1) );
        System.out.println( "size(1,1) expected output is 1");
        System.out.println( "          actual output is " + i2.sizeOfConnectedComponent(new Position(1,1)) );

        System.out.println( "isConnectedWithoutHoles() expected output is true");
        System.out.println( "                          actual output is " + i2.isConnectedWithoutHoles() );

        System.out.println( "findPinHole(0,0) expected output is null");
        System.out.println( "                 actual outout is " + i2.findPinHole(s1) );
        System.out.println( "findPinHole(1,1) expected output is null");
        System.out.println( "                 actual outout is " + i2.findPinHole(new Position(1,1)) );


        System.out.println("Test image3\n-----------");
        print(image3);
        Image i3 = new MyImage(image3);
        Position s3 = i3.find();
        System.out.println("find() expected output is any black position 0,0 0,1 1,0 2,2 2,3 3,2 3,3");
        System.out.println("       actual output is " + s3);

        System.out.println( "size(0,0) expected output is 3");
        System.out.println( "          actual output is " + i3.sizeOfConnectedComponent(s1) );
        System.out.println( "size(1,1) expected output is 9");
        System.out.println( "          actual output is " + i3.sizeOfConnectedComponent(new Position(1,1)) );
        System.out.println( "size(3,2) expected output is 4");
        System.out.println( "          actual output is " + i3.sizeOfConnectedComponent(new Position(3,2)) );

        System.out.println( "isConnectedWithoutHoles() expected output is false");
        System.out.println( "                          actual output is " + i3.isConnectedWithoutHoles() );

        System.out.println( "findPinHole(0,0) expected output is null");
        System.out.println( "                 actual outout is " + i3.findPinHole(s1) );
        System.out.println( "findPinHole(2,2) expected output is null");
        System.out.println( "                 actual outout is " + i3.findPinHole(new Position(2,2)) );

    }
}

