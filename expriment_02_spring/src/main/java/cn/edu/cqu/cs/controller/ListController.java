package cn.edu.cqu.cs.controller;

import cn.edu.cqu.cs.entity.MyFile;
import cn.edu.cqu.cs.service.FileService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
public class ListController extends BaseController{

    private List<MyFile> files;

    @Override
    public void show() {
        if (!files.isEmpty()) {
            System.out.format("-----------------------------------------------------------------\n");
            System.out.format("|         %-8s        |    %-4s   |     %-16s    |\n", "FileName", "Size", "LastModifiedTime");
            System.out.format("-----------------------------------------------------------------\n");
            for (MyFile file : files) {
                System.out.format("| %-23s | %-9s | %-24s|\n", file.getName(), file.getSize() + "B", file.getTime());
                System.out.format("-----------------------------------------------------------------\n");
            }
        }
    }

    @Override
    public void function(String dirPath) {
        files = FileService.list(dirPath, "");
        show();
    }

    @Override
    public void function(String dirPath, String sort) {
        files = FileService.list(dirPath, sort);
        show();
    }
}
