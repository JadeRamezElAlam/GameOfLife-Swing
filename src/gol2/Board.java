package gol2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{

    private static final long serialVersionUID = 2324324543246L;
    // set Size of board
    private int column=30,row=30;
    
    private  JButton[][] cells = new JButton[row][column]; //create a JButton 25x 25 array
    private Timer timer;//delays recurring action after specified time

   public Board(){    
        setLayout(new GridLayout(column,row,0,0));//lays and places components
        //Populate cells with default settings
        for(int i = 0; i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                cells[i][j] = new JButton(); 
                cells[i][j].setBackground(Color.WHITE); 
                cells[i][j].setPreferredSize(new Dimension(20,20));
                cells[i][j].setActionCommand("Pressed");
                cells[i][j].addActionListener(this);
                add(cells[i][j]); 
            }
        }
        //Create new timer to trigger events every second
        timer = new Timer(1000, this); 
        timer.setActionCommand("Timer");
        timer.setInitialDelay(0); 
    }
    public JButton[][] getCells() {
        return cells;//method to return original size of array
    }
    public void setCells(JButton[][] cells) {
        this.cells = cells;//sets initial array to a new one
    }

    public Timer getTimer() {
        return timer;//return time
    }
  

    public int getColumn() {
        return column;//returns 25
    }
    public int getRow() {
        return row;//returns 25
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Pressed")) {//loops the entire grid to determine which button is pressed

            
            for(int i = 0; i<row;i++){
                for(int j=0;j<column;j++){

                    if(e.getSource()==cells[i][j]){
                        selectedCells(cells[i][j]);
                    }
                }
            }
        }
        if(e.getActionCommand().equals("Timer")){

            //updates board after 1 second each time
            MainPanel.getCounter().incrementCount();
           
            NewBoard newBoard = new NewBoard();//sets new board
        }
    }

    public void reset(){
        //Resets board
        for(int i = 0; i<row;i++){
            for(int j=0;j<column;j++){
                cells[i][j].setSelected(false); 
                cells[i][j].setBackground(Color.WHITE);
            }
        }
        timer.stop();
    }

    private void selectedCells(JButton cell){
        
        if(cell.isSelected()==false){
            cell.setBackground(Color.red);//changes colour of cell if clicked
            cell.setSelected(true);
        }
        //If cell is already selected changes back to black
        else{
            cell.setBackground(Color.WHITE);
            cell.setSelected(false);
        }
    }
    

  

}