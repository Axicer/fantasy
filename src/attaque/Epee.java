package attaque;

import protagoniste.ZoneDeCombat;

public class Epee extends Arme{

	public static final int DEGATS = 80;
	public static final String NAME = "Epee";
	@SuppressWarnings("unused")
	private String nomEpee;
	
	public Epee(String nomEpee) {
		super(DEGATS, NAME);
		this.nomEpee = nomEpee;
		this.getZoneDeCombat().add(ZoneDeCombat.AQUATIQUE);
		this.getZoneDeCombat().add(ZoneDeCombat.TERRESTRE);
	}
	
}
