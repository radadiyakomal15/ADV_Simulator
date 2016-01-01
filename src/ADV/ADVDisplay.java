package ADV;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class ADVDisplay extends JFrame {

	private JPanel contentPane;
	private JTextField MotorPanel;
	private JTextField TerrAttPanel;
	private JTextField ISRZPanel;
	private JTextField PDPanel;
	JTextField ESRPanel = new JTextField();
	JTextField PDMGPanel = new JTextField();
	JTextField POSPanel = new JTextField();
	JTextField PWR60Panel = new JTextField();
	JTextField DCPanel = new JTextField();
	JTextField VdPanel = new JTextField();
	JTextField PNDPanel = new JTextField();	
	@SuppressWarnings("unused")
	private JTextField altTextField;
	@SuppressWarnings("unused")
	private JTextField velTextField;
	@SuppressWarnings("unused")
	private JTextField fuelTextField;
	@SuppressWarnings("unused")
	private JTextField landTextField;
	JTextField AltPanel = new JTextField();
	JTextField VfPanel = new JTextField();
	JTextField PwrRemPanel = new JTextField();
	JTextField terrTextField = new JTextField();
	JTextField SHDPOSPanel = new JTextField();
	JTextField SHDCMDPanel = new JTextField();
	JTextField DrnAttPanel = new JTextField();
 
	JFrame frame = new JFrame();
	
    public void signedTextField(float value, int places, JTextField textField)
    {
        if(value > 0)
        	switch (places) {
        	case 3: textField.setText("+" + String.format("%,.3f",value));   break;
        	case 2: textField.setText("+" + String.format("%,.2f",value));   break;
        	case 1: textField.setText("+" + String.format("%,.1f",value));   break;
        	case 0: textField.setText("+" + String.format("%,.0f",value));
        	}
        else
        	switch (places) {
        	case 3: textField.setText(String.format("%,.3f",value));   break;
        	case 2: textField.setText(String.format("%,.2f",value));   break;
        	case 1: textField.setText(String.format("%,.1f",value));   break;
        	case 0: textField.setText(String.format("%,.0f",value));      	
        	}
   }
    
    public void signedTextField(int value, JTextField textField)
    {
        if(value > 0)
        {
             textField.setText("+" + value);
        }
        else
        {
            textField.setText(Integer.toString(value));
        }
    }
    
	public void updateDisplay(Measurements measurements, Alerts alerts) {
		if (alerts.isESR()) 
			ESRPanel.setBackground(Color.YELLOW);
		else
			ESRPanel.setBackground(Color.WHITE);
		if (alerts.isPDMG()) {
			PDMGPanel.setBackground(Color.RED);
			PDMGPanel.setForeground(Color.WHITE);
			}
		else
		{
			PDMGPanel.setBackground(Color.WHITE);
			PDMGPanel.setForeground(Color.BLACK);
		}
		if (alerts.isPOS()) {
			POSPanel.setBackground(Color.RED);
			POSPanel.setForeground(Color.WHITE);
			}
		else
		{
			POSPanel.setBackground(Color.WHITE);
			POSPanel.setForeground(Color.BLACK);
		}
		if (alerts.isPWR60()) {
			PWR60Panel.setBackground(Color.RED);
			PWR60Panel.setForeground(Color.WHITE);
			}
		else
		{
			PWR60Panel.setBackground(Color.WHITE);
			PWR60Panel.setForeground(Color.BLACK);
		}
		if (alerts.isDC()) {
			DCPanel.setBackground(Color.RED);
			DCPanel.setForeground(Color.WHITE);
			}
		else
		{
			DCPanel.setBackground(Color.WHITE);
			DCPanel.setForeground(Color.BLACK);
		}
		if (alerts.isISRZ()){
			ISRZPanel.setBackground(Color.GREEN);
			ISRZPanel.setForeground(Color.WHITE);
			}
		else
		{
			ISRZPanel.setBackground(Color.WHITE);
			ISRZPanel.setForeground(Color.BLACK);
		}
		if (alerts.isPD()){
			PDPanel.setBackground(Color.GREEN);
			PDPanel.setForeground(Color.WHITE);
			}
		else
		{
			PDPanel.setBackground(Color.WHITE);
			PDPanel.setForeground(Color.BLACK);
		}
		if (alerts.isPND()){
			PNDPanel.setBackground(Color.RED);
			PNDPanel.setForeground(Color.WHITE);
			}
		else
		{
			PNDPanel.setBackground(Color.WHITE);
			PNDPanel.setForeground(Color.BLACK);
		}
        DecimalFormat sig1 = new DecimalFormat("#.0");
        sig1.setRoundingMode(RoundingMode.DOWN);
        DecimalFormat sig3 = new DecimalFormat("#.000");
        sig3.setRoundingMode(RoundingMode.DOWN);
//
        float altval = new Float(sig1.format(measurements.getAltitude()));
        float Vdval = new Float(sig3.format(measurements.getVd()));
        float Vfval = new Float(sig3.format(measurements.getVf()));
        
        DecimalFormat sig0 = new DecimalFormat("#");
        sig0.setRoundingMode(RoundingMode.DOWN);
        float pwrval = new Float(sig0.format(measurements.getpower_remaining()));

        
        signedTextField(altval,1,AltPanel);
        signedTextField(Vdval,3,VdPanel);
        signedTextField(Vfval,3,VfPanel);
        PwrRemPanel.setText(String.format("%,.0f",pwrval));
        signedTextField(measurements.getCum_attitude(),DrnAttPanel);
        signedTextField(measurements.getTerr_attitude(),TerrAttPanel);
        MotorPanel.setText(measurements.getMotor_state());
        SHDPOSPanel.setText(measurements.getshield_position());
        if (measurements.getshield_position().equals("R")){
        	SHDPOSPanel.setBackground(Color.GREEN);
        	SHDPOSPanel.setForeground(Color.WHITE);
        }
        else
        {
        	SHDPOSPanel.setBackground(Color.WHITE);
        	SHDPOSPanel.setForeground(Color.BLACK);
        }
        SHDCMDPanel.setText(measurements.getshield_cmd());        
        if (measurements.getshield_position().equals("R")){
        	SHDCMDPanel.setBackground(Color.GREEN);
        	SHDCMDPanel.setForeground(Color.WHITE);
        }
        else 
        {
        	SHDCMDPanel.setBackground(Color.WHITE);
        	SHDCMDPanel.setForeground(Color.BLACK);
        }
	}

	public void makeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
	public void addComponents (final Measurements measurements, final Alerts alerts) {
		ESRPanel.setBounds(369, 14, 39, 20);
		frame.getContentPane().add(ESRPanel);
		ESRPanel.setHorizontalAlignment(SwingConstants.CENTER);
		ESRPanel.setText("ESR");
		ESRPanel.setColumns(10);
		
		PDMGPanel.setBounds(113, 14, 52, 20);
		frame.getContentPane().add(PDMGPanel);
		PDMGPanel.setHorizontalAlignment(SwingConstants.CENTER);
		PDMGPanel.setText("PDMG");
		PDMGPanel.setColumns(10);
		
		POSPanel.setBounds(62, 14, 45, 20);
		frame.getContentPane().add(POSPanel);
		POSPanel.setHorizontalAlignment(SwingConstants.CENTER);
		POSPanel.setText("POS");
		POSPanel.setColumns(10);
		
		PWR60Panel.setBounds(12, 14, 47, 20);
		frame.getContentPane().add(PWR60Panel);
		PWR60Panel.setHorizontalAlignment(SwingConstants.CENTER);
		PWR60Panel.setText("PWR60");
		PWR60Panel.setColumns(10);
		
		DCPanel.setBounds(210, 14, 39, 20);
		frame.getContentPane().add(DCPanel);
 		DCPanel.setHorizontalAlignment(SwingConstants.CENTER);
 		DCPanel.setText("DC");
		DCPanel.setColumns(10);
		
		PNDPanel.setBounds(168, 14, 39, 20);
		frame.getContentPane().add(PNDPanel);
		PNDPanel.setHorizontalAlignment(SwingConstants.CENTER);
		PNDPanel.setText("PND");
		PNDPanel.setColumns(10);
		
		JButton DrnAttInc = new JButton(">");
		DrnAttInc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				measurements.setCum_attitude(measurements.getCum_attitude()+1);
			}
		});
		DrnAttInc.setBounds(210, 220, 45, 30);
		frame.getContentPane().add(DrnAttInc);
		DrnAttInc.setFont(new Font("Tahoma", Font.BOLD,11));
		
		JButton DrnAttDec = new JButton("<");
		DrnAttDec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				measurements.setCum_attitude(measurements.getCum_attitude()-1);
			}
		});
		DrnAttDec.setBounds(155, 220, 45, 30);
		frame.getContentPane().add(DrnAttDec);
		DrnAttDec.setFont(new Font("Tahoma", Font.BOLD,11));
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 245, 27);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(365, 11, 45, 27);
		frame.getContentPane().add(panel_1);
		
		AltPanel.setBounds(107, 65, 70, 20);
		frame.getContentPane().add(AltPanel);
		AltPanel.setHorizontalAlignment(SwingConstants.RIGHT);
		AltPanel.setText("");
		AltPanel.setColumns(10);

		
		JLabel lblAlt = new JLabel("");
		lblAlt.setBounds(90, 70, 20, 14);
		frame.getContentPane().add(lblAlt);
		lblAlt.setText("Alt");
		lblAlt.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		JLabel lblFt = new JLabel("");
		lblFt.setBounds(180, 70, 15, 14);
		frame.getContentPane().add(lblFt);
		lblFt.setText("ft");
		lblFt.setFont(new Font("Tahoma", Font.PLAIN,11));

		JLabel lblVel = new JLabel("Vel");
		lblVel.setBounds(90, 92, 20, 14);
		frame.getContentPane().add(lblVel);
		lblVel.setText("Vd");
		lblVel.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		JLabel lblFps = new JLabel("fps");
		lblFps.setBounds(180, 92, 15, 14);
		frame.getContentPane().add(lblFps);
		lblFps.setText("fps");
		lblFps.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		setVisible(true);		
		JPanel PODBTNPanel = new JPanel();
		PODBTNPanel.setBounds(328, 89, 62, 84);
		frame.getContentPane().add(PODBTNPanel);
		
		JLabel lblPodbtn = new JLabel("SHDBTN");
		PODBTNPanel.add(lblPodbtn);
		
		final JButton tglbtnR = new JButton("R");
		JButton tglbtnD = new JButton("D");
		tglbtnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				measurements.setshield_cmd("R");
				tglbtnR.setBackground(Color.GREEN);
				tglbtnR.setForeground(Color.WHITE);
		}});
		PODBTNPanel.add(tglbtnR);
		
		tglbtnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!alerts.isESR_latch()) {
					measurements.setshield_cmd("D");
					tglbtnR.setBackground(Color.WHITE);
					tglbtnR.setForeground(Color.BLACK);
				}
				else {
					measurements.setshield_cmd("R");
					tglbtnR.setBackground(Color.GREEN);
					tglbtnR.setForeground(Color.BLACK);				
				}
			}
		});
		PODBTNPanel.add(tglbtnD);
		
		JLabel label = new JLabel("+");
		label.setBounds(265, 230, 15, 14);
		frame.getContentPane().add(label);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(140, 230, 15, 14);
		frame.getContentPane().add(label_1);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		VdPanel.setBounds(107, 88, 70, 20);
		frame.getContentPane().add(VdPanel);
		VdPanel.setHorizontalAlignment(SwingConstants.RIGHT);
		VdPanel.setText("");
		VdPanel.setColumns(10);
		
		MotorPanel = new JTextField();
		MotorPanel.setBounds(107, 135, 70, 20);
		frame.getContentPane().add(MotorPanel);
		MotorPanel.setHorizontalAlignment(SwingConstants.RIGHT);
		MotorPanel.setColumns(10);
		
		JLabel lblMtr = new JLabel("Mtr");
		lblMtr.setBounds(85, 140, 20, 14);
		frame.getContentPane().add(lblMtr);
		lblMtr.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMtr.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		PwrRemPanel.setBounds(107, 160, 70, 20);
		frame.getContentPane().add(PwrRemPanel);
		PwrRemPanel.setHorizontalAlignment(SwingConstants.RIGHT);
		PwrRemPanel.setColumns(10);
		
		JLabel lblFuel = new JLabel("Pwr");
		lblFuel.setBounds(86, 160, 27, 20);
		frame.getContentPane().add(lblFuel);
		lblFuel.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		JLabel lblGln = new JLabel("Wts");
		lblGln.setBounds(180, 160, 27, 20);
		frame.getContentPane().add(lblGln);
		lblGln.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		TerrAttPanel = new JTextField();
		TerrAttPanel.setBounds(130, 189, 40, 20);
		frame.getContentPane().add(TerrAttPanel);
		TerrAttPanel.setHorizontalAlignment(SwingConstants.RIGHT);
		TerrAttPanel.setColumns(10);
		
		DrnAttPanel.setBounds(260, 189, 40, 20);
		frame.getContentPane().add(DrnAttPanel);
		DrnAttPanel.setHorizontalAlignment(SwingConstants.RIGHT);
		DrnAttPanel.setColumns(10);
		
		JLabel lblTerAtt = new JLabel("Ter Att");
		lblTerAtt.setBounds(90, 192, 40, 14);
		frame.getContentPane().add(lblTerAtt);
		lblTerAtt.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		JLabel lblDeg = new JLabel("deg");
		lblDeg.setBounds(175, 192, 20, 14);
		frame.getContentPane().add(lblDeg);
		lblDeg.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		JLabel lblDrnAtt = new JLabel("Drn Att");
		lblDrnAtt.setBounds(215, 192, 40, 14);
		frame.getContentPane().add(lblDrnAtt);
		lblDrnAtt.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		JLabel label_3 = new JLabel("deg");
		label_3.setBounds(305, 192, 20, 14);
		frame.getContentPane().add(label_3);
		label_3.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		ISRZPanel = new JTextField();
		ISRZPanel.setText("ISRZ");
		ISRZPanel.setFont(new Font("Tahoma", Font.PLAIN,11));
		ISRZPanel.setBounds(210, 70, 40, 20);
		frame.getContentPane().add(ISRZPanel);
		ISRZPanel.setHorizontalAlignment(SwingConstants.CENTER);
		ISRZPanel.setColumns(10);
		
		PDPanel = new JTextField();
		PDPanel.setText("PD");
		PDPanel.setBounds(260, 70, 40, 20);
		frame.getContentPane().add(PDPanel);
		PDPanel.setHorizontalAlignment(SwingConstants.CENTER);
		PDPanel.setColumns(10);
		
		SHDPOSPanel = new JTextField();
		SHDPOSPanel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(SHDPOSPanel);
		SHDPOSPanel.setColumns(10);
		SHDPOSPanel.setBounds(260, 100, 40, 20);
		
		SHDCMDPanel = new JTextField();
		SHDCMDPanel.setBounds(260, 128, 40, 20);
		frame.getContentPane().add(SHDCMDPanel);
		SHDCMDPanel.setHorizontalAlignment(SwingConstants.CENTER);
		SHDCMDPanel.setColumns(10);
		
		JLabel lblSHDPOS = new JLabel("SHDPOS");
		lblSHDPOS.setBounds(215, 105, 50, 14);
		frame.getContentPane().add(lblSHDPOS);
		lblSHDPOS.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		JLabel lblSHDCMD = new JLabel("SHDCMD");
		lblSHDCMD.setBounds(215, 130, 50, 14);
		frame.getContentPane().add(lblSHDCMD);
		lblSHDCMD.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		VfPanel.setText("");
		VfPanel.setHorizontalAlignment(SwingConstants.RIGHT);
		VfPanel.setColumns(10);
		VfPanel.setBounds(107, 110, 70, 20);
		frame.getContentPane().add(VfPanel);
		
		JLabel lblNewLabel = new JLabel("Vf");
		lblNewLabel.setBounds(90, 115, 20, 14);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		JLabel lblNewLabel_1 = new JLabel("fps");
		lblNewLabel_1.setBounds(180, 115, 15, 14);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN,11));
		
		}
		
	public ADVDisplay(Measurements measurements, Alerts alerts) {
		makeFrame();
		addComponents(measurements,alerts);
	}
	}