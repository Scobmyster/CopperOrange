package com.scobmyster.copperorange.client;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.scobmyster.copperorange.client.widgets.*;

public class PopupBuilder
{

    private String classname = this.getClass().getName();
    private OrangeLoggingBox logbox;


    public OrangePopupPanel buildLoadPopup(String explainText, ClientSideHandler handle, ScreenModelImpl screen)
    {
        logbox.logMessage("Building a load popup window");

        final ClientSideHandler handler = handle;
        final ScreenModelImpl screenModel = screen;

        OrangePopupPanel pop_load = new OrangePopupPanel("pop_load");

        Label lb_explain = new Label(explainText);

        final OrangeButton bt_loadRota = new OrangeButton("bt_loadRota");
        bt_loadRota.setText("Load");
        bt_loadRota.setEventID(classname + " : " + bt_loadRota.getComponentID());
        bt_loadRota.addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent clickEvent)
            {
                logbox.logMessage("Clicking load");
                handler.handleEvent(bt_loadRota.getEventID(), this.getClass().getName());
            }
        });

        screenModel.setLoadSelectedButton(bt_loadRota);

        final OrangeButton bt_loadCancel = new OrangeButton("bt_loadCancel");
        bt_loadCancel.setText("Cancel");
        bt_loadCancel.setEventID(classname + " : " + bt_loadCancel.getComponentID());
        bt_loadRota.addClickHandler(new ClickHandler()
        {
            @Override
            public void onClick(ClickEvent clickEvent)
            {
                if(screenModel.getLoadPop().isVisible() == true) {
                    logbox.logMessage("Clicking cancel");
                    handler.handleEvent(bt_loadCancel.getEventID(), this.getClass().getName());
                }
            }
        });


        screenModel.setLoadCancelButton(bt_loadCancel);

        TextCell textCell = new TextCell();
        final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
        CellList<String> rotaNames = new CellList<String>(textCell);
        rotaNames.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        rotaNames.addStyleName("customCellList");
        rotaNames.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent selectionChangeEvent)
            {
                String selected = selectionModel.getSelectedObject();
                if(selected != null)
                {
                     screenModel.setSelectedFileToLoad(selected);
                }
            }
        });
        screenModel.setRotaNames(rotaNames);

        VerticalPanel vp_content = new VerticalPanel();
        HorizontalPanel hp_button = new HorizontalPanel();
        vp_content.add(lb_explain);
        vp_content.add(rotaNames);
        vp_content.add(hp_button);
        hp_button.add(bt_loadRota);
        hp_button.add(bt_loadCancel);

        pop_load.setVisible(false);
        pop_load.setSize("256",  "256");
        pop_load.add(vp_content);


        return pop_load;
    }

    public OrangePopupPanel buildSavePopup(String explainText, ClientSideHandler handle, ScreenModelImpl screen)
    {
        Label saveLabel = new Label();
        saveLabel.setText(explainText);

        final ClientSideHandler handler = handle;
        final ScreenModelImpl screenModel = screen;

        OrangeTextbox saveNameBox = new OrangeTextbox("saveNameBox");
        screenModel.setSaveNameBox(saveNameBox);

        final OrangeButton bt_saveName = new OrangeButton("bt_saveName");
        bt_saveName.setText("Save Rota");
        bt_saveName.setEventID(this.getClass().getName() + "." + bt_saveName.getComponentID());
        bt_saveName.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(bt_saveName.getEventID(), this.getClass().getName());
            }
        });
        screenModel.setSaveRotaButton(bt_saveName);

        final OrangeButton bt_saveCancel = new OrangeButton("bt_saveCancel");
        bt_saveCancel.setText("Cancel");
        bt_saveCancel.setEventID(this.getClass().getName() + "." + bt_saveCancel.getComponentID());
        bt_saveCancel.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                logbox.logMessage("Clicking cancel on save");
                handler.handleEvent(bt_saveCancel.getEventID(), this.getClass().getName());
            }
        });
        screenModel.setSaveCancelButton(bt_saveCancel);

        VerticalPanel savePopVP = new VerticalPanel();
        HorizontalPanel savePopHP = new HorizontalPanel();
        savePopVP.add(saveLabel);
        savePopVP.add(saveNameBox);
        savePopVP.add(savePopHP);
        savePopHP.add(bt_saveName);
        savePopHP.add(bt_saveCancel);

        OrangePopupPanel pop_save = new OrangePopupPanel("loadPop");
        pop_save.setVisible(false);
        pop_save.setSize("128", "128");
        pop_save.add(savePopVP);
        screenModel.setSavePop(pop_save);
        return pop_save;
    }

    public OrangePopupPanel buildLoginPopup(String explainText, ClientSideHandler handle, ScreenModelImpl screen)
    {
        final ClientSideHandler handler = handle;
        final ScreenModelImpl screenModel = screen;

        Label loginTitle = new Label(explainText);

        Label usernameLabel = new Label("Username:");
        OrangeTextbox usernameBox = new OrangeTextbox("usernameBox");
        screenModel.setUsernameBox(usernameBox);

        Label passwordLabel = new Label("Password: ");
        OrangePasswordTextbox passwordBox = new OrangePasswordTextbox("passwordBox");
        screenModel.setPasswordBox(passwordBox);

        final OrangeButton bt_login = new OrangeButton("bt_login");
        bt_login.setText("Login");
        bt_login.setEventID(this.getClass().getName() + "." + bt_login.getComponentID());
        bt_login.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(bt_login.getEventID(), this.getClass().getName());
            }
        });
        screenModel.setLoginButton(bt_login);

        final OrangeButton bt_register = new OrangeButton("bt_register");
        bt_register.setText("Register");
        bt_register.setEventID(this.getClass().getName() + "." + bt_register.getComponentID());
        bt_register.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(bt_register.getEventID(), this.getClass().getName());
            }
        });
        screenModel.setRegisterButton(bt_register);

        Label loginErrorLabel = new Label("Error username or password incorrect");
        loginErrorLabel.setVisible(false);
        screenModel.setLoginErrorLabel(loginErrorLabel);

        VerticalPanel loginPopVP = new VerticalPanel();
        HorizontalPanel loginPopHP = new HorizontalPanel();
        loginPopVP.add(loginTitle);
        loginPopVP.add(usernameLabel);
        loginPopVP.add(usernameBox);
        loginPopVP.add(passwordLabel);
        loginPopVP.add(passwordBox);
        loginPopVP.add(loginPopHP);
        loginPopHP.add(bt_login);
        loginPopHP.add(bt_register);
        loginPopVP.add(loginErrorLabel);

        OrangePopupPanel pop_login = new OrangePopupPanel("pop_login");
        pop_login.setVisible(false);
        pop_login.setSize("1024", "1024");
        pop_login.add(loginPopVP);
        screenModel.setLoginPop(pop_login);

        Label mainTitle = new Label("CopperOrange");
        mainTitle.setSize("150", "300");

        return pop_login;
    }

    public OrangePopupPanel buildGroupPopup(String explainText, ClientSideHandler handle, ScreenModelImpl screen)
    {
        return null;
    }

    public void setLogBox(OrangeLoggingBox logbox)
    {
        this.logbox = logbox;
    }



}
