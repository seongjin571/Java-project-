package AdminChat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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

class SFrame extends JFrame implements ActionListener {
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

	public SFrame() {
		setSize(550, 600);
		f1 = new Font("����", Font.BOLD, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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



	public void serverStart() throws IOException {
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
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		textArea.append("Ŭ���̾�Ʈ�� ���ӵǾ����ϴ�.\n");
		while ((inputLine = in.readLine()) != null) {
			String s = inputLine + " "+ nowTime()+"\n";
			textArea.append(s);
//			if (outputLine.equals("quit"))
//				break;
		}
		out.close();
		in.close();
	}
	public String nowTime(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH�� mm�� ss��");
		LocalDateTime time = LocalDateTime.now();
		String nowTime = " ["+time.format(formatter)+"]";
		return nowTime;
		
	}
}

public class AdminChat { 
	public static void main(String[] args) throws IOException { 
		SFrame f = new SFrame(); 
		
		f.serverStart();
		} 
	}

