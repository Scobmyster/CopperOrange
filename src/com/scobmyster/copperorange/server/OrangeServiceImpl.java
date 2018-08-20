package com.scobmyster.copperorange.server;

import com.scobmyster.copperorange.client.OrangeService;
import com.scobmyster.copperorange.shared.Envelope;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.scobmyster.copperorange.shared.Group;

/**
 * The server-side implementation of the RPC service.
 */

public class OrangeServiceImpl extends RemoteServiceServlet implements OrangeService
{

    private static final long serialVersionUID = 1L;
    UserManager userManager = new UserManager();
    GroupManager groupManager = new GroupManager();
    Linker linker = new Linker();

    public static void main(String[] args)
    {

    }

    @Override
    public Envelope saveRota(Envelope envelope) throws IllegalArgumentException
    {
        Saver saver = new Saver();
        saver.setGroupManager(groupManager);
        saver.save(envelope);
        return envelope;
    }

    @Override
    public Envelope loadRota(Envelope envelope) throws IllegalArgumentException
    {
        new Loader().load(envelope);
        return envelope;
    }

    @Override
    public Envelope fetchFileNames(Envelope envelope) throws IllegalArgumentException
    {
        Loader loader = new Loader();
        loader.setGroupManager(groupManager);
        loader.populateList(envelope);
        return envelope;
    }

    @Override
    public Envelope login(Envelope envelope) throws IllegalArgumentException
    {
        System.out.println("Hitting the login on the server");
        userManager.loginUser(envelope);
        return envelope;
    }

    @Override
    public Envelope register(Envelope envelope) throws IllegalArgumentException
    {
        System.out.println("Hitting the register on the server");
        userManager.registerUser(envelope);
        return envelope;
    }

    @Override
    public Envelope registerGroup(Envelope envelope) throws IllegalArgumentException
    {
        System.out.println("Registering new group");
        groupManager.setUserManager(userManager);
        groupManager.RegisterGroup(envelope);
        return envelope;
    }

    @Override
    public Envelope fetchGroupNames(Envelope envelope) throws IllegalArgumentException
    {
        System.out.println("Fetching group with the prefix: " + envelope.getSearchPrefix() + " in their name");
        groupManager.FetchGroups(envelope);
        return envelope;
    }

    @Override
    public Envelope joinGroup(Envelope envelope) throws IllegalArgumentException
    {
        System.out.println("Joining group with the name: " + envelope.getGroupName() + " /// with user: " + envelope.getUserModel().getUsername());
        groupManager.AddUserToGroup(envelope);
        return envelope;
    }

    @Override
    public Envelope userSetupService(Envelope envelope) throws IllegalArgumentException
    {
        System.out.println("Running user setup service for user: " + envelope.getUserModel().getUsername());
        envelope.setGroup(groupManager.GetGroupFromName(envelope.getUserModel().FindGroupByID(0)));
        return envelope;
    }

    @Override
    public Envelope groupFetchMyGroups(Envelope envelope) throws IllegalArgumentException
    {
        System.out.println("Fetching the list of this users groups");
        envelope.setMyGroupNames(groupManager.GrabMyGroups(envelope));
        return envelope;
    }

    @Override
    public Envelope groupSwitch(Envelope envelope) throws IllegalArgumentException
    {
        envelope.setGroup(groupManager.GetGroupFromName(envelope.getGroupName()));
        return envelope;
    }

    @Override
    public Envelope userLinkToRota(Envelope envelope) throws IllegalArgumentException
    {
    	linker.setUserManager(userManager);
        linker.LinkUserAndRota(envelope);
        return envelope;
    }
}
