package com.scobmyster.copperorange.client.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.scobmyster.copperorange.client.ScreenModelImpl;

public class OrangeFlexTable extends FlexTable
{

    private String componentID;
    private ScreenModelImpl screenModel;
    private FlexCellFormatter cellFormatter = this.getFlexCellFormatter();

    public OrangeFlexTable(String componentID)
    {
        this.componentID = componentID;
    }

    public void setScreenModel(ScreenModelImpl screenModel)
    {
        this.screenModel = screenModel;
    }
    public ScreenModelImpl getScreenModel()
    {
        return screenModel;
    }

    public void setupRota(int rowCount, int colCount)
    {
        this.setWidth("32em");
        this.setCellSpacing(5);
        this.setCellPadding(3);

        //Add some text
        cellFormatter.setHorizontalAlignment(0, 1, HasHorizontalAlignment.ALIGN_LEFT);
        this.setHTML(0, 0, "someTexts");
        cellFormatter.setColSpan(0, 0, 2);

        //Add a button that will add rows
        OrangeButton addRowButton = new OrangeButton("addRowButton");
        addRowButton.setText("Add row");
        addRowButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                addRow();
            }
        });

        //Add a button that will remove rows
        OrangeButton removeRowButton = new OrangeButton("removeRowButton");
        removeRowButton.setText("Remove row");
        removeRowButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                removeRow();
            }
        });

        VerticalPanel buttonPanel = new VerticalPanel();
        buttonPanel.add(addRowButton);

    }


    private void addRow()
    {

    }

    private void removeRow()
    {

    }

}
