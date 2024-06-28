package marinalucentini.backend_esame_w6.device;

import marinalucentini.backend_esame_w6.device.entities.Device;
import marinalucentini.backend_esame_w6.employee.EmployeeResponseDto;
import marinalucentini.backend_esame_w6.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    DeviceService deviceService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeviceResponseDto saveDevice(@RequestBody @Validated DeviceDto deviceDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors());
        }
        return new DeviceResponseDto(deviceService.saveDevice(deviceDto).getId());
    }

}
