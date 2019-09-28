package attaque;

public class Eclair extends Feu {

	public static final int DEGATS = 50;
	public static final String NAME = "Eclair";
	
	public Eclair(int nbUtilisationPouvoir) {
		super(DEGATS, NAME, nbUtilisationPouvoir);
	}

}
