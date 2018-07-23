package com.company;

public class MaxTemp{

    /** t1 and t2 are considered close enough if Math.abs(t1-t2) < EPSILON */
    public static final double EPSILON = 0.01;
    double maxTemp = 0;
    double maxTempCount = 0;
    /* add attributes as you need */


    /* ----------------------------------------------------
     * constructor
     * ----------------------------------------------------
     */

    public MaxTemp(Temperature[] temperatures){
        double[] arrayofTemps = new double [temperatures.length];
        double max = arrayofTemps[0];//assign max to the first value of the array
        double countofMax=0; // assign countofMax to 0
        //loop through the temperature array, set scale to Kelvin, get the temperature and save it in an array
        for (int i = 0; i<temperatures.length; i+=1) {
            temperatures[i].setScale("K");
            arrayofTemps[i] = temperatures[i].getTemp();
        }
        //loop through the array of temperature values and find the maximum value.
        for (int i = 1; i<arrayofTemps.length; i+=1) {
            if (arrayofTemps[i] > max) {
                max = arrayofTemps[i];
            }
        }
        //loop through the array of temperature values again and increment countofMax everytime the difference is an EPSILON or less
        for (int i = 0; i<arrayofTemps.length; i+=1) {
            if ((float)(Math.abs(arrayofTemps[i] - max)) <= EPSILON) {
                countofMax+=1;
            }
        }
        maxTemp = max;
        maxTempCount = countofMax;
    }


    /* ----------------------------------------------------
     * getter
     * ----------------------------------------------------
     */

    public double[] getMax(){


        // - returns an array of length 2 [max, count]
        //   where max is the maximum temperature (expressed in the Kelvin scale)
        //   of all Temperature objects passed to the constructor, and count
        //   is the number of times that temperature was present (in the input
        //   array of the constructor)
        //   If there are no temperatures then return the array [0.0, 0.0]


        return new double[]{maxTemp,maxTempCount};
    }


    /* OPTIONAL - use your main method to test your code */
    public static void main(String[] args){
        // testing code here is optional
        Temperature temperature = new Temperature(155, "C");
        System.out.println(temperature.toString());
        temperature.setScale("F");
        temperature.getTemp();
        System.out.println(temperature.toString() + " C TO F");
        temperature.setScale("C");
        temperature.getTemp();
        System.out.println(temperature.toString() + " F TO C");
        temperature.setScale("K");
        temperature.getTemp();
        System.out.println(temperature.toString() + " C TO K");
        temperature.setScale("F");
        temperature.getTemp();
        System.out.println(temperature.toString() + " K TO F");
        temperature = new Temperature(1);
        temperature.getTemp();
        System.out.println(temperature.toString() + " 1C");
        temperature.setScale("K");
        temperature.getTemp();
        System.out.println(temperature.toString() + " C TO K");
        temperature.setScale("C");
        temperature.getTemp();
        System.out.println(temperature.toString() + " K TO C");
        temperature.setTemp(-472,"F");
        System.out.println(temperature.toString() + " set temp with Char");
        temperature.setScale("C");
        System.out.println(temperature.toString() + " F TO C");
        temperature.setScale("Kelvin");
        System.out.println(temperature.toString() + " C TO K");
        temperature.setTemp(300,"Fahrenheit");
        System.out.println(temperature.toString() + " set temp with String");
        temperature.setScale("C");
        System.out.println(temperature.toString() + " F TO C");
        temperature.setScale("Kelvin");
        System.out.println(temperature.toString() + " C TO K");
        temperature.setTemp(123);
        System.out.println(temperature.toString() + " set temp 123 should be K");
        temperature.setScale("C");
        System.out.println(temperature.toString() + " K TO C");
        temperature.setScale("Kelvin");
        System.out.println(temperature.toString() + " C TO K");
        temperature.setScale("F");
        System.out.println(temperature.toString() + " K TO F");
        temperature.setScale("K");
        System.out.println(temperature.toString() + " F TO K");
        temperature.setTemp(-1, "K");
        System.out.println(temperature.toString() + " set temp -1 should be 0K");
        temperature.setScale("K");
        System.out.println(temperature.toString() + " K TO K");
        temperature.setScale("C");
        System.out.println(temperature.toString() + " K TO C");
        temperature.setTemp(500,"F");
        System.out.println(temperature.toString() + " SET TEMP TO 500F");
        temperature.setScale("C");
        System.out.println(temperature.toString() + " F TO C");
        temperature.setScale("Fahrenheit");
        System.out.println(temperature.toString() + " C TO F");
        temperature.setScale("Celsius");
        System.out.println(temperature.toString() + " F TO C");
        Temperature[] testarray = {
                new Temperature(1001.12, "K"),
                new Temperature(-200.0, "K"),
                new Temperature(4234, "K"),
                new Temperature(1, "C"),
                new Temperature(-4234, "F"),
                new Temperature(4234, "F"),
                new Temperature(4234, "K"),
                new Temperature(4231, "K"),
                new Temperature(12, "K"),
                new Temperature(4234.01, "K"),
                new Temperature(-200.0, "K"),
                new Temperature(1001.11, "K")
        };
        MaxTemp arrayof2 = new MaxTemp(testarray);
        System.out.println((testarray[5].getTemp()));
        System.out.println("Max temp is " + arrayof2.getMax()[0] + "K and is there " + arrayof2.getMax()[1] + " times");
    }
}