import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class Project {

	private JFrame frame;
	private JTextField pencilTF;
	private JTextField penTF;
	private JTextField markerTF;
	private JTextField eraserTF;
	private JTextField calcTF;
	private JTextArea textArea;
	private JTextArea textArea_1;
	FileWriter fileWriter;
	
	int QtyPencil;
	int QtyPen;
	int QtyMarker;
	int QtyEraser;
	int QtyCalc;
	
	double ipencil = .50;
	double pen = .75;
	double marker = 1.00;
	double eraser = 3.00;
	double calculator = 10.00;
	private JTextField totalTF;
	
	double [] supplies = new double[5];
	
	//---------------------------launch application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project window = new Project();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//-----------------------------create project application
	public Project() {
		initialize();
	}

	//------------------------------initialize the JFrame
	private void initialize() {
		
		//panel_2.setLayout(null);
		frame = new JFrame();
		frame.setTitle("Gui Project");
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		//-----------------------------JPanel that contains the labels
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(6, 7, 342, 566);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSuper = new JLabel("SUPPLY STORE");
		lblSuper.setBounds(6, 10, 114, 17);
		panel_1.add(lblSuper);
		Font font = new Font("Lucida Grande 13",Font.BOLD, 15);
		lblSuper.setFont(font);
		
		JLabel jlbPencil = new JLabel("Pencil(s) ($.50)");
		jlbPencil.setBounds(6, 47, 114, 16);
		panel_1.add(jlbPencil);
		
		JLabel jlbPen = new JLabel("Pen(s) ($.75)");
		jlbPen.setBounds(6, 90, 114, 16);
		panel_1.add(jlbPen);
		
		JLabel jlbMarker = new JLabel("Marker(s) ($1.00)");
		jlbMarker.setBounds(6, 133, 114, 16);
		panel_1.add(jlbMarker);
		
		JLabel jlbEraser = new JLabel("Eraser(s) ($3.00)");
		jlbEraser.setBounds(6, 174, 114, 16);
		panel_1.add(jlbEraser);
		
		JLabel jlbCalc = new JLabel("Calculator(s) ($10.00)");
		jlbCalc.setBounds(6, 219, 140, 16);
		panel_1.add(jlbCalc);
		
		//-----------------------------textField for pencil
		pencilTF  = new JTextField();
		pencilTF.setBounds(190, 42, 130, 26);
		panel_1.add(pencilTF);
		pencilTF.setColumns(10);
		
		//------------------------------textField for pen
		penTF = new JTextField();
		penTF.setColumns(10);
		penTF.setBounds(190, 85, 130, 26);
		panel_1.add(penTF);
		
		//-------------------------------textField for marker
		markerTF = new JTextField();
		markerTF.setColumns(10);
		markerTF.setBounds(190, 128, 130, 26);
		panel_1.add(markerTF);
		
		//--------------------------------textField for eraser
		eraserTF = new JTextField();
		eraserTF.setColumns(10);
		eraserTF.setBounds(190, 169, 130, 26);
		panel_1.add(eraserTF);
		
		//---------------------------------textField for calculator
		calcTF = new JTextField();
		calcTF.setColumns(10);
		calcTF.setBounds(190, 214, 130, 26);
		panel_1.add(calcTF);
		
		//-----------------------------------line separator
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 247, 314, 9);
		panel_1.add(separator);
		
		//------------------------------------textField for total
		totalTF = new JTextField();
		totalTF.setEditable(false);
		totalTF.setColumns(10);
		totalTF.setBounds(190, 268, 130, 26);
		panel_1.add(totalTF);
		
		//-----------------------------total JButton w/ActionListener
		JButton jbTotal = new JButton("Total");
		jbTotal.setForeground(new Color(0, 100, 0));
		jbTotal.setBounds(6, 268, 117, 29);
		panel_1.add(jbTotal);
		jbTotal.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				if (pencilTF.getText().isEmpty() || penTF.getText().isEmpty() || markerTF.getText().isEmpty() 
					|| eraserTF.getText().isEmpty() || calcTF.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "TextField(s) left empty! Please cancel your order.");
				}
				
				
				//---------------------------calculations for product quantity    
				int QtyPencil = Integer.parseInt(pencilTF.getText());
				String pencil_qty = String.format("%.2f", ipencil); // pencil
				pencilTF.setText(pencil_qty);
				
				double purchase1 = QtyPencil * ipencil;
				String stot1 = String.format("$%.2f", purchase1);
				pencilTF.setText(stot1);
				
				QtyPen = Integer.parseInt(penTF.getText()); //pen
				String pen_qty = String.format("%.2f", pen);
				penTF.setText(pen_qty);
				
				double purchase2 = QtyPen * pen;
				String stot2 = String.format("$%.2f", purchase2);
				penTF.setText(stot2);
				
				QtyMarker = Integer.parseInt(markerTF.getText()); // marker
				String marker_qty = String.format("%.2f", marker);
				markerTF.setText(marker_qty);
				
				double purchase3 = QtyMarker * marker;
				String stot3 = String.format("$%.2f", purchase3);
             	markerTF.setText(stot3);
				
				QtyEraser = Integer.parseInt(eraserTF.getText()); // eraser
				String eraser_qty = String.format("%.2f", eraser);
				eraserTF.setText(eraser_qty);
				
				double purchase4 = QtyEraser * eraser;
				String stot4 = String.format("$%.2f", purchase4);
				eraserTF.setText(stot4);
				
				QtyCalc = Integer.parseInt(calcTF.getText()); // calculator
				String calc_qty = String.format("%.2f", calculator);
				calcTF.setText(calc_qty);
				
				double purchase5 = QtyCalc * calculator;
				String stot5 = String.format("$%.2f", purchase5);
				calcTF.setText(stot5);
				
				double total = purchase1 + purchase2 + purchase3 + purchase4 + purchase5;
				String totalAll = String.format("$%.2f", total);
				totalTF.setText(totalAll);
				
				
				
				
			}
		});
		
		//---------------------------------cancel JButton w/ActionListener 
		JButton jbCancel = new JButton("Cancel");
		jbCancel.setForeground(Color.RED);
		jbCancel.setBackground(new Color(255, 255, 255));
		jbCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pencilTF.setText(null);    // pencil
				penTF.setText(null);       // pen
				markerTF.setText(null);    // marker
				eraserTF.setText(null);    // eraser
				calcTF.setText(null);      // calculator
				totalTF.setText(null);
				textArea.setText("");		
				
			}
		});
		jbCancel.setBounds(6, 309, 117, 29);
		panel_1.add(jbCancel);
		
		
		//-----------------------------------confirm JButton w/ActionListener
		JButton Confirm = new JButton("Confirm");
		Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// random number generator for purchase order 
				int ord = 1576 + (int)(Math.random() * 8743);
				
				Calendar timer = Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
				tTime.format(timer.getTime());
				SimpleDateFormat Tdate = new SimpleDateFormat("MM-dd-yyyy");
				Tdate.format(timer.getTime());
			

				
				textArea.append("\t    SUPPLY STORE\n"+
								"\t 269 Madison Ave\n"+
								"\tNew York, NY 10016\n"+
								"\t    212-555-0055\n"+
								"================================"+
								"\n Order#:\t\t"+ord+
								"\n Date: \t\t" + Tdate.format(timer.getTime())+
								"\n Time: \t\t" + tTime.format(timer.getTime())+
								"\n==============================="+
								"\nPencil:\t\t"+ pencilTF.getText()+
						        "\n\n Pen: \t\t" + penTF.getText()+
								"\n\n Marker: \t\t" +markerTF.getText()+
								"\n\n Eraser: \t\t" +eraserTF.getText()+
								"\n\n Calculator: \t\t" +calcTF.getText()+
								"\n____________________________________________"+
								"\n Total: \t\t"+totalTF.getText()+
								"\n==============================="+
								"\n Thank You for shopping at SUPPLY STORE."+
								"\n\n\n\n**************************************************"+
								"\n Tell us what you think; get a coupon for"+ 
								"\n 20% off of your next purchase"+
								"\n Go to www.supplystorefeedback.com."+
								"\n Valid for 30 days. CODE:_______"+	
								"\n\n\n\n\n\n\n\n\n==============================");
				
				textArea_1.append("\t SUPPLY STORE\n"+
								  "\n Order#:\t\t"+ord+
								  "\n Date: \t\t" + Tdate.format(timer.getTime())+
								  "\n Time: \t\t" + tTime.format(timer.getTime())+
								  "\n=============================================");
				if (e.getActionCommand()==Confirm.getActionCommand()) 
				{
					try 
					{
						fileWriter = new FileWriter("purchases.txt", true);
						fileWriter.write("\n==============================="+
										 "\nOrder#:\t\t"+ord+
										 "\nDate: \t\t" + Tdate.format(timer.getTime())+
								         "\nTime: \t\t" + tTime.format(timer.getTime())+
										 "\nPencils: \t" +pencilTF.getText()+
								         "\nPens:    \t" +penTF.getText()+
								         "\nMarker:  \t" +markerTF.getText()+
										 "\nEraser:  \t" +eraserTF.getText()+
										 "\nCalculator:\t" +calcTF.getText()+
										 "\n_______________________________"+
										 "\nTotal: \t\t" +totalTF.getText()+
								         "\n===============================");
						fileWriter.flush();
						fileWriter.close();
					}catch(Exception e1) {JOptionPane.showMessageDialog(null, e1+"");}
				

			}
		}});
		Confirm.setForeground(new Color(0, 0, 139));
		Confirm.setBackground(SystemColor.window);
		Confirm.setBounds(190, 309, 117, 29);
		panel_1.add(Confirm);
		
		//-------------------------JPanel that contains the receipt
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(352, 6, 342, 566);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 330, 554);
		panel_3.add(tabbedPane);
		
		//----------------------------JPanel tab for receipt
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Receipt", null, panel_4, null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setLayout(null);
		
		//-----------------------------JTextArea for receipt
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(6, 6, 297, 496);
		panel_4.add(textArea);
		textArea.setText(" ");
		
		//------------------------------JPanel tab for orders
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabbedPane.addTab("Orders", null, panel_2, null);
		panel_2.setLayout(null);
		
		//------------------------------JTextArea for orders
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(6, 6, 297, 496);
		panel_2.add(textArea_1);
		textArea_1.setText(" ");
	
		
	}
}

/*=*****************************************************************************************************************************
 * Student: Ant Bev                                                													*
 * Course: CMP 326 																											 
 * Semester: Summer 2017/Spring 2018
 * Assignment: Purchase GUI Project
 * Description: Write a program with a GUI for a business that wants to keep track of all Purchases made
 *              by writing their details to a file (purchases.txt). 
 *              
 * Project thoughts: This project was fun and provided a great experience. However, that doesn't mean that
 *                   it didn't have many frustrating moments(The code still has a lot of flaws). 
 *                   Some of the moments that had me saying "F#$% this project."
 *                   
 *                    - Manually setting up the coordinates for the JFrame, JPanel and JTextfields was painful.
 *                      Nothing was lining up to my liking. As you can tell from line 49, I used window builder.
 *                    - The biggest problem I had was trying to print orders to textArea. For the longest time I 
 *                      couldn't figure out why .append wasn't working. 
 *                      At first, I had:
 *                                    JTextArea textArea = new JTextArea();
 *                     
 *                      After a mistake, luck or the Java-Gods feeling bad for me I changed it to this:
 *                                    textArea = new JTextArea();
 *                      And it worked!!!
 *                     
 *                    Some of the things I learned from the project.
 *                    
 *                    + I figured out how to append to the TextArea!
 *                    + Struggling is very beneficial.
 *                    + After struggling with coordinates, window builder can be a great help
 *                    + Using window builder alone won't help you understand what's going on with your code.
 *                      So, you need to manually build in order to gain that understanding.
 *                    + Although I'm not sure if I'll use it exclusively in the future, Java has definitely helped
 *                      when comes to learning other languages.
 *  
 *              
 * ******************************************************************************************************************************/

 