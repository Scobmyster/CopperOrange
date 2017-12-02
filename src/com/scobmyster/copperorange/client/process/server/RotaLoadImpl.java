package com.scobmyster.copperorange.client.process.server;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.client.ModelTranslator;
import com.scobmyster.copperorange.client.OrangeServiceAsync;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.process.ProcessModel;
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

    @Override
    public void runProcess()
    {
        Window.alert("Running process: " + this.getClass().getName());
        envelope.setRotaModel(rota);
        envelope.setAddress("loadRota");
        envelope.setRotaLoadName(screenModel.getLoadNameBox().getText());
        service.loadRota(envelope, new AsyncCallback<Envelope>() {
            @Override
            public void onFailure(Throwable throwable)
            {
                Window.alert("Failure");
            }

            @Override
            public void onSuccess(Envelope envelope)
            {
                new ModelTranslator().translate(envelope.getRotaModel(), screenModel);
                Window.alert("Success on the load apparently");
            }
        });
    }

    public void setScreenModel(ScreenModelImpl screenModel) {
        this.screenModel = screenModel;
    }

    public void setService(OrangeServiceAsync service) {
        this.service = service;
    }
}
