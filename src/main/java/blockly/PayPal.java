package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
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

   public Var call() throws Exception {
    System.out.println(Var.valueOf("Teste 07").getObjectAsString());
    item = cronapi.util.Operations.getURLFromOthers(Var.valueOf("POST"), Var.valueOf("application/json"), Var.valueOf("https://api.sandbox.paypal.com/v2/checkout/orders/"), Var.valueOf("{\"intent\":\"CAPTURE\",\"purchase_units\":[{\"amount\":{\"currency_code\":\"USD\",\"value\":\"1.00\"}}]}"), cronapi.map.Operations.createObjectMapWith(Var.valueOf("Content-Type",Var.valueOf("application/json")) , Var.valueOf("cache-control",Var.valueOf("no-cache")) , Var.valueOf("Authorization",Var.valueOf("Bearer A21AAGyhRBHsilnBaX2cAaolCrehpQL9thgDkfo0uO1ymmN2WpqsYa9vtgQiCe9PTaw76zYzc8vdZF9HfcrKOGoSO4ImnOoQQ"))), Var.VAR_NULL);
    System.out.println(item.getObjectAsString());
    return item;
   }
 }.call();
}

/**
 */
// Descreva esta função...
public static void token() throws Exception {
  new Callable<Var>() {

   private Var token = Var.VAR_NULL;

   public Var call() throws Exception {
    System.out.println(Var.valueOf("Teste 05").getObjectAsString());
    token = cronapi.util.Operations.getURLFromOthers(Var.valueOf("POST"), Var.valueOf("application/x-www-form-urlencoded"), Var.valueOf("https://api.sandbox.paypal.com/v1/oauth2/token"), cronapi.map.Operations.createObjectMapWith(Var.valueOf("grant_type",Var.valueOf("client_credentials"))), Var.VAR_NULL, cronapi.map.Operations.createObjectMapWith(Var.valueOf("Username",Var.valueOf("Af4MU2E77LH2BbHa2Ep0H0L-_vXnFvD6qKGKZekj7b_cCMbKWJrz9dASuQ4eL0ObCN2cq377v7DDxNyG")) , Var.valueOf("Password",Var.valueOf("ENsSmkBX7-S2c-LeViXYhdFTtuO2c2pjlz2Jl1HM4PMyykSzpGujMaMOrHjGLPOQmKT_xJx65H3gZd6d"))));
    System.out.println(token.getObjectAsString());
   return Var.VAR_NULL;
   }
 }.call();
}

}

