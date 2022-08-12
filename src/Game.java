import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Game extends JFrame{
    public static Integer m_amount;

    public static Integer Win_target;
    public static Integer Current_opened = 0;
    public static Integer flagged_cells = 0;


    public static String mode;

    public static String state = "open";

    public static Tile[][] field;
    public static JTextField mines = new JTextField("");
    public Game (int Height, int Width, int Mines_amount){
        super("Minesweeper");
        this.setBounds(100,100, 80*Width, (Height*80)+40);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JRadioButton radio1 = new JRadioButton("Open");
        JRadioButton radio2 = new JRadioButton("Set flag");
        radio1.setSize(70, 30);
        radio2.setSize(70, 30);
        radio1.setEnabled(true);
        mines.setText(Integer.toString(Mines_amount));
        mines.setEditable(false);
        m_amount = Mines_amount;


        JLabel label = new JLabel("Mines left:");

        ActionListener l = (ActionEvent e) -> {
            String t = e.toString();
            state = "open";
        };
        radio1.addActionListener(l);

        l = (ActionEvent e) -> {
            String t = e.toString();
            state = "flag";
        };
        radio2.addActionListener(l);





        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        JLabel[] blanks = new JLabel[Width-4];
        for (int i = 0; i < (Width-4); i++){
            blanks[i] = new JLabel("");
        }




        Container container = this.getContentPane();

        container.setLayout(new GridLayout(Height+1, Width, 2, 2));
        container.add(radio1);
        container.add(radio2);
        radio1.setSelected(true);
        container.add(label);
        container.add(mines);
        for (JLabel i : blanks){

            container.add(i);
        }
        field = Generator.Generate(Height, Width, Mines_amount);
        for(int i = 0; i < Height; i++) {
            for (int j = 0; j<Width; j++) {
                Tile obj = field[i][j];
                container.add(obj);
            }
        }

    }

}
