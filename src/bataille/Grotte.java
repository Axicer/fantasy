package bataille;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import protagoniste.Monstre;
import protagoniste.ZoneDeCombat;

public class Grotte {

	private LinkedHashMap<Salle, List<Salle>> planGrotte;
	private HashMap<Salle, Bataille> batailles;
	private HashSet<Salle> sallesExplorees;
	private int numeroSalleDecisive;

	public Grotte() {
		planGrotte = new LinkedHashMap<>();
		batailles = new HashMap<>();
		sallesExplorees = new HashSet<>();
	}

	public void ajouterSalle(ZoneDeCombat zoneDeCombat, Monstre<?>... monstres) {
		Salle s = new Salle(planGrotte.size(), zoneDeCombat);
		Bataille b = new Bataille();
		for (Monstre<?> m : monstres) {
			b.ajouter(m);
		}
		planGrotte.put(s, new ArrayList<>());
		batailles.put(s, b);
	}

	public String afficherPlanGrotte() {
		StringBuilder affichage = new StringBuilder();
		for (Map.Entry<Salle, List<Salle>> entry : planGrotte.entrySet()) {
			Salle salle = entry.getKey();
			List<Salle> acces = planGrotte.get(salle);
			affichage.append("La " + salle + ".\nelle possede " + acces.size() + " acces : ");
			for (Salle access : acces) {
				affichage.append(" vers la salle " + access);
			}
			Bataille bataille = batailles.get(salle);
			Camp<Monstre<?>> camp = bataille.getCampMonstres();
			Monstre<?> monstre = camp.selectionner();
			if (camp.nbCombattants() > 1) {
				affichage.append("\n" + camp.nbCombattants() + " monstres de type ");
			} else {
				affichage.append("\nUn monstre de type ");
			}
			affichage.append(monstre.getNom() + " la protege.\n");
			if (salle.getNumeroSalle() == numeroSalleDecisive) {
				affichage.append("C'est dans cette salle que se trouve la pierre de sang.\n");
			}
			affichage.append("\n");
		}
		return affichage.toString();
	}
	
	public Salle trouverSalle(int num) {
		Salle res = null;
		for(Salle s : planGrotte.keySet()) {
			if(s.getNumeroSalle() == num) {
				res = s;
				break;
			}
		}
		return res;
	}
	
	public void configurerAcces(int numeroSalleOrigine, int... salleAccesibles) {
		Salle origine = trouverSalle(numeroSalleOrigine-1);//la methode demande les index qui commence à 1
		List<Salle> accessibles = planGrotte.get(origine);
		
		for(int num : salleAccesibles) {
			Salle s = trouverSalle(num);
			if(s != null){
				accessibles.add(s);
			}
		}
	}

	public void setNumeroSalleDecisive(int numeroSalleDecisive) {
		this.numeroSalleDecisive = numeroSalleDecisive-1;//index start at 1
	}
	
	public boolean salleDecisive(Salle s) {
		return s.getNumeroSalle() == numeroSalleDecisive;
	}
	
	public Salle premiereSalle() {
		Salle s = (Salle) planGrotte.keySet().stream().findFirst().get();
		sallesExplorees.add(s);
		return s;
	}
	
	public Salle salleSuivante(Salle s) {
		List<Salle> accessibles = planGrotte.get(s);
		List<Salle> tmpAccess = new ArrayList<>();
		for(Salle sa : accessibles)tmpAccess.add(sa);
		
		tmpAccess.removeAll(sallesExplorees);
		if(tmpAccess.isEmpty()) {
			for(Salle sa : accessibles)tmpAccess.add(sa);
		}

		Salle choisi = tmpAccess.get(new Random().nextInt(tmpAccess.size()));
		sallesExplorees.add(choisi);
		return choisi;
	}
}
