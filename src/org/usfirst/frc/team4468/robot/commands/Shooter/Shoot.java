package org.usfirst.frc.team4468.robot.commands.Shooter;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4468.robot.Robot;

public class Shoot extends Command {

	public Shoot () {
		requires(Robot.shoot);
		
		Robot.shoot.shoot1.setPID(1, 0, 0);
	}

	private double calcSpeed() {
		double distance = Robot.shoot.getDistance()+.3;
		double numerator = -9.8*Math.pow(distance, 2);
		double TanAngle = Math.tan((65*Math.PI)/180);
		double CosAngle = Math.cos((65*Math.PI)/180);
		double denominator = (2.05-(distance*TanAngle)-.5)*Math.pow(CosAngle, 2);
		double linearSpeed =  Math.sqrt(numerator/denominator);
		return (linearSpeed*.1519)/.0347;
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.shoot.shoot1.setSetpoint(calcSpeed());
		if(Robot.shoot.shoot1.getError() < 3) { //placeholder variable
			Robot.shoot.setAgitate(.5);
		}
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