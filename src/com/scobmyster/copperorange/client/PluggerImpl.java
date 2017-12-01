package com.scobmyster.copperorange.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.client.process.client.RotaAddRowImpl;
import com.scobmyster.copperorange.client.process.client.RotaGetSaveName;
import com.scobmyster.copperorange.client.process.client.RotaNewImpl;
import com.scobmyster.copperorange.client.process.client.RotaRemoveRowImpl;
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
        Window.alert("PluggerImpl.Setup: Starting");
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

        //Popup Panel for name rota will be saved under
        Window.alert("PluggerImpl.Setup: Setting up popup panel widgets");
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

        VerticalPanel savePopVP = new VerticalPanel();
        savePopVP.add(saveLabel);
        savePopVP.add(saveNameBox);
        savePopVP.add(saveNameButton);

        OrangePopupPanel savePop = new OrangePopupPanel("savePop");
        savePop.setVisible(false);
       savePop.setSize("128",  "128");
        savePop.add(savePopVP);
        screenModel.setSavePop(savePop);


        //CLIENT EVENT STUFF
        RotaAddRowImpl rotaAddRow = new RotaAddRowImpl();
        rotaAddRow.setScreenModel(screenModel);

        RotaRemoveRowImpl rotaRemoveRow = new RotaRemoveRowImpl();
        rotaRemoveRow.setScreenModel(screenModel);

        RotaNewImpl rotaNew = new RotaNewImpl();
        rotaNew.setScreenModel(screenModel);

        RotaGetSaveName rotaSaveName = new RotaGetSaveName();
        rotaSaveName.setScreenmodel(screenModel);
        Window.alert("PluggerImpl.Setup: Setting client stuff");
        //-------------------------------

        //SERVER EVENT STUFF
        RotaSaveImpl rotaSave = new RotaSaveImpl();
        rotaSave.setScreenModel(screenModel);
        rotaSave.setService((OrangeServiceAsync) GWT.create(OrangeService.class));
        Window.alert("PluggerImpl.Setup: Setting server stuff");
        //-------------------------------

        HashMap<String, ProcessModel> mapOfProcesses = new HashMap<>();

        mapOfProcesses.put(addRowButton.getEventID(), (ProcessModel) rotaAddRow);
        mapOfProcesses.put(removeRowButton.getEventID(), (ProcessModel) rotaRemoveRow);
        mapOfProcesses.put(newButton.getEventID(), (ProcessModel) rotaNew);
        mapOfProcesses.put(saveButton.getEventID(), (ProcessModel) rotaSaveName);
        mapOfProcesses.put(saveNameButton.getEventID(), (ProcessModel) rotaSave);


        handler.setMapOfProcesses(mapOfProcesses);
        root.add(rotaTable);
        root.add(addRowButton);
        root.add(removeRowButton);
        root.add(newButton);
        root.add(saveButton);
        //root.add(savePop);
        Window.alert("PluggerImpl.Setup: Done");
    }


}
