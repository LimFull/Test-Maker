import javax.swing.*; //�봽濡쒖젥�듃 �떎�뻾�솚寃� - JavaSE-1.7 

 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class mainframe extends JFrame {
	private static final String ACTION_COMMAND_END= "1";
	JPanel jp = new JPanel();
	JLabel jl = new JLabel();
	JLabel jl2 = new JLabel();
	JTextField tf = new JTextField(20);
	JButton end = new JButton();
	int count = 0;
	int num = 1;
	int mean = 1;
	int k = 0;
	public mainframe(int selectednum) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		final String problem[] = new String[selectednum];
		final int arraymean[] = new int[selectednum];
		jl.setFont(new Font("새굴림",Font.BOLD, 40));
		jl2.setFont(new Font("새굴림",Font.BOLD, 40));
		tf.setFont(new Font("새굴림",Font.BOLD, 40));
		jl.setText("뜻 : 1개");
		end.setFont(new Font("새굴림",Font.BOLD, 40));
		end.setText("문제 생성");
		end.setSize(50,50);

		jl2.setText(Integer.toString(count));
		jp.add(jl);
		jp.add(tf);
		jp.add(jl2);
		jp.add(end);
		add(jp);
		
		//this.pack();
		//writer wr = new writer();
		tf.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				 
			}
			public void keyReleased(KeyEvent e) {
				 
			}
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode()+"pressed key");
				if (e.getKeyCode()==49) {
					jl.setText("뜻 : 1개");
					mean = 1;
					tf.setText("");
				}else if (e.getKeyCode()==50) {
					jl.setText("뜻 : 2개");
					mean = 2;
					tf.setText("");
				}else if (e.getKeyCode()==51) {
					jl.setText("뜻 : 3개");
					mean = 3;
					tf.setText("");
				}else if (e.getKeyCode()==52) {
					jl.setText("뜻 : 4개");
					mean = 4;
					tf.setText("");
				}else if (e.getKeyCode()==53) {
					jl.setText("뜻 : 5개");
					mean = 5;
					tf.setText("");
				}
				else if (e.getKeyCode()==54) {
					jl.setText("뜻 : 6개");
					mean = 6;
					tf.setText("");
				}
				else if (e.getKeyCode()==55) {
					jl.setText("뜻 : 7개");
					mean = 7;
					tf.setText("");
				}
				else if (e.getKeyCode()==56) {
					jl.setText("뜻 : 8개");
					mean = 8;
					tf.setText("");
				}
				else if (e.getKeyCode()==57) {
					jl.setText("뜻 : 9개");
					mean = 9;
					tf.setText("");
				}
				else if (e.getKeyCode()==48) {
					jl.setText("뜻 : 10개");
					mean = 10;
					tf.setText("");
				}
				if (e.getKeyCode()==49 || e.getKeyCode()==50||e.getKeyCode()==51||e.getKeyCode()==52||e.getKeyCode()==53)
				tf.setText("");
				if (e.getKeyCode() == 10) {
					//System.out.println(tf.getText());
					//String type = new String();
					//type = tf.getText();
					//writer wr = new writer(type, num++, mean);
					problem[k] = tf.getText().replaceAll("[0-9]","");
					arraymean[k] = mean;
					k++;
					tf.setText("");
					jl2.setText(Integer.toString(++count));
					if (count == selectednum) {
						tf.setText(selectednum + "개 문제를 모두 입력했습니다.");
						tf.setEnabled(false);
					}
					
				}
			}
		});
		ActionListener listener = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (e.getActionCommand().equals(ACTION_COMMAND_END)){
					
					writer wr = new writer (problem, arraymean, selectednum);
					end.setText("완료");
					end.setEnabled(false);
				}
			}
		};
		end.setActionCommand(ACTION_COMMAND_END);
		end.addActionListener(listener);
		gd.setFullScreenWindow(this);
		this.setTitle("문제 만들기");
		//this.setSize(500,500);
		this.setVisible(true);
		
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
