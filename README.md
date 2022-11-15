# demo-narayana

This project is for test [narayana-spring-boot-starter](https://github.com/snowdrop/narayana-spring-boot).

There is an issue sending a message to a queue inside a transaction when jms-pooling is enabled

To reproduce it, there are two test classes:

- ApplicationTest: This test send a message to a queue inside a transaction without pooling enabled. It works fine.
- ApplicationPoolingTest: This same test, but enabling jms pooling. The test fail with a `SynchedLocalTransactionFailedException`

