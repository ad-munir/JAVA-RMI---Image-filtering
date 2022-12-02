package myRMI;

import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.getRegistry("localhost",2010);

            ImpInterface obj = new ImpInterface();

            Inter stub = (Inter) registry.lookup("RMI");



            System.out.println("Le client est prêt ...");


            File file = new File("copa.jpg");
            stub.sendFile(file);

            stub.printMessage("file receiveid from client");

            stub.setRedFilter(file);
            //stub.setGreenFilter(file);
            //stub.setBlueFilter(file);

            stub.printMessage("server: filtering is done");


            System.out.println("client: filtering is done");


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
