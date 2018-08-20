package com.scobmyster.copperorange.server;

import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.Link;
import com.scobmyster.copperorange.shared.User;

public class Linker
{
	private UserManager userManager = new UserManager();
	

    public void LinkUserAndRota(Envelope envelope)
    {
        String usernameOnRota = envelope.getRotaLinkName();
        User linkingUser = envelope.getUserModel();
        String linkingRotaID = envelope.getRotaID();
        
        Link link = new Link();
        link.setLinkName(usernameOnRota);
        link.setRotaID(linkingRotaID);
        
        linkingUser.AddToLinks(link);
        userManager.SaveUserChanges(linkingUser);
        
    }
    
    public void setUserManager(UserManager userManager)
    {
    	this.userManager = userManager;
    }

}
