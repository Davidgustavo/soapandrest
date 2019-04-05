package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Parametro {

public static final int TIMEOUT = 300;

/**
 *
 * @param param_nome
 * @return Var
 */
// parametro
public static Var Passar(Var param_nome) throws Exception {
 return new Callable<Var>() {

   // param
   private Var nome = param_nome;
   // end

   public Var call() throws Exception {
    nome = Var.valueOf("David ");
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"), Var.valueOf("#/home/logged/pay"), cronapi.list.Operations.newList(Var.valueOf("p1",nome),Var.valueOf("p2",Var.valueOf(" Alves"))));
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 */
// Descreva esta função...
public static void obter() throws Exception {
  new Callable<Var>() {

   private Var obter = Var.VAR_NULL;

   public Var call() throws Exception {
    obter = cronapi.screen.Operations.getValueOfField(Var.valueOf("params.p1"));
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), obter);
   return Var.VAR_NULL;
   }
 }.call();
}

}

