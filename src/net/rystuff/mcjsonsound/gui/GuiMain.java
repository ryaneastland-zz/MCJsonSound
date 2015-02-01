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
    
    public GuiMain(JFrame frame)
    {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        FolderChooser assets = new FolderChooser("Select Assets Dir", "Browse...");
        FileChooser json = new FileChooser("Output json file", "Browse...");
        json.addFileTypeFilter(".json", "json Files");
        json.setMode(FileChooser.MODE_SAVE);
        add(assets);
        add(json);
        add(settings);
        add(generate);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
    }
}
