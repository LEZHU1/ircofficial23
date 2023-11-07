package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive extends CommandBase {
    DriveTrain drivetrain;
    Joystick leftJ;
    Joystick rightJ;
    Drive drive;

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
        drivetrain.drive(leftJ.getY(), right.getY());
    }

    public boolean isFinished() {
        return false;
    }

    public void end(boolean i) {
        drivetrain.drive(0, 0);
    }
}


