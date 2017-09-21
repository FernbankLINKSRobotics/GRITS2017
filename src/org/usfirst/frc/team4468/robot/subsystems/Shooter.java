package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import java.util.Arrays;
import java.util.stream.Stream;

import edu.wpi.first.wpilibj.*;

public class Shooter extends Subsystem {
	
	private VictorSP shoot1 = new VictorSP(8);
	private VictorSP shoot2 = new VictorSP(9);
	
	private PWMSpeedController[] motors = {shoot1, shoot2};
	
	Stream<PWMSpeedController> motorStream  = Arrays.stream(motors);

	public Shooter() {
		super();
		
		LiveWindow.addActuator("Shooter", "Motor 1", (VictorSP) shoot1);
		LiveWindow.addActuator("Shooter", "Motor 2", (VictorSP) shoot2);
	}
	
	@Override
	public void initDefaultCommand() {} 
	
	public void log() {}
	
	public void set(double speed) {
		motorStream.forEach((PWMSpeedController m) -> m.set(speed));
	}
	
	public void stop() {
		set(0);
	}
}