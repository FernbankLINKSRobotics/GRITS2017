package org.usfirst.frc.team4468.robot.commands.Routines;

import org.usfirst.frc.team4468.robot.commands.Drive.DriveForward;
import org.usfirst.frc.team4468.robot.commands.Drive.TurnAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {
	public Autonomous() {
		System.out.println("In Auto");
		addSequential(new DriveForward(180));
		System.out.println("Finished");
	}
}