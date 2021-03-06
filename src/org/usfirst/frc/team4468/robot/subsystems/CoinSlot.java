package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class CoinSlot extends Subsystem {
  private static DoubleSolenoid slot = new DoubleSolenoid(2, 3);
  private boolean state;
  
  public CoinSlot() {
    super();
    
    LiveWindow.addActuator("Coin Slot", "Double Solenoid", (DoubleSolenoid) slot);
    state = (slot.get() == Value.kForward);
  }
  
  @Override
  public void initDefaultCommand() {}
  
  public void log() {
    SmartDashboard.putBoolean("Coin Slot open: ", (slot.get() == Value.kForward));
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
