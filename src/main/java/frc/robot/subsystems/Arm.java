package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class Arm extends SubsystemBase{
   
    VictorSP armVictor;

    public Arm() {
        armVictor = new VictorSP(1);
    }

    public void moveArm(double arm) {
        armVictor.set(arm);
    }
}

