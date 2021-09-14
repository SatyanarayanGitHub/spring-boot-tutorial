package com.srysoft.springboot.tutorial.service;

import com.srysoft.springboot.tutorial.entity.Department;
import com.srysoft.springboot.tutorial.repository.DepartmentRepository;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department department1 = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department) && Objects.nonNull(department.getDepartmentName()) && !department.getDepartmentName().isEmpty()) {
            department1.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department) && Objects.nonNull(department.getDepartmentAddress()) && !department.getDepartmentAddress().isEmpty()) {
            department1.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(department) && Objects.nonNull(department.getDepartmentCode()) && !department.getDepartmentCode().isEmpty()) {
            department1.setDepartmentCode(department.getDepartmentCode());
        }


        return departmentRepository.save(department1);
    }
}
