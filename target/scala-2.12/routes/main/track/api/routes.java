// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/ldipotet/envio/borrar/server-side-test-master/conf/routes
// @DATE:Sat Sep 28 00:17:34 BST 2019

package track.api;

import router.RoutesPrefix;

public class routes {
  
  public static final track.api.ReverseImpressionApi ImpressionApi = new track.api.ReverseImpressionApi(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final track.api.javascript.ReverseImpressionApi ImpressionApi = new track.api.javascript.ReverseImpressionApi(RoutesPrefix.byNamePrefix());
  }

}
