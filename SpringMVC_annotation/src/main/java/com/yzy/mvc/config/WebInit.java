package com.yzy.mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @ClassName WebInit
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-04-01 16:18
 * @Version
 **/

//web工程的初始化类，用来代替web.xml
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 指定Spring配置类
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 16:23 2022/4/1
     * @param
     * @return java.lang.Class<?>[]
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 指定SpringMVC配置类
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 16:24 2022/4/1
     * @param
     * @return java.lang.Class<?>[]
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * 指定DispatcherServlet的映射规则，即url-pattern
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 16:24 2022/4/1
     * @param
     * @return java.lang.String[]
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 配置过滤器
     * @Description TODO
     * @author yzy 729141789@qq.com
     * @Date 16:31 2022/4/1
     * @param
     * @return javax.servlet.Filter[]
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{characterEncodingFilter, hiddenHttpMethodFilter};
    }
}
