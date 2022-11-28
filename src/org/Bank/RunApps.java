package org.Bank;

import javax.swing.*;

public class RunApps {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Data User Bank");
        jf.setContentPane(new FormUserBank().getRootPanel());
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(500,280);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
}
