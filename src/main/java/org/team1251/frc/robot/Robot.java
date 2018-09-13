package org.team1251.frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.team1251.frc.robot.commands.RunMotor;
import org.team1251.frc.robot.commands.RunSide;
import org.team1251.frc.robot.humanInterface.input.HumanInput;
import org.team1251.frc.robot.subsystems.DriveTrain;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    /**
     * Input from my master(s).
     */
    private HumanInput humanInput;


    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {


    }


    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit() {

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
     * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
     * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
     * below the Gyro
     * <p>1
     * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
     * or additional comparisons to the switch structure below with additional strings & commands.
     */
    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {

        DriveTrain driveTrain = new DriveTrain();

        RunMotor runMotorLeftA = new RunMotor(driveTrain, Motor.LEFT_A);
        RunMotor runMotorLeftB = new RunMotor(driveTrain, Motor.LEFT_B);

        // TODO: Create the rest of the commands
        RunMotor runMotorLeftC = null;
        RunMotor runMotorLeftD = null;
        RunMotor runMotorRightA = null;
        RunMotor runMotorRightB = null;
        RunMotor runMotorRightC = null;
        RunMotor runMotorRightD = null;
        RunSide runLeft = null;
        RunSide runRight = null;

        humanInput = new HumanInput();
        humanInput.attachCommandTriggers(
                runMotorLeftA, runMotorLeftB, runMotorLeftC, runMotorLeftD,
                runMotorRightA, runMotorRightB, runMotorRightC, runMotorRightD,
                runLeft, runRight
        );

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {

    }

}