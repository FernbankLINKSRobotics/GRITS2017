package org.usfirst.frc.team4468.robot.commands.Shooter;

import org.usfirst.frc.team4468.robot.Robot;
import org.usfirst.frc.team4468.robot.commands.Drive.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class VisionAlign extends CommandGroup {
  public VisionAlign() {
    addSequential(new TurnAngle(Robot.shoot.getAngle()));
  }
}
