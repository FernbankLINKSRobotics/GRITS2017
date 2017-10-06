package org.usfirst.frc.team4468.robot.commands.Routines;

import org.usfirst.frc.team4468.robot.commands.Shooter.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShooterRoutine extends CommandGroup {
	public ShooterRoutine() {
		addSequential(new VisionAlign());
		addSequential(new Shoot());
	}
}
