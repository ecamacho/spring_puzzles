package springpuzzles.staticfield.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import springpuzzles.staticfield.MyService;



/**
 * @author: ecamacho
 * javahispano 2010
 */
@Service("myService")
public class MyServiceImpl implements MyService {


    @Value("#{'mi constante'}")
    private static String MY_CONSTANT;

    public String processUsingConstant() {
        return MY_CONSTANT;    
    }
}

