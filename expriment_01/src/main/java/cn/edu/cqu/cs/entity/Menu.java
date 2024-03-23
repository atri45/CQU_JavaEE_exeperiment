package cn.edu.cqu.cs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu implements BaseEntity{
    private long id;
    private String name;
    private String command;
}
