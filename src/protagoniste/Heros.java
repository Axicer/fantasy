package protagoniste;

public class Heros extends Homme{

	public static final int VIE_DEFAUT = 100;
	
	public Heros(String nom) {
		super(nom);
		this.setForceDeVie(VIE_DEFAUT);
	}

	@Override
	public String toString() {
		return "Heros ["+super.toString()+"]";
	}
}
