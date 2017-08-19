package org.usfirst.frc.team4468.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4468.robot.Robot;

public class ShiftUp extends Command {

	public boolean prevState;
	
	public ShiftUp() {
		requires(Robot.shift);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		prevState = Robot.shift.isHighGear();
		
		if(!Robot.shift.isHighGear()) {
			Robot.shift.up();
		} else {
			Robot.shift.down();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return !(prevState == Robot.shift.isHighGear()); // Runs until interrupted
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {}
}