package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Consulta {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Consulta
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   private Var consulta = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    consulta = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u from User u where u.id = :id"),Var.valueOf("id",Var.valueOf("2B179834-2DA7-46E6-B30B-787AC41E0FF7")));
    consulta = cronapi.list.Operations.getFirst(consulta);
    item = cronapi.json.Operations.getJsonOrMapField(consulta, Var.valueOf("login"));
    System.out.println(item.getObjectAsString());
    return Var.VAR_NULL;
   }
 }.call();
}

}

