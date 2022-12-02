package myRMI;


import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Inter extends Remote {

    public File sendFile(File file) throws Exception;

    public File setRedFilter(File file) throws Exception;

    public File setGreenFilter(File file) throws Exception;

    public File setBlueFilter(File file) throws Exception;

    public void printMessage(String message) throws RemoteException;

}
