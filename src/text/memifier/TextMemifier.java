/* 
 * Copyright (C) 2016 Hadi Soufi
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package text.memifier;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import javax.swing.JOptionPane;

/**
 *
 * @author Hadi Soufi
 */
public class TextMemifier extends javax.swing.JFrame {

    /**
     * Creates new form TextMemifier
     */
    public TextMemifier() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_input = new javax.swing.JTextField();
        cmb_options = new javax.swing.JComboBox<>();
        btn_okay = new javax.swing.JToggleButton();
        scrl_output = new javax.swing.JScrollPane();
        txt_output = new javax.swing.JTextArea();
        btn_copy = new javax.swing.JButton();
        chk_reddit = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Memifier");

        txt_input.setToolTipText("Enter the text you'd like to memify here");

        cmb_options.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Row", "Row & Col", "Square", "Reverse Square" }));
        cmb_options.setToolTipText("Select the meme text type");

        btn_okay.setText("Memify!");
        btn_okay.setToolTipText("Generate your meme text");
        btn_okay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okayActionPerformed(evt);
            }
        });

        txt_output.setEditable(false);
        txt_output.setColumns(20);
        txt_output.setRows(5);
        txt_output.setToolTipText("You cannot type here, only copy the generated text.");
        scrl_output.setViewportView(txt_output);

        btn_copy.setText("Copy");
        btn_copy.setToolTipText("Copy the generated text to your clipboard");
        btn_copy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_copyMouseClicked(evt);
            }
        });

        chk_reddit.setText("For Reddit");
        chk_reddit.setToolTipText("If Row is selected, has no effect");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrl_output)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmb_options, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chk_reddit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_input, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_okay))
                    .addComponent(btn_copy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_okay)
                    .addComponent(cmb_options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_reddit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrl_output, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_copy)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_okayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okayActionPerformed
        switch (cmb_options.getSelectedIndex()) {
            //"Row"
            case 0:
                txt_output.setText(generateMemeRow(txt_input.getText()));
                break;
            //"Row&Col"
            case 1:
                txt_output.setText(generateMemeRowCol(txt_input.getText()));
                break;
            //"Square"
            case 2:
                txt_output.setText(generateMemeSquare(txt_input.getText(), false));
                break;
            //"Reverse Square"
            case 3:
                txt_output.setText(generateMemeSquare(txt_input.getText(), true));
                break;
            default:
                JOptionPane.showConfirmDialog(null, "Not a valid style", "Error", JOptionPane.ERROR);
        }
    }//GEN-LAST:event_btn_okayActionPerformed

    private void btn_copyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_copyMouseClicked
        //Select generated text
        StringSelection stringSelection = new StringSelection(txt_output.getText());
        
        //Copy it to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }//GEN-LAST:event_btn_copyMouseClicked

    /**
     * Formats a String
     *  eX   ampLE
     * becomes
     *  E X A M P L E
     */
    private String generateMemeRow(String txt) {
        //Step 1: Make all characters uppercase
        //Step 2: Remove all spaces
        //Step 3: Put a space after every character
        return txt.toUpperCase().replace(" ", "").replaceAll("\\B", " ");
    }

    /**
     * Formats a String
     *  eX   ampLE
     * becomes
     *  E X A M P L E
     *  X
     *  A
     *  M
     *  P
     *  L
     *  E
     */
    private String generateMemeRowCol(String txt) {
        String memified = generateMemeRow(txt);
        txt = memified.replace(" ", "");
        String spacing = (chk_reddit.isSelected() ? "\n" : "") + "\n";

        for (int i = 1; i < txt.length(); i++) {
            memified += spacing + txt.charAt(i);
        }
        return memified;
    }

    /**
     * Formats a String
     *  eX   ampLE
     * becomes
     *  E X A M P L E
     *  X A M P L E E
     *  A M P L E E X
     *  M P L E E X A
     *  P L E E X A M
     *  L E E X A M P
     *  E E X A M P L
     * 
     * OR
     * 
     *  E X A M P L E
     *  A M P L E E X 
     *  M P L E E X A 
     *  P L E E X A M 
     *  L E E X A M P 
     *  E E X A M P L 
     *  E X A M P L E 
     * 
     * @param reversed If true, second formatting. If false, first formatting
     */
    private String generateMemeSquare(String txt, boolean reversed) {
        String memified = generateMemeRow(txt);
        String currentRow = memified.replaceAll(" ", "");
        String spacing = (chk_reddit.isSelected() ? "\n" : "") + "\n";

        if(reversed) {
            for (int i = 0; i < txt.length() - 1; i++) {
                currentRow = 
                    //The last character of currentRow concatenated with
                    currentRow.charAt(currentRow.length() - 1) + 
                    //the other letters in currentRow
                    currentRow.substring(0, currentRow.length() - 1);

                memified += spacing + generateMemeRow(currentRow);
            }
        } else {
            for (int i = 0; i < txt.length() - 1; i++) {
                currentRow = 
                    //The second and succeeding letters of currentRow concatenated with
                    currentRow.substring(1)
                    //the first character of currentRow
                    + currentRow.charAt(0);

                memified += spacing + generateMemeRow(currentRow);
            }
        }
        return memified;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextMemifier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TextMemifier().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_copy;
    private javax.swing.JToggleButton btn_okay;
    private javax.swing.JCheckBox chk_reddit;
    private javax.swing.JComboBox<String> cmb_options;
    private javax.swing.JScrollPane scrl_output;
    private javax.swing.JTextField txt_input;
    private javax.swing.JTextArea txt_output;
    // End of variables declaration//GEN-END:variables
}
