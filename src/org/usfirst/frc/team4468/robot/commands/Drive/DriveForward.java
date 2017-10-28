package org.usfirst.frc.team4468.robot.commands.Drive;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4468.robot.Robot;

public class DriveForward extends Command {	
	private double distance;
	
	public PIDController pid;
	private PIDOutput pidOut;
	
	public DriveForward(double dir) {
		requires(Robot.drive);
		
		distance = dir;
		
		pidOut = new PIDOutput() {
			@Override
			public void pidWrite(double d) {
				Robot.drive.drive(d, d/1.68);
			}
		};
		
		pid = new PIDController(0.005, 0, 0.01, Robot.drive.leftEncoder, pidOut);
		pid.setPercentTolerance(5);
		pid.setOutputRange(-1, 1);
		pid.setContinuous();
	}
	
	protected void initialize() {
        pid.enable();
        Robot.drive.reset();
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		pid.setSetpoint(distance);
		
		System.out.println("Error: " + pid.getError());
		System.out.println("P: " + pid.getP());
		System.out.println("Output: " + pid.get());
		System.out.println("Target: " + pid.onTarget());
	}
	
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		boolean isDone = (pid.getError() < 10);
		SmartDashboard.putBoolean("Distance Reached Yet: ", isDone);
		return isDone;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		pid.reset();
		Robot.drive.stop();
	}
}