/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lea.gui.components;

import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author Lea
 */
public class SwitchCardButton extends JButton {

    public SwitchCardButton(String toolTipText, String cardAction) {
        super();
        setPreferredSize(new Dimension(70, 50));
        setBorder(null);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setToolTipText(toolTipText);
        setActionCommand(cardAction);
    }
    
    
    
    
}
