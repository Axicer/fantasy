package attaque;

public abstract class Pouvoir extends ForceDeCombat{

	private double nbUtilisationPouvoir;
	private double nbUtilisationPouvoirInitial;
	
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
		
		int degats = 0;
		
		nbUtilisationPouvoir--;
		if(nbUtilisationPouvoir == 0) {
			setOperationnel(false);
			degats = getPointDeDegat();
		}else if(nbUtilisationPouvoir < 0){
			degats = 0;
		}else {
			degats = getPointDeDegat();
		}
		
		return degats;
	}
}
