package org.usfirst.frc.team4468.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4468.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

public class TurnAngle extends Command {
	private double angle;
	
	private PIDController pid;
	private PIDOutput pidOut;
	
	@SuppressWarnings("deprecation")
	public TurnAngle(double ang) {
		requires(Robot.drive);
		
		angle = ang;
		
		pidOut = new PIDOutput() {
			@Override
			public void pidWrite(double d) {
				Robot.drive.drive(-d * 0.6, d * 0.6);
			}
		};
		
		pid = new PIDController(0.5, 0, 0, Robot.drive.gyro, pidOut);
		pid.setContinuous();
		pid.setTolerance(2);
	}

	protected void initialize() {
		pid.reset();
        pid.enable();
	}
	
	@Override
	protected void execute() {
		pid.setSetpoint(angle);
        System.out.println("Angle Error: " + pid.getError() + "\n");
        System.out.println("Result: " + pid.get() + "\n");
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		SmartDashboard.putString("Angle Reached Yet: ", Boolean.toString(pid.onTarget()));
		return pid.onTarget();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		pid.disable();
		Robot.drive.stop();
	}
	
	protected void iterrupted() {
		pid.disable();
	}
}
