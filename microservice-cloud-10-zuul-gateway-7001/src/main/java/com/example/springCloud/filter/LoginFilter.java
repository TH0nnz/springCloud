package com.example.springCloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
public class LoginFilter extends ZuulFilter {
    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 返回值可取：
     * - pre：在請求路由之前執行
     * - route：在請求路由時調用
     * - error：處理請求發生錯誤時調用
     * - post：請求路由之後調用， 也就是在route和error過濾器之後調用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0; //返回值是int，會根據返回值進行定義過濾器的執行順序，值越小優先級越大
    }

    @Override
    public boolean shouldFilter() {
        return true; //當前過濾器是否被執行，true則執行，false不執行
    }

    //定義 過濾功能
    @Override
    public Object run() throws ZuulException {

        //獲取請求上下文
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        //如果說請求帶了token值，則表示已經登錄過
        if(token == null) {
            logger.warn("此操作需要先登錄系統");
            //沒有登錄 過，則不進行路由轉發
            context.setSendZuulResponse(false);//拒絕訪問
            context.setResponseStatusCode(200); //響應狀態碼
            try {
                context.getResponse().getWriter().write("token is empty...");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        //通過，會進行路由轉發
        logger.info("通過，會進行路由轉發");
        return null;
    }
}