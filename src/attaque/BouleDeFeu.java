package attaque;

public class BouleDeFeu extends Feu {

	public static final int DEGATS = 20;
	public static final String NAME = "Boule de feu";

	public BouleDeFeu(int nbUtilisationPouvoir) {
		super(DEGATS, NAME, nbUtilisationPouvoir);
	}

}
