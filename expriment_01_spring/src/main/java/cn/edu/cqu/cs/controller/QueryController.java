package cn.edu.cqu.cs.controller;

import cn.edu.cqu.cs.entity.Menu;
import cn.edu.cqu.cs.entity.QueryResult;
import cn.edu.cqu.cs.service.QueryService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
public class QueryController extends BaseController{
    @Override
    public void menu() {
        List<Menu> menuList = new ArrayList<Menu>() {
            {
                add(new Menu("query single student's score","manage -c query/student -p <studentId>"));
                add(new Menu("query all students' score","manage -c query/allstudent"));
                add(new Menu("query single course's score","manage -c query/course -p <courseId> -p <order rule>"));
                add(new Menu("query all courses' score","manage -c query/allcourse -p <order rule>"));
                add(new Menu("query single class's score","manage -c query/class -p <classId> -p <order rule>"));
                add(new Menu("query all classes' score","manage -c query/allclass -p <order rule>"));
            }
        };
        System.out.println("****************************************************************************************");
        System.out.println("                                    Query Score");
        System.out.println("****************************************************************************************");
        System.out.format("%-35s %-30s \n", "Function", "Command");
        for(Menu menu : menuList){
            System.out.format("%-35s %-30s \n", menu.getName(), menu.getCommand());
        }
        System.out.println("ps: ( order rule: 1 -> studentId; 2 -> comprehensiveScore )");
    }

    @Override
    public void function(String functionName, String[] params) {
        QueryService queryService = new QueryService();
        switch (functionName) {
            case "student" :
                viewStudents(queryService.queryStudents(Integer.parseInt(params[0])));
                break;
            case "allstudent" :
                viewStudents(queryService.queryStudents(-1));
                break;
            case "course" :
                viewCourses(queryService.queryCourses(Integer.parseInt(params[0]), Integer.parseInt(params[1])));
                break;
            case "allcourse" :
                viewCourses(queryService.queryCourses(-1, Integer.parseInt(params[0])));
                break;
            case "class" :
                viewClasses(queryService.queryClasses(Integer.parseInt(params[0]), Integer.parseInt(params[1])));
                break;
            case "allclass" :
                viewClasses(queryService.queryClasses(-1, Integer.parseInt(params[0])));
                break;
            default:
                System.out.println("Unsupported command: query/" + functionName + "-p" + params);
                break;
        }
    }

    public void viewStudents(List<QueryResult> queryResults){
        if (!queryResults.isEmpty()) {
            System.out.format("--------------------------------------------------------------------------------------------------\n");
            System.out.format("|%-9s| %-7s |%-6s|%-12s|%-8s|%-17s|%-10s|%-18s|\n", "StudentId", "Student", "Course", "RegularScore", "MidScore", "ExperimentalScore", "FinalScore", "ComprehensiveScore");
            System.out.format("--------------------------------------------------------------------------------------------------\n");
            for (QueryResult queryResult : queryResults) {
                System.out.format("| %-7s |%-9s|%-6s| %-10s | %-6s | %-15s | %-8s | %-16s |\n", queryResult.getStudentId(), queryResult.getStudentName(), queryResult.getCourseName(), queryResult.getRegularScore(), queryResult.getMidScore(), queryResult.getExperimentalScore(), queryResult.getFinalScore(), queryResult.getComprehensiveScore());
                System.out.format("--------------------------------------------------------------------------------------------------\n");
            }
        }
        else {
            System.out.println("Query result is null.");
        }
    }

    public void viewCourses(List<QueryResult> queryResults){
        if (!queryResults.isEmpty()) {
            System.out.format("--------------------------------------------------------------------------------------------------\n");
            System.out.format("|%-9s|%-6s| %-7s |%-12s|%-8s|%-17s|%-10s|%-18s|\n", "CourseId", "Course", "Student", "RegularScore", "MidScore", "ExperimentalScore", "FinalScore", "ComprehensiveScore");
            System.out.format("--------------------------------------------------------------------------------------------------\n");
            for (QueryResult queryResult : queryResults) {
                System.out.format("| %-7s |%-6s|%-9s| %-10s | %-6s | %-15s | %-8s | %-16s |\n", queryResult.getCourseId(), queryResult.getCourseName(), queryResult.getStudentName(), queryResult.getRegularScore(), queryResult.getMidScore(), queryResult.getExperimentalScore(), queryResult.getFinalScore(), queryResult.getComprehensiveScore());
                System.out.format("--------------------------------------------------------------------------------------------------\n");
            }
        }
        else {
            System.out.println("Query result is null.");
        }
    }

    public void viewClasses(List<QueryResult> queryResults){
        if (!queryResults.isEmpty()) {
            System.out.format("--------------------------------------------------------------------------------------------------\n");
            System.out.format("|%-9s|%-6s| %-7s |%-12s|%-8s|%-17s|%-10s|%-18s|\n", "ClassId", "Course", "Student", "RegularScore", "MidScore", "ExperimentalScore", "FinalScore", "ComprehensiveScore");
            System.out.format("--------------------------------------------------------------------------------------------------\n");
            for (QueryResult queryResult : queryResults) {
                System.out.format("| %-7s |%-6s|%-9s| %-10s | %-6s | %-15s | %-8s | %-16s |\n", queryResult.getClassId(), queryResult.getCourseName(), queryResult.getStudentName(), queryResult.getRegularScore(), queryResult.getMidScore(), queryResult.getExperimentalScore(), queryResult.getFinalScore(), queryResult.getComprehensiveScore());
                System.out.format("--------------------------------------------------------------------------------------------------\n");
            }
        }
        else {
            System.out.println("Query result is null.");
        }
    }
}
