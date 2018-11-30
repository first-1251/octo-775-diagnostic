package org.team1251.frc.robot.humanInterface.input;

import edu.wpi.first.wpilibj.Joystick;
import org.team1251.frc.robot.commands.RunMotor;
import org.team1251.frc.robot.commands.RunSide;
import org.team1251.frc.robotCore.humanInterface.input.SimpleAnalogButtonConfig;
import org.team1251.frc.robotCore.humanInterface.input.SimpleStickConfig;
import org.team1251.frc.robotCore.humanInterface.input.gamepad.GamePad;
import org.team1251.frc.robotCore.humanInterface.input.gamepad.ModernGamePad;
import org.team1251.frc.robotCore.humanInterface.input.triggers.ButtonTrigger;

/**
 * The HumanInput encapsulates everything related to human input and provides a clean interface for all commands and
 * subsystems to use.
 *
 * All knowledge about which buttons/sticks do what is contained within this class -- no other code should be reading
 * directly from the driver input devices. By centralizing this knowledge, it becomes much easier to adjust the control
 * scheme since it is not scattered throughout the code base. This also uses "information hiding" to make sure that
 * the rest of the robot does care about the details of how driver input is interpreted.
 */
public class HumanInput {

    /**
     * Indicates that command triggers have already been attached.
     */
    private boolean commandTriggersAttached = false;

    /**
     * The primary input device
     */
    public GamePad gamePad;

    /**
     * Creates a new instance
     */
    public HumanInput() {
        gamePad = new ModernGamePad(
                new Joystick(0),
                new SimpleStickConfig(.05, false, false),
                new SimpleStickConfig(.05, false, false),
                new SimpleAnalogButtonConfig(.05, .50),
                new SimpleAnalogButtonConfig(.05, .50)
        );
    }

    /**
     * Attaches human-input related triggers to commands.
     *
     * This method should only ever be called once.
     *
     * ** WARNING **
     * runMotorLFB, runMotorLFT, runMotorLBT, runMotorLBB,
     *                 runMotorRFB, runMotorRFT, runMotorRBT, runMotorRBB,
     *
     * There is no built-in way to detach a command trigger. There is no built-in protection against
     * attaching two commands to the same trigger.
     */
    public void attachCommandTriggers(
            RunMotor runMotorLFB,
            RunMotor runMotorLFT,
            RunMotor runMotorLBT,
            RunMotor runMotorLBB,
            RunMotor runMotorRFB,
            RunMotor runMotorRFT,
            RunMotor runMotorRBT,
            RunMotor runMotorRBB,
            RunSide runLeft,
            RunSide runRight) {

        // This the typical way to prevent duplicate bindings.
        if (commandTriggersAttached) {
            return;
        }
        commandTriggersAttached = true;

        // Triggers for each of the left motors
        new ButtonTrigger(gamePad.a()).whileHeld(runMotorLFB);
        new ButtonTrigger(gamePad.b()).whileHeld(runMotorLFT);
        new ButtonTrigger(gamePad.x()).whileHeld(runMotorLBT);
        new ButtonTrigger(gamePad.y()).whileHeld(runMotorLBB);

        // Triggers for each of the right motors
        new ButtonTrigger(gamePad.lt()).whileHeld(runMotorRFB);
        new ButtonTrigger(gamePad.lb()).whileHeld(runMotorRFT);
        new ButtonTrigger(gamePad.rt()).whileHeld(runMotorRBT);
        new ButtonTrigger(gamePad.rb()).whileHeld(runMotorRBB);

        // Use the thumb stick buttons to run full left or full right
//        new ButtonTrigger(gamePad.lsClick()).whileHeld(runLeft);
//        new ButtonTrigger(gamePad.rsClick()).whileHeld(runRight);
    }

    public double getDriveStraightPower() {
        return gamePad.ls().getVertical();
    }
}