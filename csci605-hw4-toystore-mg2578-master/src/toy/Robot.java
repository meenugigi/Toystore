/*
Homework 4 : Toy Store
File Name : Robot.java
 */
package toy;

/**
 * The Robot class, which extends Toy abstract class and implements IToy
 * interface.
 *
 * @author Meenu Gigi, mg2578@rit.edu
 * @author Vedika Vishwanath Painjane, vp2312@rit.edu
 */
public class Robot extends Toy implements IToy{

    /** stores initial value of product code. */
    private static int robotProductCode = 7000000;

    /** stores battery type. */
    private final BatteryType robotBatteryType;

    /** stores battery level. */
    private int robotBatteryLevel = 100;

    /** stores number of batteries. */
    private final int robotNumBatteries;

    /** stores robot sound. */
    private final String robotSound;

    /**
     * Initialize a Robot
     * @param robotName Name
     * @param robotMSRP MSRP between 25.99 and 699.99.
     * @param robotBatteryType Battery type
     * @param robotNumBatteries Number of batteries, between 1 to 6
     * @param robotSound Sound made by the robot when it is played with
     */
     Robot(String robotName, double robotMSRP, BatteryType robotBatteryType,
                    int robotNumBatteries, String robotSound){
//         calls parent class constructor.
         super(robotName, robotMSRP);
        this.robotBatteryType = robotBatteryType;
        this.robotNumBatteries = robotNumBatteries;
        this.robotSound = robotSound;
//        assigns product code when a new Robot is created.
        productCode = robotProductCode;
        robotProductCode++;
    }

    /**
     * Called whenever the toy is played with. This will have the affect of
     * degrading the toy's condition.
     */
    @Override
    public void play() {
//         depletes battery whenever Robot is played with.
        if(getRobotBatteryLevel() > 0){
            robotBatteryLevel -= 25;
        }
       else if(getRobotBatteryLevel() <= 0){
            System.out.println("The batteries are dead! Let's replace them...");
//            replaces battery and depletes battery.
            robotBatteryLevel = 100 - 25;
        }
//         modifies degradation level whenever RC Car is played with.
        if((getDegradationLevel() + 20) < 100){
            degradeLevel += 20;
        }
        else if((getDegradationLevel() + 20) >= 100){
            degradeLevel = 100;
            condition = Condition.BROKEN;
        }
        System.out.println(getName() + " goes '" +getRobotSound() + "'");
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
                ", battery type=" + getRobotBatteryType() +
                ", number of batteries=" + getRobotNumBatteries() +
                ", battery level=" + getRobotBatteryLevel() +
                "%, sound=" + getRobotSound() + "]";
    }

    /**
     * Getter, Battery type
     * @return Battery type
     */
    public BatteryType getRobotBatteryType() {
        return robotBatteryType;
    }

    /**
     * Getter, Battery Level
     * @return Battery level
     */
    public int getRobotBatteryLevel() {
//         if battery level goes beyond 0, update battery level as 0.
        if (robotBatteryLevel < 0){
            robotBatteryLevel= 0;
        }
        return robotBatteryLevel;
    }

    /**
     * Getter, Number of batteries
     * @return Number of batteries
     */
    public int getRobotNumBatteries() {
        return robotNumBatteries;
    }

    /**
     * Getter, Robot Sound
     * @return Sound by the robot
     */
    public String getRobotSound() {
        return robotSound;
    }

}
