/*
Homework 4 : Toy Store
File Name : Action_Figure.java
 */
package toy;

/**
 * The Action Figure class, which extends Toy abstract class and implements
 * IToy interface.
 *
 * @author Meenu Gigi, mg2578@rit.edu
 * @author Vedika Vishwanath Painjane, vp2312@rit.edu
 */
public class Action_Figure extends Toy implements IToy{

    /** stores initial value of product code. */
    private static int actionFigureProductCode = 5000000;

    /** stores hair color of Action Figure. */
    private final String actionFigureHairColor;

    /** stores eye color of Action Figure. */
    private final String actionFigureEyeColor;

    /** checks grip type of Action Figure. */
    private final boolean Kung_Fu_Grip;

    /**
     * Initialize an Action_Figure.
     * @param actionFigureName Name of the action figure
     * @param actionFigureMSRP MSRP of the action figure, random value between
     *                        9.99 and 24.99.
     * @param actionFigureHairColor Hair color
     * @param actionFigureEyeColor Eye color
     * @param Kung_Fu_Grip May or may not have Kung_Fu_Grip
     */
     Action_Figure(String actionFigureName, double actionFigureMSRP,
                   String actionFigureHairColor, String actionFigureEyeColor,
                   Boolean Kung_Fu_Grip){
//        calls parent class constructor.
         super(actionFigureName, actionFigureMSRP);
         this.actionFigureHairColor = actionFigureHairColor;
         this.actionFigureEyeColor = actionFigureEyeColor;
         this.Kung_Fu_Grip = Kung_Fu_Grip;
//        assigns product code when a new Action Figure is created.
         productCode = actionFigureProductCode;
         actionFigureProductCode++;
    }

    /**
     * Called whenever the toy is played with. This will have the affect of
     * degrading the toy's condition.
     */
    @Override
    public void play() {
//         modifies degradation level whenever Action Figure is played with.
        if((getDegradationLevel() + 10) < 100){
            degradeLevel += 10;
        }
        else if((getDegradationLevel() + 10) >= 100){
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
//        calls parent class toString().
        return super.toString() +
                ", hair color=" + getActionFigureHairColor() +
                ", eye color=" + getActionFigureEyeColor() +
                ", kung-fu grip=" + Kung_Fu_Grip + "]";
    }

    /**
     * Getter, action figure hair color
     * @return hair color
     */
    private String getActionFigureHairColor() {
        return actionFigureHairColor;
    }

    /**
     * Getter, action figure eye color
     * @return eye color
     */
    private String getActionFigureEyeColor() {
        return actionFigureEyeColor;
    }
}
