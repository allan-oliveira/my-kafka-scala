import java.util

import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

object  Consumer extends App {

  import java.util.Properties

  val TOPIC="numtest"

  val  props = new Properties()
  props.put("bootstrap.servers", "192.168.99.100:9092")

  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("group.id", "my-group")

  val consumer = new KafkaConsumer[String, String](props)

  consumer.subscribe(util.Collections.singletonList(TOPIC))

  while(true){
    val records=consumer.poll(100)
    for (record<-records.asScala){
      println(record)
    }
  }

}
