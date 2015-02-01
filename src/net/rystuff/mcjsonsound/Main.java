package net.rystuff.mcjsonsound;

import net.rystuff.mcjsonsound.gui.GuiMain;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame
{
    public static Main instance;
    public static GuiMain guiMain;
    
    public Main()
    {
        // Creates a new JFrame
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
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(guiMain);
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new Main();
    }
}
