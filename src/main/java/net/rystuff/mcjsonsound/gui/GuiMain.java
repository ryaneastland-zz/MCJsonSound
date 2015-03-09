package net.rystuff.mcjsonsound.gui;

import net.rystuff.mcjsonsound.NewScan;
import net.rystuff.mcjsonsound.swing.FileChooser;
import net.rystuff.mcjsonsound.swing.FolderChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GuiMain extends JPanel implements ActionListener
{
    public static JButton settings = new JButton("Settings");
    public static JButton generate = new JButton("Generate");
    
    public static JTextField modidText = new JTextField(30);
    public static JLabel modid = new JLabel("ModID");
    
    public static FolderChooser assets;
    public static FileChooser json;

    public static JPanel panel;
    
    public GuiMain(JFrame frame)
    {
        panel = new JPanel();
        JPanel buttons = new JPanel();
        JPanel modids = new JPanel();
        setLayout(new GridLayout(4, 1));
        assets = new FolderChooser("Select Assets Dir", "Browse...");
        json = new FileChooser("Output json file", "Browse...");
        json.addFileTypeFilter(".json", "json Files");
        json.setMode(FileChooser.MODE_SAVE);
        modids.add(modid);
        modids.add(modidText);
        panel.add(modids);
        panel.add(assets);
        panel.add(json);
        buttons.add(settings);
        buttons.add(generate);
        panel.add(buttons);
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
            if (modidText.getText().equals("") || assets.getSelectedFilePath().equals("") || json.getSelectedFilePath().equals(""))
            {
                if (modidText.getText().equals(""))
                {
                    System.out.println("ModID NOT Specified!");
                }
                if (assets.getSelectedFilePath().equals(""))
                {
                    System.out.println("Assets Directory NOT Specified!");
                }
                if (json.getSelectedFilePath().equals(""))
                {
                    System.out.println("Json File NOT Specified!");
                }
            }
            else
            {
                generate.setEnabled(false);
                try
                {
                    new NewScan(modidText.getText(), assets.getSelectedFilePath(), json.getSelectedFilePath());
                }
                catch (IOException e1)
                {
                    e1.printStackTrace();
                }
                generate.setEnabled(true);
            }
        }
    }
}
