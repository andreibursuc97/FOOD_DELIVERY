package presentation;

import bll.CosBLL;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdminIstoricCosuri extends JFrame {
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private MyModel model;
    private int id;

    public AdminIstoricCosuri() {
        model = new MyModel();

        $$$setupUI$$$();
        table1 = new JTable();
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // this.setSize(380, 350);

        this.setLocationRelativeTo(null);
        this.setContentPane(panel1);
        this.setSize(700, 400);
        //finalizareButton.addActionListener(new CosCurent.FinalizareComanda());
        //finalizareButton.addActionListener();
    }

    public void setId(int id) {
        this.id = id;
    }

    private void createUIComponents() {

        table1 = new JTable();
        ///pretField = new JTextField();
        modelUpdate();
        table1.setModel(model);

        table1.setFillsViewportHeight(true);

        //listSelectionModel = table1.getSelectionModel();
        //table1.setSelectionModel(listSelectionModel);

        //table1.getModel().setValueAt();
        //dateTabel, columnNames
        scrollPane1 = new JScrollPane(table1);
        // TODO: place custom component creation code here
    }

    public void modelUpdate() {
        String[] columnNames = {"Id", "Id Client", "Data", "Pret total", "Mod de plata"};

        //ListSelectionModel listSelectionModel;
        //JTableHeader=new JTableHeader()
        CosBLL cosBLL = new CosBLL();
        ArrayList<String[]> date;
        date = cosBLL.adminVeziCosuri(id);
        model.setColumnNames(columnNames);
        model.setList(date);
        /*for (int i = 0; i < dateTabel.length; i++)
            for (int j = 0; j < columnNames.length; j++)
                model.setValueAt(dateTabel[i][j], i, j);*/


        //return model;
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
        panel1.setLayout(new GridLayoutManager(2, 1, new Insets(20, 10, 20, 10), -1, -1));
        panel1.setBackground(new Color(-5404120));
        panel2.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        scrollPane1.setBackground(new Color(-11225979));
        Font scrollPane1Font = this.$$$getFont$$$("Comic Sans MS", -1, 14, scrollPane1.getFont());
        if (scrollPane1Font != null) scrollPane1.setFont(scrollPane1Font);
        panel1.add(scrollPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        table1.setBackground(new Color(-11225979));
        table1.setFillsViewportHeight(true);
        scrollPane1.setViewportView(table1);
    }
}
