package org.usfirst.frc.team4468.robot.commands.Misc;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


public class Wait extends Command {

	private double secs;
	private double start;
	
	public Wait(double input) {
		secs = input;
		start = Timer.getMatchTime();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return (secs + start == Timer.getMatchTime()); // Runs until interrupted
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		
	}
}