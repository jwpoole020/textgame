package textGame;

import javax.swing.*;		//swing gui package
import javax.swing.text.DefaultCaret;

import java.awt.*; 			//advance window toolkit
import java.awt.event.*;	//awt event package (to program buttons)

public class GameGUI extends JFrame implements KeyListener {

	private JTextArea textArea;
	private JTextField input;
	private JPanel l1, l2;
	private static NPC currentNPC;
	
	public void print(String s) {
		textArea.append(s+'\n'+'\n');
	}
	
	
	public GameGUI() {
		setTitle("Text Game");
		setSize(750, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l1=new JPanel();
		l1.setLayout(new BorderLayout());
		l2=new JPanel();
		l2.setLayout(new BorderLayout());
		
		textArea = new JTextArea();
		textArea.setFont(new Font(null, Font.PLAIN, 18));
		textArea.setRows(15);
		textArea.setColumns(30);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane scroll = new JScrollPane(textArea);
		l1.add(scroll, BorderLayout.NORTH);
		
		
		input= new JTextField();
		input.setFont(new Font(null, Font.PLAIN, 26));
		input.addKeyListener(this);
		
		JTextArea wish = new JTextArea();
		wish.setFont(new Font(null, Font.PLAIN, 18));
		wish.setRows(1);
		wish.setColumns(1);
		wish.setLineWrap(true);
		wish.setWrapStyleWord(true);
		wish.setEditable(false);
		wish.setText("What do you wish to do: ");
		
		l2.add(wish, BorderLayout.CENTER);
		l2.add(input, BorderLayout.SOUTH);
		
		add(l1, BorderLayout.NORTH);
		add(l2,BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		currentNPC=game.getCurrentRoom().getNPC(NPC.getnpc());
		if(e.getKeyChar()=='\n') {
			if(NPC.getConvo()) {
				currentNPC.response(Integer.parseInt(input.getText()));
				NPC.setConvo(false);
			}else
				game.performTask(input.getText());
			input.setText("");
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
