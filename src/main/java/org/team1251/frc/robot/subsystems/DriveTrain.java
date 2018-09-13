package org.team1251.frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import org.team1251.frc.robot.Motor;
import org.team1251.frc.robot.robotMap.RobotMap;
import org.team1251.frc.robotCore.robotMap.PortType;
import org.team1251.frc.robotCore.subsystems.NoInitDefaultCmdSubsystem;

public class DriveTrain extends NoInitDefaultCmdSubsystem {

    private final TalonSRX motorLeftA = initLeadMotor(Motor.LEFT_A);
    private final VictorSPX motorLeftB = initFollowMotor(Motor.LEFT_B);
    private final VictorSPX motorLeftC = initFollowMotor(Motor.LEFT_C);
    private final VictorSPX motorLeftD = initFollowMotor(Motor.LEFT_D);

    private final TalonSRX motorRightA = initLeadMotor(Motor.RIGHT_A);
    private final VictorSPX motorRightB = initFollowMotor(Motor.RIGHT_B);
    private final VictorSPX motorRightC = initFollowMotor(Motor.RIGHT_C);
    private final VictorSPX motorRightD = initFollowMotor(Motor.RIGHT_D);

    /**
     * Runs a specific motor at a set power
     * @param motor The motor to run
     * @param power A value between 0 and 1 indicating the power to run the motor at where 0 is full-stop and 1 is
     *              full-power.
     */
    public void runMotor(Motor motor, double power) {
        // TODO: implement

        // TODO-bonus: When follow-mode is enabled, ignore (and log warning) any requests to run motors B-D
    }

    public void setFollowMode(boolean state) {
        // TODO: Enable or disable follow mode on Left/Right motors B-D; Stop motors before switching.
    }

    private TalonSRX initLeadMotor(Motor motor) {
        TalonSRX talonSRX = new TalonSRX(RobotMap.deviceManager.getPort(motor.getDeviceAssignment(), PortType.CAN));
        talonSRX.setInverted(motor.isInverted());
        return talonSRX;
    }

    private VictorSPX initFollowMotor(Motor motor) {
        VictorSPX victor = new VictorSPX(RobotMap.deviceManager.getPort(motor.getDeviceAssignment(), PortType.CAN));
        victor.setInverted(motor.isInverted());
        return victor;
    }

    @Override
    public void periodic() {
        // TODO: Output encoder values to dashboard
    }
}
