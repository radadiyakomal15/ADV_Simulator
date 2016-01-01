package ADV;

public class Main 
{
        public Main()
        {
        }
    	private void initialize_objects (Measurements measurements, Alerts alerts) {
    		measurements.setVd(-10.0);
       		measurements.setVf(150.0);
    		measurements.setAltitude(225.0);
    		measurements.setpower_remaining(300.0);
    		alerts.setRand_value(-0.1);
    		alerts.setshield_damage_count(0);
    		alerts.setEsr_persistence_count(0);
    		alerts.setPDMG(false); 
    		alerts.setESR_latch(false);
    		measurements.setCum_attitude(0);
    		measurements.setTerr_attitude((int)(10-21*Math.random()));
    		measurements.setshield_position("D");
    		measurements.setshield_cmd(measurements.getshield_position());
    		measurements.setAttitude_cmd("0");
    		measurements.setCum_attitude(0); 
    		measurements.setMotor_state("MP1");
    	}
    	
    	private static void initialize_alerts (Alerts alerts) {
    		alerts.setESR(false);
    		alerts.setPWR60(false);
    		alerts.setISRZ(false);
    		alerts.setDC(false);
    		alerts.setPD(false);
    		alerts.setPOS(false);
    		alerts.setPND(false);
    		alerts.setPDMG(false);
    	}

 
        public void run()
        {
        	Measurements measurements = new Measurements();
        	Alerts alerts = new Alerts();
    		ComputeSimulationState sim_state = new ComputeSimulationState();
    		int t=0;
            ADVDisplay display = new ADVDisplay(measurements,alerts);
            display.setVisible(false);
            initialize_objects(measurements,alerts);
            while (!alerts.isPD() & !alerts.isDC() & !alerts.isPND() )
            {
    			initialize_alerts(alerts);
    			sim_state.compute_state(measurements, alerts, t);
    			display.updateDisplay(measurements, alerts);
    			t++;
                try 
                {
                    Thread.sleep(500);                 //1000 milliseconds is one second.
                } catch(InterruptedException ex) 
                {
                    Thread.currentThread().interrupt();
                }
            }
        }
        
         /**
	 * Launch the application.
	 */
	public static void main(String[] args) 
        {
            Main ADV = new Main();
            ADV.run();
	}
}
