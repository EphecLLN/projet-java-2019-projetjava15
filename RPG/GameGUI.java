/**
 * 
 */
package RPG;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * @author Rody
 *
 */
public class GameGUI  {
	
	JFrame window;
	Container c;
	JPanel titlePanel,startButtonPanel,beginPanel,test,ouiPanel,nonPanel;
	JLabel titleName,q1,q2,q3;
	JButton startButton,oui,non;
	JTextField a1, a2, a3;
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	
	public GameGUI(){
		startScreen();
	}
	
	public void startScreen() {
		window = new JFrame();
		window.setSize(700, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.white);
		window.setLayout(null);
		c = window.getContentPane();
		
		titlePanel = new JPanel();
		titlePanel.setBounds(150, 50, 400, 100);
		titlePanel.setBackground(Color.blue);
		titleName = new JLabel("RPG GAME");
		titleName.setForeground(Color.white);
		titleName.setFont(new Font("Times New Roman",Font.PLAIN,70));
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 100, 70);
		startButtonPanel.setBackground(Color.white);
		
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
		startButton.setFocusPainted(false);
		startButton.addActionListener(tsHandler);
		
		titlePanel.add(titleName);
		startButtonPanel.add(startButton);
		c.add(titlePanel);
		c.add(startButtonPanel);
		window.setVisible(true);
	}
	
	
	public void infoScreen() {
		window.getContentPane().removeAll();
		window.revalidate();
		window.repaint();
		
		q1 = new JLabel("Quel type de personnage voulez-vous créer? (assassin, mage ou aventurier)");
		q1.setBounds(20, 20, 500, 50);
		a1 = new JTextField();
		a1.setBounds(20, 60, 150, 30);
		q2 = new JLabel("Choisissez un username");
		q2.setBounds(20, 100, 500, 50);
		a2 = new JTextField();
		a2.setBounds(20, 140, 150, 30);
		q3 = new JLabel("Votre username est "+ a2.getText() +", Cela vous convient-il?(oui ou non)");
		q3.setBounds(20, 180, 500, 50);
		
		ouiPanel = new JPanel();
		ouiPanel.setBounds(20, 225, 100, 70);
		ouiPanel.setBackground(Color.white);
		nonPanel = new JPanel();
		nonPanel.setBounds(200, 225, 100, 70);
		nonPanel.setBackground(Color.white);
		
		oui = new JButton("oui");
		oui.setBackground(Color.black);
		oui.setForeground(Color.white);
		oui.setFont(new Font("Times New Roman",Font.PLAIN,30));
		oui.setFocusPainted(false);
		
		non = new JButton("non");
		non.setBackground(Color.black);
		non.setForeground(Color.white);
		non.setFont(new Font("Times New Roman",Font.PLAIN,30));
		non.setFocusPainted(false);
		
		window.getContentPane().add(q1);
		window.getContentPane().add(a1);
		window.getContentPane().add(q2);
		window.getContentPane().add(a2);
		window.getContentPane().add(q3);
		ouiPanel.add(oui);
		nonPanel.add(non);
		window.getContentPane().add(ouiPanel);
		window.getContentPane().add(nonPanel);
		window.setVisible(true);
	}
	
	public class TitleScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
				infoScreen();
			}
		}
	
 
	
	
	public static void main(String[] args) {
		new GameGUI();

	}


}
