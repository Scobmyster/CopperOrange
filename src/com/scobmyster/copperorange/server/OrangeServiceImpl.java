package com.scobmyster.copperorange.server;

import com.scobmyster.copperorange.client.OrangeService;
import com.scobmyster.copperorange.shared.Envelope;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */

public class OrangeServiceImpl extends RemoteServiceServlet implements OrangeService {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args)
    {

    }

    @Override
    public Envelope saveRota(Envelope envelope) throws IllegalArgumentException
    {
        new Saver().save(envelope);
        return envelope;
    }

    @Override
    public Envelope loadRota(Envelope envelope) throws IllegalArgumentException
    {
        new Loader().load(envelope);
        return envelope;
    }
}
