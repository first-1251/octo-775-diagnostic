package org.team1251.frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import org.team1251.frc.robot.Motor;
import org.team1251.frc.robot.robotMap.Devices;
import org.team1251.frc.robot.robotMap.RobotMap;
import org.team1251.frc.robotCore.robotMap.PortType;
import org.team1251.frc.robotCore.subsystems.NoInitDefaultCmdSubsystem;

public class DriveTrain extends NoInitDefaultCmdSubsystem {

    private final TalonSRX motorLeftA = initLeadMotor(RobotMap.deviceManager.getPort(Devices.DRIVE_LEFT_A, PortType.CAN));
    private final VictorSPX motorLeftB = initFollowMotor(RobotMap.deviceManager.getPort(Devices.DRIVE_LEFT_B, PortType.CAN));
    private final VictorSPX motorLeftC = initFollowMotor(RobotMap.deviceManager.getPort(Devices.DRIVE_LEFT_C, PortType.CAN));
    private final VictorSPX motorLeftD = initFollowMotor(RobotMap.deviceManager.getPort(Devices.DRIVE_LEFT_D, PortType.CAN));

    private final TalonSRX motorRightA = initLeadMotor(RobotMap.deviceManager.getPort(Devices.DRIVE_RIGHT_A, PortType.CAN));
    private final VictorSPX motorRightB = initFollowMotor(RobotMap.deviceManager.getPort(Devices.DRIVE_RIGHT_B, PortType.CAN));
    private final VictorSPX motorRightC = initFollowMotor(RobotMap.deviceManager.getPort(Devices.DRIVE_RIGHT_C, PortType.CAN));
    private final VictorSPX motorRightD = initFollowMotor(RobotMap.deviceManager.getPort(Devices.DRIVE_RIGHT_D, PortType.CAN));

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

    private TalonSRX initLeadMotor(int port) {
        // TODO: Implement
        return null;
    }

    private VictorSPX initFollowMotor(int port) {
        // TODO: Implement
        return null;
    }

    @Override
    public void periodic() {
        // TODO: Output encoder values to dashboard
    }
}
