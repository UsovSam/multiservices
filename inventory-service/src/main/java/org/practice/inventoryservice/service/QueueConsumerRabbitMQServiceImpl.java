package org.practice.inventoryservice.service;

import lombok.extern.slf4j.Slf4j;
import org.practice.inventoryservice.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class QueueConsumerRabbitMQServiceImpl implements QueueConsumerService {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void listen(String in) {
        log.info("Message read from myQueue : " + in);
    }

}
