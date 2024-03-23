package cn.edu.cqu.cs;

import cn.edu.cqu.cs.config.AppConfiguration;
import cn.edu.cqu.cs.controller.BaseController;
import cn.edu.cqu.cs.controller.MenuController;
import cn.edu.cqu.cs.controller.QueryController;
import cn.edu.cqu.cs.controller.SimulationController;

import org.apache.commons.cli.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;

public class Main {

    /**
     * Spring容器 , 在 initSpringContainer() 方法中初始化
     */
    private static ApplicationContext container ;

    /**
     * 控制器 Map , 在 initController () 方法中初始化
     */
    private static Map<String, BaseController> controllerMap;

    /**
     * 命令行工具-命令集合, 在initCommandTool() 方法中初始化
     */
    private static Options options;

    /**
     * 命令行工具-命令集合, 在 initCommandTool()方法中初始化
     */
    private static CommandLineParser parser;


    public static void main(String[] args) {

        // 初始化
        init();

        // 显示系统主页
        String command = "manage -c menu";
        String[] arg = command.split(" ");
        executeCommand(arg);

        // 接收指令
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\ncommand>");
            command = scanner.nextLine();
            if (command.equals("exit")) {
                System.out.println("Exit the system.");
                System.exit(0);
            }
            arg = command.split(" ");
            executeCommand(arg);
        }
    }

    /**
     * 系统初始化
     */
    private static void init(){
        initSpringContainer();
        initController();
        initCommandTool();
    }

    /**
     *  初始化 Spring 容器
     */
    public static void initSpringContainer(){
        container = new AnnotationConfigApplicationContext(AppConfiguration.class);
    }

    /**
     * 初始化所有 Controller
     */
    public static void initController(){
        controllerMap = new HashMap<>();
        controllerMap.put("menu", initMenuController());
        controllerMap.put("simulation", initSimulationController());
        controllerMap.put("query", initQueryController());
    }

    /**
     * 初始化 MenuController
     */
    public static MenuController initMenuController(){

        return container.getBean(MenuController.class);
    }

    /**
     * 初始化 SimulationController
     */
    public static SimulationController initSimulationController(){

        return container.getBean(SimulationController.class);
    }

    /**
     * 初始化 QueryController
     */
    public static QueryController initQueryController(){

        return container.getBean(QueryController.class);
    }

    /**
     *  初始化 命令行工具
     */
    public static void initCommandTool(){

        options = new Options();

        Option target = new Option("c", "com", true, "command");
        target.setRequired(false);
        options.addOption(target);

        Option param = new Option("p", "param", true, "parameter");
        param.setRequired(false);
        options.addOption(param);

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
            System.out.println("Unsupported command format.");
        }
    }

    /**
     * 命令请求分发
     *
     * @param commandLine
     */
    private static void dispatcher(CommandLine commandLine){
        BaseController controller = null;
        try {
            String command = commandLine.getOptionValue('c');
            String controllerName = command.split("/")[0];
            controller = controllerMap.get(controllerName);

            assert controller != null;
            if (command.split("/").length > 1) {
                String function = command.split("/")[1];

                // simulation
                if (controllerName.equals("simulation")) {
                    controller.function(function);
                }

                // query
                else {
                    String[] params = commandLine.getOptionValues('p');
                    controller.function(function, params);
                }
            } else {
                controller.menu();
            }
        } catch (RuntimeException e) {
            System.out.println("Unsupported command format.");
        }
    }

}