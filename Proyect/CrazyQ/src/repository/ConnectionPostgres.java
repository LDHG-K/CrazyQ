package repository;

import java.sql.*;

public class ConnectionPostgres {

	private Connection con;
    private String user;
    private String password;
    private Statement stmt;
    private String url;
    private String nombreBD;

    public ConnectionPostgres( String us, String pass){
       user = us;
       password = pass;
       nombreBD  = "CrazyQ";
       conectar();
    }

    public ConnectionPostgres() {
        this("postgres","postgres");
    }

    //Metodo para conectarce a una base de datos
    private void conectar(){
        try{

            Class.forName("org.postgresql.Driver");
        }
        catch(ClassNotFoundException e){
            System.err.println("'conectarAccess()' Error al intentar cargar Driver. "+e.getMessage());
            e.printStackTrace();
        }

        try{
            url="jdbc:postgresql://localhost:5432/"+nombreBD;
            con = DriverManager.getConnection(url,user,password);

            con.setAutoCommit(false);
            System.out.println("Conexion exitosa base de datos PgSql...");
        }catch(Exception e){
            System.out.println("Error al conectarce: "+e);
        }
    }
    
    //Metodo que permite ejecutar una consulta y retorna un objeto ResulSet con
    //los resultados.
    public ResultSet executeQueryStatement(String cad){
        ResultSet res = null;
        try{
            stmt = (Statement) con.createStatement();
            res = stmt.executeQuery(cad);
            System.out.println("Consulta realizada...  ");
        }catch(Exception ex){
            System.out.println("No se pudo efectuar la consulta..." + ex);
        }

        return res;
    }

    //metodo que permite ejecutar una transaccion de insercion o actualizacion
    //o eliminacion
    public boolean executeUpdateStatement(String cad){
        int r = 0;
        try{
            stmt = con.createStatement();
            System.out.println(cad);
            
            r = stmt.executeUpdate(cad);
            System.out.println("Actualizacion realizada...  " + r);
            //con.commit();
            stmt.close();
            return true;
        }catch(Exception ex){
            System.out.println("No se pudo efectuar la grabacion en PGSql por :" + ex);
            return false;
        }
    }

    //Metodo para invocar un procedimiento almacenado
    public void executeProcedure(String cadProc){
        try{

            CallableStatement proc =con.prepareCall("{ call " + cadProc + " }");
            proc.execute();
        }catch (SQLException e)
        {
            System.out.println("Problemas con la invocacion del procedimiento " + cadProc);
        }
    }
    
    
    

    public void devolver(){
        try {
            con.rollback();
        } catch (Exception e) {
        }
    }
    
    public void aceptar(){
        try {
            con.commit();
        } catch (Exception e) {
        }
    }
    
}
