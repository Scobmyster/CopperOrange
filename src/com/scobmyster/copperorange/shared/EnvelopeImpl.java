package com.scobmyster.copperorange.shared;

import java.io.Serializable;

public class EnvelopeImpl implements Envelope, Serializable
{

    private Rota rotaModel = new Rota();
    private String address = "";
    private String fileSaveName = "";
    private String rotaLoadName = "";

    @Override
    public void setRotaModel(Rota rotaModel)
    {
        this.rotaModel = rotaModel;
    }

    @Override
    public Rota getRotaModel()
    {
        return rotaModel;
    }

    @Override
    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getFileSaveName() {
        return fileSaveName;
    }

    @Override
    public void setFileSaveName(String fileSaveName) {
        this.fileSaveName = fileSaveName;
    }

    @Override
    public String getRotaLoadName() {
        return rotaLoadName;
    }

    @Override
    public void setRotaLoadName(String rotaLoadName) {
        this.rotaLoadName = rotaLoadName;
    }


}
