package org.Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class FormUserBank {
    private JTextField textNomorKartu;
    private JComboBox comboJenisATM;
    private JComboBox comboBank;
    private JTextField textNamaPemilik;
    private JButton buttonBrowserImage;
    private JButton buttonSimpan;
    private JPanel rootPanel;
    private JTextArea textUser;
    private JLabel tempatKeluarGambar;

    public String getnamagambar;

    public void masukDatakeFile(String inputdata) throws IOException{
        FileWriter df = new FileWriter("DataBase.txt",true);
        df.write(inputdata);
        df.close();
    }

    public FormUserBank() {
        buttonSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getNomorKartu = textNomorKartu.getText();
                String getJenisATM = (String) comboJenisATM.getSelectedItem();
                String getBank = (String) comboBank.getSelectedItem();
                String getNamaPemilik = textNamaPemilik.getText();
                String Hasil = "\nNOMOR KARTU :" + getNomorKartu + "\nJENIS ATM :" + getJenisATM +"\nBANK :" +getBank + "\nNAMA PEMILIK :" + getNamaPemilik + "\nNama File :" + getnamagambar;
                textUser.append(Hasil);
                try {
                    FileWriter df = new FileWriter("DataBase.txt",true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    masukDatakeFile(Hasil + "\n\n");

                }catch (IOException ex){
                    throw new RuntimeException(ex);
                }

            }
        });

        buttonBrowserImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser img = new JFileChooser();
                int dipilih = img.showSaveDialog(null);
                if(dipilih == JFileChooser.APPROVE_OPTION){
                    String fileImage = img.getSelectedFile().getName();
                    getnamagambar = fileImage;
                }
                ImageIcon gb = new ImageIcon(new ImageIcon(img.getSelectedFile().getAbsolutePath()).getImage().getScaledInstance(120,100,Image.SCALE_SMOOTH));
                tempatKeluarGambar.setIcon(gb);


                
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
