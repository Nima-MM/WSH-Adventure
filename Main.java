package out.production;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
	
	JFrame window;
	Container con;
	
	JPanel titleNamePanel;
	JPanel mainTextPanel;
	JPanel startButtonPanel;
	JPanel choiceButtonPanel;
	JPanel informationPanel;	
	
	JLabel titleNameLabel;
	JLabel locationNameLabel;
	JLabel itemNameLabel;
	JLabel locationLabel;
	JLabel itemLabel;
	
	Font titleFont = new Font("Times new Roman", Font.PLAIN, 68);
	Font normalFont = new Font("Times new Roman", Font.PLAIN, 30);
	
	JButton startButton;
	JButton choiceButton1, choiceButton2, choiceButton3, choiceButton4;
	
	JTextArea mainTextArea;
	
	int menuLocation;
	String playerLocation = "A";
	String playerName = "Nima";
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("WHS-ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);
		
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		con.add(titleNamePanel);
		con.add(startButtonPanel);
	}
	
	public void createGameScreen() {
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		
		mainTextArea = new JTextArea(playerName +" what are you going to do next?");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		
		choiceButton1 = new JButton("choice 1");
		choiceButton1.setBackground(Color.black);
		choiceButton1.setForeground(Color.white);
		choiceButton1.setFont(normalFont);
		choiceButton1.setFocusPainted(false);
		choiceButton1.addActionListener(choiceHandler);
		choiceButton1.setActionCommand("c1");
		choiceButtonPanel.add(choiceButton1);
		
		choiceButton2 = new JButton("choice 2");
		choiceButton2.setBackground(Color.black);
		choiceButton2.setForeground(Color.white);
		choiceButton2.setFont(normalFont);
		choiceButton2.setFocusPainted(false);
		choiceButton2.addActionListener(choiceHandler);
		choiceButton2.setActionCommand("c2");
		choiceButtonPanel.add(choiceButton2);
		
		choiceButton3 = new JButton("choice 3");
		choiceButton3.setBackground(Color.black);
		choiceButton3.setForeground(Color.white);
		choiceButton3.setFont(normalFont);
		choiceButton3.setFocusPainted(false);
		choiceButton3.addActionListener(choiceHandler);
		choiceButton3.setActionCommand("c3");
		choiceButtonPanel.add(choiceButton3);
		
		choiceButton4 = new JButton("choice 4");
		choiceButton4.setBackground(Color.black);
		choiceButton4.setForeground(Color.white);
		choiceButton4.setFont(normalFont);
		choiceButton4.setFocusPainted(false);
		choiceButton4.addActionListener(choiceHandler);
		choiceButton4.setActionCommand("c4");
		choiceButtonPanel.add(choiceButton4);
		
		informationPanel = new JPanel();
		informationPanel.setBounds(100, 15, 600, 50);
		informationPanel.setBackground(Color.blue);
		informationPanel.setLayout(new GridLayout(1,4));
		
		locationNameLabel = new JLabel("Ort:");
		locationNameLabel.setBounds(100, 15, 150, 50);
		locationNameLabel.setBackground(Color.red);
		locationNameLabel.setForeground(Color.white);
		locationNameLabel.setFont(normalFont);
		
		locationLabel = new JLabel("A");
		locationLabel.setBounds(200, 15, 150, 50);
		locationLabel.setBackground(Color.black);
		locationLabel.setForeground(Color.white);
		locationLabel.setFont(normalFont);
		
		itemNameLabel = new JLabel("Item:");
		itemNameLabel.setBounds(300, 15, 150, 50);
		itemNameLabel.setBackground(Color.red);
		itemNameLabel.setForeground(Color.white);
		itemNameLabel.setFont(normalFont);
		
		itemLabel = new JLabel("Huhn");
		itemLabel.setBounds(400, 15, 150, 50);
		itemLabel.setBackground(Color.black);
		itemLabel.setForeground(Color.white);
		itemLabel.setFont(normalFont);
		
		informationPanel.add(locationNameLabel);
		informationPanel.add(locationLabel);
		informationPanel.add(itemNameLabel);
		informationPanel.add(itemLabel);
		mainTextPanel.add(mainTextArea);
		
		con.add(choiceButtonPanel);
		con.add(mainTextPanel);
		con.add(informationPanel);
		
	}
	
	public void MainMenu() {
		menuLocation = 1;
		createGameScreen();
	}
	
	public void Aufheben() {
		menuLocation = 3;
	}
	
	public class TitleScreenHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			createGameScreen();
		}
	}
	
	public class ChoiceHandler implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			String playerChoice = event.getActionCommand();

			switch(menuLocation) {
			
			case 1: // MainMenu
				
				switch(playerChoice) {
				case "c1": break;
				case "c2": break;
				case "c3": break;
				case "c4": break;
				}
				
			case 2: // Ziel
				
				switch(playerChoice) {
				case "c1": break;
				case "c2": break;
				case "c3": break;
				}
				
			case 3: // Aufheben
				
				switch(playerChoice) {
				case "c1": break;
				case "c2": break;
				case "c3": break;
				case "c4": break;
				}
				
			case 4: // Ablegen
				
				switch(playerChoice) {
				case "c1": break;
				case "c2": break;
				case "c3": break;
				case "c4": break;
				}
				
			case 5: // Reisen
				
				switch(playerChoice) {
				case "c1": break;
				case "c2": break;
				}
				
			}
		}
	}
	
}
