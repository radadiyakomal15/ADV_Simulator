package ADV;

public class Alerts {

	private boolean Em_Shield_Deploy_Warning, Pod_Overspeed_Alarm;
	private boolean PWR60, ideal_shield_down_zone;
	private boolean Drone_Crashed_Alarm, Package_Delivered_indicator,Package_Not_Delivered;
	private int shield_damage_count, esr_persistence_count; 
	private boolean pod_damaged; 
	private boolean em_shield_deploy_latch;
	private double rand_value = 1.0;
	
	public int getshield_damage_count() {
		return shield_damage_count;
	}
	public void setshield_damage_count(int shield_damage_count) {
		this.shield_damage_count = shield_damage_count;
	}
	public boolean isPDMG() {
		return pod_damaged;
	}
	public void setPDMG(boolean pod_damaged) {
		this.pod_damaged = pod_damaged;
	}
	public boolean isESR_latch() {
		return em_shield_deploy_latch;
	}
	public void setESR_latch(boolean em_shield_deploy_latch) {
		this.em_shield_deploy_latch = em_shield_deploy_latch;
	}
	public double getRand_value() {
		return rand_value;
	}
	public void setRand_value(double rand_value) {
		this.rand_value = rand_value;
	}

	public boolean isESR() {
		return Em_Shield_Deploy_Warning;
	}
	public void setESR(boolean em_Shield_Deploy_Warning) {
		this.Em_Shield_Deploy_Warning = em_Shield_Deploy_Warning;
	}
	public boolean isPOS() {
		return Pod_Overspeed_Alarm;
	}
	public void setPOS(boolean pod_Overspeed_Alarm) {
		this.Pod_Overspeed_Alarm = pod_Overspeed_Alarm;
	}
	public boolean isPWR60() {
		return PWR60;
	}
	public void setPWR60(boolean PWR60) {
		this.PWR60 = PWR60;
	}
	public boolean isISRZ() {
		return ideal_shield_down_zone;
	}
	public void setISRZ(boolean ideal_shield_down_zone) {
		this.ideal_shield_down_zone = ideal_shield_down_zone;
	}
	public boolean isDC() {
		return Drone_Crashed_Alarm;
	}
	public void setDC(boolean Drone_Crashed_Alarm) {
		this.Drone_Crashed_Alarm = Drone_Crashed_Alarm;
	}
	public boolean isPD() {
		return Package_Delivered_indicator;
	}
	public void setPD(boolean Package_Delivered_indicator) {
		this.Package_Delivered_indicator = Package_Delivered_indicator;
	}
	public int getEsr_persistence_count() {
		return esr_persistence_count;
	}
	public void setEsr_persistence_count(int esr_persistence_count) {
		this.esr_persistence_count = esr_persistence_count;
	}
	public boolean isPND() {
		return Package_Not_Delivered;
	}
	public void setPND(boolean package_not_delivered) {
		this.Package_Not_Delivered = package_not_delivered;
	}
}
