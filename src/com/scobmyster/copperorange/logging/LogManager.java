package com.scobmyster.copperorange.logging;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogManager
{

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    String name = "log-" + dateFormat.format(date);

    public void log(String msg)
    {
        File f = new File("C:\\Users\\jaas  c\\Desktop\\" + name);
        try {
            if(!f.exists())
                f.createNewFile();
            FileWriter writer = new FileWriter(f.getPath(), true);
            PrintWriter print_line = new PrintWriter(writer);
            print_line.printf("%s" + "%n", dateFormat.format(date) + ">>> " + msg);
            print_line.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
