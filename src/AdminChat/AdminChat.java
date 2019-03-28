package AdminChat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class SFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton but_input;
	JTextArea ta;
	JTextField tf;
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
		ta = new JTextArea(25, 40);
		tf = new JTextField(20);
		but_input = new JButton("�Է�");
		but_input.addActionListener(this);
		panel2.add(name);
		panel.add(ta);
		panel.add(tf);
		panel.add(but_input);
		add(panel2, BorderLayout.NORTH);
		add(panel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s;
		s = "������ : " + tf.getText();
		if (arg0.getSource() == but_input) {
			ta.append(s + "\n");
			out.println(s);
			tf.setText("");
		}
	} 

	public void serverStart() throws IOException {
		System.out.println("���� ����!");
		try {
			serverSocket = new ServerSocket(5555);
		} catch (IOException e) {
			System.out.println("������ ��Ʈ ��ȣ�� ������ �� �����ϴ� : 5555");
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
		ta.append("Ŭ���̾�Ʈ�� ���ӵǾ����ϴ�.\n");
		while ((inputLine = in.readLine()) != null) {
			String s = inputLine + "\n";
			System.out.println(s);
			ta.append(s);
			 outputLine = inputLine;
			 out.println(outputLine);
			if (outputLine.equals("quit"))
				break;
		}
	}
}

public class AdminChat { 
	public static void main(String[] args) throws IOException { 
		SFrame f = new SFrame(); 
		f.serverStart();
		} 
	}

