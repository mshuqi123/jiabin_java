package com.comics.jiabin.awutils;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.testng.*;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;
import org.testng.xml.XmlSuite;

import java.io.*;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class GenerateReporter implements IReporter {

    private DataBean data = new DataBean();
    private int passed ;
    private int failed ;
    private int skipped ;
    private Template t;
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {

        try {
            // 初始化并取得Velocity引擎
            VelocityEngine ve = new VelocityEngine();
            Properties p = new Properties();
            //虽然不懂为什么这样设置,但结果是好的.可以用了
            p.setProperty("resource.loader", "file");
            p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            ve.init(p);

            VelocityContext context = new VelocityContext();

            for (ISuite suite : suites) {
                Map<String, ISuiteResult> suiteResults = suite.getResults();
                for (ISuiteResult suiteResult : suiteResults.values()) {
                    ReporterData data = new ReporterData();
                    ITestContext testContext = suiteResult.getTestContext();
                    // 把数据填入上下文
                    context.put("overView", data.testContext(testContext));//测试结果汇总信息
                    IResultMap passedTests = testContext.getPassedTests();//测试通过的测试方法
                    IResultMap failedTests = testContext.getFailedTests();//测试失败的测试方法
                    IResultMap skippedTests = testContext.getSkippedTests();//测试跳过的测试方法
                    context.put("pass", data.testResults(passedTests, ITestResult.SUCCESS));
                    context.put("fail", data.testResults(failedTests, ITestResult.FAILURE));
                    context.put("skip", data.testResults(skippedTests, ITestResult.SKIP));
                    passed = passedTests.size();
                    failed = failedTests.size();
                    skipped = skippedTests.size();
                    if(passed ==0 && failed ==0 && skipped !=0){
                        t = ve.getTemplate("overview_skipped.html");
                    }else if (failed ==0 && skipped ==0){
                        t = ve.getTemplate("overview_passed.html");
                    }else if (failed !=0 && passed ==0){
                        {
                        t = ve.getTemplate("overview_failed.html");
                        }
                    }else{
                        t = ve.getTemplate("overview.html");
                    }
                }
            }
            // 输出流
            OutputStream out = new FileOutputStream("report.html");

            Writer writer = new BufferedWriter(new OutputStreamWriter(out, "utf-8"));//解决乱码问题
            // 转换输出
            t.merge(context, writer);
            writer.flush();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}