package com.scobmyster.copperorange.client;

import com.google.gwt.user.client.Window;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.client.widgets.OrangeLoggingBox;

import java.util.HashMap;

public class ClientSideHandler
{
    private HashMap<String, ProcessModel> mapOfProcesses;
    private OrangeLoggingBox logbox;

    public void handleEvent(String eventID, String classname)
    {
       if(!mapOfProcesses.containsKey(eventID))
       {
           logbox.logMessage("No event found for ID: ".concat(eventID));
       }
       else
       {
          logbox.logMessage("Running process: ".concat(eventID) + " --- " + "from: ".concat(classname));
           ProcessModel subModel = mapOfProcesses.get(eventID);
           subModel.runProcess();
       }
    }

    public void setMapOfProcesses(HashMap mapOfProcesses)
    {
        this.mapOfProcesses = mapOfProcesses;
    }

    public void setLogBox(OrangeLoggingBox logbox)
    {
        this.logbox = logbox;
    }

}
