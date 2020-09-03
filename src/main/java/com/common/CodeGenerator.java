package com.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGenerator {

    /**
     * 表名，多个英文逗号分割,直接在这边输入表名
     */
    //private static final String TABLE_NAMES = "";
    private static final String[] TABLE_NAMES =
            new String[]{"me_etc_contract_sign","me_etc_contract_sign_record"};
    //

    /**
     * 模块名称
     */
    private static final String MODULE_NAME = "sign";

    /**
     * 作者
     */
    private static final String AUTHOR = "wangjp";
    /**
     * 文件夹根目录
     */
    private static final String PROJECT_PATH = "D:\\codeG";
    /**
     * 代码生成文件父路径
     */
    private static final String PARENT = "com.wehgc.etc";

    /**
     * 数据库配置
     */
    private static final String URL = "jdbc:mysql://10.1.6.82:3306/mp_etc?useUnicode=true&useSSL=false&characterEncoding=utf8";
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "hczd365";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     * <p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }


    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //自己写个地址  不要生成在项目根目录下
        final String projectPath = PROJECT_PATH;
        //System.getProperty("user.dir");
        gc.setOutputDir(projectPath);
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        //id使用雪花算法生成分布式唯一id主键
        gc.setIdType(IdType.ASSIGN_ID);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        // dsc.setSchemaName("public");
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USER_NAME);
        dsc.setPassword(PASSWORD);
        //类型转化,主要是把tinyint转INTEGER,datetime转DATE
        dsc.setTypeConvert(new MySqlTypeConvert() {
            @Override
            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                //tinyint转换成Boolean
                if (fieldType.toLowerCase().contains("tinyint")) {
                    System.out.println("转换类型：" + fieldType);
                    return DbColumnType.INTEGER;
                }
                return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
            }
        });
        mpg.setDataSource(dsc);

        // 包配置
        final PackageConfig pc = new PackageConfig();
        pc.setModuleName(MODULE_NAME);
        pc.setParent(PARENT);
        mpg.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        String dtoPath = "/ftl/dto.java.ftl";
        String feignPath = "/ftl/feign.java.ftl";
        String feignfallbackPath = "/ftl/feignfallback.java.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //pc.getModuleName()
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String path = projectPath + "/" + pc.getParent() + "/";
                return path.replace(".", "/") + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        //这个DTO 不要就注释
        focList.add(new FileOutConfig(dtoPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //pc.getModuleName()
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String path = projectPath + "/" + pc.getParent() + "/" + "dto" + "/";
                return path.replace(".", "/") + tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA;
            }
        });
        //这个feign 不要就注释
        focList.add(new FileOutConfig(feignPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //pc.getModuleName()
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String path = projectPath + "/" + pc.getParent() + "/" + "feign" + "/" + MODULE_NAME + "/";
                return path.replace(".", "/") + tableInfo.getEntityName() + "Feign" + StringPool.DOT_JAVA;
            }
        });
        //这个feignfallback 不要就注释
        focList.add(new FileOutConfig(feignfallbackPath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //pc.getModuleName()
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                String path = projectPath + "/" + pc.getParent() + "/" + "feign" + "/" + MODULE_NAME + "/" + "fallback" + "/";
                return path.replace(".", "/") + tableInfo.getEntityName() + "FeignFallback" + StringPool.DOT_JAVA;
            }
        });

//        cfg.setFileCreate(new IFileCreate() {
//            @Override
//            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
//                // 判断自定义文件夹是否需要创建
//                checkDir("调用默认方法创建的目录，自定义目录用");
//                if (fileType == FileType.MAPPER) {
//                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
//                    return !new File(filePath).exists();
//                }
//                // 允许生成模板文件
//                return true;
//            }
//       });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        //templateConfig.setEntity("templates/entity2.java");
        templateConfig.setService("ftl/service.java");
        templateConfig.setServiceImpl("ftl/serviceImpl.java");
        templateConfig.setController("ftl/controller.java");
        //templateConfig.setXml(null);

        mpg.setTemplate(templateConfig);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true);
        strategy.setEntitySerialVersionUID(false);
        strategy.setRestControllerStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(true);
        // 公共父类
        // strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        //scanner("表名，多个英文逗号分割").split(",")
        strategy.setInclude(TABLE_NAMES);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
        System.out.println("生成成功!" + projectPath + "\\" + pc.getParent().replace(".", "\\"));
    }

}