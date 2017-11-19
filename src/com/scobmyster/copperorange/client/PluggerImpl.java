package com.scobmyster.copperorange.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.client.process.client.RotaAddRowImpl;
import com.scobmyster.copperorange.client.process.client.RotaRemoveRowImpl;
import com.scobmyster.copperorange.client.widgets.OrangeButton;
import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;

import java.util.HashMap;

public class PluggerImpl
{

    private static ScreenModelImpl screenModel = new ScreenModelImpl();
    private static ClientSideHandler handler = new ClientSideHandler();
    private TableBuilder tableBuilder = new TableBuilder();


    public void setup(RootPanel root)
    {


        OrangeFlexTable rotaTable = new OrangeFlexTable("rotaTable");
        rotaTable.setScreenModel(screenModel);
        rotaTable = tableBuilder.createTable(5, 4);
        screenModel.setRotaTable(rotaTable);

        final OrangeButton addRow = new OrangeButton("addRow");
        addRow.setText("Add Row");
        addRow.setEventID(this.getClass().getName() + "." + addRow.getComponentID());
        addRow.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent)
            {
                handler.handleEvent(addRow.getEventID());
            }});

        final OrangeButton removeRow = new OrangeButton("removeRow");
        removeRow.setText("Remove Row");
        removeRow.setEventID(this.getClass().getName() + "." + removeRow.getComponentID());
        removeRow.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                handler.handleEvent(removeRow.getEventID());
            }
        });

        OrangeButton pushMe = new OrangeButton("pushMe");
        pushMe.setText("Push Me");

        pushMe.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Window.alert("It's ya birthday!!!");
            }});

        RotaAddRowImpl rotaAddRow = new RotaAddRowImpl();
        rotaAddRow.setScreenModel(screenModel);

        RotaRemoveRowImpl rotaRemoveRow = new RotaRemoveRowImpl();
        rotaRemoveRow.setScreenModel(screenModel);

        HashMap<String, ProcessModel> mapOfProcesses = new HashMap<>();

        mapOfProcesses.put(addRow.getEventID(), (ProcessModel) rotaAddRow);
        mapOfProcesses.put(removeRow.getEventID(), (ProcessModel) rotaRemoveRow);


        handler.setMapOfProcesses(mapOfProcesses);
        root.add(pushMe);
        root.add(rotaTable);
        root.add(addRow);
        root.add(removeRow);
    }

}
