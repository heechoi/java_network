package java_network.udp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChattingFram extends JFrame {
	private JTextArea ta;
	private JTextField tf;
	private Messenger messenger;
	
	public ChattingFram(String title, int myPort,int otherPort, String addr){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tf = new JTextField(30);
		tf.addActionListener(listener);
		
		ta = new JTextArea(10,30);
		ta.setEditable(false); //수정 불가하게
		
		add(tf,BorderLayout.SOUTH);
		add(ta,BorderLayout.CENTER);
		
		
		pack();
		messenger = new Messenger(myPort, otherPort, addr);
		messenger.setTextArea(ta);
		messenger.start();
		
		setVisible(true);
	}
	
	ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String msg = tf.getText().trim();
			messenger.sendMessage(msg);
			ta.append("SENT : "+msg+"\n");
			tf.selectAll();
			ta.setCaretPosition(ta.getDocument().getLength());
		}
	};
}
