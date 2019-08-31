package com.lirui.hrm;


import com.lirui.hrm.domain.Systemdictionary;
import com.lirui.hrm.domain.Systemdictionaryitem;
import com.lirui.hrm.service.ISystemdictionaryService;
import com.lirui.hrm.service.ISystemdictionaryitemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SysManage9001Application.class)
public class MyTest {
    @Autowired
    private ISystemdictionaryitemService iSystemdictionaryitemService;

    @Autowired
    private ISystemdictionaryService iSystemdictionaryService;
    @Test
    public void test() throws Exception {
        List<Systemdictionaryitem> systemdictionaryitems = iSystemdictionaryitemService.selectList(null);
        for (Systemdictionaryitem systemdictionaryitem : systemdictionaryitems) {
            System.out.println(systemdictionaryitem);
        }

        for (Systemdictionary systemdictionary : iSystemdictionaryService.selectList(null)) {
            System.out.println(systemdictionary);
        }
    }


}
