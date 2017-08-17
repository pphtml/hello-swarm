package com.example;

//import org.apache.openejb.testing.*;

import java.util.Properties;

//@EnableServices(jaxrs = true)
//@Classes(context = "/", cdi = true, value = {NoteResource.class, NoteDAO.class})
//@Descriptors(@Descriptor(name = "persistence.xml", path = "META-INF/persistence.xml"))
public class SampleTomeeHerokuServer {
//    public static void main(final String[] args) throws InterruptedException {
//        if (readUrlJdbc() == null) {
//            System.err.println("Environment variable JDBC_DATABASE_URL not set.");
//        } else {
//            ApplicationComposers.run(SampleTomeeHerokuServer.class, args);
//        }
//    }
//
//    @Configuration
//    public Properties configuration() {
//        final Properties p = new Properties();
//        p.put("myDS", "new://Resource?type=DataSource");
//        p.put("myDS.JdbcDriver", "org.postgresql.Driver");
//        p.put("myDS.JdbcUrl", readUrlJdbc());
//        p.setProperty("httpejbd.port", getServerPort());
//        p.setProperty("httpejbd.bind", "0.0.0.0");
//        return p;
//    }
//
//    private static String readUrlJdbc() {
//        return System.getenv("JDBC_DATABASE_URL");
//    }
//
//    private static String getServerPort() {
//        String port = System.getenv("PORT");
//        return  port != null ? port : "8080";
//    }
}
