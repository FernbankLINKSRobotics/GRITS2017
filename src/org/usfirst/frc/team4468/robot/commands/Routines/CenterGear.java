package org.usfirst.frc.team4468.robot.commands.Routines;

import org.usfirst.frc.team4468.robot.commands.Drive.DriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterGear extends CommandGroup{
  public CenterGear() {
    addSequential(new DriveForward(5000));
  }
}
