package springpuzzles.aopproxies;

/**
 * @author: ecamacho
 * javahispano 2010
 */
public interface RegisterService {

    void setMailServer(String mailServer);
         
    void setLdapService(LdapService ldapService);

    void setMailAndLdapService( String mailServer, LdapService ldapService );
}
