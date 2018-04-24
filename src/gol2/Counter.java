package gol2;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class Counter extends JLabel{

     int count = 0;

    public Counter(){

       
        setOpaque(true);
        setText("Generation");
        setHorizontalAlignment(JLabel.CENTER);//places text in the centre
        setBorder(new EmptyBorder(10,10,10,10));

    }

    public void incrementCount(){
        setText(String.valueOf(count++));//allows us to show count next to the iteration text
    }
    

    public void resetCount(){
        count = 0;//resets iteration count
        setText("Generation");
    }

}