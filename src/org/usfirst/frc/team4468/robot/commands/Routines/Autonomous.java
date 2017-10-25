package org.usfirst.frc.team4468.robot.commands.Routines;

import org.usfirst.frc.team4468.robot.commands.Drive.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {
	public Autonomous() {
		System.out.println("In Auto");
		addSequential(new TurnAngle(20));
		System.out.println("Finished");
	}
}