object Producer extends App {

  import java.util.Properties

  import org.apache.kafka.clients.producer._

  val  props = new Properties()
  props.put("bootstrap.servers", "192.168.99.100:9092")

  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)

  val TOPIC="numtest"

  for(i <- 1 to 10){
    val record = new ProducerRecord(TOPIC, "key", s"hello $i")
    producer.send(record)
  }

  val record = new ProducerRecord(TOPIC, "key", "the end "+new java.util.Date)
  producer.send(record)

  producer.close()
}