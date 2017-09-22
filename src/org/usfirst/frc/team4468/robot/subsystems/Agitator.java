package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;

public class Agitator extends Subsystem {
	
	private VictorSP motor = new VictorSP(10);

	public Agitator() {
		super();
		
		LiveWindow.addActuator("Agitator", "Motor", (VictorSP) motor);
	}
	
	@Override
	public void initDefaultCommand() {} 
	
	public void log() {
		SmartDashboard.putNumber("Speed: ", motor.getSpeed());
	}
	
	public void set(double speed) {
		motor.set(speed);
	}
	
	public void stop() {
		set(0);
	}
}