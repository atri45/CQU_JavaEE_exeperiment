package cn.edu.cqu.cs.controller;

import cn.edu.cqu.cs.CommandTool;
import cn.edu.cqu.cs.entity.BaseEntity;
import cn.edu.cqu.cs.entity.Menu;
import cn.edu.cqu.cs.entity.Student;
import cn.edu.cqu.cs.service.IStudentService;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentController implements BaseController{

    private IStudentService studentService;

    @Override
    public void add() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "");
        jsonObject.put("age", "");
        jsonObject.put("tel", "");
        System.out.println("请输入Student的属性值：");
        Student student = (Student) CommandTool.getSystemInObject(jsonObject, Student.class);
        long id = studentService.add(student);
        System.out.println("添加Student成功, id=" + id);
    }

    @Override
    public void update(long id) {
        System.out.println("更新id=" + id + "的学生， 待完善！");
    }

    @Override
    public void delete(long id) {
        System.out.println("更新id=" + id + "的学生， 待完善！");
    }

    @Override
    public BaseEntity find(long id) {
        return studentService.find(id);
    }



    @Override
    public List<BaseEntity> findAll() {

        List<Student> studentList = studentService.findAll();
        List<BaseEntity> entitys = new ArrayList<>();
        for(Student student: studentList){
            entitys.add(student);
        }
        return entitys;
    }

    @Override
    public long count() {
        return 0;
    }



    /**
     * 展示学生管理模块操作子菜单
     */
    @Override
    public void menu() {

        System.out.println("********************************************");
        System.out.println("                学生管理模块");
        System.out.println("********************************************");
        System.out.format("%6s %6s %30s \n", "序号", "名称", "命令");
        List<Menu> menuList = new ArrayList<Menu>() {
            {
                add(new Menu(1, "添加", "manage -t student/add"));
                add(new Menu(2, "删除","manage -t student/delete -p <args>"));
                add(new Menu(2, "查询","manage -t student/find -p <args>"));
                add(new Menu(2, "更新","manage -t student/update -p <args>"));
                add(new Menu(2, "查询所有","manage -t student/findAll"));
            }
        };
        for(Menu menu : menuList){
            System.out.format("%6s %6s %20s \n", menu.getId(), menu.getName(), menu.getCommand());
        }
    }

    /**
     * 展示给定的students集合
     * @param students
     */
    @Override
    public void view(List<BaseEntity> students){
        System.out.format("-------------------------------------------------------\n");
        System.out.format("|%6s |%6s |%6s |%20s|\n", "Id","姓名", "年龄", "手机号");
        for(BaseEntity entity : students){

            Student student = (Student) entity;
            System.out.format("-------------------------------------------------------\n");
            System.out.format("|%6s |%6s |%6s  |%20s  |\n", student.getId(), student.getName(), student.getAge(), student.getTel());
        }
        System.out.format("-------------------------------------------------------\n");
    }

}
