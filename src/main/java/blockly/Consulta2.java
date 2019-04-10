package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Consulta2 {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// consulta2
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   private Var dado1 = Var.VAR_NULL;
   private Var dado2 = Var.VAR_NULL;

   public Var call() throws Exception {
    dado1 = cronapi.database.Operations.query(Var.valueOf("app.entity.User"),Var.valueOf("select u from User u"));
    System.out.println(dado1.getObjectAsString());
    dado2 = cronapi.database.Operations.query(Var.valueOf("app.entity.Arquivos"),Var.valueOf("select a from Arquivos a"));
    System.out.println(dado2.getObjectAsString());
    return cronapi.map.Operations.createObjectMapWith(Var.valueOf("obj1",dado1) , Var.valueOf("obj2",dado2));
   }
 }.call();
}

}

