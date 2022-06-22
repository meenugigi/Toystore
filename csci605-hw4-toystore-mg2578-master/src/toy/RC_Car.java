/*
Homework 4 : Toy Store
File Name : RC_Car.java
 */
package toy;

/**
 * The RC_Car class, which extends Toy abstract class and implements IToy
 * interface.
 *
 * @author Meenu Gigi, mg2578@rit.edu
 * @author Vedika Vishwanath Painjane, vp2312@rit.edu
 */
public class RC_Car extends Toy implements IToy{

    /** stores initial value of product code. */
    private static int RCProductCode = 6000000;

    /** stores battery type. */
    private final BatteryType RCBatteryType;

    /** stores initial battery level. */
    private int RCBatteryLevel = 100;

    /** stores number of batteries used. */
    private final int RCNumBatteries;

    /** stores scale speed. */
    private final int RCScaleSpeed;

    /**
     * Initializing a RC car
     * @param RCName Name of the rc car
     * @param RCMSRP MSRP between 19.99 and 159.99.
     * @param RCBatteryType Battery Type
     * @param RCNumBatteries Number of batteries, between 1 and 6.
     * @param RCScaleSpeed Scale speed, between 100 and 300.
     */
     RC_Car(String RCName, double RCMSRP, BatteryType RCBatteryType,
                     int RCNumBatteries, int RCScaleSpeed){
//        calls parent class constructor.
        super(RCName, RCMSRP);
        this.RCBatteryType = RCBatteryType;
        this.RCNumBatteries = RCNumBatteries;
        this.RCScaleSpeed = RCScaleSpeed;
//        assigns product code when a new RC Car is created.
        productCode = RCProductCode;
        RCProductCode++;
    }

    /**
     * Called whenever the toy is played with. This will have the affect of
     * degrading the toy's condition.
     */
    @Override
    public void play() {
//         depletes battery whenever RC Car is played with.
        if(getRCBatteryLevel() > 0){
           RCBatteryLevel -= 30;
        }
         else if(getRCBatteryLevel() <= 0){
            System.out.println("The batteries are dead! Let's replace them...");
//            replaces battery and depletes battery.
            RCBatteryLevel = 100 - 30;
        }
//         modifies degradation level whenever RC Car is played with.
        if((getDegradationLevel() + 15) < 100){
            degradeLevel += 15;
        }
        else if((getDegradationLevel() + 15) >= 100){
            degradeLevel = 100;
            condition = Condition.BROKEN;
        }
        System.out.println(getName() + " races in circles at " +
                getRCScaleSpeed() + " mph!");
//        calls parent class play().
        super.play();
    }

    /**
     * Prints the information of the toy.
     * @return String containing the information of the toy
     */
    @Override
    public String toString() {
//        calls parent class toString().
        return super.toString() +
                ", battery type=" + getRCBatteryType() +
                ", number of batteries=" + getRCNumBatteries() +
                ", battery level=" + getRCBatteryLevel() +
                "%, speed=" + getRCScaleSpeed() + "]";
    }

    /**
     * Getter, RC Battery Type
     * @return Battery type
     */
    public BatteryType getRCBatteryType() {
        return RCBatteryType;
    }

    /**
     * Getter, RC Number of Batteries
     * @return Number of batteries
     */
    public int getRCNumBatteries() {
        return RCNumBatteries;
    }

    /**
     * Getter, RC Scale speed
     * @return Scale speed
     */
    public int getRCScaleSpeed() {
        return RCScaleSpeed;
    }

    /**
     * Getter, RC Battery level
     * @return Battery level
     */
    public int getRCBatteryLevel() {
//         if battery level goes beyond 0, update battery level as 0.
        if(RCBatteryLevel < 0){
            RCBatteryLevel = 0;
        }
        return RCBatteryLevel;
    }
}
