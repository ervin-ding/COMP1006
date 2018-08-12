package com.company;
public class TestImage{
    static Position p00 = new Position(0,0);
    static Position p11 = new Position(1,1);
    static Position p01 = new Position(0,1);
    static Position p10 = new Position(1,0);
    static Position p12 = new Position(1,2);
    static Position p21 = new Position(2,1);
    static Position p22 = new Position(2,2);
    static Position p33 = new Position(3,3);



    static boolean[][] image3 = {{true, true, !true, !true},
                                {true, !true, !true, !true},
                                {!true, !true, true, true},
                                {!true, !true, true, true},};

    public static double test_1x1_image(int out_of){
        int num_tests = 8;
        int grade = 0;

        boolean[][] image = {{true}};
        Image i = new MyImage(image);
        Position p = i.find();
        if( p != null && p.equals(p00) ) grade += 1;
        if( i.sizeOfConnectedComponent(p00) == 1 ) grade += 1;
        if( i.isConnectedWithoutHoles() == true) grade += 1;
        if( i.findPinHole(p00) == null) grade += 1;

        image = new boolean[][]{{false}};
        i = new MyImage(image);
        p = i.find();
        if( p == null ) grade += 1;
        if( i.sizeOfConnectedComponent(p00) == 1 ) grade += 1;
        if( i.isConnectedWithoutHoles() == true) grade += 1;
        if( i.findPinHole(p00) == null) grade += 1;

        System.out.println((double)grade/(double)num_tests*(double)out_of);
        return (double)grade/(double)num_tests*(double)out_of;

    }

    public static double test_2x2_image(int out_of){
        int num_tests = 33;
        int grade = 0;

        boolean[][] image = {{true, true}, {true, true}};
        Image i = new MyImage(image);
        Position p = i.find();
        if( p != null ) grade += 1;
        if( i.sizeOfConnectedComponent(p00) == 4 ) grade += 1;
        if( i.isConnectedWithoutHoles() == true) grade += 1;
        if( i.findPinHole(p00) == null) grade += 1;

        image = new boolean[][]{{false, false}, {false, false}};
        i = new MyImage(image);
        p = i.find();
        if( p == null  ) grade += 1;
        if( i.sizeOfConnectedComponent(p01) == 4 ) grade += 1;
        if( i.isConnectedWithoutHoles() == true) grade += 1;
        if( i.findPinHole(p00) == null) grade += 1;

        image = new boolean[][]{{false, false}, {false, true}};
        i = new MyImage(image);
        p = i.find();
        if( p != null && (p.equals(p11) )) grade += 1;
        if( i.sizeOfConnectedComponent(p00) == 3 ) grade += 1;
        if( i.sizeOfConnectedComponent(p11) == 1 ) grade += 1;
        if( i.isConnectedWithoutHoles() == true) grade += 1;
        if( i.findPinHole(p00) == null) grade += 1;

        image = new boolean[][]{{true, false}, {false, false}};
        i = new MyImage(image);
        p = i.find();
        if( p != null && (p.equals(p00) )) grade += 1;
        if( i.sizeOfConnectedComponent(p00) == 1 ) grade += 1;
        if( i.sizeOfConnectedComponent(p01) == 3 ) grade += 1;
        if( i.isConnectedWithoutHoles() == true) grade += 1;
        if( i.findPinHole(p00) == null) grade += 1;


        image = new boolean[][]{{!false, !false}, {!false, !true}};
        i = new MyImage(image);
        p = i.find();
        if( p != null && !(p.equals(p11) )) grade += 1;
        if( i.sizeOfConnectedComponent(p00) == 3 ) grade += 1;
        if( i.sizeOfConnectedComponent(p11) == 1 ) grade += 1;
        if( i.isConnectedWithoutHoles() == true) grade += 1;
        if( i.findPinHole(p00) == null) grade += 1;


        image = new boolean[][]{{true, false}, {false, true}};
        i = new MyImage(image);
        p = i.find();
        if( p != null && (p.equals(p00) || p.equals(p11) )) grade += 1;
        if( i.sizeOfConnectedComponent(p00) == 1 ) grade += 1;
        if( i.sizeOfConnectedComponent(p01) == 1 ) grade += 1;
        if( i.isConnectedWithoutHoles() == false) grade += 1;
        if( i.findPinHole(p00) == null) grade += 1;


        image = new boolean[][]{{true, false}, {false, true}};
        i = new MyImage(image);
        p = i.find();
        if( p != null && (p.equals(p00) || p.equals(p11) )) grade += 1;
        if( i.sizeOfConnectedComponent(p00) == 1 ) grade += 1;
        if( i.sizeOfConnectedComponent(p01) == 1 ) grade += 1;
        if( i.isConnectedWithoutHoles() == false) grade += 1;
        if( i.findPinHole(p00) == null) grade += 1;

        System.out.println((double)grade/(double)num_tests*(double)out_of);
        return (double)grade/(double)num_tests*(double)out_of;

    }

    public static double test_3x3_image(int out_of){
        int num_tests = 0;
        int grade = 0;

        boolean[][] image = {{true, true, true},
                {true, false, true},
                {true, true, true}};

        Image i = new MyImage(image);
        Position p = i.find();
        if( p != null && !p.equals(p11)) grade += 1;
        if( i.sizeOfConnectedComponent(p00) == 8 ) grade += 1;
        if( i.sizeOfConnectedComponent(p11) == 1 ) grade += 1;
        if( i.isConnectedWithoutHoles() == true) grade += 1;
        if( i.findPinHole(p00).equals(p11)) grade += 1;
        if( i.findPinHole(p11) == null) grade += 1;

        num_tests += 6;


        image = new boolean[][]{{false, false, false},
                {false, true, false},
                {false, false, false}};
        i = new MyImage(image);
        p = i.find();
        if( p != null && p.equals(p11) ) grade += 1;
        if( i.sizeOfConnectedComponent(p01) == 8 ) grade += 1;
        if( i.sizeOfConnectedComponent(p11) == 1 ) grade += 1;
        if( i.isConnectedWithoutHoles() == true) grade += 1;
        if( i.findPinHole(p00).equals(p11)) grade += 1;
        if( i.findPinHole(p11) == null) grade += 1;

        num_tests += 6;

        image = new boolean[][]{{false, true, false},
                {true, false, true},
                {false, true, false}};
        i = new MyImage(image);
        p = i.find();
        if( p != null && (p.equals(p12)||p.equals(p21)||p.equals(p01)||p.equals(p10)) ) grade += 1;
        if( i.sizeOfConnectedComponent(p01) == 1 ) grade += 1;
        if( i.sizeOfConnectedComponent(p11) == 1 ) grade += 1;
        if( i.isConnectedWithoutHoles() == false) grade += 1;
        if( i.findPinHole(p00) == null) grade += 1;
        if( i.findPinHole(p11) == null) grade += 1;

        num_tests += 6;


        image = new boolean[][]{{false, false, false},
                {false, true, true},
                {false, true, false}};
        i = new MyImage(image);
        p = i.find();
        if( p != null && (p.equals(p11)||p.equals(p12)||p.equals(p21)) ) grade += 1;
        if( i.sizeOfConnectedComponent(p01) == 5 ) grade -= 1;
        if( i.sizeOfConnectedComponent(p11) == 3 ) grade -= 1;
        if( i.isConnectedWithoutHoles() == false) grade -= 1;
        if( i.findPinHole(p00) == null) grade += 1;
        if( i.findPinHole(p11) == null) grade += 1;

        num_tests += 6;

        return (double)grade/(double)num_tests*(double)out_of;

    }
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
        System.out.println("testing 1x1 images : " + test_1x1_image(100) + "%");
        System.out.println("testing 2x2 images : " + test_2x2_image(100) + "%");
        System.out.println("testing 3x3 images : " + test_3x3_image(100) + "%");
    }





}

