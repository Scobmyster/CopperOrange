package com.scobmyster.copperorange.client.process.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.client.ClientSideHandler;
import com.scobmyster.copperorange.client.OrangeServiceAsync;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.UserHolder;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.EnvelopeImpl;

public class GroupSwitch implements ProcessModel
{

    private UserHolder holder;
    private ScreenModelImpl screenModel;
    private OrangeServiceAsync service;

    @Override
    public void runProcess()
    {
        Envelope envelope = new EnvelopeImpl();
        envelope.setGroupName(screenModel.getSelectedGroupToSwitch());
        service.groupSwitch(envelope, new AsyncCallback<Envelope>()
        {
            @Override
            public void onFailure(Throwable throwable)
            {
                screenModel.getLogBox().logMessage("Failure to switch group");
            }

            @Override
            public void onSuccess(Envelope envelope)
            {
                screenModel.getLogBox().logMessage("Success to switch group");
                holder.setCurrentGroup(envelope.getGroup());
                screenModel.getCurrentGroup().setText(holder.getCurrentGroup().getGroupName());
            }
        });
    }

    public void setHolder(UserHolder holder)
    {
        this.holder = holder;
    }

    public void setScreenModel(ScreenModelImpl screenModel)
    {
        this.screenModel = screenModel;
    }

    public void setService(OrangeServiceAsync service)
    {
        this.service = service;
    }
}
