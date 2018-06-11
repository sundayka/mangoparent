package mango.serviceImpl;

import mango.mapper.TestMapper;
import mango.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Override
    public String queryNow() {
        System.out.println("TestServiceImpl");
        return testMapper.queryNow();
    }
}
