package frc.robot.subsystems;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hopper extends SubsystemBase {
    VictorSP hopperL;
    VictorSP hopperR;

    public Hopper() {
        hopperL = new VictorSP(Constants.HopperConstants.HOPPER_LEFT);
        hopperR = new VictorSP(Constants.HopperConstants.HOPPER_RIGHT);
    }

    // public Command extendHopper() {
    //     return run(() -> {
    //         SmartDashboard.putBoolean("HOPPER", true);
    //     }).finallyDo(interrupted -> stopHopper());
    // }

    public Command extendHopper() {
        return startEnd(
            ()-> SmartDashboard.putBoolean("HOPPER", true),
            ()-> SmartDashboard.putBoolean("HOPPER", false)
        );
    }

    public Command detractHopper() {
        return startEnd(
            ()-> SmartDashboard.putBoolean("HOPPER", true),
            ()-> SmartDashboard.putBoolean("HOPPER", false)
        );
    }

    public Command stopHopper(){
        return run (()->{
        SmartDashboard.putBoolean("HOPPER", false); 
        
    });
}

    public Command testExtend(Supplier<Double> speed) {
        return new InstantCommand();
    }

    public Command testDetract(Supplier<Double> speed) {
        return new InstantCommand();
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("HopperSpeed", hopperL.get());
    }
}
