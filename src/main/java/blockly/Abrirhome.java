package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Abrirhome {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// abrirhome
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeView"), Var.valueOf("#/home/public/home"));
    return br.com.mabilis.cronapi.boleto.Operations.gerarRemessa(Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL);
   }
 }.call();
}

}

