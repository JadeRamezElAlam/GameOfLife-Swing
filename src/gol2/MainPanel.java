package gol2;

import javax.swing.JPanel;
import java.awt.BorderLayout;


public class MainPanel extends JPanel 
{
    private static Board board;
    private static buttons button;
    private static Counter counter;

    
    public MainPanel() 
    {
        
        setLayout(new BorderLayout());
        
        button= new buttons();//add subpanels
        board = new Board();
        counter = new Counter();

        
        add(button,BorderLayout.NORTH);
        add(board,BorderLayout.CENTER);
        add(counter,BorderLayout.SOUTH);
    }

    public static Board getBoard() {
        return board;//static allows us to use instance variables it doesn't need an initial object to be called
    }

    public static Counter getCounter(){
        return counter;
    }
    
}