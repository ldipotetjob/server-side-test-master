val partialFunction1 : PartialFunction[String,Int] = {
  case "A" => 1
  case "B" => 2
  case "C" => 3
}
val partialFunction2 : PartialFunction[String,Int] = {
  case "D" => 6
  case "E" => 7
  case "F" => 8
}


val npartial: PartialFunction[String,Int] = partialFunction1 orElse partialFunction2

npartial("F")