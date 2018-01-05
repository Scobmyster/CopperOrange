package com.scobmyster.copperorange.client.process.server;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.client.ModelTranslator;
import com.scobmyster.copperorange.client.OrangeServiceAsync;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.UserHolder;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.EnvelopeImpl;
import com.scobmyster.copperorange.shared.User;

public class UserLogin implements ProcessModel
{

    private ScreenModelImpl screenModel;
    private OrangeServiceAsync service;
    private UserHolder userHolder;

    @Override
    public void runProcess()
    {
        screenModel.getLogBox().logMessage("Logging in user: " + screenModel.getUsernameBox().getText());
        Envelope envelope = new EnvelopeImpl();
        User userModel = new User();
        new ModelTranslator().translate(this.screenModel, userModel);
        envelope.setUserModel(userModel);
        service.login(envelope, new AsyncCallback<Envelope>()
        {
            @Override
            public void onFailure(Throwable throwable)
            {
                screenModel.getLogBox().logMessage("Failure on login call");
            }

            @Override
            public void onSuccess(Envelope envelope)
            {
                screenModel.getLogBox().logMessage("Success on login call");
                screenModel.getLogBox().logMessage("Greenlight is: " + envelope.getUserGreenlight());
                if(envelope.getUserGreenlight() == true)
                {
                    screenModel.getRotaTable().setVisible(true);
                    screenModel.getNewButton().setVisible(true);
                    screenModel.getAddRowButton().setVisible(true);
                    screenModel.getRemoveRowButton().setVisible(true);
                    screenModel.getSaveButton().setVisible(true);
                    screenModel.getLoadButton().setVisible(true);
                    screenModel.getLoginPop().hide();
                    userHolder.setCurrentUser(envelope.getUserModel());
                    screenModel.getCurrentUser().setText(envelope.getUserModel().getUsername());
                }
                else
                {
                    screenModel.getLogBox().logMessage("Error username or password incorrect");
                    screenModel.getLoginErrorLabel().setVisible(true);
                }
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

    public void setUserHolder(UserHolder userHolder)
    {
        this.userHolder = userHolder;
    }
}
