package marinalucentini.backend_esame_w6.employee;

import marinalucentini.backend_esame_w6.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
}
