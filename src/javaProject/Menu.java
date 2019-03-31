package javaProject;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import AdminChat.ClientChat;
import jdbc.dto.user;
import jdbc.dao.*;
import jdbc.dto.*;


public class Menu extends JFrame implements ActionListener, ItemListener{

	private static final long serialVersionUID = 1L;
	JLabel status0, status1, status2, status3, ice_hot, size, shot;
	JPanel background, choice1, choice2, choice3, grid1;
	JButton b[], chat, cancle, pay;
	JRadioButton ice, hot, small, tall, large, yes, no;
	ButtonGroup group1, group2, group3;
	user_inf u_inf = new user_inf();
	int i, b_price=0, s_price=0, flag=0;
	String userName;

	Menu(String str, String userName) {
		super(str);
		this.userName = userName;
		setLayout(null); // ���̾ƿ� ���� ���ϴ� ��ġ��


		M_button();
		M_bchoice();

		cancle = new JButton("Cancle");
		pay = new JButton("Pay");
		
		cancle.setBounds(490, 450, 100, 50);
		pay.setBounds(680, 450, 100, 50);
		
		add(cancle);
		add(pay);
		
		cancle = new JButton("Cancle");
		pay = new JButton("Pay");
		
		cancle.setBounds(490, 450, 100, 50);
		pay.setBounds(680, 450, 100, 50);
		
		add(cancle);
		add(pay);
		
		chat = new JButton("ä��");
		chat.setActionCommand("chat"); 
		chat.addActionListener(this);
		chat.setBounds(110, 453, 200, 50);// ��ġ, ũ�� ����
		chat.setBackground(new Color(210, 50, 50));// ���� ������
		chat.setFont(new Font("", Font.PLAIN, 17));// �۾�ü ����
		chat.setForeground(new Color(255, 255, 255));// �۾� �Ͼ��
		chat.setBorderPainted(false);
		add(chat);
	}
	void id(String id) {
		
		//u_inf.updateprice(id);
		
	}
	void M_button() {
		
		grid1 = new JPanel();
		status0 = new JLabel();
		status1 = new JLabel();
		status2 = new JLabel();
		status3 = new JLabel();
		grid1.setLayout(new GridLayout(2,5,30,30));
		b = new JButton[10];

		status1.setBounds(500,370,300,80);
		status2.setBounds(500,370,300,80);
		status3.setBounds(500,370,300,80);
		
		b[0] = new JButton("�Ƹ޸�ī��");
		b[1] = new JButton("ī���");
		b[2] = new JButton("���̽�Ƽ");
		b[3] = new JButton("�����");
		b[4] = new JButton("¥�İ�Ƽ");
		b[5] = new JButton("�����");
		b[6] = new JButton("Ȩ����");
		b[7] = new JButton("���׶��");
		b[8] = new JButton("�ǻ�");
		b[9] = new JButton("�ֵ���");//�޴� ��ư ����
		
		for(i=0;i<10;i++)
			grid1.add(b[i]);
		grid1.setBounds(35, 50, 800, 200);
		add(grid1);

		b[0].addActionListener(this);
		b[1].addActionListener(this);
		b[2].addActionListener(this);
		b[3].addActionListener(this);
		b[4].addActionListener(this);
		b[5].addActionListener(this);
		b[6].addActionListener(this);
		b[7].addActionListener(this);
		b[8].addActionListener(this);
		b[9].addActionListener(this);

	}
		
	void M_bchoice() {
		flag=3;
		choice1 = new JPanel();
		choice2 = new JPanel();
		choice3 = new JPanel();
		
		group1 = new ButtonGroup();
		ice = new JRadioButton("ICE");
		hot = new JRadioButton("HOT");
		group1.add(ice);
		group1.add(hot);//ice, hot ������ư ����
		
		group2 = new ButtonGroup();
		small = new JRadioButton("SMALL");
		tall = new JRadioButton("TALL");
		large = new JRadioButton("LARGE");
		group2.add(small);
		group2.add(tall);
		group2.add(large);//s,t,l ������ư ����
		
		group3 = new ButtonGroup();
		yes = new JRadioButton("YES");
		no = new JRadioButton("NO");
		group3.add(yes);
		group3.add(no);//shot ������ư ����
		
		ice_hot = new JLabel("ICE / HOT");
		size = new JLabel("SIZE");
		shot = new JLabel("SHOT");//�ؽ�Ʈ ����
		
		ice_hot.setFont(new Font("",Font.BOLD,15));
		size.setFont(new Font("",Font.BOLD,15));
		shot.setFont(new Font("",Font.BOLD,15));//�۾�ü ����
		
		ice.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				status2.setText("");
				status3.setText("");
				status1.setText(status0.getText());
				status1.setText(status1.getText()+"/ ICE");
			}
		});
		hot.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				status2.setText("");
				status3.setText("");
				status1.setText(status0.getText());
				status1.setText(status1.getText()+"/ HOT");
			}
		});
		
		status1.setFont(new Font("",Font.PLAIN,17));//�۾�ü ����
		add(status1);
	
		small.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				b_price=0;
				status3.setText("");
				status2.setText(status1.getText());
				status2.setText(status2.getText()+"/ SMALL");
				b_price=1000;
			}
		});
		
		tall.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				b_price=0;
				status3.setText("");
				status2.setText(status1.getText());
				status2.setText(status2.getText()+"/ TALL");
				b_price=1500;
			}
		});
		
		large.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				b_price=0;
				status3.setText("");
				status2.setText(status1.getText());
				status2.setText(status2.getText()+"/ LARGE");
				b_price=2000;
			}
		});
		
		status2.setFont(new Font("",Font.PLAIN,17));//�۾�ü ����
		add(status2);
		
		yes.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				status3.setText(status2.getText());
				status3.setText(status3.getText()+"/ YES");
				status3.setText(status3.getText()+"/ "+b_price+"��");
			}
		});

		no.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				status3.setText(status2.getText());
				status3.setText(status3.getText()+"/ NO");
				status3.setText(status3.getText()+"/ "+b_price+"��");
			}
		});
		status3.setFont(new Font("",Font.PLAIN,17));//�۾�ü ����
		add(status3);

		
		
	}
	void choice() {

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
		
		choice1.setBounds(100,330,200,30);
		choice2.setBounds(500,330,250,30);
		choice3.setBounds(110,380,200,30);//panel ��ġ,ũ�� ����
		
		add(choice1);
		add(choice2);
		add(choice3);//����
		
		choice1.repaint();
		choice2.repaint();
		choice3.repaint();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "chat") {
			ClientChat clientChat = new ClientChat(userName);
			new Thread(clientChat).start();
		}
		else if(e.getSource()==b[0]||e.getSource()==b[1]||e.getSource()==b[2]) {

			add(status0);
			status0.setText("");
			status1.setText("");
			status2.setText("");
			status3.setText("");
			status0.setText(e.getActionCommand());
			status0.setBounds(500,370,300,80);
			status0.setFont(new Font("",Font.PLAIN,17));//�۾�ü ����
			choice();
			
			add(status0);
		}
		
		else if(e.getSource()==b[3]||e.getSource()==b[4]||e.getSource()==b[5]||e.getSource()==b[6]||e.getSource()==b[7]||e.getSource()==b[8]||e.getSource()==b[9]) {
			
			

		
			status0.setText("");
			status1.setText("");
			status2.setText("");
			status3.setText("");
			status0.setText(e.getActionCommand()+" 2000��");
			status0.setBounds(590,370,300,80);
			status0.setFont(new Font("",Font.PLAIN,17));//�۾�ü ����
			add(status0);
			
			if(flag==3) {
				choice1.removeAll();
				choice1.revalidate();
				choice1.repaint();
				choice2.removeAll();
				choice2.revalidate();
				choice2.repaint();
				choice3.removeAll();
				choice3.revalidate();
				choice3.repaint();
			}
		}
		
		else if(e.getSource()==cancle) {
			status0.setText("");
			status1.setText("");
			status2.setText("");
			status3.setText("");
		}
		
	}
	
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==hot) {
				status2.setText("");
				status3.setText("");
				status1.setText(status0.getText());
				status1.setText(status1.getText()+"/ HOT");
			}
			else if(e.getSource()==ice) {
				status2.setText("");
				status3.setText("");
				status1.setText(status0.getText());
				status1.setText(status1.getText()+"/ ICE");
			}
				
		}
	
			
	
}