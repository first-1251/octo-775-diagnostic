package org.team1251.frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1251.frc.robot.Motor;
import org.team1251.frc.robot.subsystems.DriveTrain;

public class RunMotor extends Command {

    private final DriveTrain driveTrain;
    private final Motor motor;

    public RunMotor(DriveTrain driveTrain, Motor motor) {
        this.driveTrain = driveTrain;
        this.motor = motor;
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        driveTrain.setFollowMode(false);
    }

    @Override
    protected void execute() {
        driveTrain.runMotor(motor, 1);
    }

    @Override
    protected void end() {
        driveTrain.runMotor(motor, 0);
    }

    @Override
    protected boolean isFinished() {
        // Run until cancelled
        return false;
    }
}
