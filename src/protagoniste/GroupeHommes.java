package protagoniste;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import attaque.Arme;
import attaque.Pouvoir;
import bataille.Bataille;

public class GroupeHommes {

	private TreeSet<Homme> groupe;
	
	public TreeSet<Homme> getGroupe() {
		return groupe;
	}

	public GroupeHommes() {
		groupe = new TreeSet<>();
	}
	
	public void ajouterHommes(Homme... hommes) {
		for(Homme h : hommes)groupe.add(h);
	}
	
	public List<Homme> choixParticipants(Bataille b) {
		Monstre<?> m = b.getCampMonstres().selectionner();
		TreeMap<Arme, TreeSet<Homme>> hommesArmes = new TreeMap<>(new ComparateurArmes(m));
		for(Homme h : groupe) {
			Arme a = h.choisirArme(m);
			if(a != null) {//arme trouvée
				if(hommesArmes.containsKey(a)) {//arme dans la liste
					hommesArmes.get(a).add(h);
				}else {
					hommesArmes.put(a, new TreeSet<>(new ComparateurHommes()));
					hommesArmes.get(a).add(h);
				}
			}
		}
		List<Homme> participants = new ArrayList<>();
		int nb = 0;
		boolean shouldStop = false;
		for(Iterator<Arme> it = hommesArmes.keySet().iterator() ; it.hasNext() && !shouldStop ;) {
			Arme a = it.next();
			for(Homme h : hommesArmes.get(a)) {
				if(!participants.contains(h)) {
					participants.add(h);
					nb++;
					if(nb == 3) {
						shouldStop = true;
						break;
					}
				}
			}
		}
		return participants;
	}
	
	private final class ComparateurHommes implements Comparator<Homme>{

		@Override
		public int compare(Homme A, Homme B) {
			Integer Af = A.getForceDeVie();
			Integer Bf = B.getForceDeVie();
			int compare = Af.compareTo(Bf);
			return compare != 0 ? compare : A.getNom().compareTo(B.getNom());
		}
		
	}
	
	private final class ComparateurArmes implements Comparator<Arme>{

		private Monstre<? extends Pouvoir> monstre;
		
		public ComparateurArmes(Monstre<? extends Pouvoir> monstre) {
			this.monstre = monstre;
		}
		
		@Override
		public int compare(Arme A, Arme B) {
			Integer Mf = monstre.getForceDeVie();
			Integer Af = A.getPointDeDegat();
			Integer Bf = B.getPointDeDegat();
			
			if(Af.intValue() != Bf.intValue()) {
				TreeMap<Integer, Arme> classementForce = new TreeMap<>();
				classementForce.put(Af, A);
				classementForce.put(Bf, B);
				if(Af.intValue() > Mf.intValue() && Bf.intValue() > Mf.intValue()) {//si les deux armes sont plus forte que le monstre
					return Af.compareTo(Bf);
				}else {
					return Bf.compareTo(Af);
				}
			}else {
				return A.getNom().compareTo(B.getNom());
			}
		}
		
	}
	
	
}
