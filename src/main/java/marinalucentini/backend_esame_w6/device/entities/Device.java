package marinalucentini.backend_esame_w6.device.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import marinalucentini.backend_esame_w6.device.enums.StateDevice;
import marinalucentini.backend_esame_w6.device.enums.TypeDevice;
import marinalucentini.backend_esame_w6.employee.Employee;

import java.util.UUID;
@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Device {
    @Id
    @GeneratedValue
private UUID id;
    @Enumerated(EnumType.STRING)
    private TypeDevice typeDevice;
    @Enumerated(EnumType.STRING)
    private StateDevice stateDevice;
    @ManyToOne
    @JoinColumn (name = "employee_id")
    private Employee employee;

    public Device(TypeDevice typeDevice, StateDevice stateDevice) {
        this.typeDevice = typeDevice;
        this.stateDevice = stateDevice;
    }
}
