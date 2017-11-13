package org.usfirst.frc.team4468.robot.commands.Misc;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4468.robot.Robot;

public class SlotToggle extends Command {
  
  private boolean prevState;
  
  public SlotToggle() {
    requires(Robot.slot);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    prevState = Robot.slot.isUp();
        
    if(!Robot.slot.isUp()) {
      Robot.slot.up();
    } else {
      Robot.slot.up();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !(prevState == Robot.slot.isUp()); // Runs until interrupted
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {}
}
