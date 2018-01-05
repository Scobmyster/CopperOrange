package com.scobmyster.copperorange.client.process.server;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.scobmyster.copperorange.client.OrangeService;
import com.scobmyster.copperorange.client.OrangeServiceAsync;
import com.scobmyster.copperorange.client.ScreenModelImpl;
import com.scobmyster.copperorange.client.UserHolder;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.shared.Envelope;
import com.scobmyster.copperorange.shared.EnvelopeImpl;
import com.scobmyster.copperorange.shared.User;

public class UserRegister implements ProcessModel
{

    private ScreenModelImpl screenModel;
    private OrangeServiceAsync service;
    private UserHolder userHolder;


    @Override
    public void runProcess()
    {
        screenModel.getLogBox().logMessage("Registering user: " + screenModel.getUsernameBox().getText());
        User user = new User();
        user.setUsername(screenModel.getUsernameBox().getText());
        user.setPassword(screenModel.getPasswordBox().getText());
        Envelope envelope = new EnvelopeImpl();
        envelope.setUserModel(user);
        service.register(envelope, new AsyncCallback<Envelope>()
        {
            @Override
            public void onFailure(Throwable throwable)
            {
                screenModel.getLogBox().logMessage("Failure on registering the user");
            }

            @Override
            public void onSuccess(Envelope envelope)
            {
                screenModel.getLogBox().logMessage("Success on registering the user");
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
                }
                else
                {
                    screenModel.getLogBox().logMessage("Error username taken");
                    screenModel.getLoginErrorLabel().setText("Error username already taken");
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
