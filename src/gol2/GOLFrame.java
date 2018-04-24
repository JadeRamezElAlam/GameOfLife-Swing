package gol2;


import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GOLFrame extends JFrame implements Runnable
{
	 JFrame frame = new JFrame("Game of Life");
     MainPanel panel = new MainPanel();

    public void run() 
    {
         //Create and set up the Window
       
        //main panel class
        //sets panel in window
        frame.add(panel);
       
        frame.setSize(600,600);
        frame.setResizable(false);
        frame.pack();//sets all subpanels to their preferred sizes 
        //Display the frame.
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
			getSaveSnapShot(frame, "frame.gif");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
    public static BufferedImage getScreenShot(Component component) {

        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
        // paints into image's Graphics
        component.paint(image.getGraphics());
        return image;
    }

    public static void getSaveSnapShot(Component component, String fileName) throws Exception {
        BufferedImage img = getScreenShot(component);
        // write the captured image as a PNG
        ImageIO.write(img, "gif", new File(fileName));
    }

    
   
 
	
}