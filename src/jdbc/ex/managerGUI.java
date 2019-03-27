package jdbc.ex;

import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;

import jdbc.dao.PCDao;
import jdbc.dto.Stock;

public class managerGUI extends JFrame{
	 
	   public void showStock() {
		   
		   Object[] colNames; // ���̸� => 1���� �迭
	       Object[][] data; // 2���� �迭 ������
	       Container contentPane;
	       JLabel la;
		   
	       setTitle("��� ���� ���α׷�");
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	       setLayout(new BorderLayout());
	       contentPane = getContentPane();
	       
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
			
			la=new JLabel("��� ��Ȳ");
            
            
			contentPane.add(la,BorderLayout.NORTH);
            
			// ���̺� ����
			JTable table = new JTable(data, colNames);
			// ���̺��� ������ ����Ʈ�� �߾ӿ� ���̱�
			contentPane.add(new JScrollPane(table));
			// �ι�° �߰��� ��Һ��ʹ� setVisible�ؾ����� ���� �߰��� ��Ұ� ��µ�
            
			table.setBounds(50, 50, 500, 500);
            
			setSize(1000, 500);
			setVisible(true); 	            			   
	   }
}
