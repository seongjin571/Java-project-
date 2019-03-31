package AdminChat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class AdminChat extends JFrame implements ActionListener,Runnable, WindowListener {
	private static final long serialVersionUID = 1L;
	JButton but_input;
	JTextArea textArea;
	JTextField textInput;
	JLabel name;
	Font f1;
	static ServerSocket serverSocket = null;
	static Socket clientSocket = null;
	static PrintWriter out; 
	static BufferedReader in;
	static String inputLine, outputLine;

	public AdminChat() {
		setSize(550, 600);
		f1 = new Font("����", Font.BOLD, 30);
		addWindowListener(this);
		setTitle("SeJong Pc Cafe");
		JPanel panel = new JPanel();
		name = new JLabel("SeJong Pc Cafe ������ ä�ù�");
		name.setFont(f1);
		JPanel panel2 = new JPanel();
		textArea = new JTextArea(25, 40);
		textInput = new JTextField(20);
		textInput.registerKeyboardAction(this, "input", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0), JComponent.WHEN_FOCUSED);
		but_input = new JButton("�Է�");
		but_input.setActionCommand("input");
		but_input.addActionListener(this);
		panel2.add(name);
		panel.add(textArea);
		panel.add(textInput);
		panel.add(but_input);
		add(panel2, BorderLayout.NORTH);
		add(panel);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s;
		s = "������ : " + textInput.getText();
		if (e.getActionCommand() == "input") {
			textArea.append(s + " "+ nowTime()+"\n");
			out.println(s);
			textInput.setText("");
		}
	} 

	
	public String nowTime(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH�� mm�� ss��");
		LocalDateTime time = LocalDateTime.now();
		String nowTime = " ["+time.format(formatter)+"]";
		return nowTime;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("���� ����!");
		try {
			serverSocket = new ServerSocket(3000);
		} catch (IOException e) {
			System.out.println("�ش� ��Ʈ ��ȣ�� ������ �� �����ϴ�");
			System.exit(1);
		}
		clientSocket = null;
		try {
			clientSocket = serverSocket.accept();
		} catch (IOException e) {
			System.err.println("accept() ���� ");
			System.exit(1);
		}
		try {
			out = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textArea.append("Ŭ���̾�Ʈ�� ���ӵǾ����ϴ�.\n");
		try {
			while ((inputLine = in.readLine()) != null) {
				String s = inputLine + " "+ nowTime()+"\n";
				textArea.append(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
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



