package com.lirui.hrm.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.lirui.hrm.domain.Systemdictionary;
import com.lirui.hrm.domain.Systemdictionaryitem;
import com.lirui.hrm.mapper.SystemdictionaryMapper;
import com.lirui.hrm.mapper.SystemdictionaryitemMapper;
import com.lirui.hrm.service.ISystemdictionaryitemService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lirui
 * @since 2019-08-30
 */
@Service
public class SystemdictionaryitemServiceImpl extends ServiceImpl<SystemdictionaryitemMapper, Systemdictionaryitem> implements ISystemdictionaryitemService {


    private Logger logger = LoggerFactory.getLogger(SystemdictionaryitemServiceImpl.class);
    @Autowired
    private SystemdictionaryMapper systemdictionaryMapper;
    @Autowired
    private SystemdictionaryitemMapper systemdictionaryitemMapper;

    //前台传入数据字典类型，查询数据字典类型明细
    @Override
    public List<Systemdictionaryitem> listByParentSn(String sn) {
        Wrapper<Systemdictionary> wrapper = new EntityWrapper<Systemdictionary>().eq("sn", sn);
        //select * from t_Systemdictionary
        //Wrapper(EntityWrapper)可以用它封装查询条件
        //Wrapper.eq表示等于 eq("sn","courseLevel")
        //select * from t_Systemdictionary where sn = courseLevel
        List<Systemdictionary> systemdictionaries = systemdictionaryMapper.selectList(wrapper);
        if (systemdictionaries == null || systemdictionaries.size()<1){
            logger.error("数据字典类型不存在");
            return null;
        }
        Systemdictionary systemdictionary = systemdictionaries.get(0);
        EntityWrapper<Systemdictionaryitem> wrapper1 = new EntityWrapper<>();

        // where parent_id = #{id}
        wrapper1.eq("parent_id",systemdictionary.getId());
        return systemdictionaryitemMapper.selectList(wrapper1);
    }
}
