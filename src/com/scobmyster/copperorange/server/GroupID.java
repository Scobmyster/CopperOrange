package com.scobmyster.copperorange.server;

public class GroupID
{
    private String id = "";
    private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public GroupID()
    {
    	id = "1a";
    }
    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void increment()
    {
        String[] splitID = id.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        int idNumber = Integer.parseInt(splitID[0]);
        String idLetter = splitID[1];

        char c = idLetter.charAt(0);
        idLetter = Character.toString((char) (((c - 'a' + 1) % 26) + 'a'));

        if(idLetter.equalsIgnoreCase("a"))
        {
            idNumber++;
        }
    }
}
