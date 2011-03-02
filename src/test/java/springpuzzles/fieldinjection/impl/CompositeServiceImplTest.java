package springpuzzles.fieldinjection.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springpuzzles.fieldinjection.CompositeService;

/**
 * @author: ecamacho
 * javahispano 2010
 */
@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = "classpath:springpuzzles/fieldinjection/test-fieldinjection-context.xml")
public class CompositeServiceImplTest {

    @Autowired
    private CompositeService compositeService;

    /**
     * Spring mandara un error en fase de inicializacion marcando
     * java.lang.IllegalArgumentException: argument type mismatch
	 * dado que la dependencia es contra la clase concreta y no contra la interfaz
     * Dado que Spring AOP crea un proxy dinamico que implementa la interfaz de negocio,
     * no se puede hacer un cast a la clase concreta
     */
    @Test
    public void testDoSomething() {
         compositeService.doSomething();
    }
}
