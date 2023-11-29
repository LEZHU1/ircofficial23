package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    VictorSP leftVictor;
    VictorSP rightVictor;

    public Drivetrain() {
        leftVictor= new VictorSP(1);
        rightVictor = new VictorSP(0);
        leftVictor.setInverted(true);
    }

    public void drive(double left, double right) {
        System.out.println(left + " " + right);
        leftVictor.set(left);
        rightVictor.set(right);
    }
}