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
public class DecompressController extends BaseController{

    @Override
    public void function(String param) {
        String[] params = param.split(",");
        if (params.length == 2) {
            String zipFilePath = params[0];
            String decompressFolderPath = params[1];
            FileService.decompress(zipFilePath, decompressFolderPath);
        }
        else {
            System.out.println("Invalid params:" + param);
        }
    }
}
