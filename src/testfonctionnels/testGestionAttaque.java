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
		Monstre<Feu> m = new Monstre<>("dragotenebre", 200, ZoneDeCombat.AERIEN, Domaine.FEU, new Lave(5), new Eclair(5), new BouleDeFeu(5));
		
		System.out.println(m);
		
		m.entreEnCombat();
		for(int i = 0 ; i < 10 ; i++) {
			Feu attaque = m.attaque();
			System.out.println(attaque);			
		}
	}

}
