package net.rystuff.mcjsonsound;

import net.rystuff.mcjsonsound.gui.GuiMain;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame
{
    public static Main instance;
    public static GuiMain guiMain;
    
    public Main(String[] args)
    {
        if (args.length == 0)
        {
            try
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (InstantiationException e)
            {
                e.printStackTrace();
            }
            catch (IllegalAccessException e)
            {
                e.printStackTrace();
            }
            catch (UnsupportedLookAndFeelException e)
            {
                e.printStackTrace();
            }
            instance = this;
            guiMain = new GuiMain(this);
            setTitle("MCJsonSound");
            setSize(550, 200);
            setResizable(false);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(4, 1));
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setContentPane(guiMain);
            setVisible(true);
        }
        if (args.length == 3)
        {
            new Scan(args[0], args[1], args[2]);
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
