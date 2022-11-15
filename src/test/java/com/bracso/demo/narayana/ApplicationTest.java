package com.bracso.demo.narayana;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootTest
class ApplicationTest {

  @Autowired
  private JmsTemplate jmsTemplate;

  @Autowired
  private JtaTransactionManager transactionManager;

  /**
   * Test that we can send a message inside a jta transaction without pooling
   */
  @Test
  void contextLoads() {
    TransactionTemplate transactionTemplate = new TransactionTemplate(this.transactionManager);
    transactionTemplate.executeWithoutResult((status) -> {
      this.jmsTemplate.convertAndSend("OK");
    });
  }

}
