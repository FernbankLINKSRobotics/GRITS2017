package org.usfirst.frc.team4468.robot.commands.Shooter;

import org.usfirst.frc.team4468.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ManualShoot extends Command{
	private boolean isForward; 
	
	public ManualShoot(boolean input) {
		requires(Robot.shoot);
		isForward = input;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if(!isForward) {
			Robot.shoot.setFly(-0.5);
			Robot.shoot.setAgitate(0.4);
		} else {
			Robot.shoot.setFly(0.2);
			Robot.shoot.setAgitate(-0.3);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if(!isForward) {
			return !(Robot.oi.left.getRawButton(4)); // Runs until interrupted
		} else {
			return !(Robot.oi.left.getRawButton(5));
		}
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.shoot.stop();
	}
}
