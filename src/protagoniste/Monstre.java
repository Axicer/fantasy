package protagoniste;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import attaque.Pouvoir;

public class Monstre<U extends Pouvoir> extends EtreVivant implements Iterable<U>{

	private U[] attaques;
	private ZoneDeCombat zoneDeCombat;
	private Domaine domaine;

	@SafeVarargs
	public Monstre(String nom, int forceDeVie, ZoneDeCombat zoneDeCombat, Domaine domaine, U... attaques) {
		super(nom, forceDeVie);
		this.zoneDeCombat = zoneDeCombat;
		this.domaine = domaine;
		this.attaques = attaques;
	}

	public ZoneDeCombat getZoneDeCombat() {
		return zoneDeCombat;
	}

	public Domaine getDomaine() {
		return domaine;
	}

	@Override
	public String toString() {
		return "Monstre [attaques=" + Arrays.toString(attaques) + ", zoneDeCombat=" + zoneDeCombat + ", domaine="
				+ domaine + "]";
	}

	class gestionAttaque implements Iterator<U> {
		private U[] attaquesPossible;
		private int nbAttaquesPossible;
		
		public gestionAttaque(U[] attaquesPossibles, int nbAttaquesPossible) {
			this.attaquesPossible = attaquesPossibles;
			this.nbAttaquesPossible = nbAttaquesPossible;
		}
		
		@Override
		public boolean hasNext() {
			boolean attaquePossible = false;
			for(int i = 0 ; i < nbAttaquesPossible ; i++) {
				if(!attaques[i].isOperationnel()) {
					U tmp = attaques[nbAttaquesPossible-1];
					attaques[nbAttaquesPossible-1] = attaques[i];
					attaques[i] = tmp;
					nbAttaquesPossible--;
				}else {
					attaquePossible = true;
				}
			}
			return attaquePossible;
		}

		@Override
		public U next() {
			return attaques[new Random().nextInt(nbAttaquesPossible)];
		}
	}

	@Override
	public Iterator<U> iterator() {
		return new gestionAttaque(attaques, attaques.length);
	}
}
