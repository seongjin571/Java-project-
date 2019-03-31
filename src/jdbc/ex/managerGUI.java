package jdbc.ex;

import java.awt.*;
import AdminChat.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import jdbc.dao.PCDao;
import jdbc.dto.Stock;


public class managerGUI extends JFrame implements ActionListener, WindowListener{
	 	
	private static final long serialVersionUID = 1L;
	JPanel contentPane,contentPane1,contentPane2,grid1,grid2,grid3,grid4;
	   JButton btn1,btn2,btn3;
	   JButton btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14;
	   JButton btn15,btn16,btn17,btn18;
	   JButton btn19,btn20,btn21,btn22;
	   BufferedImage img;
	   JLabel la1,la2,label,la3,la4,la5;
	   JTextField text;
	   String str;
	   
	   private CardLayout cards=new CardLayout();
	   
	   
	   public void showStock() {
		   
		   Object[] colNames; // ���̸� => 1���� �迭
	       Object[][] data; // 2���� �迭 ������
	       
	       
		   contentPane1=new JPanel();
		   
	       setTitle("��� ���� ���α׷�");
	       addWindowListener(this);
	    
	       setLayout(null);
	       
	       PCDao dao=new PCDao();
		   ArrayList<Stock> list=dao.getStock();
		   
		   int rowCount = list.size();
		   System.out.println("���� ����: " + rowCount);
            
		 
		   // �� �̸��� ������ �迭��ü�� ���� ũ��� �����ϰ� ����
		   colNames = new Object[rowCount];
		   
		   for(int i=0;i<rowCount;i++) {
			   colNames[i]=list.get(i).getName();
		   }
            
				          
			data = new Object[1][rowCount];
			for(int r=0; r<rowCount;r++) {
				data[0][r]=list.get(r).getCount();
			}            
			
			la1=new JLabel("��� ��Ȳ");
			la1.setBounds(35 , 5, 100, 50);
			add(la1);
            
			// ���̺� ����
			JTable table = new JTable(data, colNames);
			JScrollPane j = new JScrollPane(table);
			j.setBounds(35, 50, 900, 150);
	        add(j);
	        
	        la2=new JLabel("��ǰ�ֹ�");
			la2.setBounds(35 , 200, 100, 50);
			add(la2);
			
			grid1=new JPanel();
			grid1.setLayout(new GridLayout(2,5,30,30));
			
			btn4=new JButton("�ǻ�");
			btn5=new JButton("���׶��");
			btn6=new JButton("��");
			btn7=new JButton("�����");
			btn8=new JButton("�Ҽ���");
			btn9=new JButton("���̽�Ƽ");
			btn10=new JButton("����");
			btn11=new JButton("����");
			btn12=new JButton("�����");
			btn13=new JButton("¥�İ�Ƽ");
			btn14=new JButton("Ȩ����");
			
			label=new JLabel();
			label.setBounds(35, 475, 500, 50);
			la3=new JLabel();
			la3.setBounds(35, 520, 500, 50);
			text=new JTextField(5);
			text.setBounds(130, 525, 300, 40);
			grid1.add(btn4);
			btn4.addActionListener(this);
			grid1.add(btn5);
			btn5.addActionListener(this);
			grid1.add(btn6);
			btn6.addActionListener(this);
			grid1.add(btn7);
			btn7.addActionListener(this);
			grid1.add(btn8);
			btn8.addActionListener(this);
			grid1.add(btn9);
			btn9.addActionListener(this);
			grid1.add(btn10);
			btn10.addActionListener(this);
			grid1.add(btn11);
			btn11.addActionListener(this);
			grid1.add(btn12);
			btn12.addActionListener(this);
			grid1.add(btn13);
			btn13.addActionListener(this);
			grid1.add(btn14);
			btn14.addActionListener(this);
			add(label);
			add(la3);
			grid1.setBounds(35, 250, 900, 200);
			
			add(grid1);
			
			grid2=new JPanel();
			grid2.setLayout(new GridLayout(1,4,30,30));
			
			btn15=new JButton("POS");
			btn16=new JButton("�ֹ�");
			btn16.addActionListener(this);
			btn17=new JButton("�Ǹ���Ȳ");
			btn17.addActionListener(this);
			btn18=new JButton("�ʱ�ȭ");
			
			grid2.add(btn15);
			grid2.add(btn16);
			grid2.add(btn17);
			grid2.add(btn18);
			
			grid2.setBounds(35, 600, 900, 80);
			
			add(grid2);
			
			setSize(1000, 800);
			setLocation(800,10);
			setVisible(true); 	            			   
	   }
	   
	   public void sale() {
		   
		   contentPane2=new JPanel();
		   
	       setTitle("�Ǹ� ��Ȳ");
	       addWindowListener(this);
	    
	       setLayout(null);
	       
			
			la4=new JLabel("��� ��Ȳ");
			la4.setBounds(35 , 5, 100, 50);
			add(la4);
            
			la5=new JLabel("��ǰ�ֹ�");
			la5.setBounds(35 , 200, 100, 50);
			add(la5);
			
			grid4=new JPanel();
			grid4.setLayout(new GridLayout(1,4,30,30));
			
			btn19=new JButton("POS");
			btn20=new JButton("����");
			btn21=new JButton("�޴����Ǹ�");
			btn22=new JButton("�ǸŸ���Ʈ");
			
			grid4.add(btn19);
			grid4.add(btn20);
			grid4.add(btn21);
			grid4.add(btn22);
			
			grid4.setBounds(35, 600, 900, 80);
			
			add(grid4);
			
			setSize(1000, 800);
			setLocation(800,10);
			setVisible(true); 	            			   
	   }
	   
	   public void managerWindow() {
		   
	       setTitle("������");
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       contentPane=new JPanel();
	       setLayout(null);
	       
	       ImageIcon icon=new ImageIcon("src\\\\images\\\\sejong.png");
	       JLabel picLabel=new JLabel(icon);
	       picLabel.setBounds(35, 10, 550, 550);
		   add(picLabel);
			
		   grid3=new JPanel();
		   grid3.setLayout(new GridLayout(1,3,50,50));
	       btn1=new JButton("�Ǹ���Ȳ");
	       grid3.add(btn1);
	       btn1.addActionListener(this);
	       btn2=new JButton("������");
	       grid3.add(btn2);
		   btn2.addActionListener(this);
		   btn3=new JButton("ä��");
	       grid3.add(btn3);
	       btn3.addActionListener(this);
		
	       grid3.setBounds(60,600,500,80);
	       add(grid3);
	       
	         
	       setSize(650,900);
	       setLocation(0,10);
	       setVisible(true);
	   
	   }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn1) new managerGUI().sale();
		else if(e.getSource()==btn2) new managerGUI().showStock();
		else if(e.getSource()==btn3) {
			AdminChat adminChat = new AdminChat();
			new Thread(adminChat).start();
		}
		
		if(e.getSource()==btn16) {
			if(Integer.parseInt(text.getText())>0) {
				new PCDao().useStock(str,-Integer.parseInt(text.getText()));
				System.exit(0);
				new managerGUI().showStock();
			}
			else {
				
			}
		}
		else if(e.getSource()==btn17) new managerGUI().sale();
		
		if(e.getSource()==btn4 || e.getSource()==btn5 || e.getSource()==btn6 || e.getSource()==btn7 || e.getSource()==btn8 || e.getSource()==btn9 ||e.getSource()==btn10 ||e.getSource()==btn11 || e.getSource()==btn12 || e.getSource()==btn13 || e.getSource()==btn14) {
			str=e.getActionCommand();
			label.setText(e.getActionCommand()+"��/�� �ֹ��Ͻǰǰ���? ������ �Է��ϼ���.");
			la3.setText("�ֹ������Է�:");
			add(text);
		}
		
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	   
	
}