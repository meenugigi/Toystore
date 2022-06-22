/*
Homework 4 : Toy Store
File Name : Doll.java
 */
package toy;

/**
 * The Doll class, which extends Toy abstract class and implements IToy
 * interface.
 *
 * @author Meenu Gigi, mg2578@rit.edu
 * @author Vedika Vishwanath Painjane, vp2312@rit.edu
 */
public class Doll extends Toy implements IToy{

    /** stores initial value of product code. */
    private static int dollProductCode = 3000000;

    /** stores hair color of Doll. */
    private final String dollHairColor;

    /** stores eye color of Doll. */
    private final String dollEyeColor;

    /**
     * Initialize a doll
     * @param dollName Name of the doll
     * @param dollMSRP MSRP between 12.99 and 60.00.
     * @param dollHairColor Hair color
     * @param dollEyeColor Eye color
     */
     Doll(String dollName, double dollMSRP, String dollHairColor,
          String dollEyeColor){
//        calls parent class constructor.
         super(dollName, dollMSRP);
        this.dollHairColor = dollHairColor;
        this.dollEyeColor = dollEyeColor;
//        assigns product code when a new Doll is created.
        productCode = dollProductCode;
        dollProductCode++;
    }

    /**
     * Called whenever the toy is played with. This will have the affect of
     * degrading the toy's condition.
     */
    @Override
    public void play() {
//         modifies degradation level whenever Doll is played with.
        if((getDegradationLevel() + 17) < 100){
            degradeLevel += 17;
        }
        else if((getDegradationLevel() + 17) >= 100){
            degradeLevel = 100;
            condition = Condition.BROKEN;
        }
//        calls parent class play()
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
                ", hair color=" + getDollHairColor() +
                ", eye color=" + getDollEyeColor() + "]";
    }

    /**
     * Getter, hair color
     * @return Hair color
     */
    private String getDollHairColor() {
        return dollHairColor;
    }

    /**
     * Getter, eye color
     * @return Eye color
     */
    private String getDollEyeColor() {
        return dollEyeColor;
    }
}
