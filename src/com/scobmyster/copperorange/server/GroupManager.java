package com.scobmyster.copperorange.server;

import com.scobmyster.copperorange.shared.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.*;

public class GroupManager
{

    private List<Group> groupBase = new ArrayList<Group>();
    private UserManager userManager;
    private GroupID groupID = new GroupID();

    public void RegisterGroup(Envelope envelope)
    {
        String name = envelope.getGroupName();
        User user = envelope.getUserModel();

        PopulateGroupBase();

        if(user == null)
            System.out.println("User is actaully null");

        if (GroupValid(name))
        {
            //Set group details
            System.out.println("Registering the group");
            Group group = new Group();
            String regPath = ("C:/gwt-2.8.1/CopperOrange/groups/" + groupID.getId() + ".xml");
            group.setDs_loc("C:/gwt-2.8.1/CopperOrange/ds/" + groupID.getId() + "/");
            group.setGroupName(name);
            group.setID(groupID.getId());
            //Make user admin
            List<String> groupUser = new ArrayList<>();
            groupUser.add(user.getUsername());
            group.setGroupUsers(groupUser.toArray(new String[groupUser.size()]));
            GroupRoles roles = new GroupRoles();
            Admin admins = new Admin();
            List<String> copyOfAdmins = new LinkedList<>(Arrays.asList(admins.getAdmins()));
            copyOfAdmins.add(user.getUsername());
            admins.setAdmins(copyOfAdmins.toArray(new String[copyOfAdmins.size()]));
            roles.setAdmins(admins);
            group.setRolesOfThisGroup(roles);
            //Update user profile to know it is in this new group
            user.AddToMyGroups(name);
            userManager.SaveUserChanges(user);
            System.out.println("User name is: " + user.getUsername());
            System.out.println("Creation user for the group is: " + group.getGroupUsers()[0]);
            System.out.println("List user is: " + groupUser.get(0));
            try
            {
                File file = new File(regPath);
                JAXBContext jaxbContext = JAXBContext.newInstance(Group.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                System.out.println("Saving to: " + file.getAbsolutePath());
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                jaxbMarshaller.marshal(group, file);
                jaxbMarshaller.marshal(group, System.out);
            }
            catch (JAXBException e)
            {
                e.printStackTrace();
            }
            envelope.setCreated(true);
        }
        else
        {
            System.out.println("Group name already taken");
            envelope.setCreated(false);
        }

    }

    public void PopulateGroupBase()
    {
        groupBase.clear();
        File[] filesInTargetDirectory = new File("C:/gwt-2.8.1/CopperOrange/groups/").listFiles();
        if(filesInTargetDirectory == null)
            return;
        for (File file : filesInTargetDirectory)
        {
            try
            {
                JAXBContext jaxbContext = JAXBContext.newInstance(Group.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                Group group = (Group) jaxbUnmarshaller.unmarshal(file);
                groupBase.add(group);
            } catch (JAXBException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Group base is populated");
    }

    public boolean GroupValid(String groupName)
    {

        if(groupName.equals(" ") || groupName == null)
            return false;

        if(groupBase.isEmpty())
            return true;

        for(Group group : groupBase)
        {
            if(group.getGroupName() == groupName)
                return false;
        }

        return true;
    }

    public void AddUserToGroup(Envelope envelope)
    {
        User user = envelope.getUserModel();
        String groupName = envelope.getGroupName();
        Group group = GetGroupFromName(groupName);
        if(group == null)
            return;
        if(group.getGroupUsers() == null)
        {
            System.out.println("The group : " + groupName + "'s group users is equals null this shouldn't be there should always be a user for creation");
            return;
        }
        List<String> groupUsers = new LinkedList<>(Arrays.asList(group.getGroupUsers()));
        for(String username : groupUsers)
        {
            if(user.getUsername().equals(username))
            {
                System.out.println("ERROR IN ADDUSERTOGROUP: The server is attempting to add a user to a group which already has that user listed the user is " + username + " and the group in question" +
                        " is " + groupName);
                return;
            }
        }
        groupUsers.add(user.getUsername());
        group.setGroupUsers(groupUsers.toArray(new String[groupUsers.size()]));

        GroupRoles roles = group.getRolesOfThisGroup();
        Member members = roles.getMembers();
        List<String> copyOfMembers = new LinkedList<>(Arrays.asList(members.getMembers()));
        copyOfMembers.add(user.getUsername());
        members.setMembers(copyOfMembers.toArray(new String[copyOfMembers.size()]));
        roles.setMembers(members);
        group.setRolesOfThisGroup(roles);
        WriteChangesToGroupFile(group);
    }

    public void WriteChangesToGroupFile(Group group)
    {
        System.out.println("Registering the group");
        String regPath = ("C:/gwt-2.8.1/CopperOrange/groups/" + group.getID() + ".xml");
        try
        {
            File file = new File(regPath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Group.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            System.out.println("Saving to: " + file.getAbsolutePath());
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(group, file);
            jaxbMarshaller.marshal(group, System.out);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }

    public void FetchGroups(Envelope envelope)
    {
        String prefix = envelope.getSearchPrefix();

        File[] filesInTargetDirectory = new File("C:/gwt-2.8.1/CopperOrange/groups/").listFiles();
        List<String> groupResult = new ArrayList<>();
        for (File file : filesInTargetDirectory)
        {
            System.out.println("Reading file: " + file.getName());
            Group group = LoadGroupFromFile(file);
            if(group.getGroupName().contains(prefix))
            {
            	groupResult.add(group.getGroupName());
            }
        }
        envelope.setGroupFileNames(groupResult);
    }

    public Group GetGroupFromName(String groupName)
    {
        PopulateGroupBase();
        for(Group group : groupBase)
        {
            System.out.println("Group: " + group.getGroupName());
            System.out.println("My Group Name: " + groupName);
            if(group.getGroupName().equals(groupName))
            {
                return group;
            }
        }

        System.out.println("No group for this name: " + groupName);
        return null;
    }

    public List<String> GrabMyGroups(Envelope envelope)
    {
        User user = envelope.getUserModel();
        List<String> groups = Arrays.asList(user.getMyGroups());
        return groups;
    }

    public String stripOffFileExtension(String fileName)
    {
        return fileName.replaceAll(".xml", "");
    }
    
    public Group LoadGroupFromFile(File file)
    {
    	Group group = new Group();
    	
    	 try
         {
             JAXBContext jaxbContext = JAXBContext.newInstance(Group.class);

             Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
             group = (Group) jaxbUnmarshaller.unmarshal(file);
         } catch (JAXBException e)
         {
             e.printStackTrace();
         }
    	 return group;
    }

    public void setUserManager(UserManager userManager)
    {
        this.userManager = userManager;
    }
}
