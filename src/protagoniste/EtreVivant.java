package protagoniste;

import bataille.Bataille;

public abstract class EtreVivant {

	private String nom;
	private int forceDeVie;
	protected Bataille bataille;
	
	public EtreVivant(String nom, int forceDeVie) {
		this.nom = nom;
		this.forceDeVie = forceDeVie;
	}

	public String getNom() {
		return nom;
	}

	public int getForceDeVie() {
		return forceDeVie;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setForceDeVie(int forceDeVie) {
		this.forceDeVie = forceDeVie;
	}

	public void rejointBataille(Bataille bataille) {
		this.bataille = bataille;
	}
	
	public abstract void mourir();
	
	@Override
	public String toString() {
		return "EtreVivant [nom=" + nom + ", forceDeVie=" + forceDeVie + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EtreVivant other = (EtreVivant) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
	
}
