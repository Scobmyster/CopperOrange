package com.scobmyster.copperorange.client.process.server;


import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.client.ClientSideHandler;
import com.scobmyster.copperorange.client.OrangeServiceAsync;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.UserHolder;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.EnvelopeImpl;

public class UserSetupService implements ProcessModel
{

    private ScreenModelImpl screenModel;
    private OrangeServiceAsync service;
    private UserHolder holder;
    private ClientSideHandler handler;

    @Override
    public void runProcess()
    {
        Envelope envelope = new EnvelopeImpl();
        envelope.setUserModel(holder.getCurrentUser());
        service.userSetupService(envelope, new AsyncCallback<Envelope>()
        {
            @Override
            public void onFailure(Throwable throwable)
            {
                screenModel.getLogBox().logMessage("Failed to complete the user setup service");
            }

            @Override
            public void onSuccess(Envelope envelope)
            {
                holder.setCurrentGroup(envelope.getGroup());
                if(holder.getCurrentGroup() != null)
                {
                	screenModel.getCurrentGroup().setText(holder.getCurrentGroup().getGroupName());
                }
               
                handler.handleEvent("fetchFiles");
            }
        });
    }

    public void setScreenModel(ScreenModelImpl screenModel)
    {
        this.screenModel = screenModel;
    }

    public void setService(OrangeServiceAsync service)
    {
        this.service = service;
    }

    public void setHolder(UserHolder holder)
    {
        this.holder = holder;
    }
    
    public void setHandler(ClientSideHandler handler)
    {
    	this.handler = handler;
    }
}
