package tests.tp3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bataille.Bataille;
import livre.AideEcrivain;

public class OrdreDomaineMonstresTest {

  Bataille bataille;
  AideEcrivain aideEcrivain;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
    bataille = new Bataille();
    aideEcrivain = new AideEcrivain(bataille);

  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testSurAttributMonstresDomaineSet() throws NoSuchFieldException, SecurityException {
    Field mds = aideEcrivain.getClass().getDeclaredField("monstresDomaineSet");
    int mod = mds.getModifiers();
    assertTrue(Modifier.isPrivate(mod));
    assertTrue(mds.getGenericType().getTypeName()
        .equals("java.util.NavigableSet<fantaisieTP1.protagonistes.Monstre<?>>"));
  }

  @Test
  public void testClasseInterneMonstreComparator() {
    Class innerComparator = aideEcrivain.getClass().getDeclaredClasses()[0];
    assertEquals("fantaisieTP2.livre.AideEcrivain$ComparateurMonstreDomaine",
        innerComparator.getName());
    Method[] methods = innerComparator.getDeclaredMethods();
    // assertTrue(methods.length == 1);
    System.out.println("la suite " + methods.length);
    Method compareMethod = methods[0];
    assertEquals("compare",compareMethod.getName());
    assertEquals(2,compareMethod.getParameterCount());
    for (Parameter param : compareMethod.getParameters()) {
      assertEquals("fantaisieTP1.protagonistes.Monstre<?>",param.getParameterizedType().getTypeName());
    }

  }

}
