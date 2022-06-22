/*
Homework 4 : Toy Store
File Name : Toy.java
 */
package toy;

import static toy.Condition.MINT;

/**
 * Abstract class Toy, which implements the IToy interface, this class is
 * extended by all the different toy classes.
 *
 * @author Meenu Gigi, mg2578@rit.edu
 * @author Vedika Vishwanath Painjane, vp2312@rit.edu
 */
public abstract class Toy implements IToy{

    /** stores value of product code. */
    protected int productCode;

    /** stores name of toy. */
    private final String name;

    /** stores MSRP of toy. */
    private final double MSRP;

    /** stores initial condition of toy. */
    protected Condition condition = MINT;

    /** stores initial degrade level of toy. */
    protected int degradeLevel = 0;

    /**
     * Initializing the toy
     * @param name Name
     * @param MSRP Manufacturer’s Suggested Retail Price
     */
     protected Toy(String name, double MSRP) {
        this.name = name;
        this.MSRP = MSRP;
    }

    /**
     * Getter, Product code
     * @return Product code
     */
    @Override
    public int getProductCode() {
        return productCode;
    }

    /**
     * Getter, name
     * @return Name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Getter, MSRP
     * @return MSRP
     */
    @Override
    public double getMSRP() {
        return MSRP;
    }

    /**
     * Getter, Resale Value
     * @return Resale Value
     */
    @Override
    public double getResaleValue() {
        return getMSRP() * getCondition().getMultiplier();
    }

    /**
     * Getter, Condition of the toy
     * @return Condition of the toy
     */
    @Override
    public Condition getCondition() {
        return condition = Condition.get(degradeLevel);
    }

    /**
     * Getter, Degradation level
     * @return Degradation level
     */
    @Override
    public int getDegradationLevel() {
        return degradeLevel;
    }

    /**
     * Called whenever the toy is played with. This will have the affect of
     * degrading the toy's condition.
     */
    public void play(){
        System.out.println("After play, " + getName() + "'s condition is " +
                getCondition());
    }

    /**
     * Prints the information of the toy.
     * @return String containing the information of the toy
     */
    public String toString() {
        return getName() + " [product code=" + getProductCode() +
                ", MSRP=" + String.format("%.2f", getMSRP()) +
                ", degradation level=" + getDegradationLevel() +
                "%, condition=" + getCondition() +
                ", resale value=" + String.format("%.2f", getResaleValue());
    }

}
