package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Shifter extends Subsystem {
	private DoubleSolenoid shift = new DoubleSolenoid(6, 7);
	
	public Shifter() {
		super();
		
		LiveWindow.addActuator("Shifter", "Double Solenoid", (DoubleSolenoid) shift);
	}
	
	@Override
	public void initDefaultCommand() {}
	
	public void log() {
		SmartDashboard.putBoolean("Gear high: ", shift.get() == Value.kForward);
	}
	
	public void up() {
		shift.set(Value.kForward);
	}
	
	public void down() {
		shift.set(Value.kReverse);
	}
	
	public boolean isHighGear() {
		return (shift.get() == Value.kForward);
	}
}
