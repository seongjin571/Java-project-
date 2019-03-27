package javaProject;

import java.util.*;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
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

import jdbc.dao.*;
import jdbc.dto.*;

public class Menu extends JFrame{
	
	JLabel status, ice_hot, size, shot;
	JPanel background, choice1, choice2, choice3;
	JButton b1, b2, b3, s1, s2, s3, s4, s5, s6, s7, chat, cancle, pay;
	Checkbox ice, hot, small, tall, large, yes, no;
	CheckboxGroup group1, group2, group3;
	
	Menu(String str){
		super(str);
		setLayout(null); //���̾ƿ� ���� ���ϴ� ��ġ��

		background = new JPanel();
		background.setBackground(Color.PINK);
		background.setBounds(0, 0, 900, 300);
		add(background);
		
		M_button();
		M_choice();
		M_chat();
	}
	
	void M_button() {
		
		b1 = new JButton("�Ƹ޸�ī��");
		b2 = new JButton("ī���");
		b3 = new JButton("���̽�Ƽ");
		s1 = new JButton("�����");
		s2 = new JButton("¥�İ�Ƽ");
		s3 = new JButton("�����");
		s4 = new JButton("Ȩ����");
		s5 = new JButton("���׶��");
		s6 = new JButton("�ǻ�");
		s7 = new JButton("�ֵ���");//�޴� ��ư ����
		
		b1.setBounds(50,50,100,70);
		b2.setBounds(215,50,100,70);
		b3.setBounds(380,50,100,70);
		s1.setBounds(545,50,100,70);
		s2.setBounds(710,50,100,70);
		s3.setBounds(50,170,100,70);
		s4.setBounds(215,170,100,70);
		s5.setBounds(380,170,100,70);
		s6.setBounds(545,170,100,70);
		s7.setBounds(710,170,100,70);//��ġ, ũ�� ����

		add(b1);
		add(b2);
		add(b3);
		add(s1);
		add(s2);
		add(s3);
		add(s4);
		add(s5);
		add(s6);
		add(s7);//�޴� ��ư ����
		
		
		cancle = new JButton("Cancle");
		pay = new JButton("Pay");
		
		cancle.setBounds(490, 450, 100, 50);
		pay.setBounds(680, 450, 100, 50);
		
		add(cancle);
		add(pay);
	}
	
	void M_choice() {
		
		choice1 = new JPanel();
		choice2 = new JPanel();
		choice3 = new JPanel();
		
		group1 = new CheckboxGroup();
		ice = new Checkbox("ICE", group1, true);
		hot = new Checkbox("HOT", group1, false);//ice, hot ������ư ����
		
		group2 = new CheckboxGroup();
		small = new Checkbox("SMALL", group2, true);
		tall = new Checkbox("TALL", group2, false);
		large = new Checkbox("LARGE", group2, false);//s,t,l ������ư ����
		
		group3 = new CheckboxGroup();
		yes = new Checkbox("YES", group3, true);
		no = new Checkbox("NO", group3, false);//shot ������ư ����
		
		ice_hot = new JLabel("ICE / HOT");
		size = new JLabel("SIZE");
		shot = new JLabel("SHOT");//�ؽ�Ʈ ����
		
		ice_hot.setFont(new Font("",Font.BOLD,15));
		size.setFont(new Font("",Font.BOLD,15));
		shot.setFont(new Font("",Font.BOLD,15));//�۾�ü ����
		
		choice1.add(ice_hot);
		choice1.add(ice);
		choice1.add(hot);//panel�� ���ϱ�
		
		choice2.add(size);
		choice2.add(small);
		choice2.add(tall);
		choice2.add(large);//panel�� ���ϱ�
		
		choice3.add(shot);
		choice3.add(yes);
		choice3.add(no);//panel�� ���ϱ�
		
		choice1.setBounds(100,330,200,60);
		choice2.setBounds(500,330,250,80);
		choice3.setBounds(110,380,200,60);//panel ��ġ,ũ�� ����
		
		add(choice1);
		add(choice2);
		add(choice3);//����
		
		status = new JLabel();
			
	}
	
	void M_chat() {
		chat = new JButton("chatting");
		
		chat.setBounds(110,453,200,50);//��ġ, ũ�� ����
		chat.setBackground(new Color(210,50,50));//���� ������
		chat.setFont(new Font("",Font.PLAIN,17));//�۾�ü ����
		chat.setForeground(new Color(255,255,255));//�۾� �Ͼ��
		chat.setBorderPainted(false);
		add(chat);
	}
}
