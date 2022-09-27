import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Tile extends JButton {
    public Object source;

    public String text;

    public Tile (String text, int xpos, int ypos) {
        super(text);
        ActionListener l = (ActionEvent e) -> {
            this.source = e.getSource();
            if (Game.state.equals("open")){
                this.open("initial");
            } else if (Game.state.equals("flag")) {
                this.flag();
            }
        };
        this.addActionListener(l);
    }

    public void set_digit(Tile[][] field) {

    }
    public void flag(){
        if (!Objects.equals(this.getText(), "")){

        }
        else if ((!this.getText().equals("X"))) {
            this.setText("X");
            Game.flagged_cells++;
        }
        else{
            this.setText("");
            Game.flagged_cells--;
        }
        Game.mines.setText(Integer.toString(Game.m_amount-Game.flagged_cells));
    }
    public void open(String type){

    }
}
