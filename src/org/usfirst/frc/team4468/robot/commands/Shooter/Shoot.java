package org.usfirst.frc.team4468.robot.commands.Shooter;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4468.robot.Robot;
import org.usfirst.frc.team4468.robot.subsystems.Shooter;


public class Shoot extends Command {

	private double speed;
	private double distance;
	private double TanAngle;
	private double CosAngle;
	private double numerator;
	private double denominator;
	private double linearSpeed;
	private PIDController pid;
	public Shoot () {
		requires(Robot.shoot);
		public PIDController pid;
		private PIDOutput pidOut;
			
		pidOut = new PIDOutput() {
			@Override
			public void pidWrite(double d) {
				Robot.shoot.setFly(d);
			}			
		};
			
		pid = new PIDController(0.005, 0, 0.01, Robot.drive.leftEncoder.getRate(), pidOut);
		pid.setPercentTolerance(2);
		pid.setContinuous();
	}

	private double calcSpeed() {
		distance = Shooter.getDistance()+.3;
		numerator = -9.8*Math.pow(distance, 2);
		TanAngle = Math.tan((65*Math.PI)/180);
		CosAngle = Math.cos((65*Math.PI)/180);
		denominator = (2.05-(distance*TanAngle)-.5)*Math.pow(CosAngle, 2);
		linearSpeed =  Math.sqrt(numerator/denominator);
		return (linearSpeed*.1519)/.0347;
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.shoot.setFly(calcSpeed());
		Robot.shoot.setAgitate(.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false; // Runs until interrupted
		//placeholder
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.shoot.stop();
	}
}