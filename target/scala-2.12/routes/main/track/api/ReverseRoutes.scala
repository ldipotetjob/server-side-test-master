// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ldipotet/envio/borrar/server-side-test-master/conf/routes
// @DATE:Sat Sep 28 00:17:34 BST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:10
package track.api {

  // @LINE:10
  class ReverseImpressionApi(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def getCharges(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "charges")
    }
  
    // @LINE:14
    def count(bidder:String, date:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count/bidder/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("bidder", bidder)) + "/date/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("date", date)))
    }
  
    // @LINE:10
    def save(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "impression")
    }
  
    // @LINE:13
    def get(impressionId:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "impression/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("impressionId", impressionId)))
    }
  
  }


}
