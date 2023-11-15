// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoDrive;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;


public class RobotContainer {
  Joystick leftJoystick = new Joystick(0);
  Joystick rightJoystick = new Joystick(1);
  JoystickButton raiseArmbtn = new JoystickButton(leftJoystick, 2);
  JoystickButton lowerArmBtn = new JoystickButton(rightJoystick,  2);

  Drivetrain drivetrain = new Drivetrain();
  Arm arm = new Arm();

  public RobotContainer() {
    drivetrain.setDefaultCommand(new InstantCommand(() -> drivetrain.drive(leftJoystick.getY(), rightJoystick.getY())));

    configureBindings();
  }

  private void configureBindings() {
    raiseArmbtn.onTrue(new InstantCommand(() -> arm.moveArm(0.5)));
    lowerArmBtn.onTrue(new InstantCommand(() -> arm.moveArm(-0.5)));
  }

  public Command getAutonomousCommand() {
    return new AutoDrive(drivetrain,0.5 ,0.5 ,2);
  }
}
