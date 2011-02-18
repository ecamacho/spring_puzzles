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

    @Test
    public void testDoSomething() {
         compositeService.doSomething();
    }
}
