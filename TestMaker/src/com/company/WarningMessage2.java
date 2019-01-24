package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WarningMessage2 extends JFrame implements ActionListener {

    JButton bConfirm;
    JLabel lMessage;

    public WarningMessage2 (JFrame owner)
    {
        setSize(300, 300);
        setTitle("Uwaga!");
        setLayout(null);

        lMessage = new JLabel("Wybierz element z listy");
        lMessage.setBounds(30,30,250,50);
        add(lMessage);

        bConfirm = new JButton("ok");
        bConfirm.setBounds(100,100,100,100);
        bConfirm.addActionListener(this);
        add(bConfirm);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object eventSource = e.getSource();
        if(eventSource == bConfirm) dispose();
    }
}

