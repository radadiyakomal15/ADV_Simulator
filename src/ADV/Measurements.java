package ADV;


public class Measurements {

	private double altitude;
	private int cum_attitude,terrain_attitude;
	private double power_remaining;
	private String shield_position,shield_cmd;
	private double Vd, Vf;
	private String motor_state;
	
	private String motor_state_name [] = {"Off","MP1","MP2",};
	
	public String get_motor_program (int region) {
		setMotor_state(motor_state_name[region]);
		return motor_state_name[region];
	}

	public String getMotor_state() {
		return motor_state;
	}

	public void setMotor_state(String motor_state) {
		this.motor_state = motor_state;
	}

	public double getVd() {
		return Vd;
	}

	public void setVd(double Vd) {
		this.Vd = Vd;
	}

	public String getshield_position() {
		return shield_position;
	}

	public void setshield_position(String shield_position) {
		this.shield_position = shield_position;
	}

	public double getpower_remaining() {
		return power_remaining;
	}

	public void setpower_remaining(double power_remaining) {
		this.power_remaining = power_remaining;
	}

	private String attitude_cmd;

	public String getAttitude_cmd() {
		return attitude_cmd;
	}

	public void setAttitude_cmd(String attitude_cmd) {
		this.attitude_cmd = attitude_cmd;
	}

	public int getCum_attitude() {
		return cum_attitude;
	}

	public void setCum_attitude(int cum_attitude) {
		this.cum_attitude = cum_attitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public String getshield_cmd() {
		return shield_cmd;
	}

	public void setshield_cmd(String shield_cmd) {
		this.shield_cmd = shield_cmd;
	}

	public int getTerr_attitude() {
		return terrain_attitude;
	}

	public void setTerr_attitude(int terr_attitude) {
		terrain_attitude = terr_attitude;
	}

	public double getVf() {
		return Vf;
	}

	public void setVf(double vf) {
		Vf = vf;
	}

	public void setRand(double d) {
		// TODO Auto-generated method stub
		
	}
	
	
}
