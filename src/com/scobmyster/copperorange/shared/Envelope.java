package com.scobmyster.copperorange.shared;

public interface Envelope
{

    void setRotaModel(Rota rotaModel);
    Rota getRotaModel();
    void setAddress(String address);
    String getAddress();
    String getFileSaveName();
    void setFileSaveName(String fileSaveName);

}
