package ADV;

public class ComputeSimulationState {

	private double alt_rate[]= {0.0,-3.2,-1.4,0.0}, watts_per_sec[]={0.0,2.0,1.0,0.0};
	private double vd_rate[] = {0.0,0.12,0.097,0.0};
	

	private int get_mp_region (double altitude) {
	
		int rr_region;
		if (altitude >=50.0 & altitude <500.0)
			rr_region=1;
		else 
			if (altitude >=0.1)
				rr_region=2;
			else
				rr_region=3; 

		
		return rr_region;
		
	}

	private void perform_calculations (Measurements measurements, Alerts alerts, int region, int t) {
		int mp_region=get_mp_region(measurements.getAltitude());
		if (t!=0) {
			measurements.setAltitude(measurements.getAltitude() + alt_rate[mp_region]);
			measurements.setVd(measurements.getVd() + vd_rate[mp_region]);
			measurements.setVf(15.000*Math.abs(measurements.getVd()));
			measurements.setpower_remaining(measurements.getpower_remaining() - watts_per_sec[mp_region]);
		}
		
	}
	
	
	public void compute_state (Measurements measurements, Alerts alerts, int t) {
	
		int j;
		double rand, prev_alt, prev_vd, prev_pwr;

		prev_alt = measurements.getAltitude();
		prev_vd = measurements.getVd();
		prev_pwr = measurements.getpower_remaining();

		measurements.setshield_position(measurements.getshield_cmd());
		j=get_mp_region(prev_alt);
		measurements.setMotor_state(measurements.get_motor_program(j));

			
		if (prev_alt<0.1) {
				measurements.setAltitude(prev_alt);
				measurements.setVd(prev_vd);
				measurements.setpower_remaining(prev_pwr);
				measurements.setMotor_state("Off");
				j=3;
			}
			else
				perform_calculations(measurements, alerts,j,t);

			if (measurements.getpower_remaining()<180.0) 
				alerts.setPWR60(true);

			if (measurements.getshield_position().equals("D") & measurements.getVf() < 15.0) {
				alerts.setESR(true);
				alerts.setESR_latch(true);
				alerts.setEsr_persistence_count(5);}
			
			if (alerts.getEsr_persistence_count()>0) {
				alerts.setESR(true);
				alerts.setEsr_persistence_count(alerts.getEsr_persistence_count()-1);
			}

			if (measurements.getshield_position().equals("R") & measurements.getVf() > 100) {
				alerts.setshield_damage_count(alerts.getshield_damage_count()+1);
				alerts.setPOS(true);}
			
			if (measurements.getshield_position().equals("D") & measurements.getVf() < 25 & measurements.getAltitude() < 50.0)
				alerts.setISRZ(true);
			
			if (alerts.getshield_damage_count()>=10) 
				alerts.setPDMG(true);
				
			if (alerts.isESR() | alerts.isESR_latch())
				measurements.setshield_cmd("R");
			else
				measurements.setshield_cmd(measurements.getshield_position());
			
			if (measurements.getAltitude() <0.1) {
				t=90;
				j=3;
				measurements.setMotor_state("Off");
				if (measurements.getshield_position().equals("R")) {
					if (!alerts.isPDMG() & (Math.abs(measurements.getCum_attitude()-measurements.getTerr_attitude())<=6))
						alerts.setPD(true);
					else {
						if (alerts.getRand_value()<0.0) //do not change - this is for testing
							rand=Math.random();
						else
							rand=alerts.getRand_value();
						if ((rand<0.6) & (Math.abs(measurements.getCum_attitude()-measurements.getTerr_attitude())<=6))
							alerts.setPD(true);
						else{
							if(Math.abs(measurements.getCum_attitude()-measurements.getTerr_attitude())<=6){
								alerts.setPND(true);
							}
							else{
							alerts.setDC(true); 
							alerts.setPND(true);}}}}
				else
					alerts.setPND(true); } // PND condition

	}
}
