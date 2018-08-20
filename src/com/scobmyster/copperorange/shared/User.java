package com.scobmyster.copperorange.shared;

import com.google.gwt.user.client.Window;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement
public class User implements Serializable
{
    private String username;
    private String password;
    private String ds_loc;
    private String[] myGroups = new String[]{};
    private Link[] links = new Link[] {};
    
    public String getUsername()
    {
        return username;
    }
    @XmlElement
    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }
    @XmlElement
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getDs_loc()
    {
        return ds_loc;
    }
    @XmlElement
    public void setDs_loc(String ds_loc)
    {
        this.ds_loc = ds_loc;
    }

    public String[] getMyGroups() { return myGroups; }
    @XmlElement
    public void setMyGroups(String[] myGroups){ this.myGroups = myGroups; }
    
    public Link[] getLinks()
    {
 	   return links;
    }
    @XmlElement
    public void setLinks(Link[] links)
    {
 	   this.links = links;
    }

    public String FindGroupByName(String name)
    {
        for(String groupName : myGroups)
        {
            if(groupName.equalsIgnoreCase(name))
            {
                return groupName;
            }
        }
        Window.alert("Failure");
        return null;
    }

    public String FindGroupByID(int id)
    {
        for(int i = 0; i < myGroups.length; i++)
        {
            if(i == id)
            {
                return myGroups[i];
            }
        }
        return null;
    }

    public void AddToMyGroups(String groupToAdd)
    {
        List<String> copyOfMyGroups = new LinkedList<>(Arrays.asList(myGroups));
        copyOfMyGroups.add(groupToAdd);
        setMyGroups(copyOfMyGroups.toArray(new String[copyOfMyGroups.size()]));
    }
    
    public void AddToLinks(Link linkToAdd)
    {
    	List<Link> copyOfLinks = new LinkedList<>(Arrays.asList(links));
    	copyOfLinks.add(linkToAdd);
    	setLinks(copyOfLinks.toArray(new Link[copyOfLinks.size()]));
    }



}
