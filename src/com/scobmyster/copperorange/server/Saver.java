package com.scobmyster.copperorange.server;

import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.Rota;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Saver {

    public Envelope save(Envelope envelope) {
        System.out.println("Saver.save: START");
        String slash = ".";
        DateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm:ss");
        Date date = new Date();
        String naming = envelope.getFileSaveName();
        System.out.println("Saver save: "+ "C:/gwt-2.8.1/CopperOrange/ds/" + naming);
        try {
            System.out.println("Saver.save: I am trying to write an xml file");
            if (!new File("ds").exists())
                createDatastore();
            File file = new File("C:/gwt-2.8.1/CopperOrange/ds/" + naming + ".xml");
            System.out.println("Saver.save: Saved file to : " + file.getAbsolutePath());
            JAXBContext jaxbContext = JAXBContext.newInstance(Rota.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(envelope.getRotaModel(), file);
            jaxbMarshaller.marshal(envelope.getRotaModel(), System.out);
        } catch (JAXBException jax)
        {
            jax.printStackTrace();
            System.out.println(jax.getMessage());
        }

        return envelope;
    }

    private void createDatastore()
    {
        System.out.println("Saver.createDatastore: Datastore creation : " + new File("ds").mkdir());
    }

}
