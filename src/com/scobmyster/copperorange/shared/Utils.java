package com.scobmyster.copperorange.shared;

public class Utils
{

    public int adaptNumberToTableCoords(int realNum)
    {
        return (realNum - 1);
    }

    public  int adaptTableCoordsToNumber(int coordNum)
    {
        return (coordNum + 1);
    }

}
