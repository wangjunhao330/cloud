package com.wang.authorize.webapi;

import com.wang.authorize.entity.LoginRequest;
import com.wang.authorize.entity.User;
import com.wang.authorize.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.JsonUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * token认证类Controller类
 *
 * @author wangjunhao
 * @version 1.0
 * @date 2020/1/4 18:33
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/authorize")
public class AuthorizeController {
    private Logger logger = LoggerFactory.getLogger(AuthorizeController.class);

    @Resource(name = "logService")
    private LogService logService;

    @PostMapping(value = "/login")
    public String login(@Valid LoginRequest loginRequest) {
        User user = new User();
        user.setUsernmae(loginRequest.getUsername());
        user.setPassword(loginRequest.getPassword());
        ResponseEntity entity = new ResponseEntity(logService.getToken(user), HttpStatus.OK);

        return JsonUtils.objectToJson(entity);
    }

    @PostMapping("/auth")
    public String auth(HttpServletRequest request) {
        User user = logService.parseToken(request.getParameter("token"));
        ResponseEntity entity = new ResponseEntity(user, HttpStatus.OK);
        return JsonUtils.objectToJson(entity);
    }
}
