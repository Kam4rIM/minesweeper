import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame {
    public Start() {
        super("Settings");
        this.setBounds(400, 300, 450, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 3,2,2));

        JButton start_button = new JButton("START");

        JLabel label1 = new JLabel("WIDTH");
        JLabel label2 = new JLabel("HEIGHT");
        JLabel label3 = new JLabel("MINES AMOUNT");

        JTextField input1 = new JTextField("9");
        JTextField input2 = new JTextField("9");
        JTextField input3 = new JTextField("10");

        JCheckBox checkbox = new JCheckBox("Expert Mode");
        JLabel label4 = new JLabel("Shutdown PC on loose");

        container.add(label1);
        container.add(label2);
        container.add(label3);

        container.add(input1);
        container.add(input2);
        container.add(input3);

        container.add(checkbox);
        container.add(label4);
        container.add(start_button);

        ActionListener l = (ActionEvent e) -> {
            int width = Integer.parseInt(input1.getText());
            int height = Integer.parseInt(input2.getText());
            int mines_amount = Integer.parseInt(input3.getText());
            Game.Win_target = (width * height)-mines_amount;
            Generator.maxx = width-1;
            Generator.maxy = height-1;
            Game app = new Game(height, width, mines_amount);
            app.setVisible(true);
            this.setVisible(false);
            if (checkbox.isSelected()){
                Game.mode = "Expert";
            }
            else {
                Game.mode = "Noob";
            }
        };
        start_button.addActionListener(l);



    }
}