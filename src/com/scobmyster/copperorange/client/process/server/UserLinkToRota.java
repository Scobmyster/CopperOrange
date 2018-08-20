package com.scobmyster.copperorange.client.process.server;

import com.google.gwt.user.client.Window;
import com.scobmyster.copperorange.client.OrangeServiceAsync;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.UserHolder;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.EnvelopeImpl;

public class UserLinkToRota implements ProcessModel
{

    private ScreenModelImpl screenModel;
    private UserHolder holder;
    private OrangeServiceAsync service;

    @Override
    public void runProcess()
    {
        Envelope envelope = new EnvelopeImpl();
        envelope.setRotaLinkName(screenModel.getBt_Link().getSender().getText());
        envelope.setUserModel(holder.getCurrentUser());
        envelope.setRotaID(holder.getCurrentRotaID());
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
