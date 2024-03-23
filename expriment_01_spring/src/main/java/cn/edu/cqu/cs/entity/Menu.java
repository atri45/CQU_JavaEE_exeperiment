package cn.edu.cqu.cs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    // 功能名称，功能命令
    private String name;
    private String command;
}
