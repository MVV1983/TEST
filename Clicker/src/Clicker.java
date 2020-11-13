import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clicker extends JFrame {
    public Clicker(){
        setTitle("Clicker");
        setSize(360,380);
        setLocation(350,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new Mainwindow());
        setVisible(true);
    }

    public static void main(String[] args){
       Clicker clicker = new Clicker();
    }
}
