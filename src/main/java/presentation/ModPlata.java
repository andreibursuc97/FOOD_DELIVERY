package presentation;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ModPlata extends JFrame {

    private JPanel panel1;
    private JPanel panelPrincipal;
    private JTextField plataField;
    private JButton efectueazaPlataButton;
    private JRadioButton cashRadioButton;
    private JRadioButton cardRadioButton;
    private JPasswordField codField;
    private JTextField numeField;
    private JTextField numarCardField;
    private JTextField dataExpirareField;

    public ModPlata() {
        ButtonGroup group = new ButtonGroup();
        $$$setupUI$$$();
        group.add(cashRadioButton);
        group.add(cardRadioButton);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(panelPrincipal);
        this.setResizable(false);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

    }

    public JTextField getPlataField() {
        return plataField;
    }

    public void setEfectueazaPlataButton(ActionListener e) {
        efectueazaPlataButton.addActionListener(e);
    }

    public JRadioButton getCashRadioButton() {
        return cashRadioButton;
    }

    public JPasswordField getCodField() {
        return codField;
    }

    public JTextField getNumeField() {
        return numeField;
    }

    public JTextField getNumarCardField() {
        return numarCardField;
    }

    public JTextField getDataExpirareField() {
        return dataExpirareField;
    }

    public JRadioButton getCardRadioButton() {
        return cardRadioButton;
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayoutManager(7, 3, new Insets(20, 10, 20, 10), 10, -1));
        panelPrincipal.setBackground(new Color(-5404120));
        panelPrincipal.setMinimumSize(new Dimension(420, 350));
        panel1.add(panelPrincipal, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        plataField = new JTextField();
        plataField.setEditable(false);
        panelPrincipal.add(plataField, new GridConstraints(0, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 30), new Dimension(500, 200), 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Comic Sans MS", -1, 16, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Total de plata");
        panelPrincipal.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(200, 20), 0, false));
        efectueazaPlataButton = new JButton();
        efectueazaPlataButton.setBackground(new Color(-11225979));
        Font efectueazaPlataButtonFont = this.$$$getFont$$$("Constantia", -1, 14, efectueazaPlataButton.getFont());
        if (efectueazaPlataButtonFont != null) efectueazaPlataButton.setFont(efectueazaPlataButtonFont);
        efectueazaPlataButton.setHorizontalAlignment(0);
        efectueazaPlataButton.setHorizontalTextPosition(0);
        efectueazaPlataButton.setText("Efectueaza plata");
        panelPrincipal.add(efectueazaPlataButton, new GridConstraints(6, 1, 1, 2, GridConstraints.ANCHOR_SOUTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(130, 20), new Dimension(300, 40), 0, false));
        cashRadioButton = new JRadioButton();
        cashRadioButton.setBackground(new Color(-11225979));
        Font cashRadioButtonFont = this.$$$getFont$$$("Comic Sans MS", -1, 16, cashRadioButton.getFont());
        if (cashRadioButtonFont != null) cashRadioButton.setFont(cashRadioButtonFont);
        cashRadioButton.setSelected(true);
        cashRadioButton.setText("Cash");
        panelPrincipal.add(cashRadioButton, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cardRadioButton = new JRadioButton();
        cardRadioButton.setBackground(new Color(-11225979));
        Font cardRadioButtonFont = this.$$$getFont$$$("Comic Sans MS", -1, 16, cardRadioButton.getFont());
        if (cardRadioButtonFont != null) cardRadioButton.setFont(cardRadioButtonFont);
        cardRadioButton.setSelected(false);
        cardRadioButton.setText("Card");
        panelPrincipal.add(cardRadioButton, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        numeField = new JTextField();
        numeField.setEditable(true);
        numeField.setText("Dan Popescu");
        panelPrincipal.add(numeField, new GridConstraints(1, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 30), new Dimension(500, 200), 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Comic Sans MS", -1, 16, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Nume de pe card");
        panelPrincipal.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(200, 20), 0, false));
        numarCardField = new JTextField();
        numarCardField.setEditable(true);
        numarCardField.setText("XXXX-XXXX-XXXX-XXXX");
        panelPrincipal.add(numarCardField, new GridConstraints(2, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 30), new Dimension(500, 200), 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Comic Sans MS", -1, 16, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Numar card");
        panelPrincipal.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(200, 20), 0, false));
        dataExpirareField = new JTextField();
        dataExpirareField.setEditable(true);
        dataExpirareField.setEnabled(true);
        dataExpirareField.setText("LL/AAAA");
        panelPrincipal.add(dataExpirareField, new GridConstraints(3, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 30), new Dimension(500, 200), 0, false));
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Comic Sans MS", -1, 16, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setText("Data expirare");
        panelPrincipal.add(label4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(200, 20), 0, false));
        final JLabel label5 = new JLabel();
        Font label5Font = this.$$$getFont$$$("Comic Sans MS", -1, 16, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setText("Cod Securitate");
        panelPrincipal.add(label5, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(80, 20), new Dimension(200, 20), 0, false));
        codField = new JPasswordField();
        panelPrincipal.add(codField, new GridConstraints(4, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(200, 30), new Dimension(500, 40), 0, false));
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

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
