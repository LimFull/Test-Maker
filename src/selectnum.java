import javax.swing.*; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class selectnum extends JFrame {
	
	JPanel jp = new JPanel();
	JLabel jl = new JLabel();
	JTextField tf = new JTextField(10);
	public selectnum() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		jl.setFont(new Font("새굴림",Font.BOLD, 40));
		jl.setText("문제 수 ");
		tf.setFont(new Font("새굴림",Font.BOLD, 40));
		jp.add(jl);
		jp.add(tf);
		add(jp);
		
		tf.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				 
			}
			public void keyReleased(KeyEvent e) {
				 
			}
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == 10) {
					mainframe mf = new mainframe(Integer.parseInt(tf.getText()));
					System.out.println(Integer.parseInt(tf.getText()));
					dispose();
				}
			}
		});
		this.setTitle("문제");
		gd.setFullScreenWindow(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
