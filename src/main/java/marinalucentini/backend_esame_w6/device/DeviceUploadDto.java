package marinalucentini.backend_esame_w6.device;

import jakarta.validation.constraints.NotEmpty;

public record DeviceUploadDto(
        @NotEmpty(message = "Il campo è obbligatorio")
        String stateDevice,
        @NotEmpty(message = "Il campo è obbligatorio")
        String employeeId
) {
}
