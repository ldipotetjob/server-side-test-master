// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ldipotet/envio/borrar/server-side-test-master/conf/routes
// @DATE:Sat Sep 28 00:17:34 BST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:10
  ImpressionApi_0: track.api.ImpressionApi,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:10
    ImpressionApi_0: track.api.ImpressionApi
  ) = this(errorHandler, ImpressionApi_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, ImpressionApi_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """impression""", """track.api.ImpressionApi.save"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """impression/""" + "$" + """impressionId<[^/]+>""", """track.api.ImpressionApi.get(impressionId:Int)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count/bidder/""" + "$" + """bidder<[^/]+>/date/""" + "$" + """date<[^/]+>""", """track.api.ImpressionApi.count(bidder:String, date:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """charges""", """track.api.ImpressionApi.getCharges"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:10
  private[this] lazy val track_api_ImpressionApi_save0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("impression")))
  )
  private[this] lazy val track_api_ImpressionApi_save0_invoker = createInvoker(
    ImpressionApi_0.save,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "track.api.ImpressionApi",
      "save",
      Nil,
      "POST",
      this.prefix + """impression""",
      """ Tracking Impression""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val track_api_ImpressionApi_get1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("impression/"), DynamicPart("impressionId", """[^/]+""",true)))
  )
  private[this] lazy val track_api_ImpressionApi_get1_invoker = createInvoker(
    ImpressionApi_0.get(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "track.api.ImpressionApi",
      "get",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """impression/""" + "$" + """impressionId<[^/]+>""",
      """ Impression Query""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val track_api_ImpressionApi_count2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count/bidder/"), DynamicPart("bidder", """[^/]+""",true), StaticPart("/date/"), DynamicPart("date", """[^/]+""",true)))
  )
  private[this] lazy val track_api_ImpressionApi_count2_invoker = createInvoker(
    ImpressionApi_0.count(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "track.api.ImpressionApi",
      "count",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """count/bidder/""" + "$" + """bidder<[^/]+>/date/""" + "$" + """date<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val track_api_ImpressionApi_getCharges3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("charges")))
  )
  private[this] lazy val track_api_ImpressionApi_getCharges3_invoker = createInvoker(
    ImpressionApi_0.getCharges,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "track.api.ImpressionApi",
      "getCharges",
      Nil,
      "GET",
      this.prefix + """charges""",
      """Charges Query""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:10
    case track_api_ImpressionApi_save0_route(params@_) =>
      call { 
        track_api_ImpressionApi_save0_invoker.call(ImpressionApi_0.save)
      }
  
    // @LINE:13
    case track_api_ImpressionApi_get1_route(params@_) =>
      call(params.fromPath[Int]("impressionId", None)) { (impressionId) =>
        track_api_ImpressionApi_get1_invoker.call(ImpressionApi_0.get(impressionId))
      }
  
    // @LINE:14
    case track_api_ImpressionApi_count2_route(params@_) =>
      call(params.fromPath[String]("bidder", None), params.fromPath[String]("date", None)) { (bidder, date) =>
        track_api_ImpressionApi_count2_invoker.call(ImpressionApi_0.count(bidder, date))
      }
  
    // @LINE:17
    case track_api_ImpressionApi_getCharges3_route(params@_) =>
      call { 
        track_api_ImpressionApi_getCharges3_invoker.call(ImpressionApi_0.getCharges)
      }
  }
}
