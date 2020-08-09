package com.yjn.crowd.handler;

import com.yjn.crowd.vo.ProjectVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: yjn
 * @Date: 2020/8/9 20:32
 */
@Controller
public class ProjectConsumerHandler {
    @RequestMapping("/create/project/information")
    public  String saveProjectBasicInfo(
            ProjectVO projectVO,
            MultipartFile headerPicture,
            List<MultipartFile> detailPictureList,
            HttpSession session,
            ModelMap modelMap
    ){
        System.out.println("haha");
        return null;
    }
}
