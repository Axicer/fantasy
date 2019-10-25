package tests.tp3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import protagoniste.EtreVivant;
import protagoniste.Heros;
import protagoniste.Homme;
import protagoniste.Monstre;


public class EquivalenceEtreVivant {

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void test2InstancesEtreVivantsSontEquivalents() {
    EtreVivant ev1 = new Homme("Fred");
    assertTrue(ev1.equals(ev1));
  }
  
  @Test
  public void test2InstancesEtreVivantsDeMemeNomSontEquivalents() {
    EtreVivant ev1 = new Homme("Fred");
    EtreVivant ev2 = new Homme("Fred");
    assertTrue(ev1.equals(ev2));
    assertTrue(ev2.equals(ev1));
  }
  
  @Test
  public void test2HommesDeNomsDifferentsNeSontPasEquivalents() {
    EtreVivant ev1 = new Homme("Fred");
    EtreVivant ev2 = new Homme("Fredo");
    assertFalse(ev1.equals(ev2));
    assertFalse(ev2.equals(ev1));
  }

  @Test
  public void test2HerosDeNomsDifferentsNeSontPasEquivalents() {
    EtreVivant ev1 = new Heros("Fred");
    EtreVivant ev2 = new Heros("Fredo");
    assertFalse(ev1.equals(ev2));
    assertFalse(ev2.equals(ev1));
  }

  @SuppressWarnings("unchecked")
@Test
  public void test2MonstresDeNomsDifferentsNeSontPasEquivalents() {
    EtreVivant ev1 = new Monstre("Fred", 0, null, null, null);
    EtreVivant ev2 = new Monstre("Fredo", 0, null, null, null);
    assertFalse(ev1.equals(ev2));
    assertFalse(ev2.equals(ev1));
  }

  @Test
  public void testUnHommeEtUnHerosDeMemeNomNeSontPasEquivalents() {
    Homme homme = new Homme("Fred");
    Heros heros = new Heros("Fred");
    EtreVivant evHeros = (EtreVivant) heros;
    EtreVivant evHomme = (EtreVivant) homme;
    assertFalse(homme.equals(heros));
    assertFalse(heros.equals(homme));
    assertTrue(homme.equals(evHomme));
    assertTrue(evHomme.equals(homme));
    assertFalse(evHeros.equals(evHomme));
    assertFalse(evHomme.equals(evHeros));
  }

  @Test
  public void testUnHommeEtUnMonstreDeMemeNomNeSontPasEquivalents() {
    Homme homme = new Homme("Fred");
    Monstre monstre = new Monstre("Fred", 0, null, null, null);
    EtreVivant evHomme = (EtreVivant) homme;
    EtreVivant evMonstre = (EtreVivant) monstre;
    assertFalse(homme.equals(monstre));
    assertFalse(monstre.equals(homme));
    assertTrue(homme.equals(evHomme));
    assertTrue(evHomme.equals(homme));
    assertFalse(evHomme.equals(evMonstre));
    assertFalse(evMonstre.equals(evHomme));
  }

  @Test
  public void testUnHerosEtUnMonstreDeMemeNomNeSontPasEquivalents() {
    Heros heros = new Heros("Fred");
    Monstre monstre = new Monstre("Fred", 0, null, null, null);
    EtreVivant evHeros = (EtreVivant) heros;
    EtreVivant evMonstre = (EtreVivant) monstre;
    assertFalse(heros.equals(monstre));
    assertFalse(monstre.equals(heros));
    assertTrue(heros.equals(evHeros));
    assertTrue(evHeros.equals(heros));
    assertFalse(evHeros.equals(evMonstre));
    assertFalse(evMonstre.equals(evHeros));
  }

 }
