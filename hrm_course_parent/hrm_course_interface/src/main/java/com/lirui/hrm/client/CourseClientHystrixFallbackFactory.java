package com.lirui.hrm.client;

import com.lirui.hrm.domain.Course;
import com.lirui.hrm.query.CourseQuery;
import com.lirui.hrm.util.AjaxResult;
import com.lirui.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CourseClientHystrixFallbackFactory implements FallbackFactory<CourseClient> {

    @Override
    public CourseClient create(Throwable throwable) {
        return new CourseClient() {
            @Override
            public AjaxResult save(Course course) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public Course get(Long id) {
                return null;
            }

            @Override
            public List<Course> list() {
                return null;
            }

            @Override
            public PageList<Course> json(CourseQuery query) {
                return null;
            }
        };
    }
}
