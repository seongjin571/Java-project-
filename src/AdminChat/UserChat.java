package AdminChat; 

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.PrintWriter; 
import java.net.Socket; 
import java.net.UnknownHostException; 
import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JTextArea;
import javax.swing.JTextField; 
class ClientFrame extends JFrame implements ActionListener { 
	private static final long serialVersionUID = 1L;
	JButton but_input; 
	JTextArea ta; 
	JTextField tf; // out , in ���� 
	JLabel name;
	Font f1;
	static PrintWriter out = null; 
	static BufferedReader in = null; 
	public ClientFrame() { 
		setSize(550, 600); 
		f1 = new Font("����", Font.BOLD, 30);
		setTitle("SeJong Pc Cafe"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JPanel panel = new JPanel(); 
		name = new JLabel("SeJong Pc Cafe ä�ù�");
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
	@Override public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == but_input) {
			String s = "�մ� : " + tf.getText(); 
			ta.append(s+"\n"); out.println(s); 
			tf.setText(""); 
			} 
		} 
	public void client() throws IOException { 
		Socket socket = null; 
		try { 
			socket = new Socket("localhost", 5555); 
			out = new PrintWriter(socket.getOutputStream(), true); 
			in = new BufferedReader(new InputStreamReader( socket.getInputStream())); 
			} catch (UnknownHostException e) { 
				System.err.println("localhost�� ������ �� �����ϴ�."); 
				System.exit(1); 
				} catch (IOException eg) { 
					System.err.println("����� ����11"); 
					System.exit(1); 
					} 
		String fromServer; 
		while ((fromServer = in.readLine()) != null) { 
			String s =fromServer+"\n"; 
			System.out.println(s); 
			ta.append(s); 
			System.out.println(fromServer); 
			if (fromServer.equals("quit")) break; 
			} out.close(); 
			in.close(); 
			socket.close(); 
			} 
	} 
public class UserChat { 
	public static void main(String[] args) throws IOException { 
		ClientFrame f = new ClientFrame(); 
		f.client(); 
		} 
}
