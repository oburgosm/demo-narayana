/*
 * Copyright (c) 2021.  Inditex 
 */
package com.bracso.demo.narayana.config;

import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQXAConnectionFactory;
import org.springframework.boot.jms.XAConnectionFactoryWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class DemoNarayanaConfiguration {

  @Bean
  public ConnectionFactory connectionFactory(XAConnectionFactoryWrapper wrapper) throws Exception {
    ActiveMQXAConnectionFactory activeMQConnectionFactory = new ActiveMQXAConnectionFactory();
    activeMQConnectionFactory.setBrokerURL("vm://localtestbrokerxa?broker.persistent=false");
    return wrapper.wrapConnectionFactory(activeMQConnectionFactory);
  }

  @Bean
  public JmsTemplate jmsTemplate(ConnectionFactory cf) {
    JmsTemplate jmsTemplate = new JmsTemplate();
    jmsTemplate.setConnectionFactory(cf);
    jmsTemplate.setSessionTransacted(false);
    jmsTemplate.setDefaultDestinationName("testQueue");
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    return jmsTemplate;
  }

}
