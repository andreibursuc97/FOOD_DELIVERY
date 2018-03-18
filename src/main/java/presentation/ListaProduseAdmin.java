package presentation;

import bll.ProdusBLL;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaProduseAdmin extends JFrame {
    private JPanel panel1;
    private JScrollPane ScrollPane;
    private JTable table1;
    private JButton adaugaProdusButton;
    private JTextField idField;
    private JButton modificaProdusButton;

    private MyModel model;
    private String[] selectedData;
    private ListSelectionModel listSelectionModel;

    public ListaProduseAdmin() {
        model = new MyModel();

        table1 = new JTable();
        listSelectionModel = table1.getSelectionModel();
        table1.setSelectionModel(listSelectionModel);
        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
        table1.setSelectionModel(listSelectionModel);
        $$$setupUI$$$();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        this.setLocationRelativeTo(null);
        this.setContentPane(panel1);
        this.setSize(600, 400);
        //adaugaProdusButton.addActionListener(new ButonAdaugaInCos());


        //this.setResizable(false);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        table1 = new JTable();
        listSelectionModel = table1.getSelectionModel();
        table1.setSelectionModel(listSelectionModel);
        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
        table1.setSelectionModel(listSelectionModel);
        modelUpdate();
        table1.setModel(model);
        table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table1.add(table1.getTableHeader(), BorderLayout.PAGE_START);

        ScrollPane = new JScrollPane(table1);

    }

    public JTextField getIdField() {
        return idField;
    }

    public void modelUpdate() {
        String[] columnNames = {"Id", "Descriere", "Cantitate", "Pret"};


        ProdusBLL produsBLL = new ProdusBLL();
        ArrayList<String[]> date;
        date = produsBLL.afiseazaProduse();

        model.setColumnNames(columnNames);
        model.setList(date);

    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public MyModel getModel() {
        return model;
    }

    public void setModel(MyModel model) {
        this.model = model;
    }

    public void setAdaugaProdusButton(ActionListener e) {
        adaugaProdusButton.addActionListener(e);
    }

    public void setModificaProdusButton(ActionListener e) {
        modificaProdusButton.addActionListener(e);
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
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(4, 2, new Insets(20, 10, 20, 10), -1, -1));
        panel1.setBackground(new Color(-5404120));
        panel2.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ScrollPane.setBackground(new Color(-5404120));
        ScrollPane.setForeground(new Color(-5404120));
        panel1.add(ScrollPane, new GridConstraints(0, 0, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        table1.setBackground(new Color(-11225979));
        table1.setFillsViewportHeight(true);
        ScrollPane.setViewportView(table1);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel3.setBackground(new Color(-5404120));
        panel1.add(panel3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Id Produs");
        panel3.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        adaugaProdusButton = new JButton();
        adaugaProdusButton.setBackground(new Color(-11225979));
        Font adaugaProdusButtonFont = this.$$$getFont$$$("Comic Sans MS", -1, 14, adaugaProdusButton.getFont());
        if (adaugaProdusButtonFont != null) adaugaProdusButton.setFont(adaugaProdusButtonFont);
        adaugaProdusButton.setText("Adauga produs");
        panel3.add(adaugaProdusButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(30, 15), new Dimension(200, 30), 0, false));
        idField = new JTextField();
        idField.setEditable(false);
        panel3.add(idField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 15), new Dimension(200, 30), 0, false));
        modificaProdusButton = new JButton();
        modificaProdusButton.setBackground(new Color(-11225979));
        Font modificaProdusButtonFont = this.$$$getFont$$$("Comic Sans MS", -1, 14, modificaProdusButton.getFont());
        if (modificaProdusButtonFont != null) modificaProdusButton.setFont(modificaProdusButtonFont);
        modificaProdusButton.setText("Modifica produs");
        panel3.add(modificaProdusButton, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(30, 15), new Dimension(200, 30), 0, false));
    }

    class SharedListSelectionHandler implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            if (table1.getSelectedRow() != -1)
                idField.setText(table1.getValueAt(table1.getSelectedRow(), 0).toString());

        }
    }
}
