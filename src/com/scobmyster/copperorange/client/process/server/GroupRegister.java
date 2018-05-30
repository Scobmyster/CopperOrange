package com.scobmyster.copperorange.client.process.server;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.client.ClientSideHandler;
import com.scobmyster.copperorange.client.OrangeServiceAsync;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.UserHolder;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.EnvelopeImpl;
import com.scobmyster.copperorange.shared.User;

public class GroupRegister implements ProcessModel
{

    private ScreenModelImpl screenModel;
    private OrangeServiceAsync service;
    private UserHolder holder;
    private ClientSideHandler handler;

    @Override
    public void runProcess()
    {
        Envelope envelope  = new EnvelopeImpl();
        envelope.setUserModel(holder.getCurrentUser());
        envelope.setGroupName(screenModel.getGroupName().getText());
        service.registerGroup(envelope, new AsyncCallback<Envelope>()
        {
            @Override
            public void onFailure(Throwable throwable)
            {
                screenModel.getLogBox().logMessage("Error on: " + getClass().getName() + " failed server call with: " + throwable.getStackTrace());
            }

            @Override
            public void onSuccess(Envelope envelope)
            {
                if(envelope.getCreated())
                {
                    holder.getCurrentUser().setGroupName(envelope.getGroupName());
                    screenModel.getPop_GroupRegister().hide();
                }
                else
                {
                    screenModel.getLogBox().logMessage("Error on creation of a group that was not caught on callback");
                }
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

    public void setUserHolder(UserHolder holder)
    {
        this.holder = holder;
    }

    public void setHandler(ClientSideHandler handler)
    {
        this.handler = handler;
    }
}


