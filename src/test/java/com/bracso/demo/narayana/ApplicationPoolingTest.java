package com.bracso.demo.narayana;

import org.apache.activemq.artemis.junit.EmbeddedActiveMQExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootTest
@ActiveProfiles("pooling")
@ExtendWith(EmbeddedActiveMQExtension.class)
class ApplicationPoolingTest {

  @RegisterExtension
  public EmbeddedActiveMQExtension server = new EmbeddedActiveMQExtension();

  @Autowired
  private JmsTemplate jmsTemplate;

  @Autowired
  private JtaTransactionManager transactionManager;

  /**
   * Test that we can send a message inside a jta transaction with pooling
   */
  @Test
  void testSendMessage() {
    TransactionTemplate transactionTemplate = new TransactionTemplate(this.transactionManager);
    transactionTemplate.executeWithoutResult((status) -> {
      this.jmsTemplate.convertAndSend("OK");
    });
  }

}
