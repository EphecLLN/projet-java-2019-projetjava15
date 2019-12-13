/**
 * 
 */
package RPG;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/**
 * @author Rody
 *
 */
public class GameGUI implements ActionListener {
	
	JFrame window;
	Container c;
	JPanel titlePanel,startButtonPanel,loadButtonPanel,beginPanel,test,ouiPanel,nonPanel,validerPanel,playerInfoPanel,manaPanel;
	JPanel hpPanel,hpMobPanel,choiceButtonPanel, infoPanel, authorsPanel,playerIconPanel,mobIconPanel;
	JLabel titleName,q1,q2,q3, hpLabel,fightInfo;
	JTextArea infoArea, authorNames;
	JButton startButton,loadButton,oui,non, valider,choice1,choice2,choice3;
	JTextField a1, a2, a3;
	JProgressBar hpBar, hpMobBar,manaBar;
	Graphics g;
	int hp,hpMob,mana;
	Personnage p;
	
	public GameGUI() throws IOException{
		//FightScreen("mage");
		startScreen();
	}
	
	public void startScreen() {
		window = new JFrame("RPG");
		window.setSize(1000, 1000);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.gray);
		window.setLayout(null);
		c = window.getContentPane();
		
		titlePanel = new JPanel();
		titlePanel.setBounds(300, 50, 400, 100);
		titlePanel.setBackground(Color.blue);
		titleName = new JLabel("RPG GAME");
		titleName.setForeground(Color.white);
		titleName.setFont(new Font("Times New Roman",Font.PLAIN,70));
		
		authorsPanel = new JPanel();
		authorsPanel.setBounds(300, 200, 400, 50);
		authorsPanel.setBackground(Color.gray);
		
		authorNames = new JTextArea("By Lebas Yaël & Mugisha Rodrigue");
		authorNames.setBounds(150, 200, 400, 50);
		authorNames.setBackground(Color.gray);
		authorNames.setForeground(Color.white);
		authorNames.setFont(new Font("Times New Roman",Font.PLAIN,25));
		authorNames.setEditable(false);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(450, 400, 100, 70);
		startButtonPanel.setBackground(Color.gray);
		
		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
		startButton.setFocusPainted(false);
		startButton.addActionListener(this);
		
		loadButtonPanel = new JPanel();
		loadButtonPanel.setBounds(440, 475, 130, 70);
		loadButtonPanel.setBackground(Color.gray);
		
		loadButton = new JButton("Continue");
		loadButton.setBackground(Color.black);
		loadButton.setForeground(Color.white);
		loadButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
		loadButton.setFocusPainted(false);
		//loadButton.addActionListener(this);
		
		titlePanel.add(titleName);
		startButtonPanel.add(startButton);
		loadButtonPanel.add(loadButton);
		authorsPanel.add(authorNames);
		c.add(titlePanel);
		c.add(startButtonPanel);
		c.add(loadButtonPanel);
		c.add(authorsPanel);
		window.setVisible(true);
	}
	
	
	public void infoScreen() {
		window.getContentPane().removeAll();
		window.revalidate();
		window.repaint();
		
		q1 = new JLabel("Quel type de personnage voulez-vous créer? (assassin, mage ou aventurier)");
		q1.setBounds(20, 20, 500, 50);
		q1.setForeground(Color.white);
		a1 = new JTextField();
		a1.setBounds(20, 60, 150, 30);
		q2 = new JLabel("Choisissez un username");
		q2.setBounds(20, 100, 500, 50);
		q2.setForeground(Color.white);
		a2 = new JTextField();
		a2.setBounds(20, 140, 150, 30);
		q3 = new JLabel("Votre username est "+ a2.getText() +", Cela vous convient-il?(oui ou non)");
		q3.setBounds(20, 180, 500, 50);
		q3.setForeground(Color.white);
		
		ouiPanel = new JPanel();
		ouiPanel.setBounds(20, 225, 100, 70);
		ouiPanel.setBackground(Color.gray);
		nonPanel = new JPanel();
		nonPanel.setBounds(200, 225, 100, 70);
		nonPanel.setBackground(Color.gray);
		
		oui = new JButton("oui");
		oui.setBackground(Color.black);
		oui.setForeground(Color.white);
		oui.setFont(new Font("Times New Roman",Font.PLAIN,30));
		oui.setFocusPainted(false);
		oui.addActionListener(this);
		
		non = new JButton("non");
		non.setBackground(Color.black);
		non.setForeground(Color.white);
		non.setFont(new Font("Times New Roman",Font.PLAIN,30));
		non.setFocusPainted(false);
		non.addActionListener(this);
		
		validerPanel = new JPanel();
		validerPanel.setBounds(200, 130, 140, 70);
		validerPanel.setBackground(Color.gray);
		
		valider = new JButton("valider");
		valider.setBackground(Color.black);
		valider.setForeground(Color.white);
		valider.setFont(new Font("Times New Roman",Font.PLAIN,30));
		valider.setFocusPainted(false);
		valider.addActionListener(this);
		choixClasse(p);
		
		window.getContentPane().add(q1);
		window.getContentPane().add(a1);
		window.getContentPane().add(q2);
		window.getContentPane().add(a2);
		window.getContentPane().add(q3);
		ouiPanel.add(oui);
		nonPanel.add(non);
		validerPanel.add(valider);
		window.getContentPane().add(ouiPanel);
		window.getContentPane().add(nonPanel);
		window.getContentPane().add(validerPanel);		
		window.setVisible(true);		
	}
	
	public void MapScreen() {
		window.getContentPane().removeAll();
		window.revalidate();
		window.repaint();
		
		infoPanel = new JPanel();
		infoPanel.setBounds(0, 0, 200, 400);
		infoPanel.setBackground(Color.white);
		
		
		infoArea = new JTextArea(choixClasse(p).toString());
		infoArea.setBounds(0, 0, 200, 400);
		infoArea.setBackground(Color.black);
		infoArea.setForeground(Color.red);
		infoArea.setFont(new Font("Times New Roman",Font.PLAIN,19));
		infoArea.setEditable(false);
		
		infoPanel.add(infoArea);
		window.getContentPane().add(infoPanel);
		window.setVisible(true);
		
        
	}
	
	public void FightScreen(String classe) throws IOException {
		window.getContentPane().removeAll();
		window.revalidate();
		window.repaint();
		
		window.getContentPane().setBackground(Color.gray);
		
		playerInfoPanel = new JPanel();
		playerInfoPanel.setBounds(10, 15, 300, 30);
		playerInfoPanel.setBackground(Color.gray);
		playerInfoPanel.setLayout(new GridLayout(1,2));
		c.add(playerInfoPanel);
		
		hpPanel = new JPanel();
		hpPanel.setBounds(75, 15, 200, 30);
		hpPanel.setBackground(Color.gray);
		c.add(hpPanel);
		
		playerIconPanel = new JPanel();
		playerIconPanel.setBounds(20, 150, 200, 300);
		playerIconPanel.setBackground(Color.gray);
		BufferedImage myPicture = ImageIO.read(new File("images/ninja_m.png"));
		switch (classe){
        case "assassin":
        	myPicture = ImageIO.read(new File("images/ninja_m.png"));
            break;
        case "mage":
        	myPicture = ImageIO.read(new File("images/mage_m.png"));
            break;
        case"aventurier":
        	myPicture = ImageIO.read(new File("images/warrior_m.png"));
            break;
		}
		ImageIcon pic = new ImageIcon(myPicture);
		playerIconPanel.add(new JLabel(pic));
		c.add(playerIconPanel);
		
		mobIconPanel = new JPanel();
		mobIconPanel.setBounds(700, 150, 200, 300);
		mobIconPanel.setBackground(Color.gray);
		BufferedImage myPicture2 = ImageIO.read(new File("images/mob.png"));
		ImageIcon pic2 = new ImageIcon(myPicture2);
		mobIconPanel.add(new JLabel(pic2));
		c.add(mobIconPanel);
		
		fightInfo = new JLabel("",SwingConstants.CENTER);
		fightInfo.setBounds(250, 150, 450, 40);
		fightInfo.setForeground(Color.white);
		fightInfo.setFont(new Font("Times New Roman",Font.PLAIN,30));
		c.add(fightInfo);
		
		hpBar = new JProgressBar(0,100);
		hpBar.setPreferredSize(new Dimension(300,30));
		hpBar.setBackground(Color.red);
		hpBar.setForeground(Color.green);
		hpBar.setValue(100);
		hpPanel.add(hpBar);
		hpMob = 100;
		
		manaPanel = new JPanel();
		manaPanel.setBounds(75, 50, 200, 30);
		manaPanel.setBackground(Color.gray);
		c.add(manaPanel);
		
		manaBar = new JProgressBar(0,100);
		manaBar.setPreferredSize(new Dimension(300,30));
		manaBar.setBackground(Color.red);
		manaBar.setForeground(Color.blue);
		manaBar.setValue(100);
		manaPanel.add(manaBar);
		mana = 100;
		
		hpMobPanel = new JPanel();
		hpMobPanel.setBounds(700, 15, 200, 30);
		hpMobPanel.setBackground(Color.gray);
		c.add(hpMobPanel);
		
		hpMobBar = new JProgressBar(0,100);
		hpMobBar.setPreferredSize(new Dimension(300,30));
		hpMobBar.setBackground(Color.red);
		hpMobBar.setForeground(Color.green);
		hpMobBar.setValue(100);
		hpMobPanel.add(hpMobBar);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(350, 600, 300, 150);
		choiceButtonPanel.setBackground(Color.gray);
		choiceButtonPanel.setLayout(new GridLayout(3,1));
		c.add(choiceButtonPanel);
		
		choice1 = new JButton("Attack");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(new Font("Times New Roman",Font.PLAIN,30));
		choice1.setFocusPainted(false);
		choice1.addActionListener(this);
		
		choice2 = new JButton("Heal");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(new Font("Times New Roman",Font.PLAIN,30));
		choice2.setFocusPainted(false);
		choice2.addActionListener(this);
		
		choice3 = new JButton("Cast");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(new Font("Times New Roman",Font.PLAIN,30));
		choice3.setFocusPainted(false);
		choice3.addActionListener(this);
		
		//createButton(choice1,"Attack",this);
		choiceButtonPanel.add(choice1);
		//createButton(choice2,"Heal",null);
		choiceButtonPanel.add(choice2);
		//createButton(choice3,"Cast",null);
		choiceButtonPanel.add(choice3);
		
		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(new Font("Times New Roman",Font.PLAIN,30));
		hpLabel.setForeground(Color.white);
		playerInfoPanel.add(hpLabel);
		
		window.setVisible(true);
	}
	
	public void createButton(JButton b, String text, ActionListener a) {
		b = new JButton(text);
		b.setBackground(Color.black);
		b.setForeground(Color.white);
		b.setFont(new Font("Times New Roman",Font.PLAIN,30));
		b.setFocusPainted(false);
		b.addActionListener(a);
		choiceButtonPanel.add(b);
	}
	

	public void damageReceived() {
		hpMob = hpMob - 10;
		hpMobBar.setValue(hpMob);
		fightInfo.setText("Le joueur attaque");
	}
	
	public void heal() {
		hp = hp + 10;
		hpBar.setValue(hp);
		fightInfo.setText("Le joueur se soigne");
	}
	
	public void sort() {
		mana = mana - 10;
		hpMob = hpMob - 20;
		hpMobBar.setValue(hpMob);
		manaBar.setValue(mana);
		fightInfo.setText("le joueur lance un sort");
	}
	
 
	public static void main(String[] args) throws IOException {
		new GameGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object  source = e.getSource();
		
		
		   if(source == startButton) {infoScreen();} 
		   else if(source == oui) {MapScreen();}
		   else if(source == valider) {q3.setText("Votre username est "+ a2.getText() +", Cela vous convient-il?(oui ou non)");}
		   else if(source == non) {
			   try {
				   FightScreen("aventurier");
			   } catch (IOException e1) {
				   e1.printStackTrace();
			   }}
		   else if(source == choice1) {damageReceived();}
		   else if(source == choice2) {heal();}
		   else if(source == choice3) {sort();}
	}
	
	public Personnage choixClasse(Personnage personnage) {
        switch (a1.getText().toLowerCase()){
            case "assassin":
            	personnage = new Assassin(a2.getText());
                break;
            case "mage":
            	personnage = new Mage(a2.getText());
                break;
            case"aventurier":
            	personnage = new Aventurier(a2.getText());
                break;
        }
        return personnage;
	}
	


}
