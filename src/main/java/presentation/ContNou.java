package presentation;

import bll.ClientBLL;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrei on 22/04/2017.
 */
public class ContNou extends JFrame {
    private JPanel panelPrincipal;
    private JTextField usernameField;
    private JTextField numeField;
    private JTextField adresaField;
    private JTextField varstaField;
    private JButton contNouButton;
    private JTextField parolaField;
    private JTextField emailField;


    public ContNou() {
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(380, 350);
        this.setLocationRelativeTo(null);
        this.setContentPane(panelPrincipal);
        contNouButton.addActionListener(new ButonContNou());
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayoutManager(7, 2, new Insets(20, 10, 20, 10), 10, -1));
        panelPrincipal.setBackground(new Color(-5404120));
        panelPrincipal.setMinimumSize(new Dimension(420, 350));
        panel1.add(panelPrincipal, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        usernameField = new JTextField();
        usernameField.setEditable(true);
        panelPrincipal.add(usernameField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 30), new Dimension(500, 200), 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Comic Sans MS", -1, 16, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Username");
        panelPrincipal.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(200, 20), 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Comic Sans MS", -1, 16, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Nume");
        panelPrincipal.add(label2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(200, 20), 0, false));
        numeField = new JTextField();
        panelPrincipal.add(numeField, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 30), new Dimension(500, 200), 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Comic Sans MS", -1, 16, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Adresa");
        panelPrincipal.add(label3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(200, 20), 0, false));
        adresaField = new JTextField();
        panelPrincipal.add(adresaField, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 30), new Dimension(500, 200), 0, false));
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Comic Sans MS", -1, 16, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setText("Varsta");
        panelPrincipal.add(label4, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(200, 20), 0, false));
        varstaField = new JTextField();
        panelPrincipal.add(varstaField, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 30), new Dimension(500, 200), 0, false));
        contNouButton = new JButton();
        contNouButton.setBackground(new Color(-11225979));
        Font contNouButtonFont = this.$$$getFont$$$("Constantia", -1, 14, contNouButton.getFont());
        if (contNouButtonFont != null) contNouButton.setFont(contNouButtonFont);
        contNouButton.setHorizontalAlignment(0);
        contNouButton.setHorizontalTextPosition(0);
        contNouButton.setText("Cont nou");
        panelPrincipal.add(contNouButton, new GridConstraints(6, 1, 1, 1, GridConstraints.ANCHOR_SOUTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(130, 20), new Dimension(300, 40), 0, false));
        final JLabel label5 = new JLabel();
        Font label5Font = this.$$$getFont$$$("Comic Sans MS", -1, 16, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setText("Parola");
        panelPrincipal.add(label5, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(200, 20), 0, false));
        parolaField = new JTextField();
        panelPrincipal.add(parolaField, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 30), new Dimension(500, 200), 0, false));
        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$("Comic Sans MS", -1, 16, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setText("Email");
        panelPrincipal.add(label6, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(200, 20), 0, false));
        emailField = new JTextField();
        panelPrincipal.add(emailField, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 30), new Dimension(500, 200), 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    public class ButonContNou implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {

                String username = usernameField.getText();
                String nume = numeField.getText();
                String adresa = adresaField.getText();
                String email = emailField.getText();
                int varsta = Integer.parseInt(varstaField.getText());
                String parola = parolaField.getText();

                Client client = new Client(username, nume, adresa, email, varsta, parola);
                ClientBLL clientBLL = new ClientBLL();
                clientBLL.insert(client);
                JOptionPane.showMessageDialog(null, "A fost creat un cont nou!");

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }


        }

    }

}