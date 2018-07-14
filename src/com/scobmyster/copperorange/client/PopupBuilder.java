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
    private String className = this.getClass().getName();


    public OrangePopupPanel buildLoadPopup(String explainText, ClientSideHandler handle, ScreenModelImpl screen)
    {
        logbox.logMessage("Building a load popup window");

        final ClientSideHandler handler = handle;
        final ScreenModelImpl screenModel = screen;

        OrangePopupPanel pop_load = new OrangePopupPanel("pop_load");

        Label lb_explain = new Label(explainText);

        final OrangeButton bt_loadRota = new OrangeButton("bt_loadRota", handler, "Load", className);

        screenModel.setLoadSelectedButton(bt_loadRota);

        final OrangeButton bt_loadCancel = new OrangeButton("bt_loadCancel", handler, "Cancel", className);

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


        final OrangeCheckbox ck_SaveForGroup = new OrangeCheckbox("ck_SaveForGroup");
        ck_SaveForGroup.setText("Avaliable For Group");
        screenModel.setCk_SaveForGroup(ck_SaveForGroup);

        HorizontalPanel checkPanel = new HorizontalPanel();
        checkPanel.add(ck_SaveForGroup);

        final OrangeButton bt_saveName = new OrangeButton("bt_saveName", handler, "Save Rota", className);
        screenModel.setSaveRotaButton(bt_saveName);

        final OrangeButton bt_saveCancel = new OrangeButton("bt_saveCancel", handler, "Cancel", className);
        screenModel.setSaveCancelButton(bt_saveCancel);

        VerticalPanel savePopVP = new VerticalPanel();
        HorizontalPanel savePopHP = new HorizontalPanel();
        savePopVP.add(saveLabel);
        savePopVP.add(saveNameBox);
        savePopVP.add(checkPanel);
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

        final OrangeButton bt_login = new OrangeButton("bt_login", handler, "Login", className);
        screenModel.setLoginButton(bt_login);

        final OrangeButton bt_register = new OrangeButton("bt_register", handler, "Register", className);
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

    public OrangePopupPanel buildGroupRegisterPopup(String explainText, ClientSideHandler handle, ScreenModelImpl screen)
    {
        ClientSideHandler handler = handle;
        final ScreenModelImpl screenModel = screen;

        Label title = new Label(explainText);

        Label lb_groupName = new Label("Group Name: ");

        OrangeTextbox groupName = new OrangeTextbox("groupName");
        screenModel.setGroupName(groupName);

        final OrangeButton bt_RegisterGroup = new OrangeButton("bt_RegisterGroup", handler, "Register Group", className);
        screenModel.setBt_RegisterGroup(bt_RegisterGroup);

        final OrangeButton bt_CancelRegisterGroup = new OrangeButton("bt_CancelRegisterGroup", handler, "Cancel", className);
        screenModel.setBt_CancelRegisterGroup(bt_CancelRegisterGroup);

        HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.add(bt_RegisterGroup);
        buttonPanel.add(bt_CancelRegisterGroup);

        VerticalPanel vp = new VerticalPanel();
        vp.add(title);
        vp.add(lb_groupName);
        vp.add(groupName);
        vp.add(buttonPanel);

        OrangePopupPanel pop_GroupRegister = new OrangePopupPanel("pop_groupRegister");
        pop_GroupRegister.setVisible(false);
        pop_GroupRegister.setSize("1024", "1024");
        pop_GroupRegister.add(vp);
        screenModel.setPop_GroupRegister(pop_GroupRegister);

        return pop_GroupRegister;
    }

    public OrangePopupPanel buildFindGroupPopup(String explainText, ClientSideHandler clientSideHandler, ScreenModelImpl screenModelImpl)
    {
        ClientSideHandler handler = clientSideHandler;
        final ScreenModelImpl screenModel = screenModelImpl;

        Label title = new Label(explainText);

        Label lb_findResults = new Label("Group Results");

        TextCell textCell = new TextCell();
        final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
        CellList<String> groupNames = new CellList<String>(textCell);
        groupNames.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        groupNames.addStyleName("customCellList");
        groupNames.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent selectionChangeEvent)
            {
                String selected = selectionModel.getSelectedObject();
                if(selected != null)
                {
                    screenModel.setSelectedGroupToLoad(selected);
                }
            }
        });
        screenModel.setGroupNames(groupNames);

        OrangeButton bt_JoinGroup = new OrangeButton("bt_JoinGroup", handler, "Join", className);
        screenModel.setBt_JoinGroup(bt_JoinGroup);

        Label lb_searchBox = new Label("Search for: ");

        OrangeTextbox groupSearchBox = new OrangeTextbox("groupSearchBox");
        screenModel.setGroupSearchBox(groupSearchBox);



        OrangeButton bt_SearchForGroups = new OrangeButton("bt_SearchForGroups", handler, "Search", className);
        screenModel.setBt_SearchForGroups(bt_SearchForGroups);

        OrangeButton bt_CancelFindGroup = new OrangeButton("bt_CancelFindGroup", handler, "Cancel", className);
        screenModel.setBt_CancelFindGroup(bt_CancelFindGroup);

        HorizontalPanel resultsPanel = new HorizontalPanel();
        resultsPanel.add(groupNames);
        resultsPanel.add(bt_JoinGroup);

        HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.add(bt_SearchForGroups);
        buttonPanel.add(bt_CancelFindGroup);

        VerticalPanel mainPanel = new VerticalPanel();
        mainPanel.add(title);
        mainPanel.add(lb_findResults);
        mainPanel.add(resultsPanel);
        mainPanel.add(lb_searchBox);
        mainPanel.add(groupSearchBox);
        mainPanel.add(buttonPanel);


        OrangePopupPanel pop_FindGroup = new OrangePopupPanel("pop_FindGroup", false, "1024");
        pop_FindGroup.add(mainPanel);
        screenModel.setPop_FindGroup(pop_FindGroup);

        return pop_FindGroup;
    }

    public OrangePopupPanel buildSwitchGroupPopup(String explainText, ClientSideHandler clientSideHandler, ScreenModelImpl screenModelImpl)
    {
        ClientSideHandler handler = clientSideHandler;
        final ScreenModelImpl screenModel = screenModelImpl;

        Label title = new Label(explainText);

        Label lb_findGroup = new Label("My Groups");

        TextCell textCell = new TextCell();
        final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
        CellList<String> myGroups = new CellList<String>(textCell);
        myGroups.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        myGroups.addStyleName("customCellList");
        myGroups.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent selectionChangeEvent)
            {
                String selected = selectionModel.getSelectedObject();
                if(selected != null)
                {
                    screenModel.setSelectedGroupToSwitch(selected);
                }
            }
        });
        screenModel.setMyGroups(myGroups);

        OrangeButton bt_switch = new OrangeButton("bt_switch", handler, "Switch", className);
        screenModel.setBt_switch(bt_switch);

        OrangeButton bt_switchCancel = new OrangeButton("bt_cancel", handler, "Cancel", className);
        screenModel.setBt_switchCancel(bt_switchCancel);

        HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.add(bt_switch);
        buttonPanel.add(bt_switchCancel);

        VerticalPanel mainPanel = new VerticalPanel();
        mainPanel.add(title);
        mainPanel.add(lb_findGroup);
        mainPanel.add(myGroups);
        mainPanel.add(buttonPanel);


        OrangePopupPanel pop_SwitchGroup = new OrangePopupPanel("pop_SwitchGroup", false, "1024");
        pop_SwitchGroup.add(mainPanel);
        screenModel.setPop_SwitchGroup(pop_SwitchGroup);

        return pop_SwitchGroup;
    }

    public void setLogBox(OrangeLoggingBox logbox)
    {
        this.logbox = logbox;
    }



}
