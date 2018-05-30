package com.scobmyster.copperorange.client.process.server;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.client.OrangeServiceAsync;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.UserHolder;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.EnvelopeImpl;

public class GroupJoinGroup implements ProcessModel
{

    private ScreenModelImpl screenModel;
    private OrangeServiceAsync service;
    private UserHolder holder;

    @Override
    public void runProcess()
    {
        Envelope envelope  = new EnvelopeImpl();
        envelope.setGroupName(screenModel.getSelectedGroupToLoad());
        envelope.setUserModel(holder.getCurrentUser());
        service.joinGroup(envelope, new AsyncCallback<Envelope>()
        {
            @Override
            public void onFailure(Throwable throwable)
            {
                screenModel.getLogBox().logMessage("Attempt to join group has failed \n has thrown an error of: " + throwable.getMessage());
            }

            @Override
            public void onSuccess(Envelope envelope)
            {
                screenModel.getLogBox().logMessage("Attempt to join group has succeded");
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
}
