package protagoniste;

public abstract class EtreVivant {

	private String nom;
	private int forceDeVie;
	
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

	@Override
	public String toString() {
		return "EtreVivant [nom=" + nom + ", forceDeVie=" + forceDeVie + "]";
	}
}
