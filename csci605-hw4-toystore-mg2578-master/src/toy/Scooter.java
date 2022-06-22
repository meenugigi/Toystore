/*
Homework 4 : Toy Store
File Name : Scooter.java
 */
package toy;
/**
 * The Scooter class, which extends Toy abstract class and implements IToy
 * interface.
 *
 * @author Meenu Gigi, mg2578@rit.edu
 * @author Vedika Vishwanath Painjane, vp2312@rit.edu
 */
public class Scooter extends Toy implements IToy{

    /** stores initial value of product code. */
    private static int scooterProductCode = 9000000;

    /** stores color of Scooter. */
    private final String scooterColor;

    /** stores number of wheels for a Scooter. */
    private final int scooterNumWheels;

    /** stores odometer reading for a Scooter. */
    private int scooterOdometer;

    /**
     *Initialize the scooter
     * @param scooterName Name
     * @param scooterMSRP MSRP between 39.99 and 160.99.
     * @param scooterColor Color of the scooter
     * @param scooterNumWheels Number of wheels, 2 or 3
     */
    Scooter(String scooterName, double scooterMSRP,
                      String scooterColor, int scooterNumWheels) {
//        calls parent class constructor.
        super(scooterName, scooterMSRP);
        this.scooterColor = scooterColor;
        this.scooterNumWheels = scooterNumWheels;
//        assigns product code when a new Scooter is created.
        productCode = scooterProductCode;
        scooterProductCode++;
    }

    /**
     * Called whenever the toy is played with. This will have the affect of
     * degrading the toy's condition.
     */
    @Override
    public void play() {
//        adds 2 miles to odometer reading whenever Scooter is played with.
        getOdometerReading();
//        modifies degradation level whenever Scooter is played with.
        if((getDegradationLevel() + 5) < 100){
            degradeLevel += 5;
        }
        else if((getDegradationLevel() + 5) >= 100){
            degradeLevel = 100;
            condition = Condition.BROKEN;
        }
//        calls parent class play().
        super.play();
    }

    /**
     * Prints the information of the toy.
     * @return String containing the information of the toy
     */
    @Override
    public String toString() {
//        calls parent class toString()
        return super.toString() +
                ", color="+ getScooterColor() +
                ", wheels=" + getScooterNumWheels() +
                ", odometer=" + scooterOdometer + "]";
    }

    /**
     * Getter, odometer reading
     * @return odometer reading
     */
    public int getOdometerReading(){
        return scooterOdometer += 2;
    }

    /**
     * Getter, Scooter color
     * @return Scooter color
     */
    public String getScooterColor() {
        return scooterColor;
    }

    /**
     * Getter, Scooter Number of Wheels
     * @return Scooter Number of Wheels
     */
    public int getScooterNumWheels() {
        return scooterNumWheels;
    }
}
