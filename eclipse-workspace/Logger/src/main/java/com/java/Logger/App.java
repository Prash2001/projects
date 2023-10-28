package com.java.Logger;


import java.io.File;
import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Hello world!
 *
 */
public class App 
{
  private static final Logger logger = LogManager.getLogger(App.class);
  
    public static void main( String[] args )
    {
//        ConsoleAppender cAppender = new ConsoleAppender();
//        cAppender.setThreshold(Level.ALL);
//        cAppender.setLayout(new PatternLayout("%d [%p|%c|%C{1}] %m%n"));
//        cAppender.activateOptions();
//        logger.getRootLogger().addAppender(cAppender);
        //PropertyConfigurator.configure("log4j.properties");
      //File logFile = new File();
      DOMConfigurator.configure("/Users/prashantjapkar/eclipse-workspace/Logger/src/main/Resources/log4j2.xml"); 
        logger.info("Log Some Info");
        
       /* File logFile = new File();
        Object ctx = LogManager.getContext(false);
        if (ctx instanceof LoggerContext) {
          try (LoggerContext context = (LoggerContext) ctx) {
            Configuration configuration = context.getConfiguration();
            LoggerConfig loggerConfig = configuration.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
            FileAppender fileAppender =
                FileAppender.newBuilder()
                    .setName("file")
                    .setLayout(
                        PatternLayout.newBuilder()
                            .withPattern("[%d][%-5.-5p][%-14.-14c{1}:%4L] %-22.-22M - %m%n")
                            .build())
                    .withFileName(logFile.getCanonicalPath())
                    .build();
            configuration.addAppender(fileAppender);
            loggerConfig.addAppender(fileAppender, Level.ERROR, null);
            context.updateLoggers();
          }*/
        }
}
