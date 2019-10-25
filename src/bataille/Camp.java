package bataille;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import protagoniste.EtreVivant;

public class Camp<T extends EtreVivant> implements Iterable<T> {

	private List<T> list = new LinkedList<>();

	public void ajouter(T etreVivant) {
		if (!list.contains(etreVivant)) {
			list.add(etreVivant);
		}
	}

	public void eliminer(T etreVivant) {
		if (list.contains(etreVivant)) {
			list.remove(etreVivant);
		}
	}

	@Override
	public String toString() {
		return list.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return list.listIterator();
	}

	public int nbCombattants() {
		return list.size();
	}

	public T selectionner() {
		Random randomGenerateur = new Random();
		int numeroCombattant = randomGenerateur.nextInt(list.size());
		return list.get(numeroCombattant);
	}
}
