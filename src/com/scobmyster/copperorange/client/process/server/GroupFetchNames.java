package com.scobmyster.copperorange.client.process.server;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.client.OrangeServiceAsync;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.EnvelopeImpl;

public class GroupFetchNames implements ProcessModel
{

    private ScreenModelImpl screenModel;
    private OrangeServiceAsync service;

    @Override
    public void runProcess()
    {
        Envelope envelope = new EnvelopeImpl();
        envelope.setSearchPrefix(screenModel.getGroupSearchBox().getText());
        if(screenModel.getCk_SearchAllRotas().isChecked())
            envelope.setSearchMode("All");
        else if(screenModel.getCk_SearchUserRotas().isChecked())
            envelope.setSearchMode("Users");
        else if(screenModel.getCk_SearchGroupRotas().isChecked())
            envelope.setSearchMode("Group");
        else
            envelope.setSearchMode("All");
        service.fetchGroupNames(envelope, new AsyncCallback<Envelope>()
        {
            @Override
            public void onFailure(Throwable throwable)
            {

            }

            @Override
            public void onSuccess(Envelope envelope)
            {
                screenModel.getGroupNames().setRowCount(envelope.getGroupFileNames().size(), true);
                screenModel.getGroupNames().setRowData(0, envelope.getGroupFileNames());
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
}
