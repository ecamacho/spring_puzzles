package springpuzzles.aopproxies.impl;

import springpuzzles.aopproxies.MailService;

/**
 * @author: ecamacho
 * javahispano 2010
 */
public class MailServiceImpl implements MailService {

    private String mailServer;

    public void setMailServer(String mailServer) {
        this.mailServer = mailServer;
    }
}
