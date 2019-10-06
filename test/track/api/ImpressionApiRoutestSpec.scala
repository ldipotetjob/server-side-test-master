package track.api

import akka.stream.Materializer
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.mockito.MockitoSugar
import play.api.inject.bind
import play.api.inject.guice.GuiceApplicationBuilder
import track.{ImpressionRepositoryTrait, MockIMpressionRepository}

//We should test here Routes

class ImpressionApiRoutestSpec extends FlatSpec with Matchers with MockitoSugar{
/***
  val app = new GuiceApplicationBuilder()
    .build()
  implicit lazy val materializer: Materializer = app.materializer


  implicit lazy val app: play.api.Application = new GuiceApplicationBuilder()
    .overrides(bind[ImpressionRepositoryTrait].to[MockIMpressionRepository])
    .build()

  implicit lazy val materializer: Materializer = app.materializer
  // .......
  //............**/
}
