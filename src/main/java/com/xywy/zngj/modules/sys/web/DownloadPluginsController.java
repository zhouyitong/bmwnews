package com.xywy.zngj.modules.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: lyp
 * Create Date: 2018/1/30
 * Description:
 */
@Controller
@RequestMapping("${adminPath}/download")
public class DownloadPluginsController {

    @RequestMapping(value = "plugins")
    public void plugin(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect(request.getContextPath() + "/plugins/plugins.zip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
