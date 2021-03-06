package org.usfirst.frc.team4468.robot.subsystems;

import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber extends Subsystem {
  
  private VictorSP climb1 = new VictorSP(6);
  private VictorSP climb2 = new VictorSP(7);
  
  private PWMSpeedController[] motors = {climb1, climb2};

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
    for(PWMSpeedController m : motors) {
      m.set(speed);
    }
  }
  
  public void stop() {
    set(0);
  }
}
