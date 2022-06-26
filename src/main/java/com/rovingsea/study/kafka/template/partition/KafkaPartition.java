package com.rovingsea.study.kafka.template.partition;

/**
 * <ol>
 *     <li>指明了partition，直接将partition的值作为分区</li>
 *     <li>没有指明partition，将key的hash值和topic的partition数进行取余</li>
 *     <li>
 *         既没有partition也有没key值，采用黏性分区器，会随机选择一个分区，并尽可能一直使用该分区，待该分区的
 *         batch已满或者已完成，再随机选择一个不同的分区进行使用
 *     </li>
 * </ol>
 * @author Haixin Wu
 * @since 1.0
 */
public class KafkaPartition {
}

