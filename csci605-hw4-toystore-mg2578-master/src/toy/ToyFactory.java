/*
Homework 4 : Toy Store
File Name : ToyFactory.java
 */
package toy;

import java.util.Random;

/**
 * A Toy Factory!
 *
 * @author Meenu Gigi, mg2578@rit.edu
 * @author Vedika Vishwanath Painjane, vp2312@rit.edu
 */
public final class ToyFactory {

    /** stores minimum MSRP value for a Scooter. */
    private static final double SCOOTER_MIN_MSRP = 39.99;
    /** stores maximum MSRP value for a Scooter. */
    private static final double SCOOTER_MAX_MSRP = 160.99;

    /** stores minimum MSRP value for a Doll. */
    private static final double DOLL_MIN_MSRP = 12.99;
    /** stores maximum MSRP value for a Doll. */
    private static final double DOLL_MAX_MSRP = 60.00;

    /** stores minimum MSRP value for an Action Figure. */
    private static final double ACTION_FIGURE_MIN_MSRP = 9.99;
    /** stores maximum MSRP value for an Action Figure. */
    private static final double ACTION_FIGURE_MAX_MSRP = 24.99;

    /** stores minimum MSRP value for a RC Car. */
    private static final double RC_CAR_MIN_MSRP = 19.99;
    /** stores maximum MSRP value for a RC Car. */
    private static final double RC_CAR_MAX_MSRP = 159.99;

    /** stores minimum MSRP value for a Robot. */
    private static final double ROBOT_MIN_MSRP = 25.99;
    /** stores maximum MSRP value for a Robot. */
    private static final double ROBOT_MAX_MSRP = 699.99;

    /** stores minimum number of batteries. */
    private static final int MIN_BATTERY = 1;
    /** stores maximum number of batteries. */
    private static final int MAX_BATTERY = 6;

    /** stores minimum scale speed for RC Car. */
    private static final int RC_CAR_MIN_SCALE_SPEED = 100;
    /** stores maximum scale speed for RC Car. */
    private static final int RC_CAR_MAX_SCALE_SPEED = 300;

    private static IToy iToy;

    /**
     * Used to generate random numbers.
     */
    private static final Random rand = new Random();

    /**
     * Type code used to indicate that the toy factory should make a scooter.
     */
    private static final int SCOOTER = 1;

    /**
     * Type code used to indicate that the toy factory should make a doll.
     */
    private static final int DOLL = 2;

    /**
     * Type code used to indicate that the toy factory should make an action
     * figure.
     */
    private static final int ACTION_FIGURE = 3;

    /**
     * The type code used to indicate that the toy factory should make an RC
     * car.
     */
    private static final int RC_CAR = 4;

    /**
     * The type code used to indicate that the toy factory should make a
     * robot.
     */
    private static final int ROBOT = 5;

    /**
     * The potential names for scooters.
     */
    private static final String[] SCOOTER_NAMES = {
            "Razor A", "Razor A5", "Mongoose Expo", "ENKEEO Kick", "Micro Maxi",
            "Royal Guard II", "Fuzion X-3", "Fuzion Z250 Pro", "VOKUL S2",
            "Xiaomi Mi", "WonderView"
    };

    /**
     * The potential colors for scooters.
     */
    private static final String[] SCOOTER_COLORS = {
            "Black", "Pink", "Green", "Blue", "Cyan", "Purple", "Gold", "Silver",
            "Red"
    };

    /**
     * The potential names for dolls.
     */
    private static final String[] DOLL_NAMES = {
            "Sally", "Johnny", "Barbie", "Ken", "Julio", "Ralph", "Jane", "Sarah",
            "Susan", "Benedetta", "Edwina", "Gloria", "Henriette", "Laura",
            "Marilee", "Norma", "Barbara Ann", "Barbara Lou", "Dora Lee", "Flossie",
            "Ginger", "Hilda", "Lucia Mary Lee", "Babs", "Betty", "Roger", "George",
            "Robert", "Harry", "Bruce", "Willy", "Johnson", "Pete", "Woody", "Buzz",
            "Larry"
    };

    /**
     * The potential colors for hair.
     */
    private static final String[] HAIR_COLOR = {
            "Blond", "Brown", "Brunette", "Purple", "Pink", "Red", "Black",
            "Ginger", "Green", "Blue"
    };

    /**
     * The potential colors for eyes.
     */
    private static final String[] EYE_COLOR = {
            "Blue", "Green", "Black", "Brown", "Purple", "Hazel"
    };

    /**
     * The potential prefixes for action figures.
     * The name of an action figure is the concatenation of one of those prefixes +
     * a doll's name (e.g. Strong Laura)
     */
    private static final String[] ACTION_FIGURE_PREFIXES = {
            "Action", "Lightning", "Strong", "Fast", "Sneaky", "Super", "Tough",
            "'Lasers'", "Stretch", "G.I.", "Quiet"
    };

    /**
     * The potential names for RC Cars.
     */
    private static final String[] RC_CAR_NAMES = {
            "Fistone Truck", "Gizmovine RC", "SPESXFUN", "Hapinic RC", "Amicool",
            "METAKOO RC", "Hosim RC", "KOOWHEEL Car", "Distianert Truck",
            "JEYPOD IMDEN Car"
    };


    /**
     * The potential names for robots.
     */
    private static final String[] ROBOT_NAMES = {
            "Iron Giant", "Mechagodzilla", "Optimus Prime", "Reginald", "Vector",
            "Robby", "R2-D2", "C3PO", "BB8", "Megatron", "Shockwave", "Soundwave",
            "Bumblebee", "iRobot", "Roomba", "Data"
    };

    /**
     * The potential sounds that a robot may make.
     */
    private static final String[] ROBOT_SOUNDS = {
            "Bleep Blorp", "Death to humans!", "One shall stand, one shall fall.",
            "Beepeedeepee", "Oh dear!", "Starscream, you fool!", "Eject!",
            "*radio playing*", "Bzzzzzt!", "I...am...Suuuuperman.",
            "I am not a gun!"
    };

    /**
     * Set the seed to the random number generator
     *
     * @param seed the seed
     */
    public static void setSeed(int seed) {
        rand.setSeed(seed);
    }

    /**
     * Factory method that makes and returns a random toy.
     *
     * @return A new, randomly selected toy.
     */
    public static IToy makeToy() {
        //TODO YOUR CODE HERE
        int type = randomInt(1, 5);
        if ( type == SCOOTER ) {
            return randomScooter();
        }
        else if(type == DOLL){
            return randomDoll();
        }
        else if(type == ACTION_FIGURE){
            return randomActionFigure();
        }
        else if(type == RC_CAR){
            return randomRCCar();
        }
        else if(type == ROBOT){
            return randomRobot();
        }
        return null;
    }


    /**
     * Makes and returns a scooter with a random name, MSRP, color, and
     * number of wheels (either 2 or 3).
     * The MSRP must be a value between 39.99 and 160.99
     *
     * @return The newly crafted scooter.
     */
    public static IToy randomScooter() {
        // TODO YOUR CODE HERE
        // select the scooter fields value in the following order:
        // 1 - select a random name
        // 2 - select a random MSRP (a value between 39.99 and 160.99)
        // 3 - select a random color
        // 4 - select a random number of wheels
        // make the scooter and assign it to toy

        iToy = new Scooter(randomString(SCOOTER_NAMES),
                randomDouble(SCOOTER_MIN_MSRP, SCOOTER_MAX_MSRP),
                randomString(SCOOTER_COLORS), randomInt(2,3));
        return iToy;
    }

    /**
     * Makes and returns a doll with a random name, MSRP, hair color, and eye
     * color.
     * The MSRP must be a value between 12.99 and 60.00
     *
     * @return The newly crafted doll.
     */
    public static IToy randomDoll() {
        // TODO YOUR CODE HERE
        // select the doll fields value in the following order:
        // 1 - select a random name
        // 2 - select a random MSRP (a value between 12.99 and 60.00)
        // 3 - select a random hair color
        // 4 - select a random eye color
        // make the doll and return it
        iToy = new Doll(randomString(DOLL_NAMES),
                randomDouble(DOLL_MIN_MSRP, DOLL_MAX_MSRP),
                randomString(HAIR_COLOR), randomString(EYE_COLOR));
        return iToy;
    }

    /**
     * Makes and returns an action figure with a random name, MSRP, hair
     * color, eye color, and Kung-Fu Grip (tm) configuration.
     * The MSRP must be a value between 9.99 and 24.99
     *
     * @return The newly crafted action figure.
     */
    public static IToy randomActionFigure() {
        // TODO YOUR CODE HERE
        // select the action figure fields value in the following order:
        // 1 - select a random name
        // 2 - select a random MSRP (a value between 9.99 and 24.99)
        // 3 - select a random hair color
        // 4 - select a random eye color
        // 5 - select a random Kung-Fu Grip configuration (true or false)
        // make the action figure and return it
        iToy = new Action_Figure(randomString(ACTION_FIGURE_PREFIXES) +
                " " + randomString(DOLL_NAMES),
                randomDouble(ACTION_FIGURE_MIN_MSRP, ACTION_FIGURE_MAX_MSRP),
                randomString(HAIR_COLOR), randomString(EYE_COLOR),
                randomBoolean());
        return iToy;
    }

    /**
     * Makes and returns an RC Car with a random name, MSRP, battery type,
     * number of batteries, and scale speed.
     * The number of batteries must be a random value between 1 and 6.
     * The MSRP must be a random value between 19.99 and 159.99.
     * The scale speed must be a random value between 100 and 300.
     *
     * @return The newly crafted RC Car.
     */
    public static IToy randomRCCar() {
        // TODO YOUR CODE HERE
        // select the rc car fields value in the following order:
        // 1 - select a random name
        // 2 - select a random MSRP (a value between 19.99 and 159.99)
        // 3 - select a random battery type
        // 4 - select a random number of batteries (a value between 1 and 6)
        // 5 - select a random scale speed
        // make the RC car and return it
        iToy = new RC_Car(randomString(RC_CAR_NAMES),
                randomDouble(RC_CAR_MIN_MSRP, RC_CAR_MAX_MSRP),
                randomBatteryType(), randomInt(MIN_BATTERY, MAX_BATTERY),
                randomInt(RC_CAR_MIN_SCALE_SPEED, RC_CAR_MAX_SCALE_SPEED));
        return iToy;
    }

    /**
     * Makes and returns a Robot with a random name, MSRP, battery type,
     * number of batteries, and sound.
     * The number of batteries must be a random value between 1 and 6.
     * The MSRP must be a value between 25.99 and 699.99.
     *
     * @return The newly crafted robot.
     */
    public static IToy randomRobot() {
        // TODO YOUR CODE HERE
        // select the robot fields value in the following order:
        // 1 - select a random name
        // 2 - select a random MSRP (a value between 25.99 and 699.99)
        // 3 - select a random battery type
        // 4 - select a random number of batteries (a value between 1 and 6)
        // 5 - select a random sound
        // make the robot and return it
        iToy = new Robot(
                randomString(ROBOT_NAMES),
                randomDouble(ROBOT_MIN_MSRP, ROBOT_MAX_MSRP),
                randomBatteryType(),
                randomInt(MIN_BATTERY, MAX_BATTERY),
                randomString(ROBOT_SOUNDS));
        return iToy;
    }

    //////////////////////////////////////////////////
    //              UTILITY METHODS                 //
    /////////////////////////////////////////////////

    /**
     * Returns a random integer in the range [min, max]
     *
     * @param min The minimum value.
     * @param max The maximum value.
     * @return A random integer in the range [min, max].
     */
    private static int randomInt(int min, int max) {
        int bound = max - min + 1;
        return rand.nextInt(bound) + min;
    }

    /**
     * Returns a random boolean (true or false).
     *
     * @return A random boolean.
     */
    private static boolean randomBoolean() {
        return rand.nextBoolean();
    }

    /**
     * Returns a random double in the range [min, max].
     *
     * @param min The minimum value.
     * @param max The maximum value.
     * @return A random double in the range [min, max].
     */
    private static double randomDouble(double min, double max) {
        double bound = max - min;
        double temp = rand.nextDouble() * bound + min;
        temp = temp * 100;
        int rounded = (int) temp;
        return rounded / 100.0;
    }

    /**
     * Selects a random value from the specified string array.
     *
     * @param values The array of strings from which to choose a random value.
     * @return The value that has been randomly selected from the array of
     * strings.
     */
    private static String randomString(String[] values) {
        int index = randomInt(0, values.length - 1);
        return values[index];
    }

    /**
     * Returns a randomly selected battery type.
     *
     * @return A battery type.
     */
    private static BatteryType randomBatteryType() {
        int batteries = randomInt(0, 5);
        return BatteryType.values()[batteries];
    }
}
