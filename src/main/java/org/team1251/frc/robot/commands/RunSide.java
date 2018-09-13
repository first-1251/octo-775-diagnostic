package org.team1251.frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1251.frc.robot.Motor;
import org.team1251.frc.robot.subsystems.DriveTrain;

public class RunSide extends Command {

    public enum Side { LEFT, RIGHT }

    private final Motor motor;
    private final DriveTrain driveTrain;

    public RunSide(DriveTrain driveTrain, Side side) {

        // Capture the drive train for later use and register it as required.
        this.driveTrain = driveTrain;
        requires(driveTrain);

        // We always want to run Motor A since that is the one that leads the others. We just
        // need to decide whether to run the Left-A or Right-A
        if (side == Side.LEFT) {
            this.motor = Motor.LEFT_A;
        } else {
            this.motor = Motor.RIGHT_A;
        }

    }

    @Override
    protected void initialize() {
        // We want to run the whole side of the drive train. We'll need follow mode enabled.
        driveTrain.setFollowMode(true);
    }

    @Override
    protected void execute() {
        // Run the target motor at full speed.
        driveTrain.runMotor(motor, 1);
    }

    @Override
    protected boolean isFinished() {
        // Run until cancelled or interrupted.
        return false;
    }

    @Override
    protected void end() {
        driveTrain.runMotor(motor, 0);
    }
}
