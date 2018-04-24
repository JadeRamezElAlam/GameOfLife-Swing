package gol2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class buttons extends JPanel implements ActionListener{

    
    private JButton run = new JButton("Start");
    private JButton pause = new JButton("Pause");
    private JButton reset = new JButton("Reset");

    public buttons(){

        setLayout(new GridLayout(1,3,0,0));

     
        run.setActionCommand("Start"); 
        run.addActionListener(this);

        
        pause.setActionCommand("Pause");
        pause.addActionListener(this);

        
        reset.setActionCommand("Reset");//key word to commence action listener
        reset.addActionListener(this);

        add(run);
        add(pause);
        add(reset);

    }

    
    public void actionPerformed(ActionEvent e) {

        Board board = MainPanel.getBoard();
        Counter counter = MainPanel.getCounter();

        if(e.getActionCommand()=="Start"){
        
            board.getTimer().start();//starts timer as well as action in Board class
        }
        if(e.getActionCommand()=="Pause"){
            
            board.getTimer().stop(); //Stops timer and action in Board Class
        }
        if(e.getActionCommand()=="Reset"){
            
            board.reset();
            counter.resetCount();//resets Iteration and board 
        }
    }
}