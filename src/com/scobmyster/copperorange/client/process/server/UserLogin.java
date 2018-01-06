package com.scobmyster.copperorange.client.process.server;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.client.*;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.EnvelopeImpl;
import com.scobmyster.copperorange.shared.User;

public class UserLogin implements ProcessModel {

    private ScreenModelImpl screenModel;
    private OrangeServiceAsync service;
    private UserHolder userHolder;
    private ClientSideHandler handler;

    @Override
    public void runProcess() {
        screenModel.getLogBox().logMessage("Logging in user: " + screenModel.getUsernameBox().getText());
        Envelope envelope = new EnvelopeImpl();
        User userModel = new User();
        new ModelTranslator().translate(this.screenModel, userModel);
        envelope.setUserModel(userModel);
        service.login(envelope, new AsyncCallback<Envelope>() {
            @Override
            public void onFailure(Throwable throwable) {
                screenModel.getLogBox().logMessage("Failure on login call");
            }

            @Override
            public void onSuccess(Envelope success) {
                screenModel.getLogBox().logMessage("Success on login call");
                screenModel.getLogBox().logMessage("Greenlight is: " + success.getUserGreenlight());
                if (success.getUserGreenlight() == true) {
                    screenModel.getRotaTable().setVisible(true);
                    screenModel.getNewButton().setVisible(true);
                    screenModel.getAddRowButton().setVisible(true);
                    screenModel.getRemoveRowButton().setVisible(true);
                    screenModel.getSaveButton().setVisible(true);
                    screenModel.getLoadButton().setVisible(true);
                    screenModel.getLoginPop().hide();
                    userHolder.setCurrentUser(success.getUserModel());
                    screenModel.getCurrentUser().setText(success.getUserModel().getUsername());
                    screenModel.getLogBox().logMessage("Users ds_loc is: " + success.getUserModel().getDs_loc());
                    handler.handleEvent("fetchFiles");
                } else {
                    screenModel.getLogBox().logMessage("Error username or password incorrect");
                    screenModel.getLoginErrorLabel().setVisible(true);
                }
            }
        });
    }


    public void setScreenModel(ScreenModelImpl screenModel) {
        this.screenModel = screenModel;
    }

    public void setService(OrangeServiceAsync service) {
        this.service = service;
    }

    public void setUserHolder(UserHolder userHolder) {
        this.userHolder = userHolder;
    }

    public void setHandler(ClientSideHandler handler)
    {
        this.handler = handler;
    }
}
