package com.scobmyster.copperorange.client;

import com.scobmyster.copperorange.shared.Group;
import com.scobmyster.copperorange.shared.User;

public class UserHolder
{

    private User currentUser = new User();
    private Group currentGroup = new Group();
    private String currentRotaID = "00";

    public User getCurrentUser()
    {
        return currentUser;
    }

    public void setCurrentUser(User currentUser)
    {
        this.currentUser = currentUser;
    }

    public Group getCurrentGroup()
    {
        return currentGroup;
    }

    public void setCurrentGroup(Group currentGroup) {
        this.currentGroup = currentGroup;
    }

    public String getCurrentRotaID()
    {
        return currentRotaID;
    }

    public void setCurrentRotaID(String currentRotaID)
    {
        this.currentRotaID = currentRotaID;
    }
}
