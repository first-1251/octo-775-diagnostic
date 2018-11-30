package org.team1251.frc.robot.robotMap;

import org.team1251.frc.robotCore.robotMap.Assignment;
import org.team1251.frc.robotCore.robotMap.PortAssignable;
import org.team1251.frc.robotCore.robotMap.PortType;


/**
 * List all devices (sensors, actuators, motor controllers, etc) in this enum.
 */
public enum DeviceAssignment implements PortAssignable {

    // Replace with devices for your robot
    DRIVE_LEFT_FRONT_BOTTOM(PortType.CAN, 12),
    DRIVE_LEFT_FRONT_TOP(PortType.CAN, 13),
    DRIVE_LEFT_BACK_TOP(PortType.CAN, 14),
    DRIVE_LEFT_BACK_BOTTOM(PortType.CAN, 15),
    DRIVE_RIGHT_FRONT_BOTTOM(PortType.CAN, 3),
    DRIVE_RIGHT_FRONT_TOP(PortType.CAN, 2),
    DRIVE_RIGHT_BACK_TOP(PortType.CAN, 1),
    DRIVE_RIGHT_BACK_BOTTOM(PortType.CAN, 0);

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