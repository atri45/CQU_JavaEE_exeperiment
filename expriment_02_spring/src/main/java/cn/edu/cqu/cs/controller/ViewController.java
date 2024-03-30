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
public class ViewController extends BaseController{

    @Override
    public void function(String folder, String file) {
        FileService.view(folder, file);
    }
}
