package org.superbiz;


import com.example.Note;
import com.example.NoteDAO;
import com.example.NoteResource;
import com.example.Person;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.undertow.WARArchive;

public class SampleWildflySwarmServer {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.net.preferIPv4Stack", "true");
        Container container = new Container();
        container.fraction(new DatasourcesFraction()
                .jdbcDriver("postgresql", (d) -> {
                    d.driverClassName("org.postgresql.Driver");
                    d.xaDatasourceClass("org.postgresql.Driver");
                    d.driverModuleName("org.postgresql");
                })
                .dataSource("ExampleDS", (ds) -> {
                    ds.driverName("postgresql");
//                    ds.connectionUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
                    ds.connectionUrl("jdbc:postgresql://localhost:5432/mydb?user=jozo&password=super123");
//                    ds.userName("sa");
//                    ds.password("sa");
                })
        );
        container.start();
//        Container container = new Container();
//        container.subsystem(new MessagingFraction()
//                .server(
//                        new MessagingServer()
//                                .enableInVmConnector()
//                                .topic("my-topic")
//                                .queue("my-queue")
//                )
//        );
//        // Start the container
//        container.start();

//        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
//        deployment.addResource(Person.class);
//        deployment.addResource(Note.class);
//        deployment.addResource(NoteDAO.class);
//        deployment.addResource(NoteResource.class);
//        container.deploy(deployment);

        WARArchive war = ShrinkWrap.create(WARArchive.class);
        war.addPackages(true, Note.class.getPackage());
        war.addAsWebInfResource(new ClassLoaderAsset("META-INF/persistence.xml", SampleWildflySwarmServer.class.getClassLoader()), "classes/META-INF/persistence.xml");
        war.addAsWebResource(EmptyAsset.INSTANCE, "beans.xml");
        container.deploy(war);
//
//        JaxRsDeployment appDeployment = new JaxRsDeployment();
//        appDeployment.addResource(MyResource.class);
//        // Deploy your JAX-RS app
//        container.deploy(appDeployment);
//        // Create an MSC deployment
//        ServiceDeployment deployment = new ServiceDeployment();
//        deployment.addService(new MyService("/jms/topic/my-topic"));
//        // Deploy the services
//        container.deploy(deployment);
    }
}
