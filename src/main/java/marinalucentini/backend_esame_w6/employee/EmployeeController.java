package marinalucentini.backend_esame_w6.employee;

import marinalucentini.backend_esame_w6.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eployees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
public  EmployeeResponseDto employeeResponseDto  (@RequestBody @Validated EmployeeDto employeeDto, BindingResult bindingResult){
if(bindingResult.hasErrors()){
    throw new BadRequestException(bindingResult.getAllErrors());
}
return new EmployeeResponseDto( employeeService.saveEmployee(employeeDto).getId());
    }
}
