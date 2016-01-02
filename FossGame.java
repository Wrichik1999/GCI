import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FossGame extends JFrame implements ActionListener{
	JPanel[][] qSets = new JPanel[4][5];
	JLabel[] question = new JLabel[12];
	JComboBox[] ans = new JComboBox[12];
	JButton check = new JButton("Check Answers!");
	JLabel correctL = new JLabel("");
	public FossGame(){
		this.setLayout(new GridLayout(2,2));
		for(int i = 0; i < 4; i++){
			qSets[i][0] = new JPanel();
			if(i != 3){
				qSets[i][0].setLayout(new GridLayout(4,1));
				for(int j = 1; j < 5; j++){
					qSets[i][j] = new JPanel();
					qSets[i][j].setLayout(new BorderLayout());
					qSets[i][0].add(qSets[i][j]);
;				}
			}else{
				qSets[i][0].setLayout(new BorderLayout());
				qSets[i][1] = new JPanel();
				qSets[i][1].setLayout(new BorderLayout());
			}
		}
		correctL.setHorizontalAlignment(JLabel.CENTER);
		qSets[3][0].add(qSets[3][1],BorderLayout.SOUTH);
		qSets[3][0].add(check,BorderLayout.CENTER);
		qSets[3][1].add(correctL,BorderLayout.CENTER);
		this.add(qSets[0][0]);
		this.add(qSets[2][0]);
		this.add(qSets[1][0]);
		this.add(qSets[3][0]);
		makeqSet1();
		makeqSet2();
		makeqSet3();
		check.addActionListener(this);
		this.setTitle("FOSS Quiz");
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void makeqSet1(){
		question[0] = new JLabel("1. Who made the Linux kernel?");
		ans[0] = new JComboBox(new String[]{"Linus Trovalds", "Bill Gates", "Larry Page", "Steve Jobs"});
		qSets[0][1].add(question[0],BorderLayout.NORTH);
		qSets[0][1].add(ans[0],BorderLayout.CENTER);
		question[1] = new JLabel("2. When was the Linux kernel made?");
		ans[1] = new JComboBox(new Integer[]{1983,1986,1991,2000});
		qSets[0][2].add(question[1],BorderLayout.NORTH);
		qSets[0][2].add(ans[1],BorderLayout.CENTER);
		question[2] = new JLabel("3. What does FOSS stand for?");
		ans[2] = new JComboBox(new String[]{"Free open-source services", "Faulty open-source software", "Free open-source software", "Failing open-source service"});
		qSets[0][3].add(question[2],BorderLayout.NORTH);
		qSets[0][3].add(ans[2],BorderLayout.CENTER);
		question[3] = new JLabel("4. How many known viruses have been made for Linux?");
		ans[3] = new JComboBox(new Integer[]{1000,100,10,0});
		qSets[0][4].add(question[3],BorderLayout.NORTH);
		qSets[0][4].add(ans[3],BorderLayout.CENTER);
	}
	public void makeqSet2(){
		question[4] = new JLabel("5. Where was Linux made?");
		ans[4] = new JComboBox(new String[]{"Finland", "United States of America", "Netherlands", "Poland"});
		qSets[1][1].add(question[4],BorderLayout.NORTH);
		qSets[1][1].add(ans[4],BorderLayout.CENTER);
		question[5] = new JLabel("6. What is Linux written in?");
		ans[5] = new JComboBox(new String[]{"Python", "C", "Java", "Visual Basics"});
		qSets[1][2].add(question[5],BorderLayout.NORTH);
		qSets[1][2].add(ans[5],BorderLayout.CENTER);
		question[6] = new JLabel("6. What is the AOSP(Adroid OS) kernel based on?");
		ans[6] = new JComboBox(new String[]{"Linux", "Windows NT", "OS X", "Unix"});
		qSets[1][3].add(question[6],BorderLayout.NORTH);
		qSets[1][3].add(ans[6],BorderLayout.CENTER);
		question[7] = new JLabel("6. What does AOSP stand for?");
		ans[7] = new JComboBox(new String[]{"Android Operating System Project", "Android Operating Service Project", "Android Open Software Project", "Android Open Source Project"});
		qSets[1][4].add(question[7],BorderLayout.NORTH);
		qSets[1][4].add(ans[7],BorderLayout.CENTER);
	}
	public void makeqSet3(){
		question[8] = new JLabel("9. Which one of these is open source?");
		ans[8] = new JComboBox(new String[]{"LibreOffice", "Microsoft Office", "Google Docs", "iWork"});
		qSets[2][1].add(question[8],BorderLayout.NORTH);
		qSets[2][1].add(ans[8],BorderLayout.CENTER);
		question[9] = new JLabel("10. Which one of these is open source?");
		ans[9] = new JComboBox(new String[]{"Cubase", "Sibelius", "Finale", "MuseScore"});
		qSets[2][2].add(question[9],BorderLayout.NORTH);
		qSets[2][2].add(ans[9],BorderLayout.CENTER);
		question[10] = new JLabel("11. Which one of these is open source?");
		ans[10] = new JComboBox(new String[]{"Cyberlink Photo Director", "Serif Photoplus", "GIMP", "Adobe Photoshop"});
		qSets[2][3].add(question[10],BorderLayout.NORTH);
		qSets[2][3].add(ans[10],BorderLayout.CENTER);
		question[11] = new JLabel("12. What does GIMP stand for?");
		ans[11] = new JComboBox(new String[]{"Good Image Manipulator Program", "GNU Image Manipulation Program", "Garbage Image Manipulation Partner", "GNU Image Manipulator Program"});
		qSets[2][4].add(question[11],BorderLayout.NORTH);
		qSets[2][4].add(ans[11],BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent arg0){
		int correct = 0;
		if(ans[0].getSelectedIndex()==0){
			qSets[0][1].setBackground(Color.GREEN);
			correct++;
		}else{
			qSets[0][1].setBackground(Color.RED);
		}
		if(ans[1].getSelectedIndex()==2){
			qSets[0][2].setBackground(Color.GREEN);
			correct++;
		}else{
			qSets[0][2].setBackground(Color.RED);
		}
		if(ans[2].getSelectedIndex()==2){
			qSets[0][3].setBackground(Color.GREEN);
			correct++;
		}else{
			qSets[0][3].setBackground(Color.RED);
		}
		if(ans[3].getSelectedIndex()==3){
			qSets[0][4].setBackground(Color.GREEN);
			correct++;
		}else{
			qSets[0][4].setBackground(Color.RED);
		}
		if(ans[4].getSelectedIndex()==0){
			qSets[1][1].setBackground(Color.GREEN);
			correct++;
		}else{
			qSets[1][1].setBackground(Color.RED);
		}
		if(ans[5].getSelectedIndex()==1){
			qSets[1][2].setBackground(Color.GREEN);
			correct++;
		}else{
			qSets[1][2].setBackground(Color.RED);
		}
		if(ans[6].getSelectedIndex()==0){
			qSets[1][3].setBackground(Color.GREEN);
			correct++;
		}else{
			qSets[1][3].setBackground(Color.RED);
		}
		if(ans[7].getSelectedIndex()==3){
			qSets[1][4].setBackground(Color.GREEN);
			correct++;
		}else{
			qSets[1][4].setBackground(Color.RED);
		}
		if(ans[8].getSelectedIndex()==0){
			qSets[2][1].setBackground(Color.GREEN);
			correct++;
		}else{
			qSets[2][1].setBackground(Color.RED);
		}
		if(ans[9].getSelectedIndex()==3){
			qSets[2][2].setBackground(Color.GREEN);
			correct++;
		}else{
			qSets[2][2].setBackground(Color.RED);
		}
		if(ans[10].getSelectedIndex()==2){
			qSets[2][3].setBackground(Color.GREEN);
			correct++;
		}else{
			qSets[2][3].setBackground(Color.RED);
		}
		if(ans[11].getSelectedIndex()==1){
			qSets[2][4].setBackground(Color.GREEN);
			correct++;
		}else{
			qSets[2][4].setBackground(Color.RED);
		}
		correctL.setText(correct+"/12");
		check.setEnabled(false);
		for(int i = 0; i < 12; i++){
			ans[i].setEnabled(false);
		}
	}
	public static void main(String[] args){
		new FossGame();
	}
}
