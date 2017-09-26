package org.usfirst.frc.team4468.robot.commands.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4468.robot.Robot;


public class Shoot extends Command {

	private double speed;
	
	public Shoot (double input) {
		requires(Robot.shoot);
		speed = input;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.shoot.set(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false; // Runs until interrupted
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.shoot.stop();
	}
}