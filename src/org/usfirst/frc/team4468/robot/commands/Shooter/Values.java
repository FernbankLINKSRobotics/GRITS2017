package org.usfirst.frc.team4468.robot.commands.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4468.robot.Robot;
import org.usfirst.frc.team4468.robot.subsystems.Shooter;


public class Values extends Command {
	
	public double angle;
	public double distance;
	
	public Values () {
		requires(Robot.shoot);
		Robot.shoot.startSub();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.shoot.parseInput();
		angle = Shooter.getAngle();
		distance = Shooter.getDistance();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false; // Runs until interrupted
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}
}