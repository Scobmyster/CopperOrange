package com.scobmyster.copperorange.client;

import com.scobmyster.copperorange.shared.Group;
import com.scobmyster.copperorange.shared.User;

public class UserHolder
{

    private User currentUser = new User();
    private Group currentGroup = new Group();

    public User getCurrentUser()
    {
        return currentUser;
    }

    public void setCurrentUser(User currentUser)
    {
        this.currentUser = currentUser;
    }

    private Group getCurrentGroup()
    {
        return currentGroup;
    }

    public void setCurrentGroup(Group currentGroup) {
        this.currentGroup = currentGroup;
    }
}
