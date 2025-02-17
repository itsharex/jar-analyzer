package com.chaitin.jar.analyzer.form;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommonForm {
    public JPanel commonPanel;
    private JScrollPane commonScroll;
    private JPanel opPanel;
    private JButton sendButton;
    private JTextField curText;
    private JTable commonTable;
    private static final Object[] a;
    private static final Object[][] b;

    static {
        a = new String[]{"Class", "Method"};
        b = new String[][]{
                new String[]{"javax.naming.Context", "lookup"},
                new String[]{"java.lang.Runtime", "exec"},
                new String[]{"java.lang.ProcessBuilder", "start"},
                new String[]{"java.io.ObjectInputStream", "readObject"},
                new String[]{"org.springframework.expression.Expression", "getValue"},
                new String[]{"org.yaml.snakeyaml.Yaml", "load"},
                new String[]{"com.alibaba.fastjson.JSON", "parse"},
                new String[]{"java.beans.XMLDecoder", "readObject"}
        };
    }

    public CommonForm(JarAnalyzerForm instance) {
        DefaultTableModel model = new DefaultTableModel(b, a) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.commonTable.setModel(model);

        sendButton.addActionListener(e -> {
            String text = curText.getText();
            String[] temp = text.split("\t");
            instance.classText.setText(temp[0]);
            instance.methodText.setText(temp[1]);
            instance.callSearchRadioButton.setSelected(true);
            instance.closeCommon();
        });

        this.commonTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int row = commonTable.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    String className = (String) b[row][0];
                    String methodName = (String) b[row][1];
                    curText.setText(String.format("%s\t%s", className, methodName));
                }
            }
        });
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
        commonPanel = new JPanel();
        commonPanel.setLayout(new GridLayoutManager(2, 1, new Insets(5, 5, 5, 5), -1, -1));
        commonScroll = new JScrollPane();
        commonPanel.add(commonScroll, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        commonTable = new JTable();
        commonTable.setEnabled(true);
        commonScroll.setViewportView(commonTable);
        opPanel = new JPanel();
        opPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        commonPanel.add(opPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        sendButton = new JButton();
        sendButton.setText("发送到主界面");
        opPanel.add(sendButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        curText = new JTextField();
        opPanel.add(curText, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return commonPanel;
    }

}
