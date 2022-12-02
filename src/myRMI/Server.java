package myRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) {

        try {
            ImpInterface obj = new ImpInterface();

            Inter stub = (Inter) UnicastRemoteObject.exportObject(obj,2010);

            Registry registry = LocateRegistry.createRegistry(2010);
            registry.bind("RMI", stub);

            System.out.println("Le serveur est prêt ...");


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
