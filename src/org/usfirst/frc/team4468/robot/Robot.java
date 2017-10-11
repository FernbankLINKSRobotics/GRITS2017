
package org.usfirst.frc.team4468.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4468.robot.commands.Routines.Autonomous;
import org.usfirst.frc.team4468.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static DriveTrain drive;
	public static Shooter shoot;
	public static CoinSlot slot;
	public static Climber climb;
	public static Shifter shift;
	public static OI oi;

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		drive = new DriveTrain();
		slot  = new CoinSlot();
		shoot = new Shooter();
		climb = new Climber();
		shift = new Shifter();
		oi    = new OI();
		
		autonomousCommand = new Autonomous();

		SmartDashboard.putData(drive);
		SmartDashboard.putData(slot );
		SmartDashboard.putData(climb);
		SmartDashboard.putData(shift);
		SmartDashboard.putData(shoot);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		// schedule the autonomous command (example)
		drive.reset();
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		autonomousCommand.cancel();
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		
		System.out.println(shoot.shoot1.getEncPosition());
		Scheduler.getInstance().run();
		log();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		//shoot.setAgitate(0.7);
		shoot.shoot1.set(-1);
		System.out.println(shoot.shoot1.getEncVelocity());
	}
	
	private void log() {
		drive.log();
		slot .log();
		climb.log();
		shift.log();
		shoot.log();
	}
}
