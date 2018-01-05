package com.scobmyster.copperorange.shared;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class Rota implements Serializable {

    private String[] cellText;
    private int[] rowpos;
    private int[] colpos;

    public String[] getCellText() {
        return cellText;
    }

    @XmlElement
    public void setCellText(String[] cellText) {
        this.cellText = cellText;
    }

    public int[] getRowpos()
    {
        return rowpos;
    }
    @XmlElement
    public void setRowpos(int[] rowpos)
    {
        this.rowpos = rowpos;
    }

    public int[] getColpos()
    {
        return colpos;
    }
    @XmlElement
    public void setColpos(int[] colpos)
    {
        this.colpos = colpos;
    }
}
