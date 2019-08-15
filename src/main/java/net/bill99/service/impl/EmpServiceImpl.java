package net.bill99.service.impl;

import net.bill99.dao.EmpDao;
import net.bill99.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public int getEmpCout() {
       return empDao.getEmpCount();
    }
}
