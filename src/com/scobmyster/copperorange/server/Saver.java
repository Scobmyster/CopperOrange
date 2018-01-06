package com.scobmyster.copperorange.server;

import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.Rota;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Saver {

    public Envelope save(Envelope envelope)
    {
        System.out.println("Saver.save: START");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy HH-mm-ss");
        Date date = new Date();
        String dateToStr = dateFormat.format(date);

        String naming = envelope.getFileSaveName();
        String path = envelope.getUserModel().getDs_loc() + naming + ".xml";


            System.out.println("Saver.save: Checking for datastore");
            if (!new File(envelope.getUserModel().getDs_loc()).exists())
                createDatastore(envelope.getUserModel().getDs_loc());
            File file = new File(path);
            if (file.exists())
            {
                System.out.println("Saver.save: Beginining to copy old file");
                FileInputStream ins = null;
                FileOutputStream outs = null;
                String rewritePath = envelope.getUserModel().getDs_loc()+ "/" + naming + "(" + dateToStr + ")" + ".xml";
                File copyFile = new File(rewritePath);
                try
                {
                    ins = new FileInputStream(file);
                    outs = new FileOutputStream(copyFile);
                    byte[] buffer = new byte[1024];
                    int length;

                    while ((length = ins.read(buffer)) > 0)
                    {
                        outs.write(buffer, 0, length);
                    }

                    ins.close();
                    outs.close();
                    System.out.println("File copied successfully");
                    if (new File(path).delete())
                    {
                        System.out.println("Deleted file");
                    }
                    else
                    {
                        System.out.println("Error trying to delete file");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }

                File fileNew = new File(path);

                try
                {
                    System.out.println("Saver.save: Saved file to via overwrite: " + fileNew.getAbsolutePath());
                    JAXBContext jaxbContext = JAXBContext.newInstance(Rota.class);
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                    jaxbMarshaller.marshal(envelope.getRotaModel(), fileNew);
                    jaxbMarshaller.marshal(envelope.getRotaModel(), System.out);
                } catch (JAXBException jax) {
                    jax.printStackTrace();
                    System.out.println(jax.getMessage());
                }

            }
            else
            {
                try
                {
                    System.out.println("Saver.save: Saved file to via new: " + file.getAbsolutePath());
                    JAXBContext jaxbContext = JAXBContext.newInstance(Rota.class);
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                    jaxbMarshaller.marshal(envelope.getRotaModel(), file);
                    jaxbMarshaller.marshal(envelope.getRotaModel(), System.out);
                } catch (JAXBException jax) {
                    jax.printStackTrace();
                    System.out.println(jax.getMessage());
                }
            }

        return envelope;
    }

    private void createDatastore(String path)
    {
        System.out.println("Saver.createDatastore: Datastore creation : " + new File(path).mkdir());
    }


}
