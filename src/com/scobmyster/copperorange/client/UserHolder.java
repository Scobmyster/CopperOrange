package com.scobmyster.copperorange.client;

import com.scobmyster.copperorange.shared.User;

public class UserHolder
{

    private User currentUser = new User();

    public User getCurrentUser()
    {
        return currentUser;
    }

    public void setCurrentUser(User currentUser)
    {
        this.currentUser = currentUser;
    }

}
