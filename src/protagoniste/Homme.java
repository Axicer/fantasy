package protagoniste;

import bataille.Bataille;

public class Homme extends EtreVivant {

	public final static int VIE_DEFAUT = 70;
	
	public Homme(String nom) {
		super(nom, VIE_DEFAUT);
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
		return "Homme ["+super.toString()+"]";
	}

	

}
