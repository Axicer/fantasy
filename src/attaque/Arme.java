package attaque;

import java.util.HashSet;

import protagoniste.ZoneDeCombat;

public abstract class Arme extends ForceDeCombat{

	private HashSet<ZoneDeCombat> ZoneDeCombat;
	
	public Arme(int pointDeDegat, String nom) {
		super(pointDeDegat, nom);
		ZoneDeCombat = new HashSet<>();
	}

	public HashSet<ZoneDeCombat> getZoneDeCombat() {
		return ZoneDeCombat;
	}
	
}
