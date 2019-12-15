package RPG;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

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

public class PersonnageGUI extends PersonnageVue implements ActionListener {
	
	JFrame window;
	Container c;
	JPanel titlePanel,startButtonPanel,continueButtonPanel,loadButtonPanel,beginPanel,test,ouiPanel,nonPanel,validerPanel,playerInfoPanel,manaPanel;
	JPanel hpPanel,hpMobPanel,choiceButtonPanel, infoPanel, authorsPanel,playerIconPanel,mobIconPanel,saveButtonPanel,testFightPanel;
	JLabel titleName,q1,q2,q3,logInfo,hpLabel,fightInfo;
	JTextArea infoArea, authorNames;
	JButton startButton,continueButton,loadButton,oui,non, valider,choice1,choice2,choice3, saveButton, testFightButton;
	JTextField a1, a2, a3,logUsername;
	JProgressBar hpBar, hpMobBar,manaBar;
	int hp,hpMob,mana;
	//Mob m = new Mob(80, 10, "feu", 30, 20);
	GameDB db = new GameDB();
	
	public PersonnageGUI(Personnage model,Mob e, PersonnageController controller) throws IOException{
		super(model,e,controller);
		//FightScreen();
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
		
		continueButtonPanel = new JPanel();
		continueButtonPanel.setBounds(440, 475, 130, 70);
		continueButtonPanel.setBackground(Color.gray);
		
		continueButton = new JButton("Continue");
		continueButton.setBackground(Color.black);
		continueButton.setForeground(Color.white);
		continueButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
		continueButton.setFocusPainted(false);
		continueButton.addActionListener(this);
		
		titlePanel.add(titleName);
		startButtonPanel.add(startButton);
		continueButtonPanel.add(continueButton);
		authorsPanel.add(authorNames);
		c.add(titlePanel);
		c.add(startButtonPanel);
		c.add(continueButtonPanel);
		c.add(authorsPanel);
		window.setVisible(true);
	}
	
	public void ContinueScreen() {
		window.getContentPane().removeAll();
		window.revalidate();
		window.repaint();
		
		logInfo = new JLabel("Entrer votre nom d'utilisateur");
		logInfo.setBounds(325, 200, 500, 50);
		logInfo.setForeground(Color.white);
		logInfo.setFont(new Font("Times New Roman",Font.PLAIN,30));
		logUsername = new JTextField();
		logUsername.setBounds(370,250, 250, 30);
		
		loadButtonPanel = new JPanel();
		loadButtonPanel.setBounds(425, 350, 130, 70);
		loadButtonPanel.setBackground(Color.gray);
		
		loadButton = new JButton("Load");
		loadButton.setBackground(Color.black);
		loadButton.setForeground(Color.white);
		loadButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
		loadButton.setFocusPainted(false);
		loadButton.addActionListener(this);
		
		loadButtonPanel.add(loadButton);
		window.getContentPane().add(logInfo);
		window.getContentPane().add(logUsername);
		window.getContentPane().add(loadButtonPanel);
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
		testFightPanel = new JPanel();
		testFightPanel.setBounds(400, 225, 100, 70);
		testFightPanel.setBackground(Color.gray);
		
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
		
		testFightButton = new JButton("Test");
		testFightButton.setBackground(Color.black);
		testFightButton.setForeground(Color.white);
		testFightButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
		testFightButton.setFocusPainted(false);
		testFightButton.addActionListener(this);
		
		validerPanel = new JPanel();
		validerPanel.setBounds(200, 130, 140, 70);
		validerPanel.setBackground(Color.gray);
		
		valider = new JButton("valider");
		valider.setBackground(Color.black);
		valider.setForeground(Color.white);
		valider.setFont(new Font("Times New Roman",Font.PLAIN,30));
		valider.setFocusPainted(false);
		valider.addActionListener(this);
		choixClasse();
		
		window.getContentPane().add(q1);
		window.getContentPane().add(a1);
		window.getContentPane().add(q2);
		window.getContentPane().add(a2);
		window.getContentPane().add(q3);
		ouiPanel.add(oui);
		nonPanel.add(non);
		testFightPanel.add(testFightButton);
		validerPanel.add(valider);
		window.getContentPane().add(ouiPanel);
		window.getContentPane().add(nonPanel);
		window.getContentPane().add(testFightPanel);
		window.getContentPane().add(validerPanel);		
		window.setVisible(true);		
	}
	
	public void MapScreen() {
		window.getContentPane().removeAll();
		window.revalidate();
		window.repaint();
		
		infoPanel = new JPanel();
		infoPanel.setBounds(0, 0, 200, 400);
		infoPanel.setBackground(Color.black);
		
		
		infoArea = new JTextArea(choixClasse().toString());
		infoArea.setBounds(0, 0, 200, 400);
		infoArea.setBackground(Color.black);
		infoArea.setForeground(Color.red);
		infoArea.setFont(new Font("Times New Roman",Font.PLAIN,19));
		infoArea.setEditable(false);
		
		saveButtonPanel = new JPanel();
		saveButtonPanel.setBounds(50, 425, 100, 70);
		saveButtonPanel.setBackground(Color.gray);
		
		saveButton = new JButton("Save");
		saveButton.setBackground(Color.black);
		saveButton.setForeground(Color.white);
		saveButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
		saveButton.setFocusPainted(false);
		saveButton.addActionListener(this);
			
		infoPanel.add(infoArea);
		saveButtonPanel.add(saveButton);
		window.getContentPane().add(saveButtonPanel);
		window.getContentPane().add(infoPanel);
		window.setVisible(true);
		
	}
	
	public void FightScreen() throws IOException {
		window.getContentPane().removeAll();
		window.revalidate();
		window.repaint();
		
		window.getContentPane().setBackground(Color.gray);
		
		model = choixClasse();
		
		playerInfoPanel = new JPanel();
		playerInfoPanel.setBounds(10, 15, 300, 30);
		playerInfoPanel.setBackground(Color.gray);
		playerInfoPanel.setLayout(new GridLayout(1,2));
		c.add(playerInfoPanel);
		
		
		playerIconPanel = new JPanel();
		playerIconPanel.setBounds(20, 150, 200, 300);
		playerIconPanel.setBackground(Color.gray);
		BufferedImage myPicture = ImageIO.read(new File("images/ninja_m.png"));
		switch (model.getClass().getSimpleName().toLowerCase()){
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
		
		hpPanel = new JPanel();
		hpPanel.setBounds(75, 15, 200, 30);
		hpPanel.setBackground(Color.gray);
		c.add(hpPanel);
		
		hpBar = new JProgressBar(0,model.getHpMax());
		//hpBar.setPreferredSize(new Dimension(300,30));
		hpBar.setBackground(Color.red);
		hpBar.setForeground(Color.green);
		hpBar.setValue(model.getHp());
		hpPanel.add(hpBar);
		
		manaPanel = new JPanel();
		manaPanel.setBounds(75, 50, 200, 30);
		manaPanel.setBackground(Color.gray);
		c.add(manaPanel);
		
		manaBar = new JProgressBar(0,model.getMaxMana());
		//manaBar.setPreferredSize(new Dimension(300,30));
		manaBar.setBackground(Color.red);
		manaBar.setForeground(Color.blue);
		manaBar.setValue(model.getMana());
		manaPanel.add(manaBar);
		//mana = 100;
		
		hpMobPanel = new JPanel();
		hpMobPanel.setBounds(700, 15, 200, 30);
		hpMobPanel.setBackground(Color.gray);
		c.add(hpMobPanel);
		
		hpMobBar = new JProgressBar(0,e.getHp());
		//hpMobBar.setPreferredSize(new Dimension(300,30));
		hpMobBar.setBackground(Color.red);
		hpMobBar.setForeground(Color.green);
		hpMobBar.setValue(e.getHp());
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
		
		choiceButtonPanel.add(choice1);
		choiceButtonPanel.add(choice2);
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
	
	public void sort() {
		mana = mana - 10;
		hpMob = hpMob - 20;
		hpMobBar.setValue(hpMob);
		manaBar.setValue(mana);
		fightInfo.setText("le joueur lance un sort");
	}
	
	public void sauverPerso() {
		db.sauverEnDB(model);
		System.out.println("Partie sauvegardé");
	}
	
	public void chargerPerso() {
			model = db.lireEnDB("'"+logUsername.getText()+"'",model);
			System.out.println(model);
			System.out.println("Partie chargé");

	}
	
	
	public static void main(String[] args) throws IOException {
		new GameGUI();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object  source = event.getSource();
		
		
		   if(source == startButton) {infoScreen();}
		   else if(source == continueButton) {ContinueScreen();}
		   else if(source == loadButton) {chargerPerso();}
		   else if(source == oui) {MapScreen();}
		   else if(source == valider) {q3.setText("Votre username est "+ a2.getText() +", Cela vous convient-il?(oui ou non)");}
		   else if(source == non) {a2.setText("");}
		   else if(source == testFightButton) {
			   try {
				FightScreen();
			} catch (IOException e1) {
				System.out.println("Erreur");
				e1.printStackTrace();
			}
		   }
		   else if(source == saveButton) {sauverPerso();}
		   else if(source == choice1) {
			   if(e.getHp() <= 0 || model.getHp() <= 0) {
				   window.dispose();
			   }
			   else {
				   try {
					controller.attaquer(model,e);
					fightInfo.setText(model.getUsername() + " attaque");
				} catch (InterruptedException e1) {
					System.out.println("Erreur");
					e1.printStackTrace();
				}
				   }
			   }
		   else if(source == choice2) {
			   try {
				controller.soin(model,10);
				System.out.println(model.getClass());
			} catch (InterruptedException e) {
				System.out.println("Erreur");
				e.printStackTrace();
			}
			   fightInfo.setText(model.getUsername() + " se soigne");
			   }
		   else if(source == choice3) {
			   try {
				controller.cast(model,e);
			} catch (InterruptedException e) {
				System.out.println("Erreur");
				e.printStackTrace();
			}
			   fightInfo.setText(model.getUsername() + " lance un sort");
		   }
	}
	
	public Personnage choixClasse() {
        switch (a1.getText().toLowerCase()){
            case "assassin":
            	model = new Assassin(a2.getText());
                break;
            case "mage":
            	model = new Mage(a2.getText());
                break;
            case"aventurier":
            	model = new Aventurier(a2.getText());
                break;
        }
        return model;
	}
	
	public void affiche(String string) {
		System.out.println(string);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		hpBar.setValue(model.getHp());
		hpMobBar.setValue(e.getHp());
		manaBar.setValue(model.getMana());	
	}

}
