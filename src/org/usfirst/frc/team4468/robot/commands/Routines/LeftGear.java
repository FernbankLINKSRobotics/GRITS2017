package org.usfirst.frc.team4468.robot.commands.Routines;

import org.usfirst.frc.team4468.robot.commands.Drive.DriveForward;
import org.usfirst.frc.team4468.robot.commands.Drive.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftGear extends CommandGroup{
  public LeftGear() {
    addSequential(new DriveForward(0));
    addSequential(new TurnAngle(0));
    addSequential(new DriveForward(0));
  }
}
