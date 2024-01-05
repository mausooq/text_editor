import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.plaf.metal.*;
import javax.swing.text.*;

/**
 * texteditor
 */
class texteditor extends JFrame implements ActionListener {
    JTextArea t;
    JFrame f;

    texteditor() {
        f = new JFrame("editor");
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        } catch (Exception e) {
        }
        t = new JTextArea();
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("File");
        JMenuItem mi1 = new JMenuItem("New");
        JMenuItem mi2 = new JMenuItem("Open");
        JMenuItem mi3 = new JMenuItem("Save");
        JMenuItem mi4 = new JMenuItem("Print");
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi4);
        JMenu m2 = new JMenu("Edit");
        JMenuItem mi21 = new JMenuItem("Cut");
        JMenuItem mi22 = new JMenuItem("Copy");
        JMenuItem mi23 = new JMenuItem("Paste");
        mi21.addActionListener(this);
        mi22.addActionListener(this);
        mi23.addActionListener(this);
        m2.add(mi21);
        m2.add(mi22);
        m2.add(mi23);
        JMenu m3 = new JMenu("Close");
        JMenuItem mi31 = new JMenuItem("Close Window");
        mi31.addActionListener(this);
        m3.add(mi31);

        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        f.setJMenuBar(mb);
        f.add(t);
        f.setSize(2000, 1000);
        f.show();
    }

    public void actionPerformed(ActionEvent ae) {
        String s=ae.getActionCommand();
            if(s.equals("Cut")){
                        t.cut();
                    }
            else if(s.equals("Copy")){
                        t.copy();
                    }
            else if(s.equals("Paste")){
                        t.paste();
                    }
            else if(s.equals("New")){
                       t.setText("");
                    }
            else if(s.equals("Close Window")){
                        f.setVisible(false);
                    }
            else if (s.equals("Open")){
                         JFileChooser j=new JFileChooser();
                         int r=j.showOpenDialog(null);
                         if(r==JFileChooser.APPROVE_OPTION){
                            File fi =new File(j.getSelectedFile().getAbsolutePath());
                            try{
                                String s1="",s2="";
                                FileReader fr =new FileReader(fi);
                                BufferedReader br = new BufferedReader(fr);
                                while((s1=br.readLine())!= null){
                                    s2+=s1+"\n";
                                }
                                t.setText(s2);
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(f,e.getMessage());
                            }
                         }
                         else{
                                JOptionPane.showMessageDialog(f,"User has close the Operation");

                         }
                     }  
            else if(s.equals("Save")){
              JFileChooser j=new JFileChooser();
                         int r=j.showSaveDialog(null);
                         if(r==JFileChooser.APPROVE_OPTION){
                            File fi =new File(j.getSelectedFile().getAbsolutePath());
                            try{
                                FileWriter fw =new FileWriter(fi,false);
                                BufferedWriter bw = new BufferedWriter(fw);
                                bw.write(t.getText());
                                bw.flush();
                                bw.close();
                             
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(f,e.getMessage());
                            }
                         }
                         else{
                                JOptionPane.showMessageDialog(f,"User has close the Operation");

                         }
                     }  
                     else if(s.equals("Print")){
                        try{
                            t.print();
                        }
                        catch(Exception e){
                             JOptionPane.showMessageDialog(f,e.getMessage());
                        }
                     }
    
            }

    

    public static void main(String[] args) {
        texteditor t=new texteditor();
       
    }
}
