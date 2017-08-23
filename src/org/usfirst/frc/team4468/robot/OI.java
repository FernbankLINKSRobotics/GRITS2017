package org.usfirst.frc.team4468.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team4468.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick left  = new Joystick(0);
	public Joystick right = new Joystick(1);
	
	public OI() {
		SmartDashboard.putData("Toggle slot" , new SlotToggle());
		SmartDashboard.putData("Toggle shift", new ShiftUp());
		
		JoystickButton l2 = new JoystickButton(left, 2);
		JoystickButton l3 = new JoystickButton(left, 3);
		JoystickButton lt = new JoystickButton(left, 1);
		
		JoystickButton r4 = new JoystickButton(right, 4);
		JoystickButton r5 = new JoystickButton(right, 5);
		JoystickButton rt = new JoystickButton(right, 1);
		
		l2.whenPressed(new FullForward(false));
		l3.whenPressed(new FullForward(true ));
		lt.whenPressed(new ShiftUp());
		
		r4.whenPressed(new Climbing(-1   ));
		r5.whenPressed(new Climbing(-0.25));
		rt.whenPressed(new SlotToggle());
		
		
	}
}
