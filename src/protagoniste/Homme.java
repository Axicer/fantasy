package protagoniste;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;

import attaque.Arme;
import bataille.Bataille;

public class Homme extends EtreVivant {

	public final static int VIE_DEFAUT = 70;
	private EnumMap<ZoneDeCombat, List<Arme>> armes;
	private Arme armeChoisie;
	
	public Homme(String nom) {
		super(nom, VIE_DEFAUT);
		armes = new EnumMap<>(ZoneDeCombat.class);
		for(ZoneDeCombat z : ZoneDeCombat.values()) {
			armes.put(z, new ArrayList<>());
		}
	}

	public Arme choisirArme(Monstre<?> m) {
		return armes.get(m.getZoneDeCombat()).stream().sorted(new Comparator<Arme>() {
			@Override
			public int compare(Arme A, Arme B) {
				if(!A.isOperationnel() || !B.isOperationnel()) {
					Boolean Aop = A.isOperationnel();
					Boolean Bop = B.isOperationnel();
					int compare = Aop.compareTo(Bop);
					return compare != 0 ? compare : A.getNom().compareTo(B.getNom());
				}
				Integer Af = A.getPointDeDegat();
				Integer Bf = B.getPointDeDegat();
				int compare = Af.compareTo(Bf);
				
				return compare != 0 ? compare : A.getNom().compareTo(B.getNom());
			}
		}).filter(a -> a.getPointDeDegat() <= m.getForceDeVie()).findFirst().orElse(null);
	}
	
	public void ajouterArmes(Arme... ar) {
		for(Arme a : ar) {
			for(ZoneDeCombat z : a.getZoneDeCombat()) {
				armes.get(z).add(a);
			}
		}
	}
	
	public void supprimerArmes(Arme a) {
		for(ZoneDeCombat z : a.getZoneDeCombat()) {
			armes.get(z).remove(a);
		}
	}
	
	@Override
	public void rejointBataille(Bataille bataille) {
		super.rejointBataille(bataille);
		bataille.ajouter(this);
	}
	
	@Override
	public void mourir() {
		bataille.eliminer(this);
	}

	@Override
	public String toString() {
		return "Homme ["+super.toString()+"]";
	}

	public Arme getArmeChoisie() {
		return armeChoisie;
	}

	

}
