package springpuzzles.aopproxies.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springpuzzles.aopproxies.LdapService;
import springpuzzles.aopproxies.MailService;
import springpuzzles.aopproxies.RegisterService;

/**
 * @author: ecamacho
 * javahispano 2010
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springpuzzles/aopproxies/test-aopproxies-context.xml")
public class RegisterServiceImplTest {

    @Autowired
    RegisterService registerService;

    @Autowired
    LdapService ldapService;

    @Test
    public void testAopAspects() {
        registerService.setMailServer( "smtp.host" );
        registerService.setLdapService( ldapService );
        registerService.setMailAndLdapService( "otherSmtp.host", ldapService );
    }
    
}
