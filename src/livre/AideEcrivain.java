package livre;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import bataille.Bataille;
import protagoniste.Heros;
import protagoniste.Homme;

public class AideEcrivain {

	private Bataille bataille;
	
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
}
