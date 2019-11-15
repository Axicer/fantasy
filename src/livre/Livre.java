package livre;

public interface Livre {
	
	default void ecrire(String chaine) {
		System.out.println(chaine);
	}
}
