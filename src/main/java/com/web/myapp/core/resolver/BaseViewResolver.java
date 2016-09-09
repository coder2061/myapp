package com.web.myapp.core.resolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

/**   
 * Function: 自定义视图解析(通过配置实现多视图整合,如jsp,freemarker,velocity,pdf,excel...)
 * @author jiangyf   
 * @since 2016年9月9日 上午11:59:34 
 * @version V1.0   
 */
public class BaseViewResolver implements ViewResolver  {
    private static Log logger = LogFactory.getLog(BaseViewResolver.class);
    
    //视图解析器集合
    private Map<Set<String>,ViewResolver> viewResolverMap = new HashMap<Set<String>,ViewResolver>();
    
    //默认视图解析器
    private ViewResolver defaultViewResolver = null;
    
    public View resolveViewName(String viewName, Locale locale) throws Exception {
       if(defaultViewResolver != null) {
           return defaultViewResolver.resolveViewName(viewName, locale);
       }
       //获取对应的视图解析器
       for(Map.Entry<Set<String>, ViewResolver> map : viewResolverMap.entrySet()) {
    	   Set<String> suffixs = map.getKey();
    	   for(String suffix : suffixs){
    		   if (viewName.endsWith(suffix)) {
    			   ViewResolver viewResolver = map.getValue();
    			   if(null != viewResolver){
    				   if (logger.isDebugEnabled()) {
    					   logger.debug("found viewResolver '" + viewResolver + "' for viewName '" + viewName+ "'");
    				   }
    				   return viewResolver.resolveViewName(viewName, locale);
    			   }
    		   }
    	   }
       }
       // to allow for ViewResolver chaining
       return null;
    }

    public Map<Set<String>, ViewResolver> getViewResolverMap() {
        return viewResolverMap;
    }

    public void setViewResolverMap(Map<Set<String>, ViewResolver> viewResolverMap) {
        this.viewResolverMap = viewResolverMap;
    }

    public ViewResolver getDefaultViewResolver() {
        return defaultViewResolver;
    }

    public void setDefaultViewResolver(ViewResolver defaultViewResolver) {
        this.defaultViewResolver = defaultViewResolver;
    }
}
