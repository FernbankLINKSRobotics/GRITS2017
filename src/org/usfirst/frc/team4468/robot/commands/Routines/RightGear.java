package org.usfirst.frc.team4468.robot.commands.Routines;

import org.usfirst.frc.team4468.robot.commands.Drive.DriveForward;
import org.usfirst.frc.team4468.robot.commands.Drive.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RightGear extends CommandGroup{
  public RightGear() {
    addSequential(new DriveForward(4600));
    addSequential(new TurnAngle(-150));
    addSequential(new DriveForward(4600));
  }
}

