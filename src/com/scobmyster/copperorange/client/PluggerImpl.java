package com.scobmyster.copperorange.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.client.process.client.*;
import com.scobmyster.copperorange.client.process.server.*;
import com.scobmyster.copperorange.client.widgets.*;
import com.scobmyster.copperorange.shared.User;

import java.util.HashMap;

public class PluggerImpl
{

    private static ScreenModelImpl screenModel = new ScreenModelImpl();
    private static ClientSideHandler handler = new ClientSideHandler();
    private TableBuilder tableBuilder = new TableBuilder();
    private OrangeFlexTable rotaTable = new OrangeFlexTable("rotaTable");
    private UserHolder userHolder = new UserHolder();

    private String className = this.getClass().getName() + ".";

    private PopupBuilder pop_builder = new PopupBuilder();



    public void setup(RootPanel root) {
        //Logging box

        OrangeLoggingBox logbox = new OrangeLoggingBox("logbox", handler);
        logbox.logMessage("Logging startup");
        screenModel.setLogbox(logbox);
        tableBuilder.setLogbox(logbox);
        tableBuilder.setHandler(handler);
        tableBuilder.setScreenModel(screenModel);
        pop_builder.setLogBox(logbox);

        rotaTable.setScreenModel(screenModel);
        rotaTable = tableBuilder.createTable(5, 4);
        screenModel.setRotaTable(rotaTable);


        final OrangeButton addRowButton = new OrangeButton("addRow", handler, "Add Row", className);
        screenModel.setAddRowButton(addRowButton);

        final OrangeButton removeRowButton = new OrangeButton("removeRow", handler, "Remove Row", className);
        screenModel.setRemoveRowButton(removeRowButton);

        final OrangeButton newButton = new OrangeButton("new", handler, "New", className);
        screenModel.setNewButton(newButton);

        final OrangeButton saveButton = new OrangeButton("save", handler, "Save", className);
        screenModel.setSaveButton(saveButton);

        final OrangeButton loadButton = new OrangeButton("load", handler, "Load", className);
        screenModel.setLoadButton(loadButton);

        HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.add(addRowButton);
        buttonPanel.add(removeRowButton);
        buttonPanel.add(newButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        Label username = new Label(userHolder.getCurrentUser().getUsername());
        screenModel.setCurrentUser(username);


        Label currentGroup = new Label("Current Group: " + userHolder.getCurrentGroup().getGroupName());
        screenModel.setCurrentGroup(currentGroup);


        final OrangeButton CreateGroupButton = new OrangeButton("CreateGroupButton", handler, "Create Group", className);
        final OrangeButton FindGroupButton = new OrangeButton("FindGroupButton", handler, "Find Group", className);
        final OrangeButton SwitchGroupButton = new OrangeButton("SwitchGroupButton", handler, "Switch Group", className);

        VerticalPanel userPanel = new VerticalPanel();
        userPanel.add(username);
        userPanel.add(currentGroup);
        userPanel.add(CreateGroupButton);
        userPanel.add(FindGroupButton);
        userPanel.add(SwitchGroupButton);

        //SAVE POPUP------------------------------------------------------------------------------------------
        OrangePopupPanel pop_save = pop_builder.buildSavePopup("Enter name to save rota as: ", handler, screenModel);
        screenModel.setSavePop(pop_save);
        //----------------------------------------------------------------------------

        //LOAD POPUP-------------------------------------------------------------------------------------
        OrangePopupPanel pop_load = pop_builder.buildLoadPopup("Loadable Rotas for " + userHolder.getCurrentUser().getUsername(), handler, screenModel);
        screenModel.setLoadPop(pop_load);
        //----------------------------------------------------------------------------

        //LOGIN POPUP---------------------------------------------------------------------------
        OrangePopupPanel pop_login = pop_builder.buildLoginPopup("Sign in: ", handler, screenModel);
        screenModel.setLoginPop(pop_login);
        //----------------------------------------------------------------------------

        //GROUP REGISTER POPUP-------------------------------------------------------------------
        OrangePopupPanel pop_GroupRegister = pop_builder.buildGroupRegisterPopup("Register Group", handler, screenModel);
        //----------------------------------------------------------------------------------------

        //GROUP JOIN POPUP-------------------------------------------------------------------------
        OrangePopupPanel pop_GroupJoin = pop_builder.buildFindGroupPopup("Find Group", handler, screenModel);

        //GROUP SWITCH POPUP
        OrangePopupPanel pop_GroupSwitch = pop_builder.buildSwitchGroupPopup("Switch Group", handler, screenModel);
        screenModel.setPop_SwitchGroup(pop_GroupSwitch);


        //CLIENT EVENT STUFF----------------------------------------------------------
        RotaAddRowImpl rotaAddRow = new RotaAddRowImpl();
        rotaAddRow.setScreenModel(screenModel);

        RotaRemoveRowImpl rotaRemoveRow = new RotaRemoveRowImpl();
        rotaRemoveRow.setScreenModel(screenModel);
        rotaRemoveRow.setBuilder(tableBuilder);

        RotaNewImpl rotaNew = new RotaNewImpl();
        rotaNew.setScreenModel(screenModel);
        rotaNew.setBuilder(tableBuilder);

        RotaGetSaveName rotaSaveName = new RotaGetSaveName();
        rotaSaveName.setScreenmodel(screenModel);

        RotaCancelSaveRotaImpl rotaCancelSaveRota = new RotaCancelSaveRotaImpl();
        rotaCancelSaveRota.setScreenModel(screenModel);

        RotaCancelLoadRotaImpl rotaCancelLoadRota = new RotaCancelLoadRotaImpl();
        rotaCancelLoadRota.setScreenModel(screenModel);
        rotaCancelLoadRota.setLogBox(logbox);

        RotaGetLoadName rotaLoadName = new RotaGetLoadName();
        rotaLoadName.setScreenModel(screenModel);

        RotaLoginPrompt rotaLoginPrompt = new RotaLoginPrompt();
        rotaLoginPrompt.setScreenModel(screenModel);
        rotaLoginPrompt.setLogbox(logbox);

        GroupOpenRegisterPrompt groupOpenRegisterPrompt = new GroupOpenRegisterPrompt();
        groupOpenRegisterPrompt.setScreenModel(screenModel);

        GroupCloseRegisterPrompt groupCloseRegisterPrompt = new GroupCloseRegisterPrompt();
        groupCloseRegisterPrompt.setScreenModel(screenModel);

        GroupOpenFindPrompt groupOpenFindPrompt = new GroupOpenFindPrompt();
        groupOpenFindPrompt.setScreenModel(screenModel);

        GroupCloseFindPrompt groupCloseFindPrompt = new GroupCloseFindPrompt();
        groupCloseFindPrompt.setScreenModel(screenModel);

        GroupOpenSwitchPrompt groupOpenSwitchPrompt = new GroupOpenSwitchPrompt();
        groupOpenSwitchPrompt.setScreenModel(screenModel);
        groupOpenSwitchPrompt.setHandler(handler);

        GroupCloseSwitchPrompt groupCloseSwitchPrompt = new GroupCloseSwitchPrompt();
        groupCloseSwitchPrompt.setScreenModel(screenModel);
        //--------------------------------------------------------------------------

        //SERVER EVENT STUFF---------------------------------------------------------
        RotaSaveImpl rotaSave = new RotaSaveImpl();
        rotaSave.setScreenModel(screenModel);
        rotaSave.setService((OrangeServiceAsync) GWT.create(OrangeService.class));
        rotaSave.setHolder(userHolder);

        RotaLoadImpl rotaLoad = new RotaLoadImpl();
        rotaLoad.setScreenModel(screenModel);
        rotaLoad.setHandler(handler);
        rotaLoad.setService((OrangeServiceAsync) GWT.create(OrangeService.class));
        rotaLoad.setHolder(userHolder);

        RotaFetchNames rotaFetchNames = new RotaFetchNames();
        rotaFetchNames.setScreenModel(screenModel);
        rotaFetchNames.setService((OrangeServiceAsync) GWT.create(OrangeService.class));
        rotaFetchNames.setHolder(userHolder);

        UserLogin userLogin = new UserLogin();
        userLogin.setScreenModel(screenModel);
        userLogin.setService((OrangeServiceAsync) GWT.create(OrangeService.class));
        userLogin.setUserHolder(userHolder);
        userLogin.setHandler(handler);
        userLogin.setPlugger(this);

        UserRegister userRegister = new UserRegister();
        userRegister.setScreenModel(screenModel);
        userRegister.setService((OrangeServiceAsync) GWT.create(OrangeService.class));
        userRegister.setUserHolder(userHolder);

        GroupRegister groupRegister = new GroupRegister();
        groupRegister.setScreenModel(screenModel);
        groupRegister.setUserHolder(userHolder);
        groupRegister.setService((OrangeServiceAsync) GWT.create(OrangeService.class));

        GroupFetchNames groupFetchNames = new GroupFetchNames();
        groupFetchNames.setScreenModel(screenModel);
        groupFetchNames.setService((OrangeServiceAsync) GWT.create(OrangeService.class));

        GroupJoinGroup groupJoinGroup = new GroupJoinGroup();
        groupJoinGroup.setScreenModel(screenModel);
        groupJoinGroup.setHolder(userHolder);
        groupJoinGroup.setService((OrangeServiceAsync) GWT.create(OrangeService.class));

        UserSetupService userSetupService = new UserSetupService();
        userSetupService.setScreenModel(screenModel);
        userSetupService.setHolder(userHolder);
        userSetupService.setService((OrangeServiceAsync) GWT.create(OrangeService.class));
        userSetupService.setHandler(handler);

        GroupFetchMyGroups groupFetchMyGroups = new GroupFetchMyGroups();
        groupFetchMyGroups.setScreenModel(screenModel);
        groupFetchMyGroups.setHolder(userHolder);
        groupFetchMyGroups.setService((OrangeServiceAsync) GWT.create(OrangeService.class));

        GroupSwitch groupSwitch = new GroupSwitch();
        groupSwitch.setScreenModel(screenModel);
        groupSwitch.setHolder(userHolder);
        groupSwitch.setService((OrangeServiceAsync) GWT.create(OrangeService.class));

        UserLinkToRota userLinkToRota = new UserLinkToRota();
        userLinkToRota.setScreenModel(screenModel);
        userLinkToRota.setHolder(userHolder);
        userLinkToRota.setService((OrangeServiceAsync) GWT.create(OrangeService.class));

        DebugButton debugButton = new DebugButton();
        //-------------------------------

        //------------------------------------------------------------------------------


        HashMap<String, ProcessModel> mapOfProcesses = new HashMap<>();

        mapOfProcesses.put(addRowButton.getEventID(), (ProcessModel) rotaAddRow);
        mapOfProcesses.put(removeRowButton.getEventID(), (ProcessModel) rotaRemoveRow);
        mapOfProcesses.put(newButton.getEventID(), (ProcessModel) rotaNew);
        mapOfProcesses.put(saveButton.getEventID(), (ProcessModel) rotaSaveName);
        mapOfProcesses.put(screenModel.getSaveRotaButton().getEventID(), (ProcessModel) rotaSave);
        mapOfProcesses.put(screenModel.getSaveCancelButton().getEventID(), (ProcessModel) rotaCancelSaveRota);
        mapOfProcesses.put(loadButton.getEventID(), (ProcessModel) rotaLoadName);
        mapOfProcesses.put(screenModel.getLoadSelectedButton().getEventID(), (ProcessModel) rotaLoad);
        mapOfProcesses.put(screenModel.getLoadCancelButton().getEventID(), (ProcessModel) rotaCancelLoadRota);
        mapOfProcesses.put("fetchFiles", (ProcessModel) rotaFetchNames);
        mapOfProcesses.put("loginPrompt", (ProcessModel) rotaLoginPrompt);
        mapOfProcesses.put("userSetupService", (ProcessModel) userSetupService);
        
        mapOfProcesses.put(CreateGroupButton.getEventID(), (ProcessModel) groupOpenRegisterPrompt);
        mapOfProcesses.put(screenModel.getBt_RegisterGroup().getEventID(), (ProcessModel) groupRegister);
        mapOfProcesses.put(screenModel.getBt_CancelRegisterGroup().getEventID(), (ProcessModel) groupCloseRegisterPrompt);
        mapOfProcesses.put(FindGroupButton.getEventID(), (ProcessModel) groupOpenFindPrompt);
        mapOfProcesses.put(screenModel.getBt_CancelFindGroup().getEventID(), (ProcessModel) groupCloseFindPrompt);
        mapOfProcesses.put(screenModel.getBt_SearchForGroups().getEventID(), (ProcessModel) groupFetchNames);
        mapOfProcesses.put(screenModel.getBt_JoinGroup().getEventID(), (ProcessModel) groupJoinGroup);
        mapOfProcesses.put(SwitchGroupButton.getEventID(), (ProcessModel) groupOpenSwitchPrompt);
        mapOfProcesses.put(screenModel.getBt_switch().getEventID(), (ProcessModel) groupSwitch);
        mapOfProcesses.put(screenModel.getBt_switchCancel().getEventID(), (ProcessModel) groupCloseSwitchPrompt);
        mapOfProcesses.put("fetchMyGroups", (ProcessModel) groupFetchMyGroups);

        mapOfProcesses.put(screenModel.getLoginButton().getEventID(), (ProcessModel) userLogin);
        mapOfProcesses.put(screenModel.getRegisterButton().getEventID(), (ProcessModel) userRegister);
        mapOfProcesses.put("link", (ProcessModel) userLinkToRota);




        VerticalPanel rotaPanel = new VerticalPanel();
        rotaPanel.add(rotaTable);
        rotaPanel.add(buttonPanel);


        HorizontalPanel hp = new HorizontalPanel();
        hp.add(userPanel);
        hp.add(rotaPanel);
        hp.add(logbox);
        hp.setVisible(false);
        screenModel.setHp(hp);


        handler.setMapOfProcesses(mapOfProcesses);
        root.add(hp);
        handler.handleEvent("loginPrompt");

    }

    public void setUser(User user)
    {
        userHolder.setCurrentUser(user);
    }


}
