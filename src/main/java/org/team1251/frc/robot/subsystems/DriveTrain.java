package org.team1251.frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team1251.frc.robot.Motor;
import org.team1251.frc.robot.humanInterface.input.HumanInput;
import org.team1251.frc.robot.robotMap.RobotMap;
import org.team1251.frc.robotCore.robotMap.PortType;
import org.team1251.frc.robotCore.subsystems.NoInitDefaultCmdSubsystem;

public class DriveTrain extends NoInitDefaultCmdSubsystem {

    private final VictorSPX motorLFB = initFollowMotor(Motor.LEFT_LFB);
    private final VictorSPX motorLFT = initFollowMotor(Motor.LEFT_LFT);
    private final VictorSPX motorLBT = initFollowMotor(Motor.LEFT_LBT);
    private final TalonSRX motorLBB = initLeadMotor(Motor.LEFT_LBB);

    private final VictorSPX motorRFB = initFollowMotor(Motor.RIGHT_RFB);
    private final VictorSPX motorRFT = initFollowMotor(Motor.RIGHT_RFT);
    private final VictorSPX motorRBT = initFollowMotor(Motor.RIGHT_RBT);
    private final TalonSRX motorRBB = initLeadMotor(Motor.RIGHT_RBB);
    public HumanInput humanInput;


    private double left = 0;
    private double right = 0;

    public void driveStraight(double power) {
        motorLBB.set(ControlMode.PercentOutput, power);
        motorRBB.set(ControlMode.PercentOutput, -power);
    }

    /**
     * Runs a specific motor at a set power
     * @param motor The motor to run
     * @param power A value between 0 and 1 indicating the power to run the motor at where 0 is full-stop and 1 is
     *              full-power.
     */
    public void runMotor(Motor motor, double power) {


        switch (motor) {

            case LEFT_LFB:
                motorLFB.set(ControlMode.PercentOutput, power);
                break;
            case LEFT_LFT:
                motorLFT.set(ControlMode.PercentOutput, power);
                break;
            case LEFT_LBT:
                motorLBT.set(ControlMode.PercentOutput, power);
                break;
            case LEFT_LBB:
                motorLBB.set(ControlMode.PercentOutput, power);
                break;
            case RIGHT_RFB:
                motorRFB.set(ControlMode.PercentOutput, power);
                break;
            case RIGHT_RFT:
                motorRFT.set(ControlMode.PercentOutput, power);
                break;
            case RIGHT_RBT:
                motorRBT.set(ControlMode.PercentOutput, power);
                break;
            case RIGHT_RBB:
                motorRBB.set(ControlMode.PercentOutput, power);
                break;
        }
    }

    /**
     * Sets follow mode, stopping all motors in the process.
     *
     * Be careful if you call this method in a `Command.execute()` that also sets a percent output, such as:
     *
     *     execute() {
     *         driveTrain.setFollowMode(false);
     *         driveTrain.runMotor(Motor.LEFT_A, 1);
     *     }
     *
     * Doing this would stop the motor, then immediately spin it back to up to full power approximately every 20ms!
     * Instead, use `Command.initialize()` to call this method so that it is only called once each time your command
     * is started:
     *
     *
     *     initialize() {
     *         driveTrain.setFollowMode(false);
     *     }
     *
     *     execute() {
     *         driveTrain.runMotor(Motor.LEFT_B, 1);
     *     }
     *
     * @param state `true` to enable follow mode or `false` to disable it.
     */
    public void setFollowMode(boolean state) {

        // Explicitly zero out power to all of the motors. This will implicitly disable follow mode if it was enabled.
        motorLFB.set(ControlMode.PercentOutput, 0);
        motorLFT.set(ControlMode.PercentOutput, 0);
        motorLBT.set(ControlMode.PercentOutput, 0);
        motorLBB.set(ControlMode.PercentOutput, 0);

        motorRFB.set(ControlMode.PercentOutput, 0);
        motorRFT.set(ControlMode.PercentOutput, 0);
        motorRBT.set(ControlMode.PercentOutput, 0);
        motorRBB.set(ControlMode.PercentOutput, 0);

        // Now explicitly enable follow mode if this was a request to turn it on.
        if (state) {
            motorLFT.follow(motorLBB);
            motorLBT.follow(motorLBB);
            motorLFB.follow(motorLBB);

            motorRFT.follow(motorRBB);
            motorRBT.follow(motorRBB);
            motorRFB.follow(motorRBB);
        }
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
        
        
        if (humanInput.gamePad.select().isPressed()) {
            left = right = 0;
        } else {
            left = Math.max(left, motorLBB.getSensorCollection().getQuadratureVelocity());
            right = Math.max(right, motorRBB.getSensorCollection().getQuadratureVelocity());
        }

        SmartDashboard.putNumber("Left Train", left);
        SmartDashboard.putNumber("Right Train", right);
    }
}
