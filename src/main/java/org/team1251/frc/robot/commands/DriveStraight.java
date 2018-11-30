package org.team1251.frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.team1251.frc.robot.humanInterface.input.HumanInput;
import org.team1251.frc.robot.subsystems.DriveTrain;

public class DriveStraight extends Command {

    private final DriveTrain driveTrain;
    private final HumanInput humanInput;

    public DriveStraight(DriveTrain driveTrain, HumanInput humanInput) {
        this.driveTrain = driveTrain;
        this.humanInput = humanInput;
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        driveTrain.setFollowMode(false);
    }

    @Override
    protected void execute() {
        driveTrain.driveStraight(humanInput.getDriveStraightPower());
    }

    @Override
    protected void end() {
        driveTrain.driveStraight(0);
    }

    @Override
    protected boolean isFinished() {
        // Run until cancelled
        return false;
    }
}
