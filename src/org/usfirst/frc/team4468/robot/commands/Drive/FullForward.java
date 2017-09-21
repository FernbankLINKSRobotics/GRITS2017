package org.usfirst.frc.team4468.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4468.robot.Robot;

public class FullForward extends Command {
	private boolean isForward; 
	
	public FullForward(boolean input) {
		requires(Robot.drive);
		isForward = input;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if(!isForward) {
			Robot.drive.drive(1, 1);
		} else {
			Robot.drive.drive(-1, -1);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if(!isForward) {
			return !(Robot.oi.left.getRawButton(2)); // Runs until interrupted
		} else {
			return !(Robot.oi.left.getRawButton(3));
		}
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drive.drive(0, 0);
	}
}