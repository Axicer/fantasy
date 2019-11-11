package attaque;

import protagoniste.ZoneDeCombat;

public class LancePierre extends Arme{

	public static final int DEGATS = 10;
	public static final String NAME = "Lance-pierre";
	
	public LancePierre() {
		super(DEGATS, NAME);
		this.getZoneDeCombat().add(ZoneDeCombat.AERIEN);
		this.getZoneDeCombat().add(ZoneDeCombat.TERRESTRE);
	}
}
