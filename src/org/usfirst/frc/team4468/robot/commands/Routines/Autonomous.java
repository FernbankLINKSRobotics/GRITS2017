package org.usfirst.frc.team4468.robot.commands.Routines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous extends CommandGroup {
	public Autonomous() {
		System.out.println("In Auto");
		if(SmartDashboard.getBoolean("DB/Button 0", false)){
			addSequential(new LeftGear());
		} else if(SmartDashboard.getBoolean("DB/Button 1", false)){
			addSequential(new CenterGear());
		} else if(SmartDashboard.getBoolean("DB/Button 2", false)){
			addSequential(new RightGear());
		} else {
			addSequential(new Baseline());
		}
		System.out.println("Finished");
	}
}