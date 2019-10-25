package tests.tp3;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import attaque.BouleDeFeu;
import attaque.Eclair;
import attaque.Feu;
import attaque.Glace;
import attaque.Griffe;
import attaque.LameAcier;
import attaque.Lave;
import attaque.Morsure;
import attaque.PicsDeGlace;
import attaque.Tornade;
import attaque.Tranchant;
import bataille.Bataille;
import livre.AideEcrivain;
import protagoniste.Domaine;
import protagoniste.Monstre;
import protagoniste.ZoneDeCombat;

public class OrdreNaturelMonstresTest {
  Monstre<Feu> dragotenebre;
  Monstre<Tranchant> vampirien;
  Monstre<Glace> marinsangant;
  Monstre<Tranchant> guillotimort;
  Bataille bataille;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    dragotenebre = new Monstre<>("dragotenebre", 200, ZoneDeCombat.AERIEN, Domaine.FEU,
        new BouleDeFeu(4), new Lave(1), new Eclair(3));
    vampirien = new Monstre<>("vampirien", 10, ZoneDeCombat.AERIEN, Domaine.TRANCHANT,
        new Morsure(10));
    marinsangant = new Monstre<>("marinsangant", 150, ZoneDeCombat.AQUATIQUE, Domaine.GLACE,
        new PicsDeGlace(10), new Tornade(1));
    guillotimort = new Monstre<>("guillotimort", 80, ZoneDeCombat.TERRESTRE, Domaine.TRANCHANT,
        new LameAcier(10), new Griffe());
    bataille = new Bataille();

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSujetTP3() {
    dragotenebre.rejointBataille(bataille);
    vampirien.rejointBataille(bataille);
    marinsangant.rejointBataille(bataille);
    guillotimort.rejointBataille(bataille);
    AideEcrivain aideEcrivain = new AideEcrivain(bataille);

    assertEquals(aideEcrivain.ordreNaturelMonstre(),
        "dragotenebre guillotimort marinsangant vampirien ");
  }

  @Test
  public void testBatailleVide() {
    Bataille batailleVide = new Bataille();
    AideEcrivain aideEcrivain = new AideEcrivain(bataille);

    assertEquals(aideEcrivain.ordreNaturelMonstre(),"");
  }

}
