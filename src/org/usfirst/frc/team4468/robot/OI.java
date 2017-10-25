package org.usfirst.frc.team4468.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4468.robot.commands.Misc.Climbing;
import org.usfirst.frc.team4468.robot.commands.Misc.ShiftUp;
import org.usfirst.frc.team4468.robot.commands.Misc.SlotToggle;
import org.usfirst.frc.team4468.robot.commands.Shooter.ManualShoot;
import org.usfirst.frc.team4468.robot.commands.Drive.FullForward;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick ctrl  = new Joystick(2);
	public Joystick left  = new Joystick(0);
	public Joystick right = new Joystick(1);
	
	public OI() {
		
		SmartDashboard.putData("Toggle slot" , new SlotToggle());
		SmartDashboard.putData("Toggle shift", new ShiftUp());
		
		JoystickButton l2 = new JoystickButton(left, 2);
		JoystickButton l3 = new JoystickButton(left, 3);
		JoystickButton l4 = new JoystickButton(left, 4);
		JoystickButton l5 = new JoystickButton(left, 5);
		JoystickButton lt = new JoystickButton(left, 1);
		
		JoystickButton r4 = new JoystickButton(right, 4);
		JoystickButton r5 = new JoystickButton(right, 5);
		JoystickButton rt = new JoystickButton(right, 1);
		
		l2.whenPressed(new FullForward(false));
		l3.whenPressed(new FullForward(true ));
		//l4.whenPressed(new ManualShoot(true ));
		//l5.whenPressed(new ManualShoot(false));
		lt.whenReleased(new ShiftUp());
		
		r4.whenPressed(new Climbing(-1   ));
		r5.whenPressed(new Climbing(-0.25));
		rt.whenReleased(new SlotToggle());
		
		
	}
}
