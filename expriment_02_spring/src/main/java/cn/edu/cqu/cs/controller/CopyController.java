package cn.edu.cqu.cs.controller;

import cn.edu.cqu.cs.service.FileService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class CopyController extends BaseController{

    @Override
    public void function(String param) {
        String[] params = param.split(",");
        if (params.length == 2) {
            String sourcePath = params[0];
            String targetPath = params[1];
            FileService.copy(sourcePath, targetPath);
        }
        else if (params.length == 3) {
            String sourcePath = params[0];
            String targetPath = params[1];
            String bg = params[2];
            if (bg.equals("bg")) {
                FileService.threadCopy(sourcePath, targetPath);
            }
            else {
                System.out.println("Invalid params:" + bg);
            }
        }
        else {
            System.out.println("Invalid params:" + param);
        }

    }
}
