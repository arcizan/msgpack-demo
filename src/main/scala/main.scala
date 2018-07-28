import org.msgpack.annotation.Message
import org.msgpack.ScalaMessagePack

object Main extends App {
  @Message // Don't forget to add Message annotation.
  class MyClass1 { // 引数なしのコンストラクタが必要らしい
    var name: String = ""
    var age: Int = 0
    var hobby: String = ""
  }

  @Message
  class MyClass2 {
    var name: String = ""
    var age: Int = 0
    var hobby: Seq[String] = Seq()
  }

  val obj1 = new MyClass1()
  obj1.name = "hoge"
  obj1.age = 22
  obj1.hobby = null

  val obj2 = new MyClass2()
  obj2.name = "huga"
  obj2.age = 33

  val serialized_obj1: Array[Byte] = ScalaMessagePack.write(obj1)
  val serialized_obj2: Array[Byte] = ScalaMessagePack.write(obj2)
  // val deserialized_obj1: MyClass1 = ScalaMessagePack.read[MyClass1](serialized_obj2) // Seq() -> String は MessageTypeException
  val deserialized_obj2: MyClass2 = ScalaMessagePack.read[MyClass2](serialized_obj1) // null -> Seq[String] は OK

  // println(s"name=${deserialized_obj1.name}, age=${deserialized_obj1.age}, hobby=${deserialized_obj1.hobby}")
  println(s"name=${deserialized_obj2.name}, age=${deserialized_obj2.age}")
  deserialized_obj2.hobby.zipWithIndex.foreach { case (x, i) => println(s"hobby($i)=$x") }
}
