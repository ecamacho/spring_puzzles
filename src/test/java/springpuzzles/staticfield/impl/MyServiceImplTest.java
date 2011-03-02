package springpuzzles.staticfield.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springpuzzles.staticfield.MyService;

/**
 * @author: ecamacho
 * javahispano 2010
 */
@RunWith(SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = "classpath:springpuzzles/staticfield/test-staticfield-context.xml")
public class MyServiceImplTest {

    private static final String EXPECTED_RESULT = "mi constante";
        
    @Autowired
    private MyService myService;

    /**
     * Este test fallara porque Spring por decision de diseno no inyecta valores a variables
     * estaticas
     */
    @Test
    public void testProccessUsingConstant() {
        String result = myService.processUsingConstant();
        assertEquals(EXPECTED_RESULT, result);

    }
}
