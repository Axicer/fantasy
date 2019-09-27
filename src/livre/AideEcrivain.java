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
	
	public void visualiserForcesHumaines() {
		List<Homme> listeTriee = new LinkedList<>();
		ListIterator<Homme> listeTrieeIterator = listeTriee.listIterator();
		
		for(Homme h : bataille.getCampHumains()) {
			if(!(h instanceof Heros)) { //pas heros juste homme
				
			}else { //heros
				
			}
		}
	}
}
