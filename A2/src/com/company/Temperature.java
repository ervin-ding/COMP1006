package com.company;

/**
 * A Temperature object represents temperature (with a value and scale)
 *
 * COMP 1006/1406
 * Summer 2018
 * Assignment 2
 */

public class Temperature{

    /** different scale names */
    public static String[] scales = {"Celsius", "Fahrenheit", "Kelvin"};
    public double selectedTemperature = 0;
    public char selectedScale = 'C';

    /** Initializes a temperature object with given value in Celcius
     *
     *  If the initial temperature is less than -273.15 then the temperature
     *  object will be initialized with -273.15C.
     *
     * @param temp is the initial temperature in Celsius.
     */
    //constructor chaining
    public Temperature(double temp){
        this(temp,"C" );
    }


    /** Initializes a temperature object with given value using the specified scale
     * <par>
     * If the temperature is lower than absolute zero, then set the temperature to
     * absolute zero (in whichever scale is specified).
     * <par>
     * Examples: new Temperature(12.3, "K")
     *           new Temperature(-90.2, "Celsius")
     *
     * @param temp is the initial temperature
     * @param scale is the scale of initial temperature and must either be
     *        one of the Strings in the <code>scales</code> array, or
     *        the first letter (capitalized) of one of those strings.
     */

    public Temperature(double temp, String scale) {
        selectedScale = toChar(scale);
        selectedTemperature = convertTemp(temp);
    }

    //takes in temp input and converts it to the proper value based on the scale. Checks if the temp is lower than abs zero.
    public double convertTemp(double temp) {
        double convertedTemp=selectedTemperature;
        if (temp <= 0 && selectedScale == 'K') {
            convertedTemp = 0;
        }
        else if (selectedScale == 'C' && temp < -273.15) {
            convertedTemp = -(273.15);
        }
        else if (selectedScale == 'F' && temp < -459.67) {
            convertedTemp = -(459.67);
        }
        else {
            convertedTemp = temp;
        }
        return convertedTemp;
    }

    //Converts scale input (string) to a single char.
    public char toChar(String scale){
        char[] charArrayOfScale = {'C','F','K'};
        char matchingScale = 'C';
        for (int i = 0; i<charArrayOfScale.length; i+=1){
            if (scale.length() > 1) {
                if (scale == scales[i]) {
                    matchingScale = charArrayOfScale[i];
                    break;
                }
            }
            else if (scale.length() == 1) {
                char scaleAsChar = scale.charAt(0);
                if (scaleAsChar == charArrayOfScale[i]) {
                    matchingScale = charArrayOfScale[i];
                    break;
                }
            }
        }
        return matchingScale;
    }
    /** getter for the scale
     *
     * The output of this getter method must always be the first letter of one
     * of the strings in the <code>scales</code> array, capitalized.
     *
     * @return the current scale of the object as a single char (the first letter,
     *         capitalized of one of the strings from <code>scales</code>)
     */
    public char getScale(){
        return this.selectedScale;
    }

    /** getter for the temperature
     *
     * @return the temperature of the object using the current scale
     */
    public double getTemp(){
        return this.selectedTemperature;
    }


    /** setter for scale
     *
     *
     *
     * @param scale is the new scale of the temperature and must either be
     *        one of the Strings in the <code>scales</code> array, or
     *        the first letter (capitalized) of one of those strings.
     */
    public void setScale(String scale){
        char previousScale=selectedScale;
        double previousTemp=selectedTemperature;
        char newScale=toChar(scale);
        // Changes scale and converts the previous temperature to the new one based on the new scale.
        if (newScale == 'K' && previousScale == 'C'){
            this.selectedTemperature = previousTemp + 273.15;
        }
        else if (newScale == 'C' && previousScale == 'K'){
            this.selectedTemperature = (previousTemp - 273.15);
        }
        else if (newScale == 'K' && previousScale == 'F'){
            this.selectedTemperature = (((previousTemp + 459.67)*5)/9);
        }
        else if (newScale == 'F' && previousScale == 'K'){
            this.selectedTemperature = (((previousTemp*9)/5) - 459.67);
        }
        else if (newScale == 'F' && previousScale == 'C'){
            this.selectedTemperature = (((previousTemp*9)/5) + 32);
        }
        else if (newScale == 'C' && previousScale == 'F'){
            this.selectedTemperature = (((previousTemp - 32)*5)/9);
        }
        this.selectedScale = newScale;
    }


    /** setter for temperature
     *
     * @param temp is the new temperature (in the objects current scale)
     */
    public void setTemp(double temp){
        this.selectedTemperature = convertTemp(temp); //pass it through converTemp to make sure it doesn't go below abs zero
    }

    /** setter for temperature
     *
     *
     * @param temp is the new temperature
     * @param scale is the scale of the new temperature. It must be
     *        the first letter (capitalized) of one of the strings in
     *        the <code>scales</code> array.
     */
    // converts temp to new scale. pass scale to toChar to make sure that we compare chars and return a char
    public void setTemp(double temp, char scale){
        String stringScale = Character.toString(scale);
        char charScale = scale;
        for (int i = 0; i<scales.length; i+=1)
        {
            if ( scale == toChar(stringScale)) {
                charScale = toChar(stringScale);
                break;
            }
        }
        this.selectedScale=charScale;
        this.selectedTemperature = convertTemp(temp);
    }

    /** setter for temperature
     *
     * @param temp is the new temperature
     * @param scale is the scale of the new temperature. It must be one
     *        of the strings in the <code>scales</code> array, or the first letter
     *        (capitalized) of one of those strings.
     */
    // converts temp to new scale. pass scale to toChar to make sure that we return a char
    public void setTemp(double temp, String scale) {
        this.selectedScale=toChar(scale);
        this.selectedTemperature = convertTemp(temp);
    }



    /* ------------------------------------------------- */
    /* ------------------------------------------------- */
    /* do not change anything below this                 */
    /* ------------------------------------------------- */
    /* ------------------------------------------------- */



    /** String representation of a temperature object    */
    @Override
    public String toString(){
        return "" + this.getTemp() + this.getScale();
    }

}