package javaProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Join extends JFrame   {
	JLabel lb1, la1, la2, la3, la4, status;
	JTextField id, pw, pw2, email;
	JPanel idPanel, paPanel, pa2Panel, emPanel;
	JButton b1, b2;
	ActionEvent e;
	
	Join(String str){
		super(str);
		setLayout(null); //���̾ƿ� ���� ���ϴ� ��ġ��
		
		J_idpw();
		J_button();
	}
	
	void J_idpw() {
		
		idPanel = new JPanel();
		paPanel = new JPanel();
		pa2Panel = new JPanel();
		emPanel = new JPanel();

		la1 = new JLabel("ID     ");
		la1.setFont(new Font("",Font.BOLD, 20));
		la2 = new JLabel("PW    ");
		la2.setFont(new Font("",Font.BOLD, 20));
		la3 = new JLabel("PW2  ");
		la3.setFont(new Font("",Font.BOLD, 20));
		la4 = new JLabel("E-mail");
		la4.setFont(new Font("",Font.BOLD, 20));//ID, PW �� ���� ����
		
		
		id = new JTextField(13);
		id.setFont(new Font("",Font.BOLD, 20));
		pw = new JPasswordField(13);//�Է½� �ܷ� �Էµ�
		pw.setFont(new Font("",Font.BOLD, 20));
		pw2 = new JPasswordField(13);//�Է½� �ܷ� �Էµ�
		pw2.setFont(new Font("",Font.BOLD, 20));
		email = new JTextField(13);
		email.setFont(new Font("",Font.BOLD, 20));//id, pw �� �Է� â ���� ����
		
		
		idPanel.add(la1);
		idPanel.add(id);
		idPanel.setBounds(80, 140, 300, 60);
		add(idPanel);// ID���ڿ� �ڽ� ����

		paPanel.add(la2);
		paPanel.add(pw);
		paPanel.setBounds(80, 220, 300, 60);
		add(paPanel);// PW���ڿ� �ڽ� ����

		pa2Panel.add(la3);
		pa2Panel.add(pw2);
		pa2Panel.setBounds(80, 300, 300, 60);
		add(pa2Panel);// pw2���ڿ� �ڽ� ����
		
		emPanel.add(la4);
		emPanel.add(email);
		emPanel.setBounds(80, 380, 300, 60);
		add(emPanel);// email���ڿ� �ڽ� ����
	}
	
	void J_button() {
		
		b1 = new JButton("�ߺ�");
		b2 = new JButton("JOIN");//�ߺ�, JOIN ��ư ����
		
		b1.setBounds(400,143,100,33);//��ġ, ũ�� ����
		b1.setBackground(new Color(210,50,50));//���� ������
		b1.setFont(new Font("",Font.PLAIN,17));//�۾�ü ����
		b1.setForeground(new Color(255,255,255));//�۾� �Ͼ��
		
		b2.setBounds(210,480,120,40);
		b2.setBackground(new Color(210,50,50));
		b2.setFont(new Font("",Font.PLAIN,17));
		b2.setForeground(new Color(255,255,255));
		
		add(b1);
		add(b2);//LOGIN, JOIN ��ư ���� �� ����
		
		status = new JLabel();
		b2.addActionListener(new ActionListener() {//JOIN��ư Ŭ���� �߻��ϴ� �׼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(pw.getText().equals(pw2.getText()))) {//pw�� ���� pw2�� ���� ���� ������
					status.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
			}
		});
		

		status.setBounds(190,520,200,40);
		add(status);// id+pw �� status ���� �� ����
	}

	
}