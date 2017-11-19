package com.scobmyster.copperorange.client;

import com.google.gwt.user.client.Window;
import com.scobmyster.copperorange.client.process.ProcessModel;

import java.util.HashMap;

public class ClientSideHandler
{
    private HashMap<String, ProcessModel> mapOfProcesses;

    public void handleEvent(String eventID)
    {
       if(!mapOfProcesses.containsKey(eventID))
       {
           Window.alert("No event found for ID: ".concat(eventID));
       }
       else
       {
           Window.alert("Running process: ".concat(eventID));
           ProcessModel subModel = mapOfProcesses.get(eventID);
           subModel.runProcess();
       }
    }

    public void setMapOfProcesses(HashMap mapOfProcesses)
    {
        this.mapOfProcesses = mapOfProcesses;
    }

}
