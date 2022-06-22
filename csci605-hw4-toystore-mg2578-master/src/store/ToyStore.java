/*
Homework 4 : Toy Store
File Name : ToyStore.java
 */
package store;

import toy.IToy;

/**
 * Runs a simulation during which a toy store is stocked with toys and each
 * customer 1.) purchases a toy, 2.) plays with it (degrading its condition),
 * and 3.) sells it back to the store whereupon it is discarded if broken. The
 * simulation runs until the store is out of stock.
 *
 * @author Meenu Gigi, mg2578@rit.edu
 * @author Vedika Vishwanath Painjane, vp2312@rit.edu
 *
 */
public class ToyStore {
    /**
     * The main method. It checks the number of command line arguments,
     * then stocks the toy store and plays the simulation.
     *
     * @param args Specifies a number of toys (integer) for stocking the toy
     *             store and a seed (integer) for the toy's type random
     *             number generator
     */
    public static void main(String[] args) {
        //TODO YOUR CODE HERE
//        checks number of arguments.
        if(args.length != 2){
            System.out.println("Usage: java ToyStore #_toys #_seed");
            System.exit(0);
        }
        else {
//            stores number of toys.
            int numOfToys = Integer.parseInt(args[0]);
//            stores seed value.
            int seed = Integer.parseInt(args[1]);
            AlsToyBarn store = new AlsToyBarn(numOfToys, seed);

//            repeat iteration until Toy store has stock available.
            while(store.availableStock() != 0){
//                customer purchases a toy.
                IToy purchasedToy = store.purchaseToy();
                System.out.println("The next customer purchases " +
                        purchasedToy + " and begins to play with it...");
//                customer play with purchased toy.
                purchasedToy.play();
//                customer sells toy back to store.
                store.addToy(purchasedToy);
                System.out.println("The customer grows bored with the toy" +
                        " and trades it in for $" +
                        String.format("%.2f",purchasedToy.getResaleValue()));
            }
            System.out.println("The toy store is out of stock! Time to close!");
        }
    }
}
