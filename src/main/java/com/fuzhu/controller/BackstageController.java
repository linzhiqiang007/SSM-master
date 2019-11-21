package com.fuzhu.controller;

import com.fuzhu.entity.User;
import com.fuzhu.service.UserService;
import com.fuzhu.utils.CookieUtil;
import com.fuzhu.utils.JavaWebToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 符柱成 on 2017/4/28.
 */
@Controller
@RequestMapping("/backend")
public class BackstageController {

    @RequestMapping(value = "/loginPage", method = {RequestMethod.GET})
    public String loginPage(HttpServletRequest request, String account, String password) {
        return "login";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public String login(HttpServletRequest request, HttpServletResponse response, RedirectAttributes model, String account, String password) {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        System.out.println("账号：" + user.getAccount());
        System.out.println("密码：" + user.getPassword() + " " + new Date());
        if ("linzhiqiang".equals(account) && "123456".equals(password)) {
            Map<String, Object> loginInfo = new HashMap<>();
            loginInfo.put("isLogin", "yes!");
            loginInfo.put("timestamp", new Date());
            String sessionId = JavaWebToken.createJavaWebToken(loginInfo);
            CookieUtil.addCookie(response, "isLogin", sessionId);
            //return "redirect:http://wechat.qqyqh.com/qqyqh/login.html";
            return "success";
        } else {
            model.addFlashAttribute("error", "密码错误");
            return "redirect:loginPage";
        }
    }
    @RequestMapping(value = "/loginSuccess", method = {RequestMethod.GET})
    public String accusationPage(HttpServletRequest request) {
        return "success";
    }
    @RequestMapping(value = "/logOut", method = {RequestMethod.GET})
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.deleteCookie(response,"isLogin");
        return "redirect:loginPage";
    }
}
