package marinalucentini.backend_esame_w6.device;

import marinalucentini.backend_esame_w6.device.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeviceRepository extends JpaRepository<Device, UUID> {
}
