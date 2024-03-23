package cn.edu.cqu.cs;

import cn.edu.cqu.cs.controller.BaseController;
import cn.edu.cqu.cs.controller.MenuController;
import cn.edu.cqu.cs.controller.StudentController;
import cn.edu.cqu.cs.entity.BaseEntity;
import cn.edu.cqu.cs.mapper.IMenuDao;
import cn.edu.cqu.cs.mapper.IStudentDao;
import cn.edu.cqu.cs.mapper.impl.MenuDao;
import cn.edu.cqu.cs.mapper.impl.StudentDao;
import cn.edu.cqu.cs.service.IMenuService;
import cn.edu.cqu.cs.service.IStudentService;
import cn.edu.cqu.cs.service.impl.MenuServiceImpl;
import cn.edu.cqu.cs.service.impl.StudentServiceImpl;
import org.apache.commons.cli.*;

import java.util.*;

public class Main {

    /**
     * 控制器集合 初始化在initController()方法
     */
    private static Map<String, BaseController> controllerMap;

    /**
     * 命令行工具-命令集合
     */
    private static Options options;
    /**
     * 命令行工具-命令解析器
     */
    private static CommandLineParser parser;
    

    public static void main(String[] args) {

        // 初始化
        init();

        Scanner scanner = new Scanner(System.in);
        System.out.println("学生管理系统命令使用方法");
        System.out.println("manage [-m] [-t <arg>] [-p <arg>]\n" +
                " -m,--menu    菜单列表\n" +
                " -p,--param <arg>    请求参数\n" +
                " -t,--target <arg>   请求路径");

        System.out.println("quit, 退出");

        String command = "manage -m";

        // 执行显示系统主菜单
        String[] arg = command.split(" ");
        executeCommand(arg);

        while(!command.equals("quit")){
            System.out.println("请输入命令：");
            command = scanner.nextLine();
            if(command.contains("  ")){
                System.out.println("输入命令中不能包含两个空格！");
                break;
            }
            arg = command.split(" ");
            executeCommand(arg);
        }
    }

    /**
     * 系统初始化
     */
    private static void init(){
        initController();
        initCommandTool();
    }

    /**
     * 初始化控制器
     */
    public static void initController(){

        controllerMap = new HashMap<>();
        controllerMap.put("student", initStudentController());
        controllerMap.put("menu", initMenuController());
    }

    /**
     * 初始化 MenuController
     */
    public static MenuController initMenuController(){

        IMenuDao menuDao = new MenuDao();
        IMenuService menuService = new MenuServiceImpl(menuDao);
        return new MenuController(menuService);
    }

    /**
     * 初始化 StudentController
     */
    public static StudentController initStudentController(){

        IStudentDao studentDao = new StudentDao();
        IStudentService studentService = new StudentServiceImpl(studentDao);
        return new StudentController(studentService);
    }

    /**
     *  初始化 命令行工具
     */
    public static void initCommandTool(){

        options = new Options();

        Option target = new Option("t", "target", true, "请求路径");
        target.setRequired(false);
        options.addOption(target);

        Option param = new Option("p", "param", true, "请求参数");
        param.setRequired(false);
        options.addOption(param);

        Option menu = new Option("m", "menu", false, "菜单列表");
        param.setRequired(false);
        options.addOption(menu);

        parser = new DefaultParser();
    }

    /**
     * 执行命令
     * @param args
     */
    public static void executeCommand(String[] args)  {

        HelpFormatter hf = new HelpFormatter();
        hf.setWidth(110);
        try {
            CommandLine commandLine = parser.parse(options, args);
            dispatcher(commandLine);
        }
        catch (ParseException e) {
            hf.printHelp("manage", options, true);
        }
    }

    /**
     * 命令请求分发
     *
     * @param commandLine
     */
    private static void dispatcher(CommandLine commandLine){

        BaseController controller = null;

        if(commandLine.hasOption("menu")){

            controller = controllerMap.get("menu");
            List<BaseEntity> entitys = controller.findAll();

            controller.view(entitys);

            return;
        }

        String path = commandLine.getOptionValue('t');
        String [] params = path.split("/");
        String controllerName = params[0];
        controller = controllerMap.get(controllerName);

        assert controller != null;
        if(params.length > 1){
            String functionName = params[1];
            if(functionName.equals("add")){

                controller.add();

                List<BaseEntity> entitys = controller.findAll();
                controller.view(entitys);

            }else if(functionName.equals("delete")){
                String paramValue = commandLine.getOptionValue('p');
                long id = Long.parseLong(paramValue);
                controller.delete(id);

                List<BaseEntity> entitys = controller.findAll();
                controller.view(entitys);


            }else if(functionName.equals("find")){
                String paramValue = commandLine.getOptionValue('p');
                long id = Long.parseLong(paramValue);
                BaseEntity entity = controller.find(id);

                List<BaseEntity> entitys = new ArrayList<>();
                entitys.add(entity);
                controller.view(entitys);

            }else if(functionName.equals("update")){

                String paramValue = commandLine.getOptionValue('p');
                long id = Long.parseLong(paramValue);
                controller.update(id);

                List<BaseEntity> entitys = controller.findAll();
                controller.view(entitys);

            }else if(functionName.equals("findAll")){

                List<BaseEntity> entitys = controller.findAll();
                controller.view(entitys);

            }else{

                System.out.println("-t target 路径格式错误！");

            }
        }else{
            controller.menu();
        }
    }

}