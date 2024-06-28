package marinalucentini.backend_esame_w6.employee;

import marinalucentini.backend_esame_w6.exceptions.BadRequestException;
import marinalucentini.backend_esame_w6.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService {
   @Autowired
    EmployeeRepository employeeRepository;

public Employee saveEmployee(EmployeeDto employeeDto){
employeeRepository.findByEmail(employeeDto.email()).ifPresent(
employee -> {
    throw new BadRequestException("L'email " + employeeDto.email() + " è già in uso!");
}
);
Employee employeeForDb = new Employee(employeeDto.name(), employeeDto.surname(), employeeDto.email(), employeeDto.username());
employeeForDb.setUrlavatar("https://unsplash.com/it/foto/donna-in-camicia-nera-sorridente-lNNHyRbmm0o");
return employeeRepository.save(employeeForDb);
}


public Page<Employee> getEmployee(int page, int size, String sortBy){
if(size > 50) size = 50;
Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
  return   employeeRepository.findAll(pageable);
}
public Employee findById(UUID id){
return employeeRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
}
public Employee findAndUpload(UUID id, Employee employee){
    Employee found= findById(id);
    found.setEmail(employee.getEmail());
    found.setName(employee.getName());
    found.setSurname(employee.getSurname());
    found.setUrlavatar("https://unsplash.com/it/foto/donna-in-camicia-nera-sorridente-lNNHyRbmm0o");
    found.setUsername(employee.getUsername());
    return   employeeRepository.save(found);
}
}
