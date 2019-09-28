package attaque;

public class Lave extends Feu {

	public static final int DEGATS = 80;
	public static final String NAME = "Lave";
	
	public Lave(int nbUtilisationPouvoir) {
		super(DEGATS, NAME, nbUtilisationPouvoir);
	}

}
