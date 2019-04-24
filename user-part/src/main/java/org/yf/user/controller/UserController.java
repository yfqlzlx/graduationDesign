package org.yf.user.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.web.bind.annotation.*;
import org.yf.common.vo.LoginVo;
import org.yf.common.entity.User;
import org.yf.common.response.Response;
import org.yf.user.service.IUserService;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author yfqlzlx
 * @date 2019/4/13 14:40
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private IUserService userService;
    private DefaultKaptcha defaultKaptcha;
    public UserController(IUserService userService,DefaultKaptcha defaultKaptcha){
        this.defaultKaptcha = defaultKaptcha;
        this.userService = userService;
    }

    /**
     * 用户注册
     * @param user 用户
     * @return response
     */
    @PostMapping(value = "/registry")
        public Response registry(@RequestBody User user){
        if(userService.isExist(user)){
            return new Response(405,"用户已存在");
        }
        if(userService.addUser(user)){
            return new Response(200);
        }
        return new Response(500);
    }

    /**
     * 登录
     * @param vo 输入的账号密码和验证码
     * @return response
     */
    @PostMapping(value = "/login")
    public Response login(@RequestBody LoginVo vo, HttpServletRequest request){
        System.out.println(vo);
        if(!vaildCode(request,vo.getVaildCode())){
            return new Response(406,"验证码错误");
        }
        User user = new User().setUsername(vo.getUsername()).setPassword(vo.getPassword());
        User dbUser = userService.login(user);
        if(dbUser != null){
            // 保存登录信息
            request.getSession().setAttribute("userStore",dbUser);
            return new Response(200,dbUser.getId());
        }
        return new Response(405);
    }

    /**
     * 退出登录
     * @param httpSession
     * @return
     */
    @PutMapping(value = "/logout")
    public Response logout(HttpSession httpSession){
        return new Response(200);
    }

    /**
     * 获取验证码
     * @param httpServletRequest request
     * @param httpServletResponse response
     * @throws IOException
     */
    @GetMapping(value = "/validImg")
    public void getValidImg(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws IOException {
        byte[] imgBytes ;
        ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
        try{
            String text = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("validCode", text);
            BufferedImage challenge = defaultKaptcha.createImage(text);
            ImageIO.write(challenge, "jpg", imgOutputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        imgBytes = imgOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(imgBytes);
        responseOutputStream.flush();
        responseOutputStream.close();
    }


    /**
     * 验证验证码是否输入正确
     * @param request request
     * @param vaildCode 输入的验证码
     * @return 是否正确
     */
    private boolean vaildCode(HttpServletRequest request, String vaildCode) {
        String standardCode = (String) request.getSession().getAttribute("validCode");
        System.out.println("standardCode:"+standardCode);
        return standardCode.equals(vaildCode);
    }

}
