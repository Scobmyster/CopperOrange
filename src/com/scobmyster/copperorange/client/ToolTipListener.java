package com.scobmyster.copperorange.client;

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;
import com.scobmyster.copperorange.client.widgets.OrangeButton;
import com.scobmyster.copperorange.client.widgets.OrangeReturnButton;
import com.scobmyster.copperorange.client.widgets.OrangeTableCell;

class ToolTipListener extends MouseListenerAdapter
{

    private static final String DEFAULT_TOOLTIP_STYLE = "TooltipPopup";
    private static final int DEFAULT_OFFSET_X = 50;
    private static final int DEFAULT_OFFSET_Y = 5;
    private static ClientSideHandler handler;
    private static ScreenModelImpl screenModel;
    private static boolean overToolTip = false;


    private static class Tooltip extends PopupPanel
    {
        private int delay;


        public Tooltip(Widget sender, int offsetX, int offsetY, final String text, final int delay, final String styleName)
        {
            super(true);

            this.delay = delay;


            HorizontalPanel panel = new HorizontalPanel();

            OrangeReturnButton bt_link = new OrangeReturnButton("link", handler, "Link");
            screenModel.setBt_Link(bt_link);
            bt_link.setSender((OrangeTableCell) sender);

            bt_link.addMouseOverHandler(new MouseOverHandler()
            {
                @Override
                public void onMouseOver(MouseOverEvent mouseOverEvent)
                {
                    overToolTip = true;
                }
            });
            bt_link.addMouseOutHandler(new MouseOutHandler()
            {
                @Override
                public void onMouseOut(MouseOutEvent mouseOutEvent)
                {
                    //overToolTip = false;
                }
            });
            panel.add(bt_link);
            add(panel);

            int left = sender.getAbsoluteLeft() + offsetX;
            int top = sender.getAbsoluteTop() + offsetY;

            setPopupPosition(left, top);
            setStyleName(styleName);
        }

        public void show()
        {
            super.show();

            Timer t = new Timer()
            {
                public void run()
                {
                    if(overToolTip == false)
                        Tooltip.this.hide();
                }
            };
            t.schedule(delay);

        }
    }

    private Tooltip tooltip;
    private String text;
    private String stylename;
    private int delay;
    private int offsetX = DEFAULT_OFFSET_X;
    private int offsetY = DEFAULT_OFFSET_Y;

    public ToolTipListener(String text, int delay)
    {
        this(text, delay, DEFAULT_TOOLTIP_STYLE);
    }

    public ToolTipListener(String text, int delay, String stylename)
    {
        this.text = text;
        this.delay = delay;
        this.stylename = stylename;
    }

    @Override
    public void onMouseDown(Widget sender, int x, int y)
    {
        if(tooltip != null)
        {
            if(overToolTip == false)
                tooltip.hide();
        }
        tooltip = new Tooltip(sender, offsetX, offsetY, text, delay, stylename);
        tooltip.show();
    }

    @Override
    public void onMouseLeave(Widget sender)
    {
        Timer t = new Timer()
        {
            @Override
            public void run()
            {
                if (tooltip != null)
                {
                    if (overToolTip == false)
                        tooltip.hide();
                }
            }
        };
        t.schedule(delay);

    }

    public String getStylename()
    {
        return stylename;
    }

    public void setStylename(String stylename)
    {
        this.stylename = stylename;
    }

    public int getOffsetX()
    {
        return offsetX;
    }

    public void setOffsetX(int offsetX)
    {
        this.offsetX = offsetX;
    }

    public int getOffsetY()
    {
        return offsetY;
    }

    public void setOffsetY(int offsetY)
    {
        this.offsetY = offsetY;
    }

    public void setHandler(ClientSideHandler handler)
    {
        ToolTipListener.handler = handler;
    }

    public static void setScreenModel(ScreenModelImpl screenModel)
    {
        ToolTipListener.screenModel = screenModel;
    }
}
