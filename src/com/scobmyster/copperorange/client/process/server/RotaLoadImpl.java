package com.scobmyster.copperorange.client.process.server;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.client.*;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.client.widgets.OrangeTableCell;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.EnvelopeImpl;
import com.scobmyster.copperorange.shared.Rota;

public class RotaLoadImpl implements ProcessModel
{

    private ScreenModelImpl screenModel;
    private OrangeServiceAsync service;
    private Envelope envelope = new EnvelopeImpl();
    private Rota rota = new Rota();
    private ClientSideHandler handler;
    private UserHolder holder;

    @Override
    public void runProcess()
    {
        screenModel.getLoadPop().hide();
        envelope.setRotaModel(rota);
        envelope.setAddress("loadRota");
        envelope.setRotaLoadName(screenModel.getSelectedFileToLoad());
        envelope.setUserModel(holder.getCurrentUser());
        handler.handleEvent(screenModel.getNewButton().getEventID());
        service.loadRota(envelope, new AsyncCallback<Envelope>() {
            @Override
            public void onFailure(Throwable throwable)
            {
                screenModel.getLogBox().logMessage("Failure for loadup");
            }

            @Override
            public void onSuccess(Envelope envelope)
            {
                new ModelTranslator().translate(envelope.getRotaModel(), screenModel);
            }
        });
    }

    public void setScreenModel(ScreenModelImpl screenModel) {
        this.screenModel = screenModel;
    }

    public void setService(OrangeServiceAsync service) {
        this.service = service;
    }

    public void setHandler(ClientSideHandler handler)
    {
        this.handler = handler;
    }

    public void setHolder(UserHolder holder)
    {
        this.holder = holder;
    }
}
