package org.team1251.frc.robot.robotMap;

import org.team1251.frc.robotCore.robotMap.Assignment;
import org.team1251.frc.robotCore.robotMap.PortAssignable;
import org.team1251.frc.robotCore.robotMap.PortType;


/**
 * List all devices (sensors, actuators, motor controllers, etc) in this enum.
 */
public enum DeviceAssignment implements PortAssignable {

    // Replace with devices for your robot
    // TODO: Set up the correct CAN ports
    DRIVE_LEFT_A(PortType.CAN, 0),
    DRIVE_LEFT_B(PortType.CAN, 1),
    DRIVE_LEFT_C(PortType.CAN, 2),
    DRIVE_LEFT_D(PortType.CAN, 3),
    DRIVE_RIGHT_A(PortType.CAN, 4),
    DRIVE_RIGHT_B(PortType.CAN, 5),
    DRIVE_RIGHT_C(PortType.CAN, 6),
    DRIVE_RIGHT_D(PortType.CAN, 7);

    /**
     * Port assignment for each Device
     */
    private final Assignment assignment;

    /**
     * @param portType The port type that the device is attached to
     * @param port The port the device is attached to.
     */
    DeviceAssignment(PortType portType, int port) {
        this.assignment = new Assignment(portType, port);
    }

    @Override
    public Assignment getAssignment() {
        return assignment;
    }
}