package com.scobmyster.copperorange.server;

import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.Group;
import com.scobmyster.copperorange.shared.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GroupManager
{

    private List<Group> groupBase = new ArrayList<Group>();

    public void RegisterGroup(Envelope envelope)
    {
        String name = envelope.getGroupName();
        User user = envelope.getUserModel();

        PopulateGroupBase();

        if(user == null)
            System.out.println("User is actaully null");

        if (GroupValid(name))
        {
            System.out.println("Registering the group");
            Group group = new Group();
            String regPath = ("C:/gwt-2.8.1/CopperOrange/groups/" + name + ".xml");
            group.setDs_loc("C:/gwt-2.8.1/CopperOrange/ds/" + name + "/");
            group.setGroupName(name);
            List<String> groupUser = new ArrayList<>();
            groupUser.add(user.getUsername());
            group.setGroupUsers(groupUser.toArray(new String[groupUser.size()]));
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
            if(username.equals(groupUsers))
            {
                System.out.println("ERROR IN ADDUSERTOGROUP: The server is attempting to add a user to a group which already has that user listed the user is " + username + " and the group in question" +
                        " is " + groupName);
                return;
            }
        }
        groupUsers.add(user.getUsername());
        group.setGroupUsers(groupUsers.toArray(new String[groupUsers.size()]));
        WriteChangesToGroupFile(group);
    }

    public void WriteChangesToGroupFile(Group group)
    {
        System.out.println("Registering the group");
        String regPath = ("C:/gwt-2.8.1/CopperOrange/groups/" + group.getGroupName() + ".xml");
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
        List<String> fileNames = new ArrayList<>();
        for (File file : filesInTargetDirectory)
        {
            System.out.println("Reading file: " + file.getName());
            if(file.getName().contains(prefix))
            {
                String cutFileName = stripOffFileExtension(file.getName());
                System.out.println("Found matched name: " + cutFileName);
                fileNames.add(cutFileName);
            }
        }
        envelope.setGroupFileNames(fileNames);
    }

    public Group GetGroupFromName(String groupName)
    {
        PopulateGroupBase();
        for(Group group : groupBase)
        {
            if(group.getGroupName().equals(groupName))
            {
                return group;
            }
        }

        System.out.println("No group for this name: " + groupName);
        return null;
    }

    public String stripOffFileExtension(String fileName)
    {
        return fileName.replaceAll(".xml", "");
    }
}
