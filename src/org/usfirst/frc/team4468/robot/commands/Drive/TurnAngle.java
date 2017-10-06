package org.usfirst.frc.team4468.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4468.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

public class TurnAngle extends Command {
	private double angle;
	
	private PIDController pid;
	private PIDOutput pidOut;
	
	public TurnAngle(double ang) {
		requires(Robot.drive);
		
		angle = ang;
				
		pidOut = new PIDOutput() {
			@Override
			public void pidWrite(double d) {
				Robot.drive.drive(-d * 0.6, d * 0.6);
			}
		};
		
		pid = new PIDController(0.05, 0, 0.1, Robot.drive.gyro, pidOut);
		pid.setContinuous();
		pid.setPercentTolerance(2);
	}

	protected void initialize() {
		pid.reset();
        pid.enable();
		Robot.drive.gyro.reset();
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
		SmartDashboard.putBoolean("Angle Reached Yet: ", pid.onTarget());
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
