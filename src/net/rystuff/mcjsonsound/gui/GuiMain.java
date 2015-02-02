package net.rystuff.mcjsonsound.gui;

import net.rystuff.mcjsonsound.swing.FileChooser;
import net.rystuff.mcjsonsound.swing.FolderChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiMain extends JPanel implements ActionListener
{
    public static JButton settings = new JButton("Settings");
    public static JButton generate = new JButton("Generate");
    
    public static JTextField modidText = new JTextField(30);
    public static JLabel modid = new JLabel("ModID");
    
    public GuiMain(JFrame frame)
    {
        JPanel buttons = new JPanel();
        JPanel modids = new JPanel();
        setLayout(new GridLayout(4, 1));
        FolderChooser assets = new FolderChooser("Select Assets Dir", "Browse...");
        FileChooser json = new FileChooser("Output json file", "Browse...");
        json.addFileTypeFilter(".json", "json Files");
        json.setMode(FileChooser.MODE_SAVE);
        modids.add(modid);
        modids.add(modidText);
        add(modids);
        add(assets);
        add(json);
        buttons.add(settings);
        buttons.add(generate);
        add(buttons);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
    }
}
