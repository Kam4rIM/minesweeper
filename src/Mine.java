import javax.swing.*;

public class Mine extends Tile {

    public Mine (int xpos, int ypos) {
        super("", xpos, ypos);
        super.text = "MINE";
    }

    public void open(String type){
        super.setText(super.text);
        JOptionPane.showMessageDialog(null, "DAYMN BRO YOU ARE DUMB");
        Main.kill();
    }
}
