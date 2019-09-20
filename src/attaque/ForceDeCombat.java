package attaque;

public abstract class ForceDeCombat{
	
	private int pointDeDegat;
	private String nom;
	private boolean operationnel = true; //pas de protected à la demande du professeur ;-)
	
	public ForceDeCombat(int pointDeDegat, String nom) {
		this.pointDeDegat = pointDeDegat;
		this.nom = nom;
	}

	public int getPointDeDegat() {
		return pointDeDegat;
	}

	public String getNom() {
		return nom;
	}

	public boolean isOperationnel() {
		return operationnel;
	}
	
	public void setOperationnel(boolean operationnel) {
		this.operationnel = operationnel;
	}

	@Override
	public String toString() {
		return "ForceDeCombat [pointDeDegat=" + pointDeDegat + ", nom=" + nom + ", operationnel=" + operationnel + "]";
	}
	
	public int utiliser() {
		return getPointDeDegat();
	}
	
}
