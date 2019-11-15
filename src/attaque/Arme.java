package attaque;

import java.util.HashSet;

import protagoniste.ZoneDeCombat;

public abstract class Arme extends ForceDeCombat implements Orderable<Arme>{

	private HashSet<ZoneDeCombat> ZoneDeCombat;
	
	public Arme(int pointDeDegat, String nom) {
		super(pointDeDegat, nom);
		ZoneDeCombat = new HashSet<>();
	}

	public HashSet<ZoneDeCombat> getZoneDeCombat() {
		return ZoneDeCombat;
	}
	
	@Override
	public int compareTo(Arme o) {
		Boolean ob = o.isOperationnel();
		Boolean b = isOperationnel();
		int compare = ob.compareTo(b);
		
		return compare != 0 ? compare : getNom().compareTo(o.getNom());
	}
}
