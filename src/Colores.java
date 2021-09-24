
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author ferna
 */
public class Colores {

    static Color ParadisePink = new Color(239, 71, 111);
    static Color OrangeYellowCrayola = new Color(239, 71, 111);
    static Color CaribbeanGreen = new Color(6, 214, 160);
    static Color BlueNCS = new Color(17, 138, 178);
    static Color MidnightGreenEagle = new Color(7, 59, 76);

    static void resaltar(JButton b1, JButton b2, JButton b3) {
        b1.setBorder(BorderFactory.createLineBorder(Color.red));
        b2.setBorder(BorderFactory.createLineBorder(Color.red));
        b3.setBorder(BorderFactory.createLineBorder(Color.red));
        /*b1.setOpaque(true);
        b2.setBackground(Color.red);
        b2.setOpaque(true);
        b3.setBackground(Color.red);
        b3.setOpaque(true);*/
    }

    static void sinResaltar(JButton b1, JButton b2, JButton b3, JButton b4, JButton b5,
            JButton b6, JButton b7, JButton b8, JButton b9) {
        b1.setBorder(BorderFactory.createEmptyBorder());
        b2.setBorder(BorderFactory.createEmptyBorder());
        b3.setBorder(BorderFactory.createEmptyBorder());
        b4.setBorder(BorderFactory.createEmptyBorder());
        b5.setBorder(BorderFactory.createEmptyBorder());
        b6.setBorder(BorderFactory.createEmptyBorder());
        b7.setBorder(BorderFactory.createEmptyBorder());
        b8.setBorder(BorderFactory.createEmptyBorder());
        b9.setBorder(BorderFactory.createEmptyBorder());
    }
}
