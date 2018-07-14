package com.scobmyster.copperorange.client.process.server;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.client.ModelTranslator;
import com.scobmyster.copperorange.client.OrangeServiceAsync;
import com.scobmyster.copperorange.client.UserHolder;
import com.scobmyster.copperorange.shared.Rota;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.EnvelopeImpl;

public class RotaSaveImpl implements ProcessModel {

    private ScreenModelImpl screenModel = new ScreenModelImpl();
    private OrangeServiceAsync service;
    private UserHolder holder;




    @Override
    public void runProcess()
    {
        screenModel.getSavePop().hide();
        Rota rotaModel = new Rota();
        new ModelTranslator().translate(this.screenModel, rotaModel);
        Envelope envelope = new EnvelopeImpl();
        envelope.setRotaModel(rotaModel);
        envelope.setAddress("saveRota");
        envelope.setFileSaveName(screenModel.getSaveNameBox().getText());
        envelope.setUserModel(holder.getCurrentUser());
        if(screenModel.getCk_SaveForGroup().isChecked())
        {
            envelope.setSaveForGroup(true);
            envelope.setGroupName(holder.getCurrentGroup().getGroupName());
        }
        else
            envelope.setSaveForGroup(false);
        screenModel.getSavePop().setVisible(false);
        service.saveRota(envelope, new AsyncCallback<Envelope>() {
            @Override
            public void onFailure(Throwable throwable)
            {
                Window.alert("Failed to save the rota");
            }

            @Override
            public void onSuccess(Envelope envelope)
            {

            }
        });
    }

    public void setScreenModel(ScreenModelImpl screenModel) {
        this.screenModel = screenModel;
    }

    public void setService(OrangeServiceAsync service) {
        this.service = service;
    }

    public void setHolder(UserHolder holder)
    {
        this.holder = holder;
    }
}
