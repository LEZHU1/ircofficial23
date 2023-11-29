package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Drivetrain;

public class AutoDrive extends CommandBase {
    Drivetrain drivetrain;
    Timer timer;
    double leftspeed, rightspeed;
    double time;

    public AutoDrive(Drivetrain dt, double ls, double rs, double t) {
        timer = new Timer();
        drivetrain = dt;
        leftspeed = ls;
        rightspeed = rs;
        time = t;
    }
    public void initialize(){
        timer.reset();
        timer.start();
    }
    public void execute(){
        drivetrain.drive(leftspeed, rightspeed);
    }
    public void end(){

    }
}
