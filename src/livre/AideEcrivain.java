package livre;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NavigableSet;
import java.util.TreeSet;

import attaque.Feu;
import attaque.Glace;
import attaque.Tranchant;
import bataille.Bataille;
import protagoniste.Domaine;
import protagoniste.Heros;
import protagoniste.Homme;
import protagoniste.Monstre;
import protagoniste.ZoneDeCombat;

public class AideEcrivain {

	private static final int COMPARATOR_ZONE_WEIGHT = 100;
	
	private Bataille bataille;
	private NavigableSet<Monstre<?>> monstreDomaineSet = new TreeSet<Monstre<?>>(
			new Comparator<Monstre<?>>() {
				public int compare(Monstre<?> o1, Monstre<?> o2) {
					int comparaison = o1.getDomaine().compareTo(o2.getDomaine());
					if(comparaison != 0)return comparaison;
					return o1.compareTo(o2);
				};
			});
	private NavigableSet<Monstre<?>> monstreZoneSet = new TreeSet<Monstre<?>>(
			new Comparator<Monstre<?>>() {
				public int compare(Monstre<?> o1, Monstre<?> o2) {
					int comparaisonZoneDeCombat = o1.getZoneDeCombat().compareTo(o2.getZoneDeCombat());
					int comparaisonForce = new Integer(o2.getForceDeVie()).compareTo(new Integer(o1.getForceDeVie()));
					int comparaison = comparaisonZoneDeCombat*COMPARATOR_ZONE_WEIGHT+comparaisonForce;
					if(comparaison != 0)return comparaison;
					return o1.compareTo(o2);
				};
			});
	
	private NavigableSet<Monstre<Feu>> monstresDeFeu = new TreeSet<>();
	private NavigableSet<Monstre<Glace>> monstresDeGlace = new TreeSet<>();
	private NavigableSet<Monstre<Tranchant>> monstresTranchant = new TreeSet<>();
	
	public AideEcrivain(Bataille bataille) {
		this.bataille = bataille;
		
	}
	
	public List<Homme> visualiserForcesHumaines() {
		System.out.println("\n");
		List<Homme> listeTriee = new LinkedList<>();
		for(Homme h : bataille.getCampHumains()) {
			if(listeTriee.isEmpty()) {
				listeTriee.add(h);
			}else {
				if(!(h instanceof Heros)) { //simple homme
					listeTriee.add(h);
				}else { //heros
					seekInsertHeros(listeTriee, h);
				}
			}
		}
		return listeTriee;
	}

	private void seekInsertHeros(List<Homme> listeTriee, Homme h) {
		boolean trouve = false; //si on a trouvé le premier homme
		for(ListIterator<Homme> it = listeTriee.listIterator() ; it.hasNext() && !trouve ;) { //nouvel iterateur depuis le debut
			Homme ht = it.next();
			if(!(ht instanceof Heros)) {//simple homme
				trouve = true;
				it.previous();
				it.add(h);
			}
		}
	}
	
	public String ordreNaturelMonstre(){
		StringBuilder builder = new StringBuilder();
		NavigableSet<Monstre<?>> set = new TreeSet<>();
		for(Monstre<?> m : this.bataille.getCampMonstres()) {
			set.add(m);
		}
		for(Iterator<Monstre<?>> it = set.iterator() ; it.hasNext() ;) {
			Monstre<?> m = it.next();
			if(it.hasNext()) {
				builder.append(m.getNom() + ", ");
			}else {
				builder.append(m.getNom());
			}
		}
		
		return builder.toString();
	}
	
	public NavigableSet<Monstre<Feu>> getMonstresDeFeu() {
		return monstresDeFeu;
	}

	public NavigableSet<Monstre<Glace>> getMonstresDeGlace() {
		return monstresDeGlace;
	}

	public NavigableSet<Monstre<Tranchant>> getMonstresTranchant() {
		return monstresTranchant;
	}

	public void updateMonstreDomaine() {
		for(Monstre<?> m : this.bataille.getCampMonstres()) {
			monstreDomaineSet.add(m);
		}
	}
	
	public void updateMonstreZone() {
		for(Monstre<?> m : this.bataille.getCampMonstres()) {
			monstreZoneSet.add(m);
		}
	}
	
	public String ordreMonstreDomaine(){
		updateMonstreDomaine();
		StringBuilder builder = new StringBuilder();
		Domaine currentDomaine = null;
		boolean first = true;
		for(Iterator<Monstre<?>> it = monstreDomaineSet.iterator() ; it.hasNext() ;) {
			Monstre<?> m = it.next();
			if(currentDomaine != m.getDomaine()) {
				currentDomaine = m.getDomaine();
				if(first) {
					first = false;
					builder.append(currentDomaine + ":\n");
				}else {
					builder.append("\n" + currentDomaine + ":\n");					
				}
			}
			if(it.hasNext()) {
				builder.append(m.getNom() + ", ");
			}else {
				builder.append(m.getNom());
			}
		}
		builder.append("\n");
		return builder.toString();
	}
	
	public String ordreMonstreZone(){
		updateMonstreZone();
		StringBuilder builder = new StringBuilder();
		ZoneDeCombat currentZone = null;
		boolean first = true;
		for(Iterator<Monstre<?>> it = monstreZoneSet.iterator() ; it.hasNext() ;) {
			Monstre<?> m = it.next();
			if(currentZone != m.getZoneDeCombat()) {
				currentZone = m.getZoneDeCombat();
				if(first) {
					first = false;
					builder.append(currentZone + ":\n");
				}else {
					builder.append("\n" + currentZone+ ":\n");					
				}
			}
			if(it.hasNext()) {
				builder.append(m.getNom() + " : " + m.getForceDeVie() + ", ");
			}else {
				builder.append(m.getNom() + " : " + m.getForceDeVie());
			}
		}
		builder.append("\n");
		return builder.toString();
	}
}
