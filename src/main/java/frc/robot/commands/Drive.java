package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
    Drivetrain drivetrain;
    Joystick leftJ;
    Joystick rightJ;

    public Drive(Drivetrain d, Joystick L, Joystick r) {
        drivetrain = d;
        leftJ = L;
        rightJ = r;
        addRequirements(d);
    }
    public void initialize() {
        drivetrain.drive(0, 0);
    }

    public void execute() {
        System.out.println(leftJ.getY() + " " + rightJ.getY());
        drivetrain.drive(leftJ.getY(), rightJ.getY());
    }

    public boolean isFinished() {
        return false;
    }

    public void end(boolean i) {
        drivetrain.drive(0, 0);
    }
}


