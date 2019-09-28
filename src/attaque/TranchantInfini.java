package attaque;

public class TranchantInfini extends Tranchant{

	public TranchantInfini(int pointDeDegat, String nom) {
		super(pointDeDegat, nom, -1);
		setOperationnel(true);
	}
	
	@Override
	public int utiliser() {
		return getPointDeDegat();
	}

}
