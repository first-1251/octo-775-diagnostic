package org.team1251.frc.robot;

import org.team1251.frc.robot.robotMap.DeviceAssignment;

/**
 * Used to identify/select a specific motor.
 */
public enum Motor {
    LEFT_A(false, DeviceAssignment.DRIVE_LEFT_A),
    LEFT_B(false, DeviceAssignment.DRIVE_LEFT_B),
    LEFT_C(false, DeviceAssignment.DRIVE_LEFT_C),
    LEFT_D(false, DeviceAssignment.DRIVE_LEFT_D),
    RIGHT_A(false, DeviceAssignment.DRIVE_RIGHT_A),
    RIGHT_B(false, DeviceAssignment.DRIVE_RIGHT_B),
    RIGHT_C(false, DeviceAssignment.DRIVE_RIGHT_C),
    RIGHT_D(false, DeviceAssignment.DRIVE_RIGHT_D);

    private final boolean inverted;

    public boolean isInverted() {
        return inverted;
    }

    public DeviceAssignment getDeviceAssignment() {
        return deviceAssignment;
    }

    private final DeviceAssignment deviceAssignment;

    Motor(boolean inverted, DeviceAssignment deviceAssignment) {
        this.inverted = inverted;
        this.deviceAssignment = deviceAssignment;
    }
}
