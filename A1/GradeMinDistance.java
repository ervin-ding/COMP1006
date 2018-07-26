public class GradeMinDistance{
    private static boolean verb = true;

    static byte[] N =  {5, 3, 7, 2, 3, 4, 4, 7, 3, -1, 3, 4, 7, 5};
    static byte[] N2 = {7, 5, 9, 4, 5, 6, 6, 9, 5,  1, 5, 6, 9, 7};
    static int[] NTests =  {5,12, 4, 0, 7, 4, 3, 1, 2, -1, 13, -2};
    static int[] NTests2 = {7,12, 6, 0, 9, 4, 5, 1, 4, -1, 15, -2};

    static void print(String s){System.out.print(s);}


    static double test1(int testNum, int value){
        byte[] N = new byte[100];
        N[3] = N[3+5] = N[20] = N[20+8] = N[60] = N[70+5] = -2;
        N[96] = 8;
        int[] NTests = {18,-2, 8,-1, -2, 4};
        return testN(testNum, value, N, NTests);
    }


    static double testN(int testNum, int value, byte[] n, int[] nTests){
        double grade = 0;
        double inc = 1.0*value/(nTests.length/2.);
        print("########## Test " + testNum + "  [" + value + " marks]\n");
        if(verb){
            if( n.length < 20){
                print("  N=" + java.util.Arrays.toString(n) + "\n");
            }else{
                print("  N has more than 20 elements...\n");
            }
        }
        for(int test=0; test<nTests.length; test+=2){
            if(verb){
                print("  MinDistance.distance( (byte)"+nTests[test]);
                print(", N) = ");
            }
            try{
                int ans = MinDistance.distance((byte)nTests[test] , n);
                if(ans == nTests[test+1]){
                    grade += inc;
                    if(verb){print(ans + " correct\n");}
                }else{
                    if(verb){print(ans + " incorrect, expected " + nTests[test+1] + "\n");}
                }
            }catch(Exception e){
                print("Exception thrown... case failed\n");
            }
            //System.out.println( nTests[test] + "," + nTests[test+1] );
        }
        {print("  grade = " + grade + "/" + value + "\n" );}
        return grade;
    }


    public static void main(String[] args){
        double total = 0.0;

        total += test1(3,5);


        print("----------------------------------------------\n");
        print("----------------------------------------------\n");
        print("  grade = " + Math.round(total*100.0)/100.0 + "/50     [" + (Math.round(total/50.0*100*100)/100.0) + "%]\n");

    }

}
