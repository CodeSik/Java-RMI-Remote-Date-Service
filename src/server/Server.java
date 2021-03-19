package server;

import rdate.RemoteDate;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Server implements RemoteDate
{
    public Server(){}


    @Override
    public Date remoteDate() throws RemoteException {
        Date now = new Date();

        System.out.println("클라이언트가 remoteDate() method invoke");
        return now;
    }

    @Override
    public String regionalDate(Locale language) throws RemoteException {
        String pattern = "yyyy MMMMM dd EEEEE HH:mm:ss.SSSZ";
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat(pattern, language);

        String date = simpleDateFormat.format(new Date());

        System.out.println("클라이언트가 regionalDate() method invoke");
        return date;
    }

    public static void main(String[] args)
    {
        System.setProperty("java.security.policy","file:/C:/RMI_Assignment/server.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        Server obj = new Server();
        try {
            RemoteDate stub = (RemoteDate) UnicastRemoteObject.exportObject(obj,0);
            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry(0);
            registry.rebind("RemoteDate", stub);
            System.out.println("Server ready");
        }
        catch (Exception e) {
            System.out.println("Server exception: " + e.toString());
        }
    }


}
