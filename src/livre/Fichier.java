package livre;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Fichier implements Livre{

	private FileWriter writer;
	
	public Fichier(String path) {
		try {
			writer = new FileWriter(new File(path), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void ecrire(String chaine) {
		try {
			writer.write(chaine);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
