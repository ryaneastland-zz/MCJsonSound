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
    
    public static FolderChooser assets;
    public static FileChooser json;
    
    public GuiMain(JFrame frame)
    {
        JPanel buttons = new JPanel();
        JPanel modids = new JPanel();
        setLayout(new GridLayout(4, 1));
        assets = new FolderChooser("Select Assets Dir", "Browse...");
        json = new FileChooser("Output json file", "Browse...");
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
        settings.addActionListener(this);
        generate.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == settings)
        {
            GuiSettings frame = new GuiSettings();
            frame.setSize(500, 500);
            frame.setTitle("MCJsonSound Settings");
            frame.setResizable(false);
            frame.setVisible(true);
        }
        if (e.getSource() == generate)
        {
            if (modidText.getText() != null ||  assets.getSelectedFilePath() != null || json.getSelectedFilePath() != null)
            {
                generate.setEnabled(false);
                new Scan(modidText.getText(), assets.getSelectedFilePath(), json.getSelectedFilePath());
                generate.setEnabled(true);
            }
            else 
                System.out.println("Invalid modid, assets dir or json file!");
        }
    }
}
