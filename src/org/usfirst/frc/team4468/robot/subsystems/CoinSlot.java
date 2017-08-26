package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class CoinSlot extends Subsystem {
	private DoubleSolenoid slot = new DoubleSolenoid(4, 5);
	private boolean state; 
	
	public CoinSlot() {
		super();
		
		LiveWindow.addActuator("Coin Slot", "Double Solenoid", (DoubleSolenoid) slot);
		
		state = (slot.get() == Value.kForward);
	}
	
	@Override
	public void initDefaultCommand() {}
	
	public void log() {
		SmartDashboard.putBoolean("Coin Slot open: ", state);
	}
	
	public void up() {
		slot.set(Value.kForward);
		state = !state;
	}
	
	public void down() {
		slot.set(Value.kReverse); 
		state = !state;
	}
	
	public boolean isUp() {
		return state;
	}
}