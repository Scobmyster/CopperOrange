package com.scobmyster.copperorange.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.scobmyster.copperorange.client.process.ProcessModel;
import com.scobmyster.copperorange.client.process.client.RotaAddRowImpl;
import com.scobmyster.copperorange.client.process.client.RotaNewImpl;
import com.scobmyster.copperorange.client.process.client.RotaRemoveRowImpl;
import com.scobmyster.copperorange.client.widgets.OrangeButton;
import com.scobmyster.copperorange.client.widgets.OrangeFlexTable;

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

        RotaAddRowImpl rotaAddRow = new RotaAddRowImpl();
        rotaAddRow.setScreenModel(screenModel);

        RotaRemoveRowImpl rotaRemoveRow = new RotaRemoveRowImpl();
        rotaRemoveRow.setScreenModel(screenModel);

        RotaNewImpl rotaNew = new RotaNewImpl();
        rotaNew.setScreenModel(screenModel);



        HashMap<String, ProcessModel> mapOfProcesses = new HashMap<>();

        mapOfProcesses.put(addRowButton.getEventID(), (ProcessModel) rotaAddRow);
        mapOfProcesses.put(removeRowButton.getEventID(), (ProcessModel) rotaRemoveRow);
        mapOfProcesses.put(newButton.getEventID(), (ProcessModel) rotaNew);


        handler.setMapOfProcesses(mapOfProcesses);
        root.add(rotaTable);
        root.add(addRowButton);
        root.add(removeRowButton);
        root.add(newButton);
    }

    public void setRotaTable(OrangeFlexTable rotaTable)
    {
        this.rotaTable = rotaTable;
    }

}
