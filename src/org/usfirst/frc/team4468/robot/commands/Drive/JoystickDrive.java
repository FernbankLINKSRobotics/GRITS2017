package org.usfirst.frc.team4468.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4468.robot.Robot;

public class JoystickDrive extends Command {

  public JoystickDrive() {
    requires(Robot.drive);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.drive.drive(-Robot.oi.right.getY(), -Robot.oi.left.getY());
    
    System.out.println("Heading: " + Robot.drive.gyro.getCompassHeading());
    System.out.println("Angle: " + Robot.drive.gyro.getAngle());
    System.out.println("Yaw: " + Robot.drive.gyro.getYaw());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false; // Runs until interrupted
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.drive.stop();
  }
}
