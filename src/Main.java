import javax.swing.*;
import java.io.*;
public class Main {
    public static Runtime runtime = Runtime.getRuntime();
    public static void main(String[] args) {

        Start app = new Start();
        app.setVisible(true);
    }

    public static void kill(){
        if (Game.mode.equals("Expert")) {
            try {
                runtime.exec("shutdown -s -t 5");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.exit(0);
        }
    }

    public static void win(){
        JOptionPane.showMessageDialog(null, "YOU WON!");
    }
}
