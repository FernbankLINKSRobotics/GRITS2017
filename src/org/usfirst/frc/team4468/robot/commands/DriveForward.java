package org.usfirst.frc.team4468.robot.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4468.robot.Robot;

public class DriveForward extends Command {	
	private final double mult = 0.6;
	private double distanceDriven;
	private double distance;
	
	private PIDController pid;
	private PIDOutput pidOut;
	
	@SuppressWarnings("deprecation")
	public DriveForward(double dir) {
		requires(Robot.drive);
		
		distance = Robot.drive.getDistance();
		distance = dir;
		
		pidOut = new PIDOutput() {
			@Override
			public void pidWrite(double d) {
				Robot.drive.drive(d * mult, d * mult);
			}
		};
		
		pid = new PIDController(0.5, 0, 0, Robot.drive.leftEncoder, pidOut);
		pid.setTolerance(2);
		pid.setContinuous();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		pid.setSetpoint(distanceDriven);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		boolean isThere = distance - (distanceDriven - Robot.drive.getDistance()) == 0;
		SmartDashboard.putString("Distance Reached Yet: ", Boolean.toString(isThere));
		return isThere;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drive.stop();
	}
}