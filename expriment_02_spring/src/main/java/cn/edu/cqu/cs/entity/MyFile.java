package cn.edu.cqu.cs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyFile {
    private String name;

    private Long size;

    private String time;

    public char getFirstChar() {
        return name.charAt(0);
    }
}
