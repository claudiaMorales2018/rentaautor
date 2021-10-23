package ModeloRauto;

public class ModeloUsuario {

    private int Usuario_Id;
    private String Usuario_Login;
    private String Rol_Id;
    private String Usuario_PWG;
    private int Usuario_Estado;

    public ModeloUsuario() {
    }

    public ModeloUsuario(int Usuario_Id, String Usuario_Login, String Rol_Id, String Usuario_PWG, int Usuario_Estado) {
        this.Usuario_Id = Usuario_Id;
        this.Usuario_Login = Usuario_Login;
        this.Rol_Id = Rol_Id;
        this.Usuario_PWG = Usuario_PWG;
        this.Usuario_Estado = Usuario_Estado;
    }

    public int getUsuario_Id() {
        return Usuario_Id;
    }

    public void setUsuario_Id(int Usuario_Id) {
        this.Usuario_Id = Usuario_Id;
    }

    public String getUsuario_Login() {
        return Usuario_Login;
    }

    public void setUsuario_Login(String Usuario_Login) {
        this.Usuario_Login = Usuario_Login;
    }

    public String getRol_Id() {
        return Rol_Id;
    }

    public void setRol_Id(String Rol_Id) {
        this.Rol_Id = Rol_Id;
    }

    public String getUsuario_PWG() {
        return Usuario_PWG;
    }

    public void setUsuario_PWG(String Usuario_PWG) {
        this.Usuario_PWG = Usuario_PWG;
    }

    public int getUsuario_Estado() {
        return Usuario_Estado;
    }

    public void setUsuario_Estado(int Usuario_Estado) {
        this.Usuario_Estado = Usuario_Estado;
    }

   

   
}
