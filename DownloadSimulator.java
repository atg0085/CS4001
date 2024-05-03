

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DownloadSimulator implements ActionListener
{
    private JTextField songSizeTextField;
    private JTextField memoryTextField;
    private JButton downloadButton;
    private JButton deleteButton;
    private JFrame frame;
    private final double maxMemory = 1024; //init. storage space (1gb probably)
    private double memory = maxMemory; //same before downloading songs
    

    public DownloadSimulator()
    {
        //basically a copy of the last one but with different var names
        
        frame = new JFrame("Music Download Simulator");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        
        songSizeTextField = new JTextField(15);
        contentPane.add(songSizeTextField);        

        downloadButton = new JButton("Download");
        contentPane.add(downloadButton);
        downloadButton.addActionListener(this);       

        deleteButton = new JButton("Delete");
        contentPane.add(deleteButton);
        deleteButton.addActionListener(this);
        
        memoryTextField = new JTextField(15);
        contentPane.add(memoryTextField);        
        
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        // Command prompt-inator
        DownloadSimulator downloader = new DownloadSimulator();
    }

    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();
        if (command.equals("Download")) {
            download();
        }
        if (command.equals("Delete")) {
            delete();
        }
    }
    
    public int getSize()
    {
        int songSize = Integer.parseInt(songSizeTextField.getText());
        return songSize;
    }

    public void download()
    {
        int songSize = getSize();
        
        if (songSize <= memory) {
            memory = memory - songSize;
            memoryTextField.setText("" + memory);
        } else {
            memoryTextField.setText("Insufficient memory");
        }
    }

    //never before seen delete procedure incoming
    
    public void delete()
    {
        int songSize = getSize();

        if (memory + songSize <= maxMemory) {
            memory = memory + songSize;
            memoryTextField.setText("" + memory);
        } else {
            memoryTextField.setText("Exceeds max memory.");
        }
    }
}
