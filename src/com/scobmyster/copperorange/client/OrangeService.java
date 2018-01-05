package com.scobmyster.copperorange.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.scobmyster.copperorange.shared.Envelope;


/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("call")
public interface OrangeService extends RemoteService
{
    Envelope saveRota(Envelope envelope) throws IllegalArgumentException;
    Envelope loadRota(Envelope envelope) throws IllegalArgumentException;
    Envelope fetchFileNames(Envelope envelope) throws IllegalArgumentException;
    Envelope login(Envelope envelope) throws IllegalArgumentException;
    Envelope register(Envelope envelope) throws IllegalArgumentException;
}
