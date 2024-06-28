package marinalucentini.backend_esame_w6.device;

import jakarta.validation.constraints.NotEmpty;

public record DeviceDto(
        @NotEmpty (message = "Il tipo del dispositivo è obbligatorio")
        String typeDevice,
        @NotEmpty(message = "Lo stato del dispositivo è obbligatorio")
        String stateDevice
) {
}
