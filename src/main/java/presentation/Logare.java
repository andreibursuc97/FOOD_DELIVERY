package presentation;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Andrei on 20/04/2017.
 */
public class Logare extends JFrame {
    private JTextField parolaField;
    private JButton logareButton;
    private JTextField usernameField;
    private JPanel panelPrincipal;
    private JButton contNouButton;
    private JButton logareAdminButon;

    public Logare() {


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setContentPane(panelPrincipal);
        this.setResizable(false);
        this.setVisible(true);

    }

    public void setContNouButton(ActionListener e) {
        contNouButton.addActionListener(e);
    }

    public void setLogareButton(ActionListener e) {
        logareButton.addActionListener(e);
    }


    public void setLogareAdminButon(ActionListener e) {
        logareAdminButon.addActionListener(e);
    }


    public JTextField getUsernameField() {
        return usernameField;
    }


    public JTextField getParolaField() {
        return parolaField;
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

    private void createUIComponents() {
        // TODO: place custom component creation code here
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
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayoutManager(3, 3, new Insets(20, 10, 20, 10), 10, 10));
        panelPrincipal.setBackground(new Color(-5404120));
        panelPrincipal.setEnabled(true);
        panelPrincipal.setPreferredSize(new Dimension(430, 200));
        final JLabel label1 = new JLabel();
        label1.setAlignmentX(0.5f);
        Font label1Font = this.$$$getFont$$$("Comic Sans MS", -1, 16, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setHorizontalTextPosition(10);
        label1.setText("Username");
        panelPrincipal.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 20), new Dimension(90, 20), new Dimension(200, 20), 0, false));
        usernameField = new JTextField();
        Font usernameFieldFont = this.$$$getFont$$$("Comic Sans MS", -1, 14, usernameField.getFont());
        if (usernameFieldFont != null) usernameField.setFont(usernameFieldFont);
        panelPrincipal.add(usernameField, new GridConstraints(0, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 30), new Dimension(500, 40), 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-5404120));
        panelPrincipal.add(panel1, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        logareButton = new JButton();
        logareButton.setBackground(new Color(-11225979));
        Font logareButtonFont = this.$$$getFont$$$("Comic Sans MS", -1, 14, logareButton.getFont());
        if (logareButtonFont != null) logareButton.setFont(logareButtonFont);
        logareButton.setHorizontalAlignment(0);
        logareButton.setHorizontalTextPosition(0);
        logareButton.setText("Logare");
        panel1.add(logareButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(100, 40), 0, false));
        contNouButton = new JButton();
        contNouButton.setBackground(new Color(-11225979));
        Font contNouButtonFont = this.$$$getFont$$$("Comic Sans MS", -1, 14, contNouButton.getFont());
        if (contNouButtonFont != null) contNouButton.setFont(contNouButtonFont);
        contNouButton.setHorizontalAlignment(0);
        contNouButton.setHorizontalTextPosition(0);
        contNouButton.setText("Cont nou");
        panel1.add(contNouButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(100, 40), 0, false));
        logareAdminButon = new JButton();
        logareAdminButon.setBackground(new Color(-11225979));
        Font logareAdminButonFont = this.$$$getFont$$$("Comic Sans MS", -1, 14, logareAdminButon.getFont());
        if (logareAdminButonFont != null) logareAdminButon.setFont(logareAdminButonFont);
        logareAdminButon.setHorizontalAlignment(0);
        logareAdminButon.setHorizontalTextPosition(0);
        logareAdminButon.setText("Admin");
        panel1.add(logareAdminButon, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(100, 40), 0, false));
        parolaField = new JPasswordField();
        panelPrincipal.add(parolaField, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 30), new Dimension(500, 400), 0, false));
        final JLabel label2 = new JLabel();
        label2.setAlignmentX(0.5f);
        Font label2Font = this.$$$getFont$$$("Comic Sans MS", -1, 16, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setHorizontalTextPosition(10);
        label2.setText("Parola");
        panelPrincipal.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 20), new Dimension(80, 20), new Dimension(200, 20), 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelPrincipal;
    }
}
