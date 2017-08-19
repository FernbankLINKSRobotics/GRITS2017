package org.usfirst.frc.team4468.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous extends CommandGroup {
	public Autonomous() {
		//System.out.println("In Auto");
		addSequential(new TurnAngle(10));
	}
}