package marinalucentini.backend_esame_w6.device;

import marinalucentini.backend_esame_w6.device.entities.Device;
import marinalucentini.backend_esame_w6.employee.Employee;
import marinalucentini.backend_esame_w6.employee.EmployeeResponseDto;
import marinalucentini.backend_esame_w6.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
    @GetMapping
    public Page<Device> getDevice (@RequestParam (defaultValue = "0")int page, @RequestParam (defaultValue = "5")int size){
        return deviceService.getEmployee(page, size);
    }
    @GetMapping("/{deviceId}")
    public Device getDeviceById (@PathVariable UUID deviceId){
        return  deviceService.findById(deviceId);
    }
//    @PutMapping("/{employeeId}")
//    public Employee putEmployee (@PathVariable UUID employeeId, @RequestBody Employee employee){
//        return employeeService.findAndUpload(employeeId, employee);
//    }
//    @DeleteMapping("{employeeId}")
//    public void deleteEmployee(@PathVariable UUID employeeId){
//        employeeService.findByIdAndDelete(employeeId);
//    }

}
