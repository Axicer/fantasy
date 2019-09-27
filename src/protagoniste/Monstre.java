package protagoniste;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import attaque.Pouvoir;
import bataille.Bataille;

public class Monstre<U extends Pouvoir> extends EtreVivant{

	private U[] attaques;
	private ZoneDeCombat zoneDeCombat;
	private Domaine domaine;
	private gestionAttaque gestion;

	@SafeVarargs
	public Monstre(String nom, int forceDeVie, ZoneDeCombat zoneDeCombat, Domaine domaine, U... attaques) {
		super(nom, forceDeVie);
		this.zoneDeCombat = zoneDeCombat;
		this.domaine = domaine;
		this.attaques = attaques;
		this.gestion = new gestionAttaque(this);
	}

	public ZoneDeCombat getZoneDeCombat() {
		return zoneDeCombat;
	}

	public Domaine getDomaine() {
		return domaine;
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
		return "Monstre [attaques=" + Arrays.toString(attaques) + ", zoneDeCombat=" + zoneDeCombat + ", domaine="
				+ domaine + "]";
	}

	class gestionAttaque implements Iterator<U> {
		private U[] attaquesPossible;
		private int nbAttaquesPossible;
		
		public gestionAttaque(Monstre<U> monstre) {
			this.attaquesPossible = monstre.attaques;
			this.nbAttaquesPossible = monstre.attaques.length;
		}
		
		@Override
		public boolean hasNext() {
			boolean attaquePossible = false;
			for(int i = 0 ; i < nbAttaquesPossible ; i++) {
				if(!attaquesPossible[i].isOperationnel()) {
					U tmp = attaquesPossible[nbAttaquesPossible-1];
					attaquesPossible[nbAttaquesPossible-1] = attaquesPossible[i];
					attaquesPossible[i] = tmp;
					nbAttaquesPossible--;
				}else {
					attaquePossible = true;
				}
			}
			return attaquePossible;
		}

		@Override
		public U next() {
			return attaquesPossible[new Random().nextInt(nbAttaquesPossible)];
		}
	}
	
	public void entreEnCombat() {
		for(Pouvoir p : attaques) {
			p.regenererPouvoir();
		}
		gestion = new gestionAttaque(this);
	}
	
	public U attaque() {
		return gestion.hasNext() ? gestion.next() : null;
	}
}
