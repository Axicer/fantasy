package attaque;

import protagoniste.ZoneDeCombat;

public class Arc extends Arme{

	public static final int DEGATS = 50;
	public static final String NAME = "Arc";
	
	private int nbFlechesRestantes;
	
	public Arc(int nbFlechesRestantes) {
		super(DEGATS, NAME);
		this.nbFlechesRestantes = nbFlechesRestantes;
		this.getZoneDeCombat().add(ZoneDeCombat.AQUATIQUE);
		this.getZoneDeCombat().add(ZoneDeCombat.AERIEN);
		this.getZoneDeCombat().add(ZoneDeCombat.TERRESTRE);
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
