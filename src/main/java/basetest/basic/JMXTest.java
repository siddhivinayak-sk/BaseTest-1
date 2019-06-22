/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basetest.basic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 *
 * @author sandeepkumar
 */
public class JMXTest {
    
    public static void main(String...args) throws MalformedURLException, IOException, MalformedObjectNameException, MBeanException, AttributeNotFoundException, InstanceNotFoundException, ReflectionException {
        Map<String,String[]> env=new HashMap<>();
        String[] data=new String[]{"admin","sk@123456"};  
        env.put(JMXConnector.CREDENTIALS, data);

        // JMX connection
        JMXServiceURL jurl = new JMXServiceURL( "service:jmx:remoting-jmx://127.0.0.1:9999");
        JMXConnector connector = JMXConnectorFactory.connect(jurl, env); 
        MBeanServerConnection connection = connector.getMBeanServerConnection();

        // here, we list all queues in the embedded activeMQ server "default" (do not forget to activate JMX in the active-MQ subsystem, search the doc...)
        ObjectName objn = new ObjectName("org.apache.activemq.artemis:module=Core,type=Server"); 
        String[] queueNames = (String[]) connection.getAttribute(objn, "QueueNames"); 
        for (String qn : queueNames ) {
          System.out.println(qn.toString());
        }

        connector .close();        
    }
    
}
