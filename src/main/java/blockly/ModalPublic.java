package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ModalPublic {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// ModalPublic
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   public Var call() throws Exception {
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.showModal"), Var.valueOf("modal63944"));
    return Var.VAR_NULL;
   }
 }.call();
}

}

