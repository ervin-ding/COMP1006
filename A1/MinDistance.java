public class MinDistance {


    public static int distance(byte target, byte[] numbers) {
        /* purpose: determine the minimal distance between any
         *          two instances of target in the numbers array
         * input  : target is the number we are looking for
         *          numbers is an array of numbers
         * output : the method returns
         *           o) the minimal distance between any two instances
         *              of target in the numbers array, if there are
         *              at least two instances of target present, or
         *           o) -2 if target is not in the numbers array, or
         *           o) -1 if target appears only once in the numbers array
         */
        int counterOfTarget = 0; //to count how many times the target appears in the array
        int positionInArray = 0; //to keep track of the position in the array
        int finalDistance = 0; //used with tempDistance and tempDistance2 to determine smallest distance
        Integer tempDistance;
        Integer tempDistance2;
        //loop to count the amount of times the target appears to create an array of that size
        for (int i = 0; i < numbers.length; i += 1) {
            if (target == numbers[i]) {
                counterOfTarget +=1;
            }
        }
        //declaring and initializing a new array (dist) with the target's positions in the given array
        int[] dist = new int[counterOfTarget];
        for (int i = 0; i < numbers.length; i += 1) {
            if (target == numbers[i])
            {
                dist[positionInArray] = i;
                positionInArray += 1;
            }

        }
        //if the number of times the target appears in the given array is more than 2, calculate the shortest distance
        if ( counterOfTarget > 2 ){
            //calculate shortest distance
            for ( int i=1; i < dist.length-1; i += 1) {
                if (i < dist.length) {
                    tempDistance = dist[i + 1] - dist[i] - 1;
                    tempDistance2 = dist[i] - dist[i - 1] - 1;
                    if (tempDistance < tempDistance2) {
                        finalDistance = tempDistance;
                    }
                    else {
                        finalDistance = tempDistance2;
                    }

                }
                else {
                    break;
                }
            }
            return finalDistance;
        }
        //if the array size is 2, grab shortest distance by subtracting the 2 and removing 1.
        if ( counterOfTarget == 2 ){
            return dist[1] - dist[0] - 1;
        }
        //returns -1 since target is only present once
        else if ( counterOfTarget == 1 ) {
            return -1;
        }
        //returns -2 since target is not present
        else {
            return -2;
        }
    }

    /*
      main method can be used for basic test cases. Modify the method to add
    more test cases. Your main method will NOT be graded. But, be sure it does
    cause your class to not compile.
    */
    public static void main(String[] args){
        byte[] N = {5 , 3 , 7 , 2 , 3 , 4 , 4 , 7 , 3 , -1 , 3 , 4 , 7 , 5};
        System.out.println( distance((byte)5, N));
        System.out.println( distance((byte)4, N));
        System.out.println( distance((byte)7, N));
        System.out.println( distance((byte)3, N));
        System.out.println( distance((byte)2, N));
        System.out.println( distance((byte)13, N));

    }
}