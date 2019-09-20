package attaque;

public abstract class Pouvoir extends ForceDeCombat{

	private int nbUtilisationPouvoir;
	private int nbUtilisationPouvoirInitial;
	
	public Pouvoir(int pointDeDegat, String nom, int nbUtilisationPouvoir) {
		super(pointDeDegat, nom);
		this.nbUtilisationPouvoir = nbUtilisationPouvoir;
		this.nbUtilisationPouvoirInitial = nbUtilisationPouvoir;
	}
	
	public void regenererPouvoir() {
		nbUtilisationPouvoir = nbUtilisationPouvoirInitial;
		setOperationnel(true);
	}

	@Override
	public int utiliser() {
		if(!isOperationnel())return 0;
		
		nbUtilisationPouvoir--;
		if(nbUtilisationPouvoir == 0) {
			setOperationnel(false);
			return getPointDeDegat();
		}else if(nbUtilisationPouvoir < 0){
			return 0;
		}else {
			return getPointDeDegat();
		}
	}
}
