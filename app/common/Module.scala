package common

import java.time.Clock

import com.google.inject.AbstractModule
import track.{ImpressionRepository, ImpressionRepositoryTrait}

class Module extends AbstractModule {
  override def configure(): Unit = {
    bind(classOf[Clock]).toInstance(Clock.systemUTC())
    bind(classOf[ImpressionRepositoryTrait]).to(classOf[ImpressionRepository]).asEagerSingleton()
  }
}
