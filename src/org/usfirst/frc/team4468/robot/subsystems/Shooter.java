package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Arrays;
import java.util.stream.Stream;

import edu.wpi.first.wpilibj.*;

public class Shooter extends Subsystem {
	
	private TalonSRX shoot1 = new TalonSRX(8);
	private TalonSRX shoot2 = new TalonSRX(9);
	
	private PWMSpeedController[] motors = {shoot1, shoot2};
	
	Stream<PWMSpeedController> motorStream  = Arrays.stream(motors);

	public Shooter() {
		super();
		
		LiveWindow.addActuator("Shooter", "Motor 1", (TalonSRX) shoot1);
		LiveWindow.addActuator("Shooter", "Motor 2", (TalonSRX) shoot2);
	}
	
	@Override
	public void initDefaultCommand() {} 
	
	public void log() {
		SmartDashboard.putNumber("Speed 1:", shoot1.getSpeed());
		SmartDashboard.putNumber("Speed 2:", shoot2.getSpeed());
	}
	
	public void set(double speed) {
		motorStream.forEach((PWMSpeedController m) -> m.set(speed));
	}
	
	public void stop() {
		set(0);
	}
}