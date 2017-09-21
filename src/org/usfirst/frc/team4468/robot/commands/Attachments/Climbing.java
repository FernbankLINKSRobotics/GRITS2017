package org.usfirst.frc.team4468.robot.commands.Attachments;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4468.robot.Robot;


public class Climbing extends Command {

	private double speed;
	
	public Climbing(double input) {
		requires(Robot.climb);
		speed = input;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.climb.set(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false; // Runs until interrupted
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.climb.stop();
	}
}