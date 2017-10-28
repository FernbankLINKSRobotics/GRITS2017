package org.usfirst.frc.team4468.robot.commands.Drive;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4468.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

public class TurnAngle extends Command {
	private double angle;
	private double error;
	
	private double tolerance = 2;
	private double speed = 0.3;
	
	private double yomama = Robot.drive.gyro.getYaw();
	private double goal;
	
	
	
	public TurnAngle(double ang) {
		requires(Robot.drive);
				
		angle = ang;
		goal = yomama + angle;
				
		/*Robot.drive.gyro.reset();
		Robot.drive.gyro.zeroYaw();
		Robot.drive.gyro.resetDisplacement();*/
	}

	protected void initialize() {
	}
	
	@Override
	protected void execute() {
		/*if (angle < 0) {
			tolerance = -tolerance;
		}*/
		System.out.println("In Turn");
		error = (goal - Robot.drive.gyro.getYaw() % 360);
		if(error < -tolerance) {
			Robot.drive.drive(-speed, speed);
		} else if(error > tolerance) {
			Robot.drive.drive(speed, -speed);
		} else {
			Robot.drive.stop();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return ((error > -tolerance) && (error < tolerance));
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drive.stop();
		Robot.drive.reset();
	}
	
	protected void iterrupted() {
		Robot.drive.stop();
	}
}
