package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Arrays;
import java.util.stream.Stream;

import edu.wpi.first.wpilibj.*;

public class Climber extends Subsystem {
	
	private VictorSP climb1 = new VictorSP(6);
	private VictorSP climb2 = new VictorSP(7);
	
	private PWMSpeedController[] motors = {climb1, climb2};
	
	Stream<PWMSpeedController> motorStream  = Arrays.stream(motors);

	public Climber() {
		super();
		
		LiveWindow.addActuator("Climber", "Motor 1", (VictorSP) climb1);
		LiveWindow.addActuator("Climber", "Motor 2", (VictorSP) climb2);
	}
	
	@Override
	public void initDefaultCommand() {
		SmartDashboard.putNumber("Speed 1:", climb1.getSpeed());
		SmartDashboard.putNumber("Speed 2:", climb2.getSpeed());
	}
	
	public void log() {}
	
	public void set(double speed) {
		motorStream.forEach((PWMSpeedController m) -> m.set(speed));
	}
	
	public void stop() {
		set(0);
	}
}
