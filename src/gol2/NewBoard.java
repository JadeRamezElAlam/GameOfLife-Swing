package gol2;

import java.awt.Color;

import javax.swing.JButton;

public class NewBoard {

    private Board board = MainPanel.getBoard();//return initial board
    private JButton[][] cells = board.getCells();//return method that returns 25x 25 grid
    private int row = board.getRow(), column = board.getColumn();//returns number of rows found in board class
    private boolean newCells[][] = new boolean[row][column];//returns number of columns found in board class

    public NewBoard(){
        neighbours(); 
    }

    
    private void neighbours(){//checks number of neighbours enabling us to wrap around the board
        for(int i = 0; i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                int neighbours=0;
                for(int x = -1; x<2;x++){
                    for(int y=-1;y<2;y++){
                        if(x==0 && y==0);
                        else if(cells[(i+x+column)%column][(j+y+row)%row].isSelected()==true)
                        {
                            neighbours++;
                        }
                    }
                }
                
                newCells[i][j] = setCellStatus(cells[i][j],newCells[i][j],neighbours);//stores new cells in a boolean array and checks rules 
            }
        }
        createNewBoard();
    }

   
    private boolean setCellStatus(JButton cell, boolean newCell, int neighbours){

        if(cell.isSelected()==true && ((neighbours < 2) || (neighbours > 3))) { 
        	
        	newCell=false;//if cell has less than two neighbours or greater than 3 it dies
        	
        	}

        else if(cell.isSelected()==false && (neighbours==3)) {
        	newCell=true;//if cell has exactly three neighbours it lives
        }

        else if(cell.isSelected()==true) {
        	
        	newCell=true;
        	
        }

        else{
        	
            newCell=false; //Otherwise remain false
            
        }
        return newCell; //Return outcome to newCells index
    }
    
   
    
   
    private void createNewBoard(){//creates new board based on the boolean array 

        for(int i = 0; i<row;i++){
            for(int j = 0; j<column;j++){

                if(newCells[i][j]==true){
                    cells[i][j].setSelected(true);
                    cells[i][j].setBackground(Color.red);
                }
                else{
                    cells[i][j].setSelected(false);
                    cells[i][j].setBackground(Color.WHITE);
                }
            }
        }
        board.setCells(cells);
    }
}
