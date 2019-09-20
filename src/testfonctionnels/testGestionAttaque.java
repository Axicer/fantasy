package testfonctionnels;

import attaque.BouleDeFeu;
import attaque.Eclair;
import attaque.Feu;
import attaque.Lave;
import protagoniste.Domaine;
import protagoniste.Monstre;
import protagoniste.ZoneDeCombat;

public class testGestionAttaque {
	
	public static void main(String[] args) {
		Monstre<Feu> m = new Monstre<>("dragotenebre", 200, ZoneDeCombat.aerien, Domaine.feu, new Lave(42), new Eclair(69), new BouleDeFeu(666));
		
		System.out.println(m);
	}

}
