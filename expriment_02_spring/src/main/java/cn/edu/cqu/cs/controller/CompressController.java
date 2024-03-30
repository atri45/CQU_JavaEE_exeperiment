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
public class CompressController extends BaseController{

    @Override
    public void function(String param) {
        String[] params = param.split(",");
        if (params.length == 2) {
            String sourceFilePath = params[0];
            String compressFilePath = params[1];
            FileService.compress(sourceFilePath, compressFilePath);
        }
        else {
            System.out.println("Invalid params:" + param);
        }
    }
}
