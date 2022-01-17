package guru.springmk.springbootactuator.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {
    @ResponseBody
    @RequestMapping(path = "/")
    public String home(HttpServletRequest request){
        String contextPath = request.getContextPath();
        String host = request.getServerName();

        String endpointBasePath = "/actuator";
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>Sprig Boot Actuator</h2>");
        sb.append("<ul>");

        // http://localhost:8090/actuator
        String url = "http://" + host + ":8090" + contextPath + endpointBasePath;
        sb.append("<li><a href='" + url + "'>" + url + "</a></li>");
        sb.append("</ul>");
        return sb.toString();
    }
}
