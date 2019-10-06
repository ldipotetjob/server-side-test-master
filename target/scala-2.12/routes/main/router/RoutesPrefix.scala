// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ldipotet/envio/borrar/server-side-test-master/conf/routes
// @DATE:Sat Sep 28 00:17:34 BST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
