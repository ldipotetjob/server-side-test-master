// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ldipotet/envio/borrar/server-side-test-master/conf/routes
// @DATE:Sat Sep 28 00:17:34 BST 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:10
package track.api.javascript {

  // @LINE:10
  class ReverseImpressionApi(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def getCharges: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "track.api.ImpressionApi.getCharges",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "charges"})
        }
      """
    )
  
    // @LINE:14
    def count: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "track.api.ImpressionApi.count",
      """
        function(bidder0,date1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "count/bidder/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("bidder", bidder0)) + "/date/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("date", date1))})
        }
      """
    )
  
    // @LINE:10
    def save: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "track.api.ImpressionApi.save",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "impression"})
        }
      """
    )
  
    // @LINE:13
    def get: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "track.api.ImpressionApi.get",
      """
        function(impressionId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "impression/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("impressionId", impressionId0))})
        }
      """
    )
  
  }


}
