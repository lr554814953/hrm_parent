package com.lirui.hrm.service;

import com.baomidou.mybatisplus.service.IService;
import com.lirui.hrm.domain.Course;
import com.lirui.hrm.query.CourseQuery;
import com.lirui.hrm.util.PageList;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lirui
 * @since 2019-09-03
 */
public interface ICourseService extends IService<Course> {

    /**
     * 分页+高级查询+关联查询
     * @param query
     * @return
     */
    PageList<Course> selectListPage(CourseQuery query);
}
