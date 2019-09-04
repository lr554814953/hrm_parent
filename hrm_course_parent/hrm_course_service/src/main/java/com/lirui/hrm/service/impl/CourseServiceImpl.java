package com.lirui.hrm.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lirui.hrm.domain.Course;
import com.lirui.hrm.mapper.CourseDetailMapper;
import com.lirui.hrm.mapper.CourseMapper;
import com.lirui.hrm.query.CourseQuery;
import com.lirui.hrm.service.ICourseService;
import com.lirui.hrm.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lirui
 * @since 2019-09-03
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {

    @Autowired
    private CourseMapper mapper;
    @Autowired
    private CourseDetailMapper detailMapper;
    @Override
    public PageList<Course> selectListPage(CourseQuery query) {
        Page<Course> page = new Page<>(query.getPage(),query.getRows());
        List<Course> rows =  mapper.loadListPage(page,query);
        return new PageList<>(page.getTotal(),rows);
    }

    @Override
    public boolean insert(Course entity) {
        //保存课程
        entity.setStatus(0); // tenantId tenantName userId userName
        mapper.insert(entity);
        //保存关联对象课程详情
        entity.getDetail().setCourseId(entity.getId());
        detailMapper.insert(entity.getDetail());
        return true;
    }
}
