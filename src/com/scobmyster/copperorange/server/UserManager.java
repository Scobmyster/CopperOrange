package com.scobmyster.copperorange.server;

import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.Rota;
import com.scobmyster.copperorange.shared.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserManager
{

    private User userModel;
    private List<User> userbase = new ArrayList<>();

    public Envelope loginUser(Envelope envelope)
    {
        userModel = envelope.getUserModel();
        populateUserBase();
        envelope.setUserGreenlight(checkUserValid(userModel));
        envelope.setUserModel(userModel);
        return envelope;
    }

    public boolean checkUserValid(User userModel)
    {
        boolean correctName = false;
        boolean correctPassword = false;
        boolean userValid = false;

        for(User user : userbase)
        {
            if(userModel.getUsername().equals(user.getUsername()))
            {
                correctName = true;
            }
            if(userModel.getPassword().equals(user.getPassword()))
            {
                correctPassword = true;
            }
        }

        if(correctName && correctPassword)
        {
            userValid = true;
            for(User user : userbase)
            {
                if(userModel.getUsername().equals(user.getUsername()))
                {
                    userModel.setDs_loc(user.getDs_loc());
                }
            }
        }
        return userValid;
    }

    public void populateUserBase()
    {
        userbase.clear();
        File[] filesInTargetDirectory = new File("C:/gwt-2.8.1/CopperOrange/users/").listFiles();
        for(File file : filesInTargetDirectory)
        {
            try
            {
                JAXBContext jaxbContext = JAXBContext.newInstance(User.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                User user = (User) jaxbUnmarshaller.unmarshal(file);
                userbase.add(user);
            } catch (JAXBException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("User base is populated");
    }

    public void registerUser(Envelope envelope)
    {
        userModel = envelope.getUserModel();
        populateUserBase();
        if(checkUserCanRegister(userModel) == true)
        {
            System.out.println("Registering the user");
            String regPath = ("C:/gwt-2.8.1/CopperOrange/users/" + userModel.getUsername() + ".xml");
            userModel.setDs_loc("C:/gwt-2.8.1/CopperOrange/ds/" + userModel.getUsername() + "/");
            try
            {
                File file = new File(regPath);
                JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                System.out.println("Saving to: " + file.getAbsolutePath());
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                jaxbMarshaller.marshal(envelope.getUserModel(), file);
                jaxbMarshaller.marshal(envelope.getUserModel(), System.out);
            }
            catch (JAXBException e)
            {
                e.printStackTrace();
            }
            envelope.setUserGreenlight(true);
        }
        else
        {
            System.out.println("Username already taken");
            envelope.setUserGreenlight(false);
        }
    }

    public boolean checkUserCanRegister(User userModel)
    {
        boolean registerValid = false;
        for(User user : userbase)
        {
            if(userModel.getUsername().equals(user.getUsername()))
            {
                System.out.println("Register Invalid: " + userModel.getUsername());
                registerValid = false;
            }
            else
            {
                System.out.println("Register Valid: " + userModel.getUsername());
                registerValid = true;
            }
        }
        return registerValid;
    }
}


