package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class PayPal {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// paypal
public static Var paypal() throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;
   private Var token = Var.VAR_NULL;
   private Var objetos = Var.VAR_NULL;
   private Var listapay = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var href = Var.VAR_NULL;
   private Var rel = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(Var.valueOf("Teste 07").getObjectAsString());
    token = cronapi.screen.Operations.getValueOfField(Var.valueOf("params.p1"));
    objetos = cronapi.util.Operations.getURLFromOthers(Var.valueOf("POST"), Var.valueOf("application/json"), Var.valueOf("https://api.sandbox.paypal.com/v2/checkout/orders/"), Var.valueOf("{\"intent\":\"CAPTURE\",\"purchase_units\":[{\"amount\":{\"currency_code\":\"USD\",\"value\":\"1.00\"}}]}"), cronapi.map.Operations.createObjectMapWith(Var.valueOf("Content-Type",Var.valueOf("application/json")) , Var.valueOf("cache-control",Var.valueOf("no-cache")) , Var.valueOf("Authorization",Var.valueOf(Var.valueOf("Bearer ").toString() + token.toString()))), Var.VAR_NULL);
    System.out.println(objetos.getObjectAsString());
    item = cronapi.json.Operations.toJson(objetos);
    listapay = cronapi.json.Operations.getJsonOrMapField(item, Var.valueOf("links"));
    System.out.println(listapay.getObjectAsString());
    for (Iterator it_i = listapay.iterator(); it_i.hasNext();) {
        i = Var.valueOf(it_i.next());
        href = cronapi.json.Operations.getJsonOrMapField(i, Var.valueOf("href"));
        System.out.println(href.getObjectAsString());
        rel = cronapi.json.Operations.getJsonOrMapField(i, Var.valueOf("rel"));
        System.out.println(rel.getObjectAsString());
    } // end for
    return objetos;
   }
 }.call();
}

/**
 */
// Descreva esta função...
public static void Get() throws Exception {
  new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    item = cronapi.util.Operations.getURLFromOthers(Var.valueOf("GET"), Var.valueOf("application/x-www-form-urlencoded"), Var.valueOf("https://api.sandbox.paypal.com/v2/checkout/orders/3CC47190AV997484U"), Var.VAR_NULL, cronapi.map.Operations.createObjectMapWith(Var.valueOf("Content-Type",Var.valueOf("application/json")) , Var.valueOf("cache-control",Var.valueOf("no-cache")) , Var.valueOf("Authorization",Var.valueOf("Bearer A21AAFfcl6Qr35nRqrmzSFrMowrsSbCqS-lT7iONLPnK96M7APAZ-p3A5EiovmIIhSk0driOxfCS3xVVhoUDHCghQbWMZaQ4A"))), Var.VAR_NULL);
    System.out.println(item.getObjectAsString());
   return Var.VAR_NULL;
   }
 }.call();
}

/**
 */
// Descreva esta função...
public static void token() throws Exception {
  new Callable<Var>() {

   private Var item = Var.VAR_NULL;
   private Var token = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(Var.valueOf("Teste 02").getObjectAsString());
    item = cronapi.conversion.Operations.StringToBase64(Var.valueOf("Af4MU2E77LH2BbHa2Ep0H0L-_vXnFvD6qKGKZekj7b_cCMbKWJrz9dASuQ4eL0ObCN2cq377v7DDxNyG:ENsSmkBX7-S2c-LeViXYhdFTtuO2c2pjlz2Jl1HM4PMyykSzpGujMaMOrHjGLPOQmKT_xJx65H3gZd6d"));
    System.out.println(token.getObjectAsString());
    token = cronapi.util.Operations.getURLFromOthers(Var.valueOf("POST"), Var.valueOf("application/x-www-form-urlencoded"), Var.valueOf("https://api.sandbox.paypal.com/v1/oauth2/token?grant_type=client_credentials&undefined="), Var.VAR_NULL, cronapi.map.Operations.createObjectMapWith(Var.valueOf("Authorization",Var.valueOf(Var.valueOf("Basic ").toString() + item.toString()))), Var.VAR_NULL);
    System.out.println(token.getObjectAsString());
    token = cronapi.json.Operations.toJson(token);
    token = cronapi.json.Operations.getJsonOrMapField(token, Var.valueOf("access_token"));
    System.out.println(token.getObjectAsString());
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("params.p1"), token);
   return Var.VAR_NULL;
   }
 }.call();
}

}

