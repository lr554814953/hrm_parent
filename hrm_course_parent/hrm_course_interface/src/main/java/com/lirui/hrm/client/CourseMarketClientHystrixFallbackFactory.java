package com.lirui.hrm.client;

import com.lirui.hrm.domain.CourseMarket;
import com.lirui.hrm.query.CourseMarketQuery;
import com.lirui.hrm.util.AjaxResult;
import com.lirui.hrm.util.PageList;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lirui
 * @date 2018/10/8-16:18
 */
@Component
public class CourseMarketClientHystrixFallbackFactory implements FallbackFactory<CourseMarketClient> {

    @Override
    public CourseMarketClient create(Throwable throwable) {
        return new CourseMarketClient() {
            @Override
            public AjaxResult save(CourseMarket courseMarket) {
                return null;
            }

            @Override
            public AjaxResult delete(Integer id) {
                return null;
            }

            @Override
            public CourseMarket get(Long id) {
                return null;
            }

            @Override
            public List<CourseMarket> list() {
                return null;
            }

            @Override
            public PageList<CourseMarket> json(CourseMarketQuery query) {
                return null;
            }
        };
    }
}
