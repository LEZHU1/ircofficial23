// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoDrive;
import frc.robot.commands.Drive;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.RotateArm;

public class RobotContainer {
  Joystick leftJoystick = new Joystick(0);
  Joystick rightJoystick = new Joystick(1);
  JoystickButton raiseArmbtn = new JoystickButton(leftJoystick, 1);
  JoystickButton lowerArmBtn = new JoystickButton(rightJoystick,  1);

  Drivetrain drivetrain = new Drivetrain();
  Arm arm = new Arm();
  Drive drive = new Drive(drivetrain, leftJoystick, rightJoystick);
RotateArm rotate = new RotateArm(arm, 0);
  public RobotContainer() {
    //drivetrain.setDefaultCommand(new InstantCommand(() -> drivetrain.drive(leftJoystick.getY(), rightJoystick.getY())));
    
    drivetrain.setDefaultCommand(drive);

    configureBindings();
  }

  private void configureBindings() {
    //raiseArmbtn.onTrue(new InstantCommand(() -> arm.moveArm(0.1)));
    raiseArmbtn.whileTrue(new RotateArm(arm, 0.5));
    lowerArmBtn.whileTrue(new RotateArm(arm, -0.5));
  }

  public Command getAutonomousCommand() {
    return new AutoDrive(drivetrain,500 ,500 ,15);
  }
}
