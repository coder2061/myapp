package com.web.myapp.demo.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**   
 * Websocet服务端实现（注册实现类）
 * @author jiangyf   
 * @since 2016年9月8日 下午2:41:57 
 * @version V1.0   
 */
@Configuration	//spring依赖注入，并且支持springmvc和websocket
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    	//用来注册websocket server实现类，第二个参数是访问websocket的地址
        registry.addHandler(systemWebSocketHandler(),"/webSocketServer")
        		.addInterceptors(new WebSocketHandshakeInterceptor());
        //使用Sockjs的注册方法
        registry.addHandler(systemWebSocketHandler(), "/sockjs/webSocketServer")
        		.addInterceptors(new WebSocketHandshakeInterceptor())
                .withSockJS();
    }

    @Bean
    public WebSocketHandler systemWebSocketHandler(){
        return new SystemWebSocketHandler();
    }

}
