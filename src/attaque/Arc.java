package attaque;

public class Arc extends Arme{

	private int nbFlechesRestantes;
	
	public Arc(int nbFlechesRestantes) {
		super(50, "Arc");
		this.nbFlechesRestantes = nbFlechesRestantes;
	}
	
	@Override
	public int utiliser() {
		if(!isOperationnel())return 0;
		
		nbFlechesRestantes--;
		if(nbFlechesRestantes == 0) {
			setOperationnel(false);
			return getPointDeDegat();
		}else if(nbFlechesRestantes < 0) {
			return 0;//ne devrais pas arriver
		}else {
			return getPointDeDegat();
		}
	}
}
