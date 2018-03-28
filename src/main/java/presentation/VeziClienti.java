package presentation;

import bll.ClientBLL;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;

/**
 * Created by Andrei on 26/04/2017.
 */
public class VeziClienti extends JFrame {
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton dateClientButton;
    private JTextField idField;
    private JButton istoricCosuriButton;
    private JButton loialButon;
    private JButton obisnuitButton;
    private JButton meniuButton;
    private MyModel model;
    private ListSelectionModel listSelectionModel;


    public VeziClienti() {
        model = new MyModel();

        table1 = new JTable();
        listSelectionModel = table1.getSelectionModel();
        table1.setSelectionModel(listSelectionModel);
        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
        table1.setSelectionModel(listSelectionModel);
        $$$setupUI$$$();
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        // this.setSize(380, 350);

        this.setLocation(650, 300);
        this.setContentPane(panel1);
        this.setSize(600, 400);

    }

    public void setDateClientButton(ActionListener e) {
        dateClientButton.addActionListener(e);
    }

    public void setIstoricCosuriButton(ActionListener e) {
        istoricCosuriButton.addActionListener(e);
    }

    public void setLoialButon(ActionListener e) {
        loialButon.addActionListener(e);
    }

    public void setObisnuitButton(ActionListener e) {
        obisnuitButton.addActionListener(e);
    }

    public void setMeniuButton(ActionListener e) {
        meniuButton.addActionListener(e);
    }

    public JTextField getIdField() {
        return idField;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        table1 = new JTable();
        listSelectionModel = table1.getSelectionModel();
        table1.setSelectionModel(listSelectionModel);
        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
        table1.setSelectionModel(listSelectionModel);
        ///pretField = new JTextField();
        modelUpdate();
        table1.setModel(model);
        table1.setFillsViewportHeight(true);
        scrollPane1 = new JScrollPane(table1);

        //listSelectionModel = table1.getSelectionModel();
        //table1.setSelectionModel(listSelectionModel);

        //table1.getModel().setValueAt();
        //dateTabel, columnNames
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
        panel1.setLayout(new GridLayoutManager(3, 5, new Insets(20, 10, 20, 10), -1, -1));
        panel1.setBackground(new Color(-5404120));
        panel2.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        scrollPane1.setBackground(new Color(-11225979));
        Font scrollPane1Font = this.$$$getFont$$$("Comic Sans MS", -1, 14, scrollPane1.getFont());
        if (scrollPane1Font != null) scrollPane1.setFont(scrollPane1Font);
        panel1.add(scrollPane1, new GridConstraints(0, 0, 2, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        table1.setBackground(new Color(-11225979));
        table1.setFillsViewportHeight(true);
        scrollPane1.setViewportView(table1);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(5, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel3.setBackground(new Color(-5404120));
        panel1.add(panel3, new GridConstraints(0, 1, 1, 4, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Id Client");
        panel3.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        dateClientButton = new JButton();
        dateClientButton.setBackground(new Color(-11225979));
        Font dateClientButtonFont = this.$$$getFont$$$("Comic Sans MS", -1, 14, dateClientButton.getFont());
        if (dateClientButtonFont != null) dateClientButton.setFont(dateClientButtonFont);
        dateClientButton.setText("Date Client");
        panel3.add(dateClientButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(30, 15), new Dimension(200, 30), 0, false));
        idField = new JTextField();
        idField.setEditable(false);
        panel3.add(idField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 15), new Dimension(200, 30), 0, false));
        loialButon = new JButton();
        loialButon.setBackground(new Color(-11225979));
        Font loialButonFont = this.$$$getFont$$$("Comic Sans MS", -1, 14, loialButon.getFont());
        if (loialButonFont != null) loialButon.setFont(loialButonFont);
        loialButon.setText("Seteaza ca loial");
        panel3.add(loialButon, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(30, 15), new Dimension(200, 30), 0, false));
        obisnuitButton = new JButton();
        obisnuitButton.setBackground(new Color(-11225979));
        Font obisnuitButtonFont = this.$$$getFont$$$("Comic Sans MS", -1, 12, obisnuitButton.getFont());
        if (obisnuitButtonFont != null) obisnuitButton.setFont(obisnuitButtonFont);
        obisnuitButton.setText("Seteaza ca obisnuit");
        panel3.add(obisnuitButton, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(30, 15), new Dimension(200, 30), 0, false));
        istoricCosuriButton = new JButton();
        istoricCosuriButton.setBackground(new Color(-11225979));
        Font istoricCosuriButtonFont = this.$$$getFont$$$("Comic Sans MS", -1, 14, istoricCosuriButton.getFont());
        if (istoricCosuriButtonFont != null) istoricCosuriButton.setFont(istoricCosuriButtonFont);
        istoricCosuriButton.setText("Istoric Cosuri");
        panel3.add(istoricCosuriButton, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(30, 15), new Dimension(200, 30), 0, false));
        meniuButton = new JButton();
        meniuButton.setBackground(new Color(-11225979));
        Font meniuButtonFont = this.$$$getFont$$$("Comic Sans MS", -1, 14, meniuButton.getFont());
        if (meniuButtonFont != null) meniuButton.setFont(meniuButtonFont);
        meniuButton.setText("Meniu");
        panel1.add(meniuButton, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(30, 15), new Dimension(200, 30), 0, false));
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

    class SharedListSelectionHandler implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            if (table1.getSelectedRow() != -1)
                idField.setText(table1.getValueAt(table1.getSelectedRow(), 0).toString());

        }
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

    public void modelUpdate() {
        String[] columnNames = {"Id", "Username", "Nume", "Adresa", "Email", "Varsta", "Loial"};

        //ListSelectionModel listSelectionModel;
        //JTableHeader=new JTableHeader()
        ClientBLL clientBLL = new ClientBLL();
        ArrayList<String[]> date;
        date = clientBLL.showAll();
        model.setColumnNames(columnNames);
        model.setList(date);
        /*for (int i = 0; i < dateTabel.length; i++)
            for (int j = 0; j < columnNames.length; j++)
                model.setValueAt(dateTabel[i][j], i, j);*/


        //return model;
    }

}
