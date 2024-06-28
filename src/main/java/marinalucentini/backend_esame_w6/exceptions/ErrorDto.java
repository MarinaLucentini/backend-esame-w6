package marinalucentini.backend_esame_w6.exceptions;

import java.time.LocalDateTime;

public record ErrorDto(String massage, LocalDateTime localDateTime) {
}
