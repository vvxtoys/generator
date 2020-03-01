package org.mybatis.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorUtil.class);
    public void generator() throws Exception {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        String filePath = this.getClass().getResource("/scripts/generatorConfig-test.xml").getPath();
        String workdir = Thread.currentThread().getContextClassLoader().getResource("").getFile();
        String targetProjectPrex = "";
        if(workdir.indexOf("target") != -1){
            targetProjectPrex = workdir.substring(0, workdir.indexOf("target"));
        }
        // 指定 逆向工程配置文件
        File configFile = new File(filePath);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        Context context = config.getContext("testTables");
        context.getJavaModelGeneratorConfiguration().setTargetProject(targetProjectPrex + "src/main/java");
        context.getSqlMapGeneratorConfiguration().setTargetProject(targetProjectPrex + "src/main/resources");
        context.getJavaClientGeneratorConfiguration().setTargetProject(targetProjectPrex + "src/main/java");

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
     }

    public static void main(String[] args) throws Exception {
        try {
            GeneratorUtil generatorSqlmap = new GeneratorUtil();
            generatorSqlmap.generator();
            System.out.println("成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
