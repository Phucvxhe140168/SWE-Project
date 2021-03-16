/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author quann
 */
public class Detail extends JFrame implements ActionListener {

    private JLabel lbEm, lbCode, lbName, lbSex, lbEmail, lbDegree, lbHobby, lbExperiences;
    private JTextField txtCode, txtName, txtEmail;
    private ButtonGroup btnM_F;
    private JRadioButton rb;
    private JComboBox cbDegree;
    private JTextArea taEx;
    private JScrollPane sbEx1;
    private JCheckBox cbMusic;
    private JCheckBox cbSport;
    private JButton btnNew, btnOK, btnExit;

    public Detail() {
        super("Login System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 50, 450, 680);
        setResizable(false);
        
        Container cont = getContentPane();
        cont.setLayout(null);
        
        lbEm = new JLabel("EMPLOYEE DETAILS");
        lbEm.setForeground(Color.BLUE);
        lbEm.setBounds(20, 20, 240, 30);
        lbEm.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        lbEm.setBorder(new LineBorder(Color.YELLOW));
        //lbEm.setBackground(Color.YELLOW);
        lbCode = new JLabel("Code");
        lbCode.setBounds(20, 60, 300, 30);
        lbCode.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lbName = new JLabel("Name");
        lbName.setBounds(20, 110, 300, 30);
        lbName.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lbSex = new JLabel("Sex");
        lbSex.setBounds(20, 160, 300, 30);
        lbSex.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lbEmail = new JLabel("E-mail");
        lbEmail.setBounds(20, 210, 300, 30);
        lbEmail.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lbDegree = new JLabel("Degree");
        lbDegree.setBounds(20, 260, 300, 30);
        lbDegree.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lbHobby = new JLabel("Hobbies");
        lbHobby.setBounds(20, 520, 300, 30);
        lbHobby.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        lbExperiences = new JLabel("Experiences");
        lbExperiences.setBounds(20, 400, 300, 30);
        lbExperiences.setFont(new Font("TimesRoman", Font.PLAIN, 20));        
        taEx = new JTextArea();
        taEx.setBounds(150, 310, 250, 200);
        taEx.setBorder(new LineBorder(Color.BLACK));
        sbEx1 = new JScrollPane();
        sbEx1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sbEx1.getViewport().setBackground(Color.WHITE);
        sbEx1.getViewport().add(taEx);
        sbEx1.setBounds(150, 310, 250, 200);
        txtCode = new JTextField();
        txtCode.setBounds(100, 60, 300, 30);
        txtName = new JTextField();
        txtName.setBounds(100, 110, 300, 30);
        txtEmail = new JTextField();
        txtEmail.setBounds(100, 210, 300, 30);
        cbDegree = new JComboBox();
        cbDegree.addItem("High School");
        cbDegree.addItem("University");
        cbDegree.addItem("Ph.D");
        cbDegree.addItem("Dr.");
        cbDegree.setBounds(100, 260, 300, 30);
        btnM_F = new ButtonGroup();
        rb = new JRadioButton("Male", true);
        rb.setBounds(150, 160, 70, 30);
        btnM_F.add(rb);
        rb.addActionListener(this);
        cont.add(rb);
        rb = new JRadioButton("Female");
        rb.setBounds(250, 160, 70, 30);
        btnM_F.add(rb);
        rb.addActionListener(this);
        cont.add(rb);
        cbMusic = new JCheckBox("Music");
        cbMusic.setBounds(150, 520, 70, 30);
        cbSport = new JCheckBox("Sport");
        cbSport.setBounds(250, 520, 120, 30);
        btnNew = new JButton("NEW");
        btnNew.setBounds(10, 570, 120, 30);
        btnOK = new JButton("OK");
        btnOK.setBounds(160, 570, 120, 30);
        btnExit = new JButton("EXIT");
        btnExit.setBounds(310, 570, 120, 30);
        
        cont.add(lbEm);
        cont.add(lbCode);
        cont.add(lbName);
        cont.add(lbSex);
        cont.add(lbEmail);
        cont.add(lbDegree);
        cont.add(lbExperiences);
        cont.add(txtCode);
        cont.add(txtName);
        cont.add(txtEmail);
        cont.add(cbDegree);
        cont.add(sbEx1);
        cont.add(lbHobby);
        cont.add(cbMusic);
        cont.add(cbSport);
        cont.add(btnNew);
        cont.add(btnOK);
        cont.add(btnExit);
        
        // Add actions event to components
        btnOK.addActionListener(this);
        btnNew.addActionListener(this);
        btnExit.addActionListener(this);
        
    }
    
    public static void main(String[] args) {
        new Detail().setVisible(true);
    }    
    
    private boolean validData(){
        String s;
        
        s = this.txtCode.getText().trim().toUpperCase();
        this.txtCode.setText(s);
        if(!s.matches("^E\\d{3}$")){
            JOptionPane.showMessageDialog(this, "Code E + 3 digits.", "Wairning", JOptionPane.WARNING_MESSAGE);
            txtCode.requestFocus();
            return false;
        }
        
        s = this.txtName.getText().trim().toUpperCase();
        this.txtName.setText(s);
        if(s.length()==0){
            JOptionPane.showMessageDialog(this, "Name is required.");
            txtName.requestFocus();
            return false;
        }
        
        s = this.txtEmail.getText().trim().toUpperCase();
        this.txtEmail.setText(s);
        if(!s.matches("^\\w+@\\w+[.]\\w+$")){
            JOptionPane.showMessageDialog(this, "Email: anyname@any.any");
            txtEmail.requestFocus();
            return false;
        }
        
        if(cbDegree.getSelectedIndex()<=0){
            cbDegree.requestFocus();
            return false;
        }
        
        return true;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNew) {
            // Reset value all components on the Frame
            txtCode.setText("");
            txtName.setText("");
            txtEmail.setText("");
            cbDegree.setSelectedIndex(0);
            taEx.setText("");
            cbMusic.setSelected(true);
            cbSport.setSelected(false);
            txtCode.requestFocus();
        }
        
        if (e.getSource() == btnOK) {
            if(validData()){
                String s = "Welcome: ";
                s += txtCode.getText() + "," +
                        txtName.getText() + "," +
                        txtEmail.getText() + "," +
                        (rb.isSelected() ? rb.getText() + "," : ",")+
                        cbDegree.getSelectedItem() + "," +
                        taEx.getText() + "," +
                        (cbMusic.isSelected() ? cbMusic.getText() + "," : "")+
                        (cbSport.isSelected() ? cbSport.getText() : "");
                JOptionPane.showMessageDialog(this, s);
            }
        }
        
        if (e.getSource() == btnExit) {
            if(JOptionPane.showConfirmDialog(this, "Exit?", "Infomation", JOptionPane.YES_NO_OPTION)==0){
                System.exit(0);
            }            
        }
    }
}
