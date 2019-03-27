package jdbc.ex;

import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;

import jdbc.dto.Food;
import jdbc.dto.Stock;


public class managerGUI extends JFrame{
	 private static String dburl = "jdbc:mysql://localhost/java_study?characterEncoding=UTF-8&serverTimezone=UTC";
	 private static String dbUser = "java";
	 private static String dbpasswd = "wkqktmxjel";

	   Connection conn = null;
	   PreparedStatement ps = null;
	   ResultSet rs = null;
	   String[] ingredient;
	   JLabel la;
	   
	   public void showStock() {
		   
		   Object[] colNames; // ���̸� => 1���� �迭
	       Object[][] data; // 2���� �迭 ������
	       Container contentPane;
		   
	       setTitle("��� ���� ���α׷�");
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	       setLayout(new BorderLayout());
	       contentPane = getContentPane();
		   
		   try {
			   
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,count from stock";
			ps= conn.prepareStatement(sql);
			rs=ps.executeQuery();
          
            // �� ���� �������� ���� Ŀ���� �� ���������� �ű��
            rs.last();
            int rowCount = rs.getRow();
            System.out.println("���� ����: " + rowCount);
            
            rs.first();
            
            // �� �̸��� ������ �迭��ü�� ���� ũ��� �����ϰ� ����
            colNames = new Object[rowCount];
            for(int i=0; i<rowCount; i++) {
                colNames[i] = rs.getObject(1);
                rs.next();
            }
            
            // ������ => 2���� �迭 ����
            rs.first();
            
            data = new Object[1][rowCount];
            for(int r=0; r<rowCount;r++) {
               data[0][r] = rs.getObject(2); // �� �ε���
               rs.next();
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
            
			//����� ��� ���� �� �� ����
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   finally {
			   if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   
			   
		   }
	   }
}
