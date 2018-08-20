package com.scobmyster.copperorange.server;

import com.scobmyster.copperorange.client.process.client.RotaCancelSaveRotaImpl;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.Group;
import com.scobmyster.copperorange.shared.Rota;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Loader
{

    private GroupManager groupManager;

    public Envelope load(Envelope envelope)
    {
        Rota rota = envelope.getRotaModel();
        String loadName = envelope.getGroup().getID() + "_" + envelope.getRotaLoadName();
        System.out.println("Loading up rota: " + loadName);
       
            try
            {
                File file = new File(envelope.getGroup().getDs_loc() + loadName);
                JAXBContext jaxbContext = JAXBContext.newInstance(Rota.class);

                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                rota = (Rota) jaxbUnmarshaller.unmarshal(file);
            } catch (JAXBException e)
            {
                e.printStackTrace();
                e.getMessage();
            }
            envelope.setRotaModel(rota);

       
        return envelope;
    }

    public Envelope populateList(Envelope envelope)
    {
        System.out.println("Populating list for file names");
        File[] filesInTargetDirectory = new File(envelope.getGroup().getDs_loc()).listFiles();
        List<String> fileNames = new ArrayList<>();
        if(filesInTargetDirectory != null)
        {
            for (File file : filesInTargetDirectory)
            {
                String cutFileName = stripOffFileExtension(file.getName());
                fileNames.add(cutFileName);
            }
        }

        envelope.setRotaFileNames(fileNames);

        return envelope;
    }

    public boolean FileWithinUserDir(String filename, Envelope envelope)
    {
        File[] filesInUserSaveDir = new File(envelope.getUserModel().getDs_loc()).listFiles();
        if(filesInUserSaveDir != null)
        {
            for (File file : filesInUserSaveDir)
            {
                if(file.getName().equalsIgnoreCase(filename))
                    return true;
            }
        }
        return false;
    }

    public String stripOffFileExtension(String fileName)
    {
    	String[] result = fileName.split("_");
        return result[1];
    }

    public void setGroupManager(GroupManager groupManager)
    {
        this.groupManager = groupManager;
    }
}
