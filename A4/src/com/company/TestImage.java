package com.company;public class TestImage{
    static Position p00 = new Position(0,0);
    static Position p11 = new Position(1,1);
    static Position p01 = new Position(0,1);
    static Position p10 = new Position(1,0);
    static Position p12 = new Position(1,2);
    static Position p21 = new Position(2,1);
    static Position p22 = new Position(2,2);
    static Position p33 = new Position(3,3);
    static Position p13 = new Position(1,3);
    static Position p31 = new Position(3,1);
    static Position p44 = new Position(4,4);
    static Position p88 = new Position(88,88);

    static Position p18 = new Position(18,18);

    static boolean X = true;
    static boolean O = false;

    static boolean[][] image3 = {{true, true, !true, !true},
            {true, !true, !true, !true},
            {!true, !true, true, true},
            {!true, !true, true, true},};

    /* --------------------------------------------------------------------------- */
    public static double test_1x1_image(int out_of){
        int num_tests = 8;
        int grade = 0;

        boolean[][] image = {{true}};
        Image i = null;
        Position p = null;
        try{
            i = new MyImage(image);
            p = i.find();
            if( p != null && p.equals(p00) ) grade += 1;
            if( i.sizeOfConnectedComponent(p00) == 1 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(p00) == null) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        image = new boolean[][]{{false}};
        try{
            i = new MyImage(image);
            p = i.find();
            if( p == null ) grade += 1;
            if( i.sizeOfConnectedComponent(p00) == 1 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(p00) == null) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        try{
            return (double)grade/(double)num_tests*(double)out_of;
        }catch(Exception e){ return 0; }

    }

    /* ---------------------------------------------------------------------- */
    /* ---------------------------------------------------------------------- */
    public static double test_2x2_image(int out_of){
        int num_tests = 33;
        int grade = 0;


        boolean[][] image = {{true, true}, {true, true}};
        Image i = null;
        Position p = null;

        try{
            i = new MyImage(image);
            p = i.find();

            if( p != null ) grade += 1;
            if( i.sizeOfConnectedComponent(p00) == 4 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(p00) == null) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        try{
            image = new boolean[][]{{false, false}, {false, false}};
            i = new MyImage(image);
            p = i.find();
            if( p == null  ) grade += 1;
            if( i.sizeOfConnectedComponent(p01) == 4 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(p00) == null) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        try{
            image = new boolean[][]{{false, false}, {false, true}};
            i = new MyImage(image);
            p = i.find();
            if( p != null && (p.equals(p11) )) grade += 1;
            if( i.sizeOfConnectedComponent(p00) == 3 ) grade += 1;
            if( i.sizeOfConnectedComponent(p11) == 1 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(p00) == null) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        try{
            image = new boolean[][]{{true, false}, {false, false}};
            i = new MyImage(image);
            p = i.find();
            if( p != null && (p.equals(p00) )) grade += 1;
            if( i.sizeOfConnectedComponent(p00) == 1 ) grade += 1;
            if( i.sizeOfConnectedComponent(p01) == 3 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(p00) == null) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        try{
            image = new boolean[][]{{!false, !false}, {!false, !true}};
            i = new MyImage(image);
            p = i.find();
            if( p != null && !(p.equals(p11) )) grade += 1;
            if( i.sizeOfConnectedComponent(p00) == 3 ) grade += 1;
            if( i.sizeOfConnectedComponent(p11) == 1 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(p00) == null) grade += 1;
        }catch(Exception e){ System.err.println(e); }


        try{
            image = new boolean[][]{{true, false}, {false, true}};
            i = new MyImage(image);
            p = i.find();
            if( p != null && (p.equals(p00) || p.equals(p11) )) grade += 1;
            if( i.sizeOfConnectedComponent(p00) == 1 ) grade += 1;
            if( i.sizeOfConnectedComponent(p01) == 1 ) grade += 1;
            if( i.isConnectedWithoutHoles() == false) grade += 1;
            if( i.findPinHole(p00) == null) grade += 1;
        }catch(Exception e){ System.err.println(e); }


        try{
            image = new boolean[][]{{true, false}, {false, true}};
            i = new MyImage(image);
            p = i.find();
            if( p != null && (p.equals(p00) || p.equals(p11) )) grade += 1;
            if( i.sizeOfConnectedComponent(p00) == 1 ) grade += 1;
            if( i.sizeOfConnectedComponent(p01) == 1 ) grade += 1;
            if( i.isConnectedWithoutHoles() == false) grade += 1;
            if( i.findPinHole(p00) == null) grade += 1;
        }catch(Exception e){ System.err.println(e); }



        try{
            return (double)grade/(double)num_tests*(double)out_of;
        }catch(Exception e){return 0;}
    }

    public static double test_3x3_image(int out_of){
        int num_tests = 0;
        int grade = 0;

        Image i = null;
        Position p = null;

        boolean[][] image = {{true, true, true},
                {true, false, true},
                {true, true, true}};

        try{
            i = new MyImage(image);
            p = i.find();
            if( p != null && !p.equals(p11)) grade += 1;
            if( i.sizeOfConnectedComponent(p00) == 8 ) grade += 1;
            if( i.sizeOfConnectedComponent(p11) == 1 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(p00).equals(p11)) grade += 1;
            if( i.findPinHole(p11) == null) grade += 1;
        }catch(Exception e){ System.err.println(e); }
        num_tests += 6;


        try{    image = new boolean[][]{{false, false, false},
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
        }catch(Exception e){ System.err.println(e); }

        num_tests += 6;

        try{
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
        }catch(Exception e){ System.err.println(e); }

        num_tests += 6;

        try{
            image = new boolean[][]{{false, false, false},
                    {false, true, true},
                    {false, true, false}};
            i = new MyImage(image);
            p = i.find();
            if( p != null && (p.equals(p11)||p.equals(p12)||p.equals(p21)) ) grade += 1;
            if( i.sizeOfConnectedComponent(p01) == 5 ) grade += 1;
            if( i.sizeOfConnectedComponent(p11) == 3 ) grade += 1;
            if( i.isConnectedWithoutHoles() == false) grade += 1;
            if( i.findPinHole(p00) == null) grade += 1;
            if( i.findPinHole(p11) == null) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        num_tests += 6;

        return (double)grade/(double)num_tests*(double)out_of;
    }


    public static double test_4x4_image(int out_of){
        int num_tests = 0;
        int grade = 0;

        boolean[][] image = {{true, true, true, true},
                {true, true, true, true},
                {true, true, false, true},
                {true, true, true, true}};


        Image i = null;
        Position p = null;

        try{
            i = new MyImage(image);
            p = i.find();
            if( p != null && !p.equals(p22)) grade += 1;
            if( i.sizeOfConnectedComponent(p00) == 15 ) grade += 1;
            if( i.sizeOfConnectedComponent(p22) == 1 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(p01).equals(p22)) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        num_tests += 5;

        try{    image = new boolean[][]{{true, true, true, true},
                {true, false, false, true},
                {true, false, true, true},
                {true, true, true, true}};

            i = new MyImage(image);
            p = i.find();
            if( p != null && !p.equals(p21) && !p.equals(p11) && !p.equals(p12)) grade += 1;
            if( i.sizeOfConnectedComponent(p00) == 13 ) grade += 1;
            if( i.sizeOfConnectedComponent(p12) == 3 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(p01) == null ) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        num_tests += 5;

        try{
            image = new boolean[][]{{true, true, true, true},
                    {true, false, false, true},
                    {true, false, true, true},
                    {true, true, true, false}};

            i = new MyImage(image);
            p = i.find();
            if( p != null && !p.equals(p21) && !p.equals(p11)
                    && !p.equals(p12) && !p.equals(p33)) grade += 1;
            if( i.sizeOfConnectedComponent(p00) == 12 ) grade += 1;
            if( i.sizeOfConnectedComponent(p12) == 3 ) grade += 1;
            if( i.isConnectedWithoutHoles() == false) grade += 1;
            if( i.findPinHole(p01) == null ) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        num_tests += 5;


        try{
            image = new boolean[][]{{true, true, true, true},
                    {true, false, true, true},
                    {true, true, true, true},
                    {true, true, true, false}};

            i = new MyImage(image);
            p = i.find();
            if( p != null && !p.equals(p11) && !p.equals(p33)) grade += 1;
            if( i.sizeOfConnectedComponent(p00) == 14 ) grade += 1;
            if( i.sizeOfConnectedComponent(p11) == 1 ) grade += 1;
            if( i.isConnectedWithoutHoles() == false) grade += 1;
            if( i.findPinHole(p22).equals(p11) ) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        num_tests += 5;
        return (double)grade/(double)num_tests*(double)out_of;
    }

    /* ------------------------------------------------------------------------------- */
    /* ------------------------------------------------------------------------------- */
    /* ------------------------------------------------------------------------------- */
    /* ------------------------------------------------------------------------------- */
    /* ------------------------------------------------------------------------------- */
    public static double test_5x5_image(int out_of){
        int num_tests = 0;
        int grade = 0;
        Image i = null;
        Position p = null;
        boolean[][] image = new boolean[5][5];

        try{
            i = new MyImage(image);
            p = i.find();
            if( p == null ) grade += 1;
            if( i.sizeOfConnectedComponent(p33) == 25 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(new Position(4,2)) == null ) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        num_tests += 4;

        try{
            image = new boolean[][]{{true, true, true, true, true},
                    {true, true, true, true, true},
                    {true, true, true, true, true},
                    {true, true, true, true, true},
                    {true, true, true, true, false}};

            i = new MyImage(image);
            p = i.find();
            if( p != null && !p.equals(p44) ) grade += 1;
            if( i.sizeOfConnectedComponent(new Position(4,2)) == 24 ) grade += 1;
            if( i.sizeOfConnectedComponent(p44) == 1 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(new Position(3,0)) == null ) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        num_tests += 5;

        try{
            image = new boolean[][]{{true, true, true, true, true},
                    {true, true, true, true, true},
                    {true, true, true, true, true},
                    {true, true, true, false, true},
                    {true, true, true, true, true}};

            i = new MyImage(image);
            p = i.find();
            if( p != null && !p.equals(p33) ) grade += 1;
            if( i.sizeOfConnectedComponent(new Position(4,2)) == 24 ) grade += 1;
            if( i.sizeOfConnectedComponent(p33) == 1 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(new Position(3,0)).equals(p33) ) grade += 1;
        }catch(Exception e){ System.err.println(e); }

        num_tests += 5;

        try{
            image = new boolean[][]{{O,O,O,O,O},
                    {O,X,O,X,O},
                    {O,O,X,O,O},
                    {O,X,O,X,O},
                    {O,O,O,O,O}};

            i = new MyImage(image);  // find an X (true)
            p = i.find();
            if( p != null && (p.equals(p33)||p.equals(p11)||p.equals(p22)||p.equals(p13)||p.equals(p31))  ) grade += 1;
            if( i.sizeOfConnectedComponent(p11) == 1 ) grade += 1;
            if( i.sizeOfConnectedComponent(new Position(4,4)) == 20 ) grade += 1;
            if( i.isConnectedWithoutHoles() == false) grade += 1;
            Position pin = i.findPinHole(new Position(1,3));
            if( p != null && (p.equals(p33)||p.equals(p11)||p.equals(p22)||p.equals(p13)||p.equals(p31)) ) grade += 6;
        }catch(Exception e){ System.err.println(e); }

        num_tests += 10;


        return (double)grade/(double)num_tests*(double)out_of;
    }

    /* ------------------------------------------------------------------------------- */
    public static double test_6x6_image(int out_of){
        int num_tests = 0;
        int grade = 0;
        Image i = null;
        Position p = null;
        boolean[][] image = new boolean[6][6];

        try{
            image[4][4] = true;
            i = new MyImage(image);
            p = i.find();
            if( p != null && p.equals(p44) ) grade += 1;
            if( i.sizeOfConnectedComponent(p33) == 35 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(new Position(4,2)).equals(p44) ) grade += 1;
        }catch(Exception e){ System.err.println(e); }
        print(grade);
        num_tests += 4;

        try{
            image = new boolean[][]{
                    {X,X,X,X,X,X},
                    {X,X,X,X,X,X},
                    {X,X,O,O,X,X},
                    {X,X,O,O,X,X},
                    {X,X,X,X,X,X},
                    {X,X,X,X,X,X}};

            i = new MyImage(image);  // find an X (true)
            p = i.find();
            if( i.sizeOfConnectedComponent(p11) == 32 ) grade += 1;
            if( i.sizeOfConnectedComponent(p33) == 4 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            Position pin = i.findPinHole(new Position(1,3));
            if( pin == null)  grade += 1;
        }catch(Exception e){ System.err.println(e); }
        print(grade);

        num_tests += 4;

        try{
            image = new boolean[][]{
                    {O,O,O,O,O,O},
                    {O,X,X,X,X,O},
                    {O,X,O,O,X,O},
                    {O,X,O,O,X,O},
                    {O,X,X,X,X,O},
                    {O,O,O,O,O,O}};

            i = new MyImage(image);  // find an X (true)
            p = i.find();
            if( i.sizeOfConnectedComponent(p11) == 12 ) grade += 1;
            if( i.sizeOfConnectedComponent(p33) == 4 ) grade += 1;
            if( i.isConnectedWithoutHoles() == false) grade += 1;
            Position pin = i.findPinHole(new Position(1,3));
            if( pin == null)  grade += 1;
        }catch(Exception e){ System.err.println(e); }
        print(grade);

        num_tests += 4;


        try{
            image = new boolean[][]{
                    {O,O,O,O,O,O},
                    {O,X,X,X,X,O},
                    {O,X,X,X,X,O},
                    {O,X,X,X,X,O},
                    {O,X,X,X,X,O},
                    {O,O,O,O,O,O}};

            i = new MyImage(image);  // find an X (true)
            p = i.find();
            if( i.sizeOfConnectedComponent(p11) == 16 ) grade += 1;
            if( i.sizeOfConnectedComponent(new Position(5,0)) == 20 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
        }catch(Exception e){ System.err.println(e); }
        print(grade);

        num_tests += 3;


        return (double)grade/(double)num_tests*(double)out_of;
    }



    /* ------------------------------------------------------------------------------- */
    public static double test_7x7_image(int out_of){
        int num_tests = 0;
        int grade = 0;
        Image i = null;
        Position p = null;
        boolean[][] image = new boolean[7][7];


        try{
            image = new boolean[][]{
                    {X,X,X,X,X,X,X},
                    {X,X,X,X,X,X,X},
                    {X,X,X,X,X,X,X},
                    {X,X,X,O,X,X,X},
                    {X,X,X,X,X,X,X},
                    {X,X,X,X,X,X,X},
                    {X,X,X,X,X,X,X}};

            i = new MyImage(image);  // find an X (true)
            p = i.find();
            if( p != null && !p.equals(p33)) grade += 1;
            if( i.sizeOfConnectedComponent(p11) == 48 ) grade += 1;
            if( i.sizeOfConnectedComponent(p33) == 1 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            Position pin = i.findPinHole(new Position(1,3));
            if( pin != null && pin.equals(p33))  grade += 1;
        }catch(Exception e){ System.err.println(e); }

        num_tests += 5;


        return (double)grade/(double)num_tests*(double)out_of;
    }


    public static double test_NxN_image(int out_of){
        int num_tests = 0;
        int grade = 0;


        boolean[][] image = new boolean[20][20];
        image[18][18] = true;

        Image i = null;
        Position p = null;

        try{
            i = new MyImage(image);
            p = i.find();
            if( p.equals(p18) ) grade += 1;
            if( i.sizeOfConnectedComponent(new Position(12,16)) == (20*20-1) ) grade += 1;
            if( i.sizeOfConnectedComponent(p18) == 1 ) grade += 1;
            if( i.isConnectedWithoutHoles() == true) grade += 1;
            if( i.findPinHole(new Position(16,4)).equals(p18)) grade += 1;
            if( i.findPinHole(p18) == null) grade += 1;
        }catch(Exception e){ System.err.println(e); }
        num_tests += 6;


        return (double)grade/(double)num_tests*(double)out_of;
    }

    public static double test_BIGxBIG_image(int out_of){
        int num_tests = 0;
        int grade = 0;


        boolean[][] image = new boolean[10000][10000];
        image[9876][9876] = true;

        Image i = new MyImage(image);
        try{
            i.sizeOfConnectedComponent(new Position(12,16)) ;
        }catch(java.lang.StackOverflowError e){
            grade  += 1;
        }catch(Exception e){System.err.println(e); }
        num_tests += 1;


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

    static void print(double in){
//System.out.println("grade=" + in);
    }

    public static void main(String[] args){
        double t1,t2,t3,t4,t5,t6,t7,tn,tbig;

        System.out.println("testing 1x1 images    (1 mark)  : " + (t1=test_1x1_image(100)) + "%");
        System.out.println("testing 2x2 images    (1 mark)  : " + (t2=test_2x2_image(100)) + "%");
        System.out.println("testing 3x3 images    (1 mark)  : " + (t3=test_3x3_image(100)) + "%");
        System.out.println("testing 4x4 images    (1 mark)  : " + (t4=test_4x4_image(100)) + "%");
        System.out.println("testing 5x5 images    (1 mark)  : " + (t5=test_5x5_image(100)) + "%");
        System.out.println("testing 6x6 images    (1 mark)  : " + (t6=test_6x6_image(100)) + "%");
        System.out.println("testing 7x7 images    (1 mark)  : " + (t7=test_7x7_image(100)) + "%");
        System.out.println("testing NxN images    (1 mark)  : " + (tn=test_NxN_image(100)) + "%");
        System.out.println("testing for recursion (2 marks) : " + (tbig=test_BIGxBIG_image(100)) + "%");
        System.out.println("            total grade is " +  (t1+t2+t3+t4+t5+t6+t7+tn+tbig*2)/10.0  + "/100");
    }





}





