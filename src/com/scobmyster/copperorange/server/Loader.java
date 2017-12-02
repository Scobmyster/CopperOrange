package com.scobmyster.copperorange.server;

import com.scobmyster.copperorange.client.process.client.RotaCancelSaveRotaImpl;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.Rota;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Loader {

    public Envelope load(Envelope envelope)
    {
        Rota rota = envelope.getRotaModel();
        String loadName = envelope.getRotaLoadName();
        System.out.println("Loading up rota: " + loadName);
        try
        {
            File file = new File("C:/gwt-2.8.1/CopperOrange/ds/" + loadName + ".xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Rota.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            rota = (Rota) jaxbUnmarshaller.unmarshal(file);
        }
        catch(JAXBException e)
        {
            e.printStackTrace();
            e.getMessage();
        }
        envelope.setRotaModel(rota);
        return envelope;
    }

}
