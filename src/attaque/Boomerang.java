package attaque;

import protagoniste.ZoneDeCombat;

public class Boomerang extends Arme{

	public static final int DEGATS = 20;
	public static final String NAME = "Boomerang";
	
	public Boomerang() {
		super(DEGATS, NAME);
		this.getZoneDeCombat().add(ZoneDeCombat.AERIEN);
		this.getZoneDeCombat().add(ZoneDeCombat.TERRESTRE);
	}

}
