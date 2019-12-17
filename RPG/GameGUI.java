package RPG;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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

/**
 * @authors Lebas Yaël & Mugisha Rodrigue
 * 
 * 
 *
 */
public class GameGUI extends GameVue implements ActionListener {
	
	private JFrame window;
	private Container c;
	private JPanel titlePanel,startButtonPanel,continueButtonPanel,loadButtonPanel,ouiPanel,nonPanel,validerPanel,playerInfoPanel,manaPanel;
	private JPanel hpPanel,hpMobPanel,choiceButtonPanel, authorsPanel,playerIconPanel,mobIconPanel,choixPanel;
	private JPanel staffIconPanel, cloakIconPanel, coinIconPanel, buyStaffPanel, buyCloakPanel ;
	private JLabel titleName,question1,question2,question3,logInfo,hpLabel,fightInfo, roomLabel, nbPieceInfo,descriptionStaff, descriptionCloak;
	private JTextArea authorNames;
	private JButton startButton,continueButton,loadButton,oui,non, valider,choice1,choice2,choice3;
	private JButton nextButton, saveButton, fullHealButton, buyStaffButton, buyCloakButton;
	private JTextField answer1,answer2,logUsername;
	private JProgressBar hpBar, hpMobBar,manaBar;
	private GameDB db = new GameDB();
	private Shop shop = new Shop();
	
	public GameGUI(Personnage model,Mob e, GameController controller) throws IOException{
		super(model,e,controller);
		startScreen();
	}
	
	/**
	 * Méthode créeant et affichant une fenêtre, il s'agit de menu du début où il est possible de commencer un nouvelle partie ou continuer sa progression.	 
	 * 
	 *   
	 **/
	public void startScreen() {
		window = new JFrame("GAME");
		window.setSize(1000, 1000);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.gray);
		window.setLayout(null);
		c = window.getContentPane();
		
		titlePanel = new JPanel();
		titlePanel.setBounds(250, 50, 500, 100);
		titlePanel.setBackground(Color.blue);
		titleName = new JLabel("RPG ARCADE");
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
	
	/**
	 * 
	 * Méthode affichant une fenêtre dans laquelle l'utilisateur entre son nom d'utilisateur en champ texte pour reprendre sa progression
	 * 
	 */
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
	
	/**
	 * 
	 * Méthode affichant une fenêtre permettant l'enregistrement d'informations nécessaire pour commencer une nouvelle partie. 
	 * L'utilisateur choisi entre les 3 classes(Aventurier, Mage et Assassin) et mentionne son nom d'utilisateur.
	 *  
	 */
	public void infoScreen() {
		window.getContentPane().removeAll();
		window.revalidate();
		window.repaint();
		
		question1 = new JLabel("Quel type de personnage voulez-vous créer? (assassin, mage ou aventurier)");
		question1.setBounds(20, 20, 500, 50);
		question1.setForeground(Color.white);
		answer1 = new JTextField();
		answer1.setBounds(20, 60, 150, 30);
		question2 = new JLabel("Choisissez un username");
		question2.setBounds(20, 100, 500, 50);
		question2.setForeground(Color.white);
		answer2 = new JTextField();
		answer2.setBounds(20, 140, 150, 30);
		question3 = new JLabel("Votre username est "+ answer2.getText() +", Cela vous convient-il?(oui ou non)");
		question3.setBounds(20, 180, 500, 50);
		question3.setForeground(Color.white);
		
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
		
		window.getContentPane().add(question1);
		window.getContentPane().add(answer1);
		window.getContentPane().add(question2);
		window.getContentPane().add(answer2);
		window.getContentPane().add(question3);
		ouiPanel.add(oui);
		nonPanel.add(non);
		validerPanel.add(valider);
		window.getContentPane().add(ouiPanel);
		window.getContentPane().add(nonPanel);
		window.getContentPane().add(validerPanel);		
		window.setVisible(true);		
	}
	
	/**
	 * 
	 * Méthode affichant une fenêtre dans laquelle le combat se déroule contre un mob. L'utilisateur a le choix entre plusieurs actions(attaquer, se soigner ou lancer un sort).
	 * Lorsque le mob a été vaincu, l'utilisateur retourne dans la salle de repos. Si l'utilisateur meurt le jeu se termine.
	 * 
	 * @throws IOException
	 */
	public void FightScreen() throws IOException {
		window.getContentPane().removeAll();
		window.revalidate();
		window.repaint();
		
		window.getContentPane().setBackground(Color.gray);
		
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
		hpBar.setBackground(Color.red);
		hpBar.setForeground(Color.green);
		hpBar.setValue(model.getHp());
		hpPanel.add(hpBar);
		
		manaPanel = new JPanel();
		manaPanel.setBounds(75, 50, 200, 30);
		manaPanel.setBackground(Color.gray);
		c.add(manaPanel);
		
		manaBar = new JProgressBar(0,model.getMaxMana());
		manaBar.setBackground(Color.red);
		manaBar.setForeground(Color.blue);
		manaBar.setValue(model.getMana());
		manaPanel.add(manaBar);
		
		hpMobPanel = new JPanel();
		hpMobPanel.setBounds(700, 15, 200, 30);
		hpMobPanel.setBackground(Color.gray);
		c.add(hpMobPanel);
		
		hpMobBar = new JProgressBar(0,e.getHp());
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
	
	/**
	 * 
	 * Méthode affichant une fenêtre où le joueur peut se ravitailler avant le prochain combat. Une boutique avec de l'équipement est disponible.
	 * L'utilisateur peut utiliser l'option "Full Heal" pour se soigner complètement en l'échange de pièces.L'utilisateur peut sauvegarder sa progression via l'option "Save".
	 * Lorsque l'utilisateur est prêt, il peut cliquer l'option "Next" pour passer au combat suivant.
	 * 
	 * @throws IOException
	 */
	public void RoomScreen() throws IOException {
		window.getContentPane().removeAll();
		window.revalidate();
		window.repaint();
		
		roomLabel = new JLabel("Room");
		roomLabel.setBounds(425, 30, 500, 50);
		roomLabel.setFont(new Font("Times New Roman",Font.PLAIN,50));
		roomLabel.setForeground(Color.white);
		
		choixPanel = new JPanel();
		choixPanel.setBounds(600, 700, 300, 150);
		choixPanel.setBackground(Color.gray);
		choixPanel.setLayout(new GridLayout(3,1));
		window.getContentPane().add(choixPanel);

		nextButton = new JButton("Next");
		nextButton.setBackground(Color.black);
		nextButton.setForeground(Color.white);
		nextButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
		nextButton.setFocusPainted(false);
		nextButton.addActionListener(this);
		
		saveButton = new JButton("Save");
		saveButton.setBackground(Color.black);
		saveButton.setForeground(Color.white);
		saveButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
		saveButton.setFocusPainted(false);
		saveButton.addActionListener(this);
		
		fullHealButton = new JButton("Full Heal");
		fullHealButton.setBackground(Color.black);
		fullHealButton.setForeground(Color.white);
		fullHealButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
		fullHealButton.setFocusPainted(false);
		fullHealButton.addActionListener(this);
		
		coinIconPanel = new JPanel();
		coinIconPanel.setBounds(20, 750, 100, 75);
		coinIconPanel.setBackground(Color.gray);
		
		BufferedImage ic = ImageIO.read(new File("images/coin.png"));
		ImageIcon imic = new ImageIcon(ic);
		coinIconPanel.add(new JLabel(imic));
		window.getContentPane().add(coinIconPanel);
		
		nbPieceInfo = new JLabel(""+ model.getNbPieces());
		nbPieceInfo.setBounds(130, 760, 300, 50);
		nbPieceInfo.setFont(new Font("Times New Roman",Font.PLAIN,40));
		nbPieceInfo.setForeground(Color.white);
		
		staffIconPanel = new JPanel();
		staffIconPanel.setBounds(20, 200, 100, 100);
		staffIconPanel.setBackground(Color.white);
		
		BufferedImage ic2 = ImageIO.read(new File("images/staff.png"));
		ImageIcon imic2 = new ImageIcon(ic2);
		staffIconPanel.add(new JLabel(imic2));
		window.getContentPane().add(staffIconPanel);
		
		cloakIconPanel = new JPanel();
		cloakIconPanel.setBounds(20, 400, 100, 75);
		cloakIconPanel.setBackground(Color.white);
		
		BufferedImage ic3 = ImageIO.read(new File("images/cloak.png"));
		ImageIcon imic3 = new ImageIcon(ic3);
		cloakIconPanel.add(new JLabel(imic3));
		window.getContentPane().add(cloakIconPanel);
		
		buyStaffPanel = new JPanel();
		buyStaffPanel.setBounds(450, 200, 100, 70);
		buyStaffPanel.setBackground(Color.gray);
		
		buyCloakPanel = new JPanel();
		buyCloakPanel.setBounds(450, 400, 100, 70);
		buyCloakPanel.setBackground(Color.gray);
		
		buyStaffButton = new JButton("Buy");
		buyStaffButton.setBackground(Color.black);
		buyStaffButton.setForeground(Color.white);
		buyStaffButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
		buyStaffButton.setFocusPainted(false);
		buyStaffButton.addActionListener(this);
		
		buyCloakButton = new JButton("Buye");
		buyCloakButton.setBackground(Color.black);
		buyCloakButton.setForeground(Color.white);
		buyCloakButton.setFont(new Font("Times New Roman",Font.PLAIN,30));
		buyCloakButton.setFocusPainted(false);
		buyCloakButton.addActionListener(this);
		
		descriptionStaff = new JLabel("Lvl puissance: "+ shop.getArmesDispo().get(0).getNiveau() + ", prix: "+ shop.getArmesDispo().get(0).getPrix());
		descriptionStaff.setBounds(150, 200, 500, 50);
		descriptionStaff.setFont(new Font("Times New Roman",Font.PLAIN,25));
		descriptionStaff.setForeground(Color.white);
		
		descriptionCloak = new JLabel("Lvl puissance: "+ shop.getArmuresDispo().get(0).getNiveau() + ", prix: "+ shop.getArmuresDispo().get(0).getPrix());
		descriptionCloak.setBounds(150, 400, 500, 50);
		descriptionCloak.setFont(new Font("Times New Roman",Font.PLAIN,25));
		descriptionCloak.setForeground(Color.white);
		
		choixPanel.add(nextButton);
		choixPanel.add(saveButton);
		choixPanel.add(fullHealButton);
		buyStaffPanel.add(buyStaffButton);
		buyCloakPanel.add(buyCloakButton);
		
		window.getContentPane().add(roomLabel);
		window.getContentPane().add(choixPanel);
		window.getContentPane().add(coinIconPanel);
		window.getContentPane().add(nbPieceInfo);
		window.getContentPane().add(buyStaffPanel);
		window.getContentPane().add(buyCloakPanel);
		window.getContentPane().add(descriptionStaff);
		window.getContentPane().add(descriptionCloak);
		
		window.setVisible(true);
	}
	

	public void sauverPerso() {
		db.save("'"+model.getUsername()+"'",model);
	}
	
	public Personnage chargerPerso() {
			model = db.lireEnDB("'"+logUsername.getText()+"'",model);
			System.out.println(model);
			System.out.println("Partie chargé");
			return model;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object  source = event.getSource();
		
		
		   if(source == startButton) {infoScreen();}
		   else if(source == continueButton) {ContinueScreen();}
		   else if(source == loadButton) {
			   chargerPerso();
			   try {
				RoomScreen();
			} catch (IOException e) {
				e.printStackTrace();
			}
		   }
		   else if(source == oui) {
			   try {
			RoomScreen();
			   }catch (IOException e) {
				   e.printStackTrace();
			   }}
		   else if(source == valider) {question3.setText("Votre username est "+ answer2.getText() +", Cela vous convient-il?(oui ou non)");}
		   else if(source == non) {answer2.setText("");}
		   else if(source == choice1) {
			   if(e.getHp() <= 0 || model.getHp() <= 0) {
				   System.out.println("Combat terminé");
				   controller.expUp(60);
				   model.setNbPieces(model.getNbPieces() + 10);
				   try {
					RoomScreen();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				   e.setHp(80);
			   }
			   else {
				   try {
					controller.attaquer(model,e);
					 affiche(model.getUsername() + " attaque");
				} catch (InterruptedException e1) {
					System.out.println("Erreur");
					e1.printStackTrace();
				}
				   }
			   }
		   else if(source == choice2) {
			   if(model.getHp() <= 0) {
				   window.dispose();
			   }
			   else {
			   try {
				controller.soin(model,10);
				affiche(model.getUsername() + " se soigne");
			} catch (InterruptedException e) {
				System.out.println("Erreur");
				e.printStackTrace();
			}
			   }
		   }
		   else if(source == choice3) {
			   if(e.getHp() <= 0 || model.getHp() <= 0) {
				   System.out.println("Combat terminé");
				   controller.expUp(60);
				   model.setNbPieces(model.getNbPieces() + 10);
				   try {
					RoomScreen();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				   e.setHp(80);
			   }
			   try {
				controller.cast(model,e);
				 affiche(model.getUsername() + " lance un sort");
			} catch (InterruptedException e) {
				System.out.println("Erreur");
				e.printStackTrace();
			}
		   }
		   else if(source == nextButton) {
			   try {
				FightScreen();
			} catch (IOException e) {
				e.printStackTrace();
			}
		   }
		   else if(source == saveButton) {sauverPerso();}
		   else if(source == fullHealButton) {
			   model.setHp(model.getHpMax());
			   model.setMana(model.getMaxMana());
			   model.setNbPieces(model.getNbPieces() - 10);
		   }
		   else if(source == buyStaffButton) {model.acheterArme(shop,0);}
		   else if(source == buyCloakButton) {model.acheterArmure(shop,0);}
	}

	public void affiche(String string) {
		 fightInfo.setText(string);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		hpBar.setValue(model.getHp());
		hpMobBar.setValue(e.getHp());
		manaBar.setValue(model.getMana());
		nbPieceInfo.setText(""+model.getNbPieces());
	}

}
