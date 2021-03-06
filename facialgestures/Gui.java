package facialgestures;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.*;

import Core.Publisher;

public class Gui extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static Model model;
	private final int PORT = 1594;
	private JRadioButton radioButton;
	protected JLabel labelPublishPort;
	private final JButton buttonConnect = new JButton("run");
	static String engageIcon = "Engagement";
    static String shortTermIcon = "Short Term Excitement";
    static String longTermIcon = "Long Term Excitement";
    static String meditateIcon = "Meditation";
    static String frustrateIcon = "Frustration";
    
    static String blinkTrue = "Blink_1";
    static String leftWinkTrue = "LWink_1";
    static String rightWinkTrue = "RWink_1" ;
    static String lookLeftTrue = "LookL_1";
    static String lookRightTrue = "LookR_1";
    
    static String leftSmirk = "Left Smirk";
    static String rightSmirk = "Right Smirk";
    static String raiseBrow = "Raise Brow";
    static String furrowBrow = "Furrow Brow";
    static String smile = "Smile";
    static String laugh = "Laugh";
    static String clench = "Clench";
    JLabel gifIcon;
    HashMap<String, Integer> listOfExpressions = new HashMap<>();
    ArrayList<Double> arrayList = new ArrayList<Double>();
    JSlider slider;
    

	private Component createPanelSouth() {

		JPanel labels = new JPanel();
		labels.setBackground(Color.GRAY);
		labels.add(new JLabel("  Publishing at port: "));
		labelPublishPort = new JLabel("" + PORT);
		labels.add(labelPublishPort);
		JPanel panel = new JPanel(new BorderLayout());
		panel.setBackground(Color.CYAN);
		panel.add(labels, BorderLayout.WEST);
		panel.add(buttonConnect, BorderLayout.EAST);
		buttonConnect.addActionListener(this);
		buttonConnect.setEnabled(true);
		return panel;
	}

	public Gui() {
		expressionToIndexMapping();
		for(int i=0;i<17;i++)
			arrayList.add(0.0);
    model = new Model(new FacialDataGenerator(), new Publisher(PORT));
    this.setBackground(Color.WHITE);
    this.setLayout(new BorderLayout());
    this.add(createPanelSouth(), BorderLayout.SOUTH);
    Dimension screen = getToolkit().getScreenSize();
    this.setSize(screen.width / 2, 3 * screen.height / 4);
    this.setLocation((screen.width - getSize().width) / 2, (screen.height - getSize().height) / 2);
   
    JPanel panel = new JPanel();
    panel.setBounds(0, 28, 331, 497);
    panel.setLayout(null);
    
    JLabel lblNewLabel = new JLabel("Blink");
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(10, 31, 89, 25);
    panel.add(lblNewLabel);
    
    JLabel lblLeftWink = new JLabel("Left Wink");
    lblLeftWink.setHorizontalAlignment(SwingConstants.CENTER);
    lblLeftWink.setBounds(10, 67, 89, 25);
    panel.add(lblLeftWink);
    
    JLabel lblRightWink = new JLabel("Right Wink");
    lblRightWink.setHorizontalAlignment(SwingConstants.CENTER);
    lblRightWink.setBounds(10, 103, 89, 25);
    panel.add(lblRightWink);
    
    JLabel lblLookLeft = new JLabel("Look Left");
    lblLookLeft.setHorizontalAlignment(SwingConstants.CENTER);
    lblLookLeft.setBounds(10, 139, 89, 25);
    panel.add(lblLookLeft);
    
    JLabel lblLookRight = new JLabel("Look Right");
    lblLookRight.setHorizontalAlignment(SwingConstants.CENTER);
    lblLookRight.setBounds(10, 175, 89, 25);
    panel.add(lblLookRight);
    
    radioButton = new JRadioButton("Blink_0");
    radioButton.setBounds(158, 33, 21, 23);
    panel.add(radioButton);
    
	JRadioButton radioButton_1 = new JRadioButton(blinkTrue);
    radioButton_1.setBounds(216, 32, 21, 23);
    panel.add(radioButton_1);
    
    JRadioButton radioButton_2 = new JRadioButton("LWink_0");
    radioButton_2.setBounds(158, 68, 21, 23);
    panel.add(radioButton_2);
    
    JRadioButton radioButton_3 = new JRadioButton(leftWinkTrue);
    radioButton_3.setBounds(216, 68, 21, 23);
    panel.add(radioButton_3);
    
    JRadioButton radioButton_4 = new JRadioButton("RWink_0");
    radioButton_4.setBounds(158, 104, 21, 23);
    panel.add(radioButton_4);
    
    JRadioButton radioButton_5 = new JRadioButton(rightWinkTrue);
    radioButton_5.setBounds(216, 104, 21, 23);
    panel.add(radioButton_5);
    
    JRadioButton radioButton_6 = new JRadioButton("LookL_0");
    radioButton_6.setBounds(158, 140, 21, 23);
    panel.add(radioButton_6);
    
    JRadioButton radioButton_7 = new JRadioButton(lookLeftTrue);
    radioButton_7.setBounds(216, 140, 21, 23);
    panel.add(radioButton_7);
    
    JRadioButton radioButton_8 = new JRadioButton("LookR_0");
    radioButton_8.setBounds(158, 176, 21, 23);
    panel.add(radioButton_8);
    
    JRadioButton radioButton_9 = new JRadioButton(lookRightTrue);
    radioButton_9.setBounds(216, 176, 21, 23);
    panel.add(radioButton_9);
    
    ButtonGroup group1 = new ButtonGroup();
    group1.add(radioButton);
    group1.add(radioButton_1);
    
    ButtonGroup group2 = new ButtonGroup();
    group2.add(radioButton_2);
    group2.add(radioButton_3);
    
    ButtonGroup group3 = new ButtonGroup();
    group3.add(radioButton_4);
    group3.add(radioButton_5);
    
    ButtonGroup group4 = new ButtonGroup();
    group4.add(radioButton_6);
    group4.add(radioButton_7);
    
    ButtonGroup group5 = new ButtonGroup();
    group5.add(radioButton_8);
    group5.add(radioButton_9);
    
    radioButton.addActionListener(this);
    radioButton_1.addActionListener(this);
    radioButton_2.addActionListener(this);
    radioButton_3.addActionListener(this);
    radioButton_4.addActionListener(this);
    radioButton_5.addActionListener(this);
    radioButton_6.addActionListener(this);
    radioButton_7.addActionListener(this);
    radioButton_8.addActionListener(this);
    radioButton_9.addActionListener(this);    
    
    JLabel lblNewLabel_1 = new JLabel("0");
    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel_1.setBounds(147, 12, 46, 14);
    panel.add(lblNewLabel_1);
    
    JLabel label = new JLabel("1");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setBounds(202, 12, 46, 14);
    panel.add(label);
    
    JPanel panel_1 = new JPanel();
    panel_1.setBounds(334, 28, 339, 497);
    panel_1.setLayout(null);
    
    JLabel lblLeftSmirk = new JLabel("Left Smirk");
    lblLeftSmirk.setHorizontalAlignment(SwingConstants.CENTER);
    lblLeftSmirk.setBounds(26, 25, 89, 25);
    panel_1.add(lblLeftSmirk);
    
    JLabel lblRightSmirk = new JLabel("Right Smirk");
    lblRightSmirk.setHorizontalAlignment(SwingConstants.CENTER);
    lblRightSmirk.setBounds(26, 61, 89, 25);
    panel_1.add(lblRightSmirk);
    
    JLabel lblRaiseBurrow = new JLabel("Raise Brow");
    lblRaiseBurrow.setHorizontalAlignment(SwingConstants.CENTER);
    lblRaiseBurrow.setBounds(26, 97, 89, 25);
    panel_1.add(lblRaiseBurrow);
    
    JLabel lblFurrowBrow = new JLabel("Furrow Brow");
    lblFurrowBrow.setHorizontalAlignment(SwingConstants.CENTER);
    lblFurrowBrow.setBounds(26, 137, 89, 25);
    panel_1.add(lblFurrowBrow);
    
    JLabel lblSmile = new JLabel("Smile");
    lblSmile.setHorizontalAlignment(SwingConstants.CENTER);
    lblSmile.setBounds(26, 173, 89, 25);
    panel_1.add(lblSmile);
    
    JLabel lblLaugh = new JLabel("Laugh");
    lblLaugh.setHorizontalAlignment(SwingConstants.CENTER);
    lblLaugh.setBounds(26, 209, 89, 25);
    panel_1.add(lblLaugh);
    
    JLabel lblClench = new JLabel("Clench");
    lblClench.setHorizontalAlignment(SwingConstants.CENTER);
    lblClench.setBounds(26, 243, 89, 25);
    panel_1.add(lblClench);
    
    JLabel num = new JLabel("1");
    num.setHorizontalAlignment(SwingConstants.CENTER);
    num.setBounds(215, 25, 30, 25);
    panel_1.add(num);
    
    slider = new JSlider();
    slider.setBounds(107, 15, 100, 50);
    slider.setMaximum(10);
    slider.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
        	double value = ((JSlider)e.getSource()).getValue() * 0.1;
            System.out.println(value);
        	num.setText(String.valueOf(value));	
        	arrayList.set(5, value);
        }
    });
    panel_1.add(slider);
    
    JLabel num1 = new JLabel("1");
    num1.setHorizontalAlignment(SwingConstants.CENTER);
    num1.setBounds(215, 65, 30, 25);
    panel_1.add(num1); 
    
    JSlider slider_1 = new JSlider();
    slider_1.setMaximum(10);
    slider_1.setBounds(107, 55, 100, 50);
    slider_1.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
        	double value = ((JSlider)e.getSource()).getValue() * 0.1;
            System.out.println(value);
        	num1.setText(String.valueOf(value));	
        	arrayList.set(6, value);
        }
    });
    panel_1.add(slider_1);
    
    JLabel num2 = new JLabel("1");
    num2.setHorizontalAlignment(SwingConstants.CENTER);
    num2.setBounds(215, 100, 30, 25);
    panel_1.add(num2);
    
    JSlider slider_2 = new JSlider();
    slider_2.setMaximum(10);
    slider_2.setBounds(107, 90, 100, 50);
    slider_2.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
        	double value = ((JSlider)e.getSource()).getValue() * 0.1;
            System.out.println(value);
        	num2.setText(String.valueOf(value));	
        	arrayList.set(7, value);
        }
    });
    panel_1.add(slider_2);    
   
    JLabel num3 = new JLabel("1");
    num3.setHorizontalAlignment(SwingConstants.CENTER);
    num3.setBounds(215, 135, 30, 25);
    panel_1.add(num3);
    
    JSlider slider_3 = new JSlider();
    slider_3.setMaximum(10);
    slider_3.setBounds(107, 125, 100, 50);
    slider_3.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
        	double value = ((JSlider)e.getSource()).getValue() * 0.1;
            System.out.println(value);
        	num3.setText(String.valueOf(value));
        	arrayList.set(8, value);
        }
    });
    panel_1.add(slider_3);
    
    JLabel num4 = new JLabel("1");
    num4.setHorizontalAlignment(SwingConstants.CENTER);
    num4.setBounds(215, 170, 30, 25);
    panel_1.add(num4);
    
    JSlider slider_4 = new JSlider();
    slider_4.setMaximum(10);
    slider_4.setBounds(107, 160, 100, 50);
    slider_4.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
        	double value = ((JSlider)e.getSource()).getValue() * 0.1;
            System.out.println(value);
        	num4.setText(String.valueOf(value));
        	arrayList.set(9, value);
        }
    });
    panel_1.add(slider_4);
   
    JLabel num5 = new JLabel("1");
    num5.setHorizontalAlignment(SwingConstants.CENTER);
    num5.setBounds(215, 200, 30, 25);
    panel_1.add(num5);
    
    JSlider slider_5 = new JSlider();
    slider_5.setMaximum(10);
    slider_5.setBounds(107, 195, 100, 50);
    slider_5.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
        	double value = ((JSlider)e.getSource()).getValue() * 0.1;
            System.out.println(value);
        	num5.setText(String.valueOf(value));	
        	arrayList.set(10, value);
        }
    });
    panel_1.add(slider_5);
    
    JLabel num6 = new JLabel("1");
    num6.setHorizontalAlignment(SwingConstants.CENTER);
    num6.setBounds(215, 240, 30, 25);
    panel_1.add(num6);  
    
    JSlider slider_6 = new JSlider();
    slider_6.setMaximum(10);
    slider_6.setBounds(107, 230, 100, 50);
    slider_6.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
        	double value = ((JSlider)e.getSource()).getValue() * 0.1;
            System.out.println(value);
        	num6.setText(String.valueOf(value));
        	arrayList.set(11, value);
        }
    });
    panel_1.add(slider_6);
    
    JPanel panel_2 = new JPanel();
    panel_2.setBounds(334, 28, 339, 497);
    panel_2.setLayout(null);
    setBorder(BorderFactory.createEmptyBorder(15,15,15,15));  
    
    JLabel engage = new JLabel("Engagement");
    engage.setHorizontalAlignment(SwingConstants.CENTER);
    engage.setBounds(26, 25, 130, 25);
    panel_2.add(engage);
    
    JLabel sExcite = new JLabel("Short Term Excitement");
    sExcite.setHorizontalAlignment(SwingConstants.CENTER);
    sExcite.setBounds(26, 50, 130, 25);
    panel_2.add(sExcite);
    
    JLabel lExcite = new JLabel("Long Term Excitement");
    lExcite.setHorizontalAlignment(SwingConstants.CENTER);
    lExcite.setBounds(26, 75, 130, 25);
    panel_2.add(lExcite);
    
    JLabel med = new JLabel("Meditation");
    med.setHorizontalAlignment(SwingConstants.CENTER);
    med.setBounds(26, 100, 130, 25);
    panel_2.add(med);
    
    JLabel fru = new JLabel("Frustration");
    fru.setHorizontalAlignment(SwingConstants.CENTER);
    fru.setBounds(26, 125, 130, 25);
    panel_2.add(fru);
    
    JRadioButton radioButton_10 = new JRadioButton(engageIcon);
    radioButton_10.setBounds(170, 25, 21, 23);
    radioButton_10.setActionCommand(engageIcon);
    panel_2.add(radioButton_10);
    
    JRadioButton radioButton_11 = new JRadioButton(shortTermIcon);
    radioButton_11.setBounds(170, 50, 21, 23);
    radioButton_11.setActionCommand(shortTermIcon);
    panel_2.add(radioButton_11);
    
    JRadioButton radioButton_12 = new JRadioButton(longTermIcon);
    radioButton_12.setBounds(170, 75, 21, 23);
    radioButton_12.setActionCommand(longTermIcon);
    panel_2.add(radioButton_12);
    
    JRadioButton radioButton_13 = new JRadioButton(meditateIcon);
    radioButton_13.setBounds(170, 100, 21, 23);
    radioButton_13.setActionCommand(meditateIcon);
    panel_2.add(radioButton_13);
    
    JRadioButton radioButton_14 = new JRadioButton(frustrateIcon);
    radioButton_14.setBounds(170, 125, 21, 23);
    radioButton_14.setActionCommand(frustrateIcon);
    panel_2.add(radioButton_14);
    
    ButtonGroup group = new ButtonGroup();
    group.add(radioButton_10);
    group.add(radioButton_11);
    group.add(radioButton_12);
    group.add(radioButton_13);
    group.add(radioButton_14);
    
    radioButton_10.addActionListener(this);
	radioButton_11.addActionListener(this);
	radioButton_12.addActionListener(this);
	radioButton_13.addActionListener(this);
	radioButton_14.addActionListener(this);  

	gifIcon = new JLabel(createImageIcon("" + ".gif"));
	gifIcon.setBounds(197, 55, 280, 200);
	panel_2.add(gifIcon, BorderLayout.CENTER);
   
    JTabbedPane tp=new JTabbedPane();  
    tp.setBounds(50,50,200,200);  
    tp.add("Expressive_binary",panel);  
    tp.add("Expressive_continuous",panel_1);  
    tp.add("Affective",panel_2);  
    add(tp);
    System.out.println("gui done");
  }

	private void expressionToIndexMapping() {
		listOfExpressions.put(blinkTrue, 0);
		listOfExpressions.put(leftWinkTrue, 1);
		listOfExpressions.put(rightWinkTrue, 2);
		listOfExpressions.put(lookLeftTrue, 3);
		listOfExpressions.put(lookRightTrue, 4);
		listOfExpressions.put(leftSmirk, 5);
		listOfExpressions.put(rightSmirk, 6);
		listOfExpressions.put(raiseBrow, 7);
		listOfExpressions.put(furrowBrow, 8);
		listOfExpressions.put(smile, 9);
		listOfExpressions.put(laugh, 10);
		listOfExpressions.put(clench, 11);
		listOfExpressions.put(engageIcon, 12);
		listOfExpressions.put(shortTermIcon, 13);
		listOfExpressions.put(longTermIcon, 14);
		listOfExpressions.put(meditateIcon, 15);
		listOfExpressions.put(frustrateIcon, 16);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 gifIcon.setIcon(createImageIcon(e.getActionCommand()
	              + ".gif"));
            System.out.println("Button Clicked!");
		System.out.println("listener trigger");
		
		
		for (int i = 0; i < 17; i++) {
			arrayList.add(0.0);
		}
		
		setExpressiveBinary(e, arrayList);
		
		
		
		setAffective(e, arrayList);
		model.setFacialValues(arrayList);
		




		if (e.getSource() == buttonConnect) {
			if (buttonConnect.getText().compareTo("run") == 0) {
				System.out.println("start");
				model.setFacialValues(arrayList);
				model.start();
				
				buttonConnect.setText("stop");
			} else if (buttonConnect.getText().compareTo("stop") == 0) {
				System.out.println("stop");
				model.stop();
				buttonConnect.setText("run");
			}
		}
	
		
	}

	private void setAffective(ActionEvent e, ArrayList<Double> arrayList) {
		if(e.getActionCommand().equals(engageIcon))
		{
		arrayList.set(listOfExpressions.get(engageIcon), (double) 1);			
		}
		else if(e.getActionCommand().equals(shortTermIcon))
		{
		arrayList.set(listOfExpressions.get(shortTermIcon), (double) 1);			
		}
		else if(e.getActionCommand().equals(longTermIcon))
		{
		arrayList.set(listOfExpressions.get(longTermIcon), (double) 1);			
		}
		else if(e.getActionCommand().equals(meditateIcon))
		{
		arrayList.set(listOfExpressions.get(meditateIcon), (double) 1);			
		}
		else if(e.getActionCommand().equals(frustrateIcon))
		{
		arrayList.set(listOfExpressions.get(frustrateIcon), (double) 1);			
		}
	}

	private void setExpressiveBinary(ActionEvent e, ArrayList<Double> arrayList) {
		if(e.getActionCommand().equals(blinkTrue))
			{
			arrayList.set(listOfExpressions.get(blinkTrue), (double) 1);			
			}
		if(e.getActionCommand().equals(leftWinkTrue))
		{arrayList.set(listOfExpressions.get(leftWinkTrue), (double) 1);
		}
		if(e.getActionCommand().equals(rightWinkTrue))
		{arrayList.set(listOfExpressions.get(rightWinkTrue), (double) 1);
		}
		if(e.getActionCommand().equals(lookLeftTrue))
		{arrayList.set(listOfExpressions.get(lookLeftTrue), (double) 1);
		}
		if(e.getActionCommand().equals(lookRightTrue))
		{arrayList.set(listOfExpressions.get(lookRightTrue), (double) 1);
		}
	}

	protected static ImageIcon createImageIcon(String path) {
	      java.net.URL gifURL = Gui.class.getResource(path);
	      if (gifURL != null) {
	          return new ImageIcon(gifURL);
	      } else {
	          System.err.println("");
	          return null;
	      }
	  }
	public static void main(String[] args) {

		JFrame frame = new JFrame("Simulator");
		frame.setLayout(new GridLayout(1, 1));
		frame.add(new Gui());
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				model.shutdown();
				System.exit(0);
			}
		});
		frame.pack();
		frame.setSize(500, 400);
		frame.setVisible(true);
	}
}
