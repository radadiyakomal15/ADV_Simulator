package ADV;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComputeSimulationStateTest {
		
	
	private void clearAlerts (Alerts alerts) {
    	alerts.setESR(false);
    	alerts.setPWR60(false);
    	alerts.setISRZ(false);
    	alerts.setDC(false);
    	alerts.setPD(false);
    	alerts.setPOS(false);
    	alerts.setPND(false);
    	alerts.setPDMG(false);
	}
 
	@Test
	public void testCompute_state() {
		Alerts alerts = new Alerts();
		Measurements measurements = new Measurements();
		ComputeSimulationState state = new ComputeSimulationState();
		
		//TC_001 -Scenario 1a test alt BV of 249.9
		clearAlerts(alerts);
		measurements.setAltitude(253.1);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(101.805);
		measurements.setVd(-6.787);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(true,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(249.9,measurements.getAltitude(),0.01);
		assertEquals(100.005,measurements.getVf(),0.0001);
		assertEquals(-6.667,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		
		//TC_002 - Scenario 1a test alt BV of 249.9 + PDMG
				clearAlerts(alerts);
				measurements.setAltitude(253.1);
				measurements.setshield_position("R");
				measurements.setshield_cmd("R");
				measurements.setVf(101.805);
				measurements.setVd(-6.787);
				measurements.setpower_remaining(182);
				measurements.setRand(0.59);
				alerts.setshield_damage_count(10);
				alerts.setESR_latch(false);
				alerts.setEsr_persistence_count(0);
				measurements.setCum_attitude(5);
				measurements.setTerr_attitude(-1);
				state.compute_state(measurements, alerts, 1);
				assertEquals(false,alerts.isPWR60());
				assertEquals(true,alerts.isPOS());
				assertEquals(true,alerts.isPDMG());
				assertEquals(false,alerts.isPND());
				assertEquals(false,alerts.isDC());
				assertEquals(false,alerts.isESR());
				assertEquals(false,alerts.isISRZ());
				assertEquals(false,alerts.isPD());
				assertEquals(249.9,measurements.getAltitude(),0.01);
				assertEquals(100.005,measurements.getVf(),0.0001);
				assertEquals(-6.667,measurements.getVd(),0.0001);
				assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		
		
		
		clearAlerts(alerts);
		measurements.setAltitude(253.1);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(101.79);
		measurements.setVd(-6.786);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(249.9,measurements.getAltitude(),0.01);
		assertEquals(99.99,measurements.getVf(),0.0001);
		assertEquals(-6.666,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		
		
		
		//TC 3
		clearAlerts(alerts);
		measurements.setAltitude(53.1);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(101.790);
		measurements.setVd(-6.786);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(49.9,measurements.getAltitude(),0.01);
		assertEquals(99.99,measurements.getVf(),0.0001);
		assertEquals(-6.666,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
	
		
		
		
		//TC 4
		clearAlerts(alerts);
		measurements.setAltitude(1.5);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(26.460);
		measurements.setVd(-1.764);
		measurements.setpower_remaining(180);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(0.1,measurements.getAltitude(),0.01);
		assertEquals(25.005,measurements.getVf(),0.0001);
		assertEquals(-1.667,measurements.getVd(),0.0001);
		assertEquals("MP2",measurements.getMotor_state());
		assertEquals(179,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
	
		
		
		//TC 5
		clearAlerts(alerts);
		measurements.setAltitude(53.2);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(101.790);
		measurements.setVd(-6.786);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(50.0,measurements.getAltitude(),0.01);
		assertEquals(99.990,measurements.getVf(),0.0001);
		assertEquals(-6.666,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
	
		
		
		//TC 6
		clearAlerts(alerts);
		measurements.setAltitude(1.4);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(1.530);
		measurements.setVd(-0.10200);
		measurements.setpower_remaining(156);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(true,alerts.isPD());
		assertEquals(0.000,measurements.getAltitude(),0.01);
		assertEquals(0.075,measurements.getVf(),0.0001);
		assertEquals(-0.0050,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(155,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		
		
		
		//TC 7
		clearAlerts(alerts);
		measurements.setAltitude(25.2);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(26.445);
		measurements.setVd(-1.76300);
		measurements.setpower_remaining(173);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(true,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(23.8,measurements.getAltitude(),0.01);
		assertEquals(24.990,measurements.getVf(),0.0001);
		assertEquals(-1.6660,measurements.getVd(),0.0001);
		assertEquals("MP2",measurements.getMotor_state());
		assertEquals(172,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
		
		
		
	    //TC 8	
		clearAlerts(alerts);
		measurements.setAltitude(15.4);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(16.440);
		measurements.setVd(-1.096);
		measurements.setpower_remaining(166);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(true);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(true,alerts.isESR());
		assertEquals(true,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(14.000,measurements.getAltitude(),0.01);
		assertEquals(14.985,measurements.getVf(),0.0001);
		assertEquals(-0.9990,measurements.getVd(),0.0001);
		assertEquals("MP2",measurements.getMotor_state());
		assertEquals(165,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		
		
		
		//TC 9
		clearAlerts(alerts);
		measurements.setAltitude(1.4);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(1.530);
		measurements.setVd(-0.10200);
		measurements.setpower_remaining(156);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(6);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(true,alerts.isPND());
		assertEquals(true,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(0.000,measurements.getAltitude(),0.01);
		assertEquals(0.075,measurements.getVf(),0.0001);
		assertEquals(-0.0049,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(155,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		
		
		
		//TC 10
		clearAlerts(alerts);
		measurements.setAltitude(1.4);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(1.530);
		measurements.setVd(-0.10200);
		measurements.setpower_remaining(156);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(true,alerts.isPD());
		assertEquals(0.000,measurements.getAltitude(),0.01);
		assertEquals(0.075,measurements.getVf(),0.0001);
		assertEquals(-0.0049,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(155,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		
		
		
		//TC 11
		clearAlerts(alerts);
		measurements.setAltitude(1.4);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(1.530);
		measurements.setVd(-0.10200);
		measurements.setpower_remaining(156);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(true,alerts.isPD());
		assertEquals(0.000,measurements.getAltitude(),0.01);
		assertEquals(0.075,measurements.getVf(),0.0001);
		assertEquals(-0.0049,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(155,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		//TC -12
		clearAlerts(alerts);
		measurements.setAltitude(1.4);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(1.530);
		measurements.setVd(-0.10200);
		measurements.setpower_remaining(156);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(true,alerts.isPD());
		assertEquals(0.000,measurements.getAltitude(),0.01);
		assertEquals(0.075,measurements.getVf(),0.0001);
		assertEquals(-0.0049,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(155,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		
		//TC 13
		clearAlerts(alerts);
		measurements.setAltitude(1.4);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(1.530);
		measurements.setVd(-0.10200);
		measurements.setpower_remaining(156);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(6);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(true,alerts.isPND());
		assertEquals(true,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(0.000,measurements.getAltitude(),0.01);
		assertEquals(0.075,measurements.getVf(),0.0001);
		assertEquals(-0.0049,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(155,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
	
		
		

	//TC 14
		clearAlerts(alerts);
		measurements.setAltitude(53.1);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(101.790);
		measurements.setVd(-6.786);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(49.9,measurements.getAltitude(),0.01);
		assertEquals(99.99,measurements.getVf(),0.0001);
		assertEquals(-6.666,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
	
		
		
		
		
		//TC - 15
		clearAlerts(alerts);
		measurements.setAltitude(253.1);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(101.790);
		measurements.setVd(-6.786);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		System.out.println(measurements.getVd());
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(249.9,measurements.getAltitude(),0.01);
		assertEquals(99.99,measurements.getVf(),0.0001);
		assertEquals(-6.6660,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
	
		
		
		//TC - 16
		clearAlerts(alerts);
		measurements.setAltitude(253.1);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(101.790);
		measurements.setVd(-6.786);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(249.9,measurements.getAltitude(),0.01);
		assertEquals(99.99,measurements.getVf(),0.0001);
		assertEquals(-6.6660,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
		
		
		
		
		//TC - 17 
		clearAlerts(alerts);
		measurements.setAltitude(53.1);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(101.790);
		measurements.setVd(-6.786);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(49.9,measurements.getAltitude(),0.01);
		assertEquals(99.990,measurements.getVf(),0.0001);
		assertEquals(-6.666,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		
		
		
		
		
		//TC - 18
		
		clearAlerts(alerts);
		measurements.setAltitude(53.1);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(101.790);
		measurements.setVd(-6.786);
		measurements.setpower_remaining(182);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(false,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(49.9,measurements.getAltitude(),0.01);
		assertEquals(99.990,measurements.getVf(),0.0001);
		assertEquals(-6.666,measurements.getVd(),0.0001);
		assertEquals("MP1",measurements.getMotor_state());
		assertEquals(180,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
		
		
		
		
		//TC - 20
		clearAlerts(alerts);
		measurements.setAltitude(1.5);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(26.460);
		measurements.setVd(-1.764);
		measurements.setpower_remaining(180);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(0.1,measurements.getAltitude(),0.01);
		assertEquals(25.005,measurements.getVf(),0.0001);
		assertEquals(-1.6670,measurements.getVd(),0.0001);
		assertEquals("MP2",measurements.getMotor_state());
		assertEquals(179,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
		
		
		//TC - 21
		clearAlerts(alerts);
		measurements.setAltitude(25.2);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(26.445);
		measurements.setVd(-1.76300);
		measurements.setpower_remaining(173);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(1);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(true,alerts.isESR());
		assertEquals(true,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(23.8,measurements.getAltitude(),0.01);
		assertEquals(24.990,measurements.getVf(),0.0001);
		assertEquals(-1.6660,measurements.getVd(),0.0001);
		assertEquals("MP2",measurements.getMotor_state());
		assertEquals(172,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		
		
		
		//TC 22
		clearAlerts(alerts);
		measurements.setAltitude(15.4);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(16.440);
		measurements.setVd(-1.09600);
		measurements.setpower_remaining(166);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(10);
		alerts.setESR_latch(true);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(true,alerts.isESR());
		assertEquals(true,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(14.0,measurements.getAltitude(),0.01);
		assertEquals(14.985,measurements.getVf(),0.0001);
		assertEquals(-0.9990,measurements.getVd(),0.0001);
		assertEquals("MP2",measurements.getMotor_state());
		assertEquals(165,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		
		
		
		//TC 23
				clearAlerts(alerts);
				measurements.setAltitude(53.2);
				measurements.setshield_position("D");
				measurements.setshield_cmd("D");
				measurements.setVf(101.800);
				measurements.setVd(-6.78667);
				measurements.setpower_remaining(182);
				measurements.setRand(0.59);
				alerts.setshield_damage_count(8);
				alerts.setESR_latch(false);
				alerts.setEsr_persistence_count(0);
				measurements.setCum_attitude(5);
				measurements.setTerr_attitude(-1);
				state.compute_state(measurements, alerts, 1);
				assertEquals(false,alerts.isPWR60());
				assertEquals(false,alerts.isPOS());
				assertEquals(false,alerts.isPDMG());
				assertEquals(false,alerts.isPND());
				assertEquals(false,alerts.isDC());
				assertEquals(false,alerts.isESR());
				assertEquals(false,alerts.isISRZ());
				assertEquals(false,alerts.isPD());
				assertEquals(50.0,measurements.getAltitude(),0.01);
				assertEquals(100.000,measurements.getVf(),0.0001);
				assertEquals(-6.6667,measurements.getVd(),0.0001);
				assertEquals("MP1",measurements.getMotor_state());
				assertEquals(180,measurements.getpower_remaining(),.1);
				assertEquals("D",measurements.getshield_position());
				assertEquals("D",measurements.getshield_cmd());
		
		
				
				
	//TC 24
				
				clearAlerts(alerts);
				measurements.setAltitude(1.4);
				measurements.setshield_position("D");
				measurements.setshield_cmd("D");
				measurements.setVf(1.530);
				measurements.setVd(-0.10200);
				measurements.setpower_remaining(156);
				measurements.setRand(0.60);
				alerts.setshield_damage_count(8);
				alerts.setESR_latch(false);
				alerts.setEsr_persistence_count(0);
				measurements.setCum_attitude(4);
				measurements.setTerr_attitude(-1);
				state.compute_state(measurements, alerts, 1);
				assertEquals(true,alerts.isPWR60());
				assertEquals(false,alerts.isPOS());
				assertEquals(false,alerts.isPDMG());
				assertEquals(true,alerts.isPND());
				assertEquals(false,alerts.isDC());
				assertEquals(true,alerts.isESR());
				assertEquals(true,alerts.isISRZ());
				assertEquals(false,alerts.isPD());
				assertEquals(0.000,measurements.getAltitude(),0.01);
				assertEquals(0.075,measurements.getVf(),0.0001);
				assertEquals(-0.0049,measurements.getVd(),0.0001);
				assertEquals("Off",measurements.getMotor_state());
				assertEquals(155,measurements.getpower_remaining(),.1);
				assertEquals("D",measurements.getshield_position());
				assertEquals("R",measurements.getshield_cmd());
		
				
		//TC - 25
		

		clearAlerts(alerts);
		measurements.setAltitude(25.2);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(26.455);
		measurements.setVd(-1.76367);
		measurements.setpower_remaining(173);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(23.8,measurements.getAltitude(),0.01);
		assertEquals(25.000,measurements.getVf(),0.0001);
		assertEquals(-1.6667,measurements.getVd(),0.0001);
		assertEquals("MP2",measurements.getMotor_state());
		assertEquals(172,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("D",measurements.getshield_cmd());
		
		//TC - 26
		
		clearAlerts(alerts);
		measurements.setAltitude(1.4);
		measurements.setshield_position("R");
		measurements.setshield_cmd("R");
		measurements.setVf(1.530);
		measurements.setVd(-0.10200);
		measurements.setpower_remaining(156);
		measurements.setRand(0.60);
		alerts.setshield_damage_count(10);
		alerts.setESR_latch(false);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(4);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(true,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(false,alerts.isISRZ());
		assertEquals(true,alerts.isPD());
		assertEquals(0.000,measurements.getAltitude(),0.01);
		assertEquals(0.075,measurements.getVf(),0.0001);
		assertEquals(-0.0049,measurements.getVd(),0.0001);
		assertEquals("Off",measurements.getMotor_state());
		assertEquals(155,measurements.getpower_remaining(),.1);
		assertEquals("R",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		
		
		//TC 27
		clearAlerts(alerts);
		measurements.setAltitude(15.4);
		measurements.setshield_position("D");
		measurements.setshield_cmd("D");
		measurements.setVf(16.445);
		measurements.setVd(-1.09700);
		measurements.setpower_remaining(166);
		measurements.setRand(0.59);
		alerts.setshield_damage_count(8);
		alerts.setESR_latch(true);
		alerts.setEsr_persistence_count(0);
		measurements.setCum_attitude(5);
		measurements.setTerr_attitude(-1);
		state.compute_state(measurements, alerts, 1);
		System.out.println(measurements.getVf());
		assertEquals(true,alerts.isPWR60());
		assertEquals(false,alerts.isPOS());
		assertEquals(false,alerts.isPDMG());
		assertEquals(false,alerts.isPND());
		assertEquals(false,alerts.isDC());
		assertEquals(false,alerts.isESR());
		assertEquals(true,alerts.isISRZ());
		assertEquals(false,alerts.isPD());
		assertEquals(14.0,measurements.getAltitude(),0.01);
		assertEquals(15.000,measurements.getVf(),0.0001);
		assertEquals(-1.0000,measurements.getVd(),0.0001);
		assertEquals("MP2",measurements.getMotor_state());
		assertEquals(165,measurements.getpower_remaining(),.1);
		assertEquals("D",measurements.getshield_position());
		assertEquals("R",measurements.getshield_cmd());
		
		 
	
		
		
		
		
		
		
		
		
		
		
	

	
	
	}
	
}
