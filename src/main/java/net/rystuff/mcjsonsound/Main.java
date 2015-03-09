package net.rystuff.mcjsonsound;

import net.rystuff.mcjsonsound.gui.GuiMain;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main
{
    public static Main instance;
    public static JFrame frame;
    public static GuiMain guiMain;
    
    public Main(String[] args)
    {
        if (args.length == 0)
        {
            try
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e)
            {
                e.printStackTrace();
            }
            instance = this;
            frame = new JFrame();
            guiMain = new GuiMain(frame);
            frame.setTitle("MCJsonSound");
            frame.setSize(550, 200);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new GridLayout(4, 1));
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setContentPane(GuiMain.panel);
            frame.setVisible(true);
        }
        else if (args.length == 3)
        {
            try
            {
                new NewScan(args[0], args[1], args[2]);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("Invalid arguments");
        }
    }
    
    public static void main(String[] args)
    {
        new Main(args);
    }
}
