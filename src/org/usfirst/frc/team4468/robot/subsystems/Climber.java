package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.*;

public class Climber extends Subsystem {
	
	private VictorSP climb1 = new VictorSP(6);
	public VictorSP climb2 = new VictorSP(7); //make it private when done
	
	private PWMSpeedController[] motors = {climb1, climb2};

	public Climber() {
		super();
		
		LiveWindow.addActuator("Climber", "Motor 1", (VictorSP) climb1);
		LiveWindow.addActuator("Climber", "Motor 2", (VictorSP) climb2);
	}
	
	@Override
	public void initDefaultCommand() {}
	
	public void log() {}
	
	public void set(double speed) {
		for(PWMSpeedController motor : motors){
			motor.set(speed); 
		}
	}
	
	public void stop() {
		set(0);
	}
}
