import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ClienteVitor{
	JTextField outgoing;
	PrintWriter writer;
	public void go(){
		JFrame frame = new JFrame("JFrame");
		JPanel mainPanel = new JPanel();
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("send") ;
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		setUpNetworking();
		frame.setSize(400,500);
		frame.setVisible(true);
	}
	public void setUpNetworking(){
		try{
			Socket sock = new Socket("192.168.0.117", 5555);
			PrintWriter writer = new PrintWriter (sock.getOutputStream());
			System. out.println ("networking established");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	public class SendButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent av){
		try {
			writer.println(outgoing.getText());
			writer.flush();
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		outgoing.setText ("String:") ;
		outgoing.requestFocus();
		}
	}	
	public static void main (String[] args){
		ClienteVitor client = new ClienteVitor();
		client.go();
	}
}