package com.scobmyster.copperorange.client;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
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


    public void setup(RootPanel root)
    {
        //Logging box
        OrangeLoggingBox logbox = new OrangeLoggingBox("logbox", handler);
        logbox.logMessage("Logging startup");
        screenModel.setLogbox(logbox);
        tableBuilder.setLogbox(logbox);

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

        final OrangeButton addGroupButton = new OrangeButton("addGroupButton", handler, "Add Group", className);


        VerticalPanel userPanel = new VerticalPanel();
        userPanel.add(username);
        userPanel.add(addGroupButton);

        //Save popup
        Label saveLabel = new Label();
        saveLabel.setText("Enter name for rota: ");

        OrangeTextbox saveNameBox = new OrangeTextbox("saveNameBox");
        screenModel.setSaveNameBox(saveNameBox);

        final OrangeButton saveNameButton = new OrangeButton("saveNameButton", handler, "Save Rota", className);

        final OrangeButton saveCancelButton = new OrangeButton("saveCancelButton", handler, "Cancel", className);

        VerticalPanel savePopVP = new VerticalPanel();
        HorizontalPanel savePopHP = new HorizontalPanel();
        savePopVP.add(saveLabel);
        savePopVP.add(saveNameBox);
        savePopVP.add(savePopHP);
        savePopHP.add(saveNameButton);
        savePopHP.add(saveCancelButton);

        OrangePopupPanel savePop = new OrangePopupPanel("loadPop");
        savePop.setVisible(false);
        savePop.setSize("128",  "128");
        savePop.add(savePopVP);
        screenModel.setSavePop(savePop);
        //----------------------------------------------------------------------------

        //Load popup
        Label loadLabel = new Label();
        loadLabel.setText("Enter name for rota to load: ");

        OrangeTextbox loadNameBox = new OrangeTextbox("loadNameBox");
        screenModel.setLoadNameBox(loadNameBox);

        final OrangeButton loadNameButton = new OrangeButton("loadNameButton", handler, "Load Rota", className);

        final OrangeButton loadCancelButton = new OrangeButton("loadCancelButton", handler, "Cancel", className);

        TextCell textCell = new TextCell();
        
        final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
        CellList<String> rotaNames = new CellList<String>(textCell);
        rotaNames.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        rotaNames.addStyleName("customCellList");
        rotaNames.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
            @Override
            public void onSelectionChange(SelectionChangeEvent selectionChangeEvent) {
                String selected = selectionModel.getSelectedObject();
                if(selected != null)
                {
                    screenModel.setSelectedFileToLoad(selected);
                }
            }
        });
        screenModel.setRotaNames(rotaNames);

        VerticalPanel loadPopVP = new VerticalPanel();
        HorizontalPanel loadPopHP = new HorizontalPanel();
        loadPopVP.add(loadLabel);
        loadPopVP.add(rotaNames);
        loadPopVP.add(loadPopHP);
        loadPopHP.add(loadNameButton);
        loadPopHP.add(loadCancelButton);

        OrangePopupPanel loadPop = new OrangePopupPanel("loadPop");
        loadPop.setVisible(false);
        loadPop.setSize("256",  "256");
        loadPop.add(loadPopVP);
        screenModel.setLoadPop(loadPop);
        //----------------------------------------------------------------------------

        //Login Popup
        Label loginTitle = new Label("Sign In");

        Label usernameLabel = new Label("Username:");

        OrangeTextbox usernameBox = new OrangeTextbox("usernameBox");
        screenModel.setUsernameBox(usernameBox);

        Label passwordLabel = new Label("Password: ");

        OrangePasswordTextbox passwordBox = new OrangePasswordTextbox("passwordBox");
        screenModel.setPasswordBox(passwordBox);

        final OrangeButton loginButton = new OrangeButton("loginButton", handler, "Login", className);
        screenModel.setLoginButton(loginButton);

        final OrangeButton registerButton = new OrangeButton("registerButton", handler, "Register", className);
        screenModel.setRegisterButton(registerButton);

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
        loginPopHP.add(loginButton);
        loginPopHP.add(registerButton);
        loginPopVP.add(loginErrorLabel);

        OrangePopupPanel loginPop = new OrangePopupPanel("loginPop");
        loginPop.setVisible(false);
        loginPop.setSize("1024", "1024");
        loginPop.add(loginPopVP);
        screenModel.setLoginPop(loginPop);

        Label mainTitle = new Label("CopperOrange");
        mainTitle.setSize("150", "300");

        //----------------------------------------------------------------------------
        //CLIENT EVENT STUFF
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

        RotaGetLoadName rotaLoadName = new RotaGetLoadName();
        rotaLoadName.setScreenModel(screenModel);

        RotaLoginPrompt rotaLoginPrompt = new RotaLoginPrompt();
        rotaLoginPrompt.setScreenModel(screenModel);
        rotaLoginPrompt.setLogbox(logbox);
        //-------------------------------

        //SERVER EVENT STUFF
        RotaSaveImpl rotaSave = new RotaSaveImpl();
        rotaSave.setScreenModel(screenModel);
        rotaSave.setService((OrangeServiceAsync) GWT.create(OrangeService.class));

        RotaLoadImpl rotaLoad = new RotaLoadImpl();
        rotaLoad.setScreenModel(screenModel);
        rotaLoad.setHandler(handler);
        rotaLoad.setService((OrangeServiceAsync) GWT.create(OrangeService.class));

        RotaFetchNames rotaFetchNames = new RotaFetchNames();
        rotaFetchNames.setScreenModel(screenModel);
        rotaFetchNames.setService((OrangeServiceAsync) GWT.create(OrangeService.class));

        UserLogin userLogin = new UserLogin();
        userLogin.setScreenModel(screenModel);
        userLogin.setService((OrangeServiceAsync) GWT.create(OrangeService.class));
        userLogin.setUserHolder(userHolder);

        UserRegister userRegister = new UserRegister();
        userRegister.setScreenModel(screenModel);
        userRegister.setService((OrangeServiceAsync) GWT.create(OrangeService.class));
        userRegister.setUserHolder(userHolder);

        DebugButton debugButton = new DebugButton();

        //-------------------------------

        HashMap<String, ProcessModel> mapOfProcesses = new HashMap<>();

        mapOfProcesses.put(addRowButton.getEventID(), (ProcessModel) rotaAddRow);
        mapOfProcesses.put(removeRowButton.getEventID(), (ProcessModel) rotaRemoveRow);
        mapOfProcesses.put(newButton.getEventID(), (ProcessModel) rotaNew);
        mapOfProcesses.put(saveButton.getEventID(), (ProcessModel) rotaSaveName);
        mapOfProcesses.put(saveNameButton.getEventID(), (ProcessModel) rotaSave);
        mapOfProcesses.put(saveCancelButton.getEventID(), (ProcessModel) rotaCancelSaveRota);
        mapOfProcesses.put(loadButton.getEventID(), (ProcessModel) rotaLoadName);
        mapOfProcesses.put(loadNameButton.getEventID(), (ProcessModel) rotaLoad);
        mapOfProcesses.put(loadCancelButton.getEventID(), (ProcessModel) rotaCancelLoadRota);
        mapOfProcesses.put("fetchFiles", (ProcessModel) rotaFetchNames);
        mapOfProcesses.put("loginPrompt", (ProcessModel) rotaLoginPrompt);
        mapOfProcesses.put(loginButton.getEventID(), (ProcessModel) userLogin);
        mapOfProcesses.put(registerButton.getEventID(), (ProcessModel) userRegister);
        mapOfProcesses.put(addGroupButton.getEventID(), (ProcessModel) debugButton);





        DockPanel dock = new DockPanel();
        dock.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
        dock.setSpacing(4);
        dock.add(buttonPanel, DockPanel.SOUTH);
        dock.add(logbox, DockPanel.EAST);
        dock.add(userPanel, DockPanel.WEST);
        dock.add(rotaTable, DockPanel.CENTER);
        screenModel.setMainPanel(dock);


        handler.setMapOfProcesses(mapOfProcesses);
        root.add(dock);
        handler.handleEvent("fetchFiles");
        handler.handleEvent("loginPrompt");
    }


}
