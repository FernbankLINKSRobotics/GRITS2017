package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Shifter extends Subsystem {
	private DoubleSolenoid shift = new DoubleSolenoid(6, 7);
	private boolean state; 
	
	public Shifter() {
		super();
		
		LiveWindow.addActuator("Shifter", "Double Solenoid", (DoubleSolenoid) shift);
		
		if (shift.get() == Value.kForward) {
			state = true;
		} else {
			state = false;
		}
	}
	
	@Override
	public void initDefaultCommand() {}
	
	public void log() {
		SmartDashboard.putBoolean("Gear high: ", state);
	}
	
	public void up() {
		shift.set(Value.kForward);
		state = !state;
	}
	
	public void down() {
		shift.set(Value.kReverse);
		state = !state;
	}
	
	public boolean isHighGear() {
		return state;
	}
}
