package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class CoinSlot extends Subsystem {
	private DoubleSolenoid slot = new DoubleSolenoid(4, 5);
	private boolean state = false; 
	
	public CoinSlot() {
		super();
		
		LiveWindow.addActuator("Coin Slot", "Double Solenoid", (DoubleSolenoid) slot);
	}
	
	@Override
	public void initDefaultCommand() {}
	
	public void log() {
		SmartDashboard.putBoolean("Coin Slot open: ", state);
	}
	
	public void up() {
		slot.set(Value.kForward);
		state = true;
	}
	
	public void down() {
		slot.set(Value.kReverse); 
		state = false;
	}
	
	public boolean isUp() {
		return state;
	}
}