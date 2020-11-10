/**
 * 
 */
package it.unibo.oop.lab.enum2;

/**
 * Represents an enumeration for declaring sports.
 * 
 * A sport is declared with a {@link Place}, the number of players needed for a team (1 for individual sports) and the name of the sport itself
 * 
 */
public enum Sport {
	
	BASKET(Place.INDOOR, 5, "Basket"),
	VOLLEY(Place.INDOOR, 6, "Volley"),
	TENNIS(Place.OUTDOOR, 1, "Tennis"),
	BIKE(Place.OUTDOOR, 1, "Bike"),
	F1(Place.OUTDOOR, 1, "F1"),
	MOTOGP(Place.OUTDOOR, 1, "MotoGP"),
	SOCCER(Place.OUTDOOR, 11, "Soccer");
	
	/* 
     * [FIELDS]
     */
	
	private final Place place;
	private final int noTeamMembers;
	private final String actualName;

    /* 
     * [CONSTRUCTOR]
     */
	
	Sport(final Place place, final int noTeamMembers, final String actualName) {
		this.place = place;
		this.noTeamMembers = noTeamMembers;
		this.actualName = actualName;
	}

    /*
     * [METHODS]
     */
	
	
	/**
	 * Check if a sport is individual or not
	 * @return true only if it is an individual sport (1 player)
	 */
	public boolean isIndividualSport() {
		return this.noTeamMembers == 1;
	}
	
	/**
	 * Check if a sport is indoor or outdoor
	 * @return true only if it's {@link #getPlace()} is indoor
	 */
	public boolean isIndoorSport() {
		return this.place.equals(Place.INDOOR);
	}
	
	/**
	 * Gets the place (INDOOR or OUTDOOR)
	 * @return the place in which the sport is done
	 */
	public Place getPlace() {
		return this.place;
	}
	
	/**
	 * String representation of a sport
	 * {@inheritDoc}
	 */
	public String toString() {
		return String.format("%s is made up of %d %s and it is done " + this.place, this.actualName, this.noTeamMembers, this.noTeamMembers == 1 ? "individual" : "team members");
	}
	
}
