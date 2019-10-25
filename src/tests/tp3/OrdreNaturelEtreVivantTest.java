package tests.tp3;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import protagoniste.EtreVivant;
import protagoniste.Homme;

public class OrdreNaturelEtreVivantTest {

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
  public void test2InstancesEtreVivantsSontEquivalentsEtEgales() {
    EtreVivant ev1 = new Homme("Fred");
    assertTrue((ev1.equals(ev1))==(ev1.compareTo(ev1)==0));
  }
  
  @Test
  public void test2HommesDeMemeNomSontEquivalentsEtEgaux() {
    EtreVivant ev1 = new Homme("Fred");
    EtreVivant ev2 = new Homme("Fred");
    assertTrue((ev1.equals(ev2))==(ev1.compareTo(ev2)==0));
    assertTrue((ev2.equals(ev1))==(ev2.compareTo(ev1)==0));
    assertTrue(ev1.compareTo(ev2)==ev2.compareTo(ev1));
  }

  // sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for all x and y
  @Test
  public void testReflexivity2Hommes() {
    EtreVivant ev1 = new Homme("Fred");
    EtreVivant ev2 = new Homme("Fredo");
    assertTrue((Math.signum(ev1.compareTo(ev2))) == -Math.signum(ev2.compareTo(ev1)) );
  }

//  The implementor must also ensure that the relation is transitive: (x.compareTo(y)>0 && y.compareTo(z)>0) implies x.compareTo(z)>0.
  @Test
  public void testTransitivity3Hommes() {
    EtreVivant ev1 = new Homme("Fred");
    EtreVivant ev2 = new Homme("Frederic");
    EtreVivant ev3 = new Homme("Fredo");
    assertTrue((ev3.compareTo(ev2)>0)&&(ev2.compareTo(ev1)>0));
    assertTrue(ev3.compareTo(ev1)>0);
  }

//  Finally, the implementor must ensure that x.compareTo(y)==0 implies that sgn(x.compareTo(z)) == sgn(y.compareTo(z)), for all z.
  @Test
  public void testSubstituvity2Hommes() {
    EtreVivant ev1 = new Homme("Fred");
    EtreVivant ev2 = new Homme("Fred");
    EtreVivant ev3 = new Homme("Fredo");
    assertTrue(ev1.compareTo(ev2)==0);
    assertTrue(Math.signum(ev1.compareTo(ev3))==Math.signum(ev2.compareTo(ev3)));
  }


}
