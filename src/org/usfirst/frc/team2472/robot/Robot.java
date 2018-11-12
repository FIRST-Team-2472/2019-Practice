/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2472.robot;

import java.util.ArrayList;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import actions.Action;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	
	ArrayList<Action> step = new ArrayList<Action>();

	ArrayList<Action> stepSecondary = new ArrayList<Action>();
	
	TalonSRX frontLeft = new TalonSRX(1);
	TalonSRX backLeft = new TalonSRX(2);
	TalonSRX frontRight = new TalonSRX(3);
	TalonSRX backRight = new TalonSRX(4);
	

	int currentAction = 0;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {


		



		//Cycles through the steps and stops when it finds a null

		if (step.size() > 0 && step.get(currentAction) != null) {



			if (!step.get(currentAction).isFinished()) {

				step.get(currentAction).periodic();

			}



			if (!stepSecondary.get(currentAction).isFinished()) {

				stepSecondary.get(currentAction).periodic();

			}



			if (step.get(currentAction).isFinished() && stepSecondary.get(currentAction).isFinished()) {



				currentAction++;



				if (step.get(currentAction) != null) {



					step.get(currentAction).startAction();

					stepSecondary.get(currentAction).startAction();



				}



			}



		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		frontLeft.set(ControlMode.PercentOutput, 0.2);
		backLeft.set(ControlMode.PercentOutput, 0.2);
		frontRight.set(ControlMode.PercentOutput, 0.2);
		backRight.set(ControlMode.PercentOutput, 0.2);
	}
}
