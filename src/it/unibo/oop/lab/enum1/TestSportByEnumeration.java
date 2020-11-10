package it.unibo.oop.lab.enum1;

import it.unibo.oop.lab.socialnetwork.User;

/**
 * This is going to act as a test for
 * {@link it.unibo.oop.lab.enum1.SportSocialNetworkUserImpl}
 * Every test must return true
 * 
 */
public final class TestSportByEnumeration {

    private TestSportByEnumeration() { }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String... args) {
        /*
         * [TEST DEFINITION]
         * 
         * By now, you know how to do it
         */
    	final SportSocialNetworkUserImpl<User> dcassani = new SportSocialNetworkUserImpl<User>("Davide","Cassani", "dcassani", 53);
        final SportSocialNetworkUserImpl<User> becclestone = new SportSocialNetworkUserImpl<User>("Bernie","Ecclestone", "becclestone", 83);
        final SportSocialNetworkUserImpl<User> falonso = new SportSocialNetworkUserImpl<User>("Fernando","Alonso", "falonso", 34);

        /*
         * Alonso is a fan of soccer and bike and practices F1: 
         * add these sports to Alonso
         * 
         * falonso.addSport(Sport.F1);
         * 
         * ...
         */
        falonso.addSport(Sport.F1);
        falonso.addSport(Sport.Soccer);
        falonso.addSport(Sport.Bike);
        System.out.println("Alonso practices F1: " + falonso.hasSport(Sport.F1));
        System.out.println("Alonso does not like volley: " + !falonso.hasSport(Sport.Volley));
        /*
         * Cassani practiced bike and loves F1 and MotoGP
         */
        dcassani.addSport(Sport.Bike);
        dcassani.addSport(Sport.F1);
        dcassani.addSport(Sport.MotoGP);
        System.out.println("Cassani has been a professional biker: "
                + dcassani.hasSport(Sport.Bike));
        System.out.println("Cassani does not like soccer: " + !dcassani.hasSport(Sport.Soccer));
        /**
         * Ecclestone is the de-facto owner of F1 but also a fan of basket.
         */
        becclestone.addSport(Sport.F1);
        becclestone.addSport(Sport.Basket);
        System.out.println("Bernie's the boss when it comes to F1: "
                + becclestone.hasSport(Sport.F1));
        System.out.println("Bernie does love playing also basket: "
                + becclestone.hasSport(Sport.Basket));
    }
}
