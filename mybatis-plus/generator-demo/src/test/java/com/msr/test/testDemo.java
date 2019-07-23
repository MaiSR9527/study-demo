package com.msr.test;

import org.junit.Test;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 使用MyBatis-Plus的代码生成器
 * 
 * @author maishuren
 * @date 2019/7/8 15:50
 */
public class testDemo {

    @Test
    public void generate() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置 GlobalConfig是mybatis plus.generator.config中的类
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("maishuren");
        gc.setActiveRecord(true);
        gc.setIdType(IdType.AUTO);
        gc.setFileOverride(true);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setOpen(false);// 打开目录
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");// service impl 命名方式
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setUrl("jdbc:mysql:///mp?useUnicode=true&characterEncoding=UTF-8");
        // dsc.setSchemaName("public");
        dataSource.setDriverName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("mai13129761558");
        mpg.setDataSource(dataSource);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // pc.setModuleName(scanner("模块名"));//父包模块名
        pc.setParent("com.msr");// 父包名。// 自定义包路径 如果为空，将下面子包名必须写全部， 否则就只需写子包名
        pc.setEntity("pojo");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");// 设置控制器包名
        pc.setXml("mapper");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true);// 全局代谢命名
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);// 表名下划线转成驼峰
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);// 字段名下划线转驼峰
        strategyConfig.setTablePrefix("tbl_");// 表前缀
        strategyConfig.setInclude("tbl_employee");
        strategyConfig.setEntityLombokModel(true);// 实体类使用lombok
        strategyConfig.setControllerMappingHyphenStyle(true);// 驼峰转连字符
        strategyConfig.setRestControllerStyle(true);// 生成RestController
        mpg.setStrategy(strategyConfig);

        mpg.execute();
    }

}
