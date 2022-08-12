import javax.swing.*;
import java.util.Objects;

public class Digit extends Tile {

    public int xpos;
    public int ypos;
    public int[][] nearby_cells;


    public Digit (int xpos, int ypos) {

        super("", xpos, ypos);
        this.nearby_cells = Generator.get_nearby(xpos, ypos);

        this.xpos = xpos;
        this.ypos = ypos;

    }

    public void set_digit(Tile[][] field){

        int count = 0;
        for (int[] i : nearby_cells){
            int x = i[0];
            int y = i[1];
            if (field[y][x] instanceof Mine){
                count++;
            }
        }
        super.text = Integer.toString(count);
    }

    public void open(String type){
        Game.Current_opened++;
        super.setText(super.text);
        for (int[] i : nearby_cells){
            int x = i[0];
            int y = i[1];
            Tile target = Game.field[y][x];
            if (target instanceof Digit & ((Objects.equals(target.text, "0") & Objects.equals(type, "initial")) | (Objects.equals(this.text, "0"))) & Objects.equals(target.getText(), "")) {
                target.open("recursive");
            }
            if (Objects.equals(Game.Current_opened, Game.Win_target)){
                Main.win();
            }
        }
    }
}
