package springpuzzles.aopproxies.impl;

import springpuzzles.aopproxies.LdapService;
import springpuzzles.aopproxies.MailService;
import springpuzzles.aopproxies.RegisterService;


/**
 * @author: ecamacho
 * javahispano 2010
 */
public class RegisterServiceImpl implements RegisterService {
    
    private MailService mailService = new MailServiceImpl();

    private LdapService ldapService;

    public void setMailServer(String mailServer) {
        this.mailService.setMailServer( mailServer );
    }

    
    public void setLdapService(LdapService ldapService) {
        this.ldapService = ldapService;
    }

    public void setMailAndLdapService( String mailServer, LdapService ldapService ) {
        setMailServer( mailServer );
        setLdapService( ldapService ); 
    }

    
}
