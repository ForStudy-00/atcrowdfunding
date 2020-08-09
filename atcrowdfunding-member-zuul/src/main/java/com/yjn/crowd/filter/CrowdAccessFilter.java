package com.yjn.crowd.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.yjn.crowd.constant.AccessPassResources;
import com.yjn.crowd.constant.CrowdConstant;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author: yjn
 * @Date: 2020/7/22 20:09
 */
@Component
public class CrowdAccessFilter extends ZuulFilter {
    @Override
    public String filterType() {

        //返回pre是表示在目标微服务执行前过滤
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        // 1.获取 RequestContext 对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = requestContext.getRequest();
        String servletPath = request.getServletPath();

        boolean containsResult = AccessPassResources.PASS_RES_SET.contains(servletPath);
        if (containsResult){
            return false;
        }
        return !AccessPassResources.judgeCurrentServletPathWhetherStaticResource(servletPath);
    }

    @lombok.SneakyThrows
    @Override
    public Object run() throws ZuulException {
        //获取当前请求对象
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //获取当前session对象
        HttpSession session = request.getSession();
        //尝试从session对象中获取已登录的用户
        Object loginMember = session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);
        //判断loginMember是否为空
        if (loginMember==null){
            session.setAttribute(CrowdConstant.ATTR_NAME_MESSAGE, CrowdConstant.MESSAGE_ACCESS_FORBIDEN);
            //获取response对象
            HttpServletResponse response = currentContext.getResponse();
            response.sendRedirect("/auth/member/to/login/page");
        }
        return null;
    }
}
