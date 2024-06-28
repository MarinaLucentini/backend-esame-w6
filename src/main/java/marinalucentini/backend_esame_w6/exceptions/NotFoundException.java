package marinalucentini.backend_esame_w6.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException{
    public NotFoundException(UUID id) {
        super("Record con id " + id + " non trovato!");
    }
}
