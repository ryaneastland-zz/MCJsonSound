package net.rystuff.mcjsonsound.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FolderChooser extends JPanel
{
    private String textFieldLabel;
    private String buttonLabel;

    private JLabel label;
    private JTextField textField;
    private JButton button;

    private JFileChooser fileChooser;

    public FolderChooser(String textFieldLabel, String buttonLabel)
    {
        this.textFieldLabel = textFieldLabel;
        this.buttonLabel = buttonLabel;

        fileChooser = new JFileChooser();

        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        // creates the GUI
        label = new JLabel(textFieldLabel);

        textField = new JTextField(30);
        button = new JButton(buttonLabel);

        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                buttonActionPerformed(evt);
            }
        });

        add(label);
        add(textField);
        add(button);

    }

    private void buttonActionPerformed(ActionEvent evt)
    {
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    public String getSelectedFilePath()
    {
        return textField.getText();
    }

    public JFileChooser getFileChooser()
    {
        return this.fileChooser;
    }
}