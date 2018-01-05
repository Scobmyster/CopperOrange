package com.scobmyster.copperorange.client.process.server;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.client.ClientSideHandler;
import com.scobmyster.copperorange.client.ModelTranslator;
import com.scobmyster.copperorange.client.OrangeServiceAsync;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.client.widgets.OrangeTableCell;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.EnvelopeImpl;
import com.scobmyster.copperorange.shared.Rota;

public class RotaLoadImpl implements ProcessModel
{

    private ScreenModelImpl screenModel;
    private OrangeServiceAsync service;
    private String rotaLoadName;
    private Envelope envelope = new EnvelopeImpl();
    private Rota rota = new Rota();
    private ClientSideHandler handler;

    @Override
    public void runProcess()
    {
        screenModel.getLoadPop().hide();
        envelope.setRotaModel(rota);
        envelope.setAddress("loadRota");
        envelope.setRotaLoadName(screenModel.getSelectedFileToLoad());
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
}
