package myRMI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.rmi.RemoteException;

public class ImpInterface implements Inter {

    @Override
    public File sendFile(File file) throws Exception {
        return file;
    }

    @Override
    public File setRedFilter(File file) throws Exception {

        BufferedImage buff = ImageIO.read(file);

        File newFile = new File("red-image.jpg");
        newFile.createNewFile();

        for(int i=0 ; i < buff.getHeight() ; i++){
            for(int j=0 ; j < buff.getWidth() ; j++){

                Color c = new Color(buff.getRGB(j,i));

                int red = 255 - c.getRed();
                //int green = 255 - c.getGreen();
                //int blue = 255 - c.getBlue();

                Color newColor = new Color(red,0,0);
                buff.setRGB(j,i,newColor.getRGB());
            }
        }

        ImageIO.write(buff, "jpg", newFile);

        return newFile;
    }

    @Override
    public File setGreenFilter(File file) throws Exception {

        BufferedImage buff = ImageIO.read(file);

        File newFile = new File("green-image.jpg");
        newFile.createNewFile();

        for(int i=0 ; i < buff.getHeight() ; i++){
            for(int j=0 ; j < buff.getWidth() ; j++){

                Color c = new Color(buff.getRGB(j,i));

                int green = 255 - c.getGreen();

                Color newColor = new Color(0,green,0);
                buff.setRGB(j,i,newColor.getRGB());
            }
        }

        ImageIO.write(buff, "jpg", newFile);

        return newFile;
    }

    @Override
    public File setBlueFilter(File file) throws Exception {
        BufferedImage buff = ImageIO.read(file);

        File newFile = new File("blue-image.jpg");
        newFile.createNewFile();

        for(int i=0 ; i < buff.getHeight() ; i++){
            for(int j=0 ; j < buff.getWidth() ; j++){

                Color c = new Color(buff.getRGB(j,i));

                int blue = 255 - c.getBlue();

                Color newColor = new Color(0,0,blue);
                buff.setRGB(j,i,newColor.getRGB());
            }
        }

        ImageIO.write(buff, "jpg", newFile);

        return newFile;
    }

    @Override
    public void printMessage(String message) throws RemoteException {
        System.out.println(message);
    }
}
