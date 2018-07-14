package com.scobmyster.copperorange.client.process.server;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.client.OrangeServiceAsync;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.UserHolder;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.EnvelopeImpl;

public class GroupFetchMyGroups implements ProcessModel
{

    private ScreenModelImpl screenModel;
    private UserHolder holder;
    private OrangeServiceAsync service;

    @Override
    public void runProcess()
    {
        screenModel.getLogBox().logMessage("Running the runProcess for fetchMyGroups");
        Envelope envelope = new EnvelopeImpl();
        envelope.setUserModel(holder.getCurrentUser());
        service.groupFetchMyGroups(envelope, new AsyncCallback<Envelope>()
        {
            @Override
            public void onFailure(Throwable throwable)
            {
                screenModel.getLogBox().logMessage("Failed to fetch my groups for user: " + holder.getCurrentUser().getUsername());
            }

            @Override
            public void onSuccess(Envelope envelope)
            {
                screenModel.getLogBox().logMessage("Succeeded to fetch my groups for user: " + holder.getCurrentUser().getUsername());
                screenModel.getMyGroups().setRowCount(envelope.getMyGroupNames().size(), true);
                screenModel.getMyGroups().setRowData(0, envelope.getMyGroupNames());
            }
        });
    }

    public void setScreenModel(ScreenModelImpl screenModel)
    {
        this.screenModel = screenModel;
    }

    public void setHolder(UserHolder holder)
    {
        this.holder = holder;
    }

    public void setService(OrangeServiceAsync service)
    {
        this.service = service;
    }
}
