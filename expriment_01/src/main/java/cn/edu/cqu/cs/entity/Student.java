package cn.edu.cqu.cs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data 注解在类，生成 setter and getter、equals、hashCode、toString 等方法，
 * 如为final属性，则不会为该属性生成setter方法。
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements BaseEntity{
    private long id;
    private String name;
    private String age;
    private String tel;

}
