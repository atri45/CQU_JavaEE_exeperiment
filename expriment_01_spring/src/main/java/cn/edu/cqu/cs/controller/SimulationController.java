package cn.edu.cqu.cs.controller;

import cn.edu.cqu.cs.entity.*;
import cn.edu.cqu.cs.entity.Class;
import cn.edu.cqu.cs.service.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
public class SimulationController extends BaseController{
    private List<Course> courses = new ArrayList<>();
    private List<Class> classes = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Score> scores = new ArrayList<>();
    private String[] courseName = {"Java", "C/C++", "Python", "Scala"};
    private String[] teacherName = {"Adam", "Alice", "Lucas", "Mike", "Jack", "Elizabeth", "Leo", "Anne"};

    @Override
    public void menu() {
        List<Menu> menuList = new ArrayList<Menu>() {
            {
                add(new Menu("generate data","manage -c simulation/step1"));
                add(new Menu("choose course","manage -c simulation/step2"));
                add(new Menu("generate score","manage -c simulation/step3"));
            }
        };
        System.out.println("******************************************************");
        System.out.println("                  Simulate Teaching");
        System.out.println("******************************************************");
        System.out.format("%-25s %-30s \n", "Function", "Command");
        for(Menu menu : menuList){
            System.out.format("%-25s %-30s \n", menu.getName(), menu.getCommand());
        }
    }

    @Override
    public void function(String functionName) {
        switch (functionName) {
            case "step1" :
                // generate class
                for (int i = 0; i < 4; i++) {
                    courses.add(new Course(i, courseName[i]));
                    classes.add(new Class(i, i, 0, 1));
                }

                // generate teacher
                for (int i = 0; i < 8; i++) {
                    teachers.add(new Teacher(i, teacherName[i], i/2));
                }

                // generate student
                for (int i = 0; i < 80; i++){
                    students.add(new Student(i, "student" + i, (i%2) == 0 ? "male" : "female", 2021));
                }

                System.out.println("Step1 done.");
                break;
            case "step2" :
                List<Integer> nums = Arrays.asList(0, 1, 2, 3);
                for (int i = 0; i < 80; i++){
                    // student randomly choose three courses
                    Collections.shuffle(nums);
                    List<Integer> selectNums = Arrays.asList(nums.get(0), nums.get(1), nums.get(2));
                    students.get(i).setClassId(selectNums);
                    students.get(i).setCourseId(selectNums);

                    // classes add student
                    classes.get(selectNums.get(0)).addStudent();
                    classes.get(selectNums.get(1)).addStudent();
                    classes.get(selectNums.get(2)).addStudent();
                }
                System.out.println("Step2 done.");
                break;
            case "step3" :
                // randomly generate score
                for (int i = 0; i < 80; i++) {
                    for (Integer id : students.get(i).getCourseId()) {
                        scores.add(new Score(i, id, id));
                    }
                }

                // create table and insert data
                StudentService studentService = new StudentService();
                studentService.create();
                for (Student student : students) {
                    studentService.insert(student);
                }

                CourseService courseService = new CourseService();
                courseService.create();
                for (Course course : courses) {
                    courseService.insert(course);
                }

                ClassService classService = new ClassService();
                classService.create();
                for (Class classObj : classes) {
                    classService.insert(classObj);
                }

                TeacherService teacherService = new TeacherService();
                teacherService.create();
                for (Teacher teacher : teachers) {
                    teacherService.insert(teacher);
                }

                ScoreService scoreService = new ScoreService();
                scoreService.create();
                for(Score score : scores) {
                    scoreService.insert(score);
                }

                System.out.println("Step3 done.");
//                // print simulation result
//                for (int i = 0; i < 4; i++) {
//                    System.out.println(courses.get(i).toString());
//                }
//                for (int i = 0; i < 4; i++) {
//                    System.out.println(classes.get(i).toString());
//                }
//                for (int i = 0; i < 8; i++) {
//                    System.out.println(teachers.get(i).toString());
//                }
//                for (int i = 0; i < 80; i++) {
//                    System.out.println(students.get(i).toString());
//                    for (int j = i * 3; j < i * 3 + 3; j++) {
//                        System.out.println(scores.get(j).toString());
//                    }
//                }
                break;
            default:
                System.out.println("Unsupported command: simulation/" + functionName);
                break;
        }
    }
}
