package attaque;

public class LameAcier extends Tranchant{

	public static final int DEGATS = 50;
	public static final String NAME = "Lame d'acier";
	
	public LameAcier(int nbUtilisationPouvoir) {
		super(DEGATS, NAME, nbUtilisationPouvoir);
	}

}
