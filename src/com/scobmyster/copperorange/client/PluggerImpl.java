package com.scobmyster.copperorange.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.client.process.client.*;
import com.scobmyster.copperorange.client.process.server.RotaLoadImpl;
import com.scobmyster.copperorange.client.process.server.RotaSaveImpl;
import com.scobmyster.copperorange.client.widgets.OrangeButton;
import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;
import com.scobmyster.copperorange.client.widgets.OrangePopupPanel;
import com.scobmyster.copperorange.client.widgets.OrangeTextbox;

import java.util.HashMap;

public class PluggerImpl
{

    private static ScreenModelImpl screenModel = new ScreenModelImpl();
    private static ClientSideHandler handler = new ClientSideHandler();
    private TableBuilder tableBuilder = new TableBuilder();
    private OrangeFlexTable rotaTable = new OrangeFlexTable("rotaTable");


    public void setup(RootPanel root)
    {
        rotaTable.setScreenModel(screenModel);
        rotaTable = tableBuilder.createTable(5, 4);
        rotaTable.setDefColCount(rotaTable.getColumnCount());
        rotaTable.setDefRowCount(rotaTable.getRowCount());
        screenModel.setRotaTable(rotaTable);

        final OrangeButton addRowButton = new OrangeButton("addRow");
        addRowButton.setText("Add Row");
        addRowButton.setEventID(this.getClass().getName() + "." + addRowButton.getComponentID());
        addRowButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent)
            {
                handler.handleEvent(addRowButton.getEventID());
            }});

        final OrangeButton removeRowButton = new OrangeButton("removeRow");
        removeRowButton.setText("Remove Row");
        removeRowButton.setEventID(this.getClass().getName() + "." + removeRowButton.getComponentID());
        removeRowButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(removeRowButton.getEventID());
            }
        });


        final OrangeButton newButton = new OrangeButton("new");
        newButton.setText("New");
        newButton.setEventID(this.getClass().getName() + "." + newButton.getComponentID());
        newButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(newButton.getEventID());
            }
        });

        final OrangeButton saveButton = new OrangeButton("save");
        saveButton.setText("Save");
        saveButton.setEventID(this.getClass().getName() + "." + saveButton.getComponentID());
        saveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(saveButton.getEventID());
            }
        });

        final OrangeButton loadButton = new OrangeButton("load");
        loadButton.setText("Load");
        loadButton.setEventID(this.getClass().getName() + "." + loadButton.getComponentID());
        loadButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(loadButton.getEventID());
            }
        });

        //Save popup
        Label saveLabel = new Label();
        saveLabel.setText("Enter name for rota: ");

        OrangeTextbox saveNameBox = new OrangeTextbox("saveNameBox");
        screenModel.setSaveNameBox(saveNameBox);

        final OrangeButton saveNameButton = new OrangeButton("saveNameButton");
        saveNameButton.setText("Save Rota");
        saveNameButton.setEventID(this.getClass().getName() + "." + saveNameButton.getComponentID());
        saveNameButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(saveNameButton.getEventID());
            }
        });

        final OrangeButton saveCancelButton = new OrangeButton("saveCancelButton");
        saveCancelButton.setText("Cancel");
        saveCancelButton.setEventID(this.getClass().getName() + "." + saveCancelButton.getComponentID());
        saveCancelButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(saveCancelButton.getEventID());
            }
;        });

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
        saveLabel.setText("Enter name for rota to load: ");

        OrangeTextbox loadNameBox = new OrangeTextbox("loadNameBox");
        screenModel.setLoadNameBox(loadNameBox);

        final OrangeButton loadNameButton = new OrangeButton("loadNameButton");
        loadNameButton.setText("Load Rota");
        loadNameButton.setEventID(this.getClass().getName() + "." + loadNameButton.getComponentID());
        loadNameButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(loadNameButton.getEventID());
            }
        });

        final OrangeButton loadCancelButton = new OrangeButton("loadCancelButton");
        loadCancelButton.setText("Cancel");
        loadCancelButton.setEventID(this.getClass().getName() + "." + loadCancelButton.getComponentID());
        loadCancelButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(loadCancelButton.getEventID());
            }

        });

        VerticalPanel loadPopVP = new VerticalPanel();
        HorizontalPanel loadPopHP = new HorizontalPanel();
        loadPopVP.add(loadLabel);
        loadPopVP.add(loadNameBox);
        loadPopVP.add(loadPopHP);
        loadPopHP.add(loadNameButton);
        loadPopHP.add(loadCancelButton);

        OrangePopupPanel loadPop = new OrangePopupPanel("loadPop");
        loadPop.setVisible(false);
        loadPop.setSize("128",  "128");
        loadPop.add(loadPopVP);
        screenModel.setLoadPop(loadPop);


        //CLIENT EVENT STUFF
        RotaAddRowImpl rotaAddRow = new RotaAddRowImpl();
        rotaAddRow.setScreenModel(screenModel);

        RotaRemoveRowImpl rotaRemoveRow = new RotaRemoveRowImpl();
        rotaRemoveRow.setScreenModel(screenModel);

        RotaNewImpl rotaNew = new RotaNewImpl();
        rotaNew.setScreenModel(screenModel);

        RotaGetSaveName rotaSaveName = new RotaGetSaveName();
        rotaSaveName.setScreenmodel(screenModel);

        RotaCancelSaveRotaImpl rotaCancelSaveRota = new RotaCancelSaveRotaImpl();
        rotaCancelSaveRota.setScreenModel(screenModel);

        RotaCancelLoadRotaImpl rotaCancelLoadRota = new RotaCancelLoadRotaImpl();
        rotaCancelLoadRota.setScreenModel(screenModel);

        RotaGetLoadName rotaLoadName = new RotaGetLoadName();
        rotaLoadName.setScreenModel(screenModel);
        //-------------------------------

        //SERVER EVENT STUFF
        RotaSaveImpl rotaSave = new RotaSaveImpl();
        rotaSave.setScreenModel(screenModel);
        rotaSave.setService((OrangeServiceAsync) GWT.create(OrangeService.class));

        RotaLoadImpl rotaLoad = new RotaLoadImpl();
        rotaLoad.setScreenModel(screenModel);
        rotaLoad.setService((OrangeServiceAsync) GWT.create(OrangeService.class));
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



        handler.setMapOfProcesses(mapOfProcesses);
        root.add(rotaTable);
        root.add(addRowButton);
        root.add(removeRowButton);
        root.add(newButton);
        root.add(saveButton);
        root.add(loadButton);
        Window.alert("PluggerImpl.Setup: Done");
    }


}
