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
    private PopupBuilder pop_builder = new PopupBuilder();


    public void setup(RootPanel root) {
        //Logging box
        final OrangeLoggingBox logbox = new OrangeLoggingBox("logbox");
        logbox.logMessage("Logging startup");
        screenModel.setLogbox(logbox);
        handler.setLogBox(logbox);
        tableBuilder.setLogbox(logbox);
        pop_builder.setLogBox(logbox);

        rotaTable.setScreenModel(screenModel);
        rotaTable = tableBuilder.createTable(5, 4);
        screenModel.setRotaTable(rotaTable);

        final OrangeButton addRowButton = new OrangeButton("addRow");
        addRowButton.setText("Add Row");
        addRowButton.setEventID(this.getClass().getName() + "." + addRowButton.getComponentID());
        addRowButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(addRowButton.getEventID(), this.getClass().getName());
            }
        });
        screenModel.setAddRowButton(addRowButton);

        final OrangeButton removeRowButton = new OrangeButton("removeRow");
        removeRowButton.setText("Remove Row");
        removeRowButton.setEventID(this.getClass().getName() + "." + removeRowButton.getComponentID());
        removeRowButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(removeRowButton.getEventID(), this.getClass().getName());
            }
        });
        screenModel.setRemoveRowButton(removeRowButton);

        final OrangeButton newButton = new OrangeButton("new");
        newButton.setText("New");
        newButton.setEventID(this.getClass().getName() + "." + newButton.getComponentID());
        newButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(newButton.getEventID(), this.getClass().getName());
            }
        });
        screenModel.setNewButton(newButton);

        final OrangeButton saveButton = new OrangeButton("save");
        saveButton.setText("Save");
        saveButton.setEventID(this.getClass().getName() + "." + saveButton.getComponentID());
        saveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(saveButton.getEventID(), this.getClass().getName());
            }
        });
        screenModel.setSaveButton(saveButton);

        final OrangeButton loadButton = new OrangeButton("load");
        loadButton.setText("Load");
        loadButton.setEventID(this.getClass().getName() + "." + loadButton.getComponentID());
        loadButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(loadButton.getEventID(), this.getClass().getName());
            }
        });
        screenModel.setLoadButton(loadButton);

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
        mapOfProcesses.put(screenModel.getLoginButton().getEventID(), (ProcessModel) userLogin);
        mapOfProcesses.put(screenModel.getRegisterButton().getEventID(), (ProcessModel) userRegister);

        HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.add(addRowButton);
        buttonPanel.add(removeRowButton);
        buttonPanel.add(newButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        VerticalPanel userPanel = new VerticalPanel();
        Label username = new Label(userHolder.getCurrentUser().getUsername());
        screenModel.setCurrentUser(username);
        userPanel.add(username);

        VerticalPanel rotaPanel = new VerticalPanel();
        rotaPanel.add(rotaTable);
        rotaPanel.add(buttonPanel);

        /*
        DockPanel dock = new DockPanel();
        dock.setHorizontalAlignment(DockPanel.ALIGN_CENTER);
        dock.setSpacing(4);
        dock.add(logbox, DockPanel.SOUTH);
        dock.add(userPanel, DockPanel.WEST);
        dock.add(rotaPanel, DockPanel.CENTER);
        screenModel.setMainPanel(dock);
        */

        SplitLayoutPanel p = new SplitLayoutPanel();
        p.addWest(userPanel, 128);
        p.addNorth(logbox, 384);
        p.add(rotaPanel);
        screenModel.setMainPanel(p);

        handler.setMapOfProcesses(mapOfProcesses);
        root.add(p);
        handler.handleEvent("loginPrompt", this.getClass().getName());

    }

    public void setUser(User user)
    {
        userHolder.setCurrentUser(user);
    }


}
