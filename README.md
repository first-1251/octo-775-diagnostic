# 8-motor 775 Drive Train Diagnostic

This robot program is focused on diagnosis and trouble-shooting of our 8-motor 775 Drive Train --
specifically the one which is currently on Clawzilla

# Motor Layout

For the purposes of this project, the motors on each side of the drive train are identified 
as A-D using the following diagram

        MOTOR POSITIONS

          ---   ---         F
         | A | | B |        R
          ---   ---         O
     ---            ---     N
    | C |          | D |    T
     ---            ---
     
Motor A (on each side )is the "lead" motor -- it is (should be) controlled via a `TalonSRX` which -- 
during normal operations -- is leading the 3 `VictorSPX` which are controlling the remaining motors.