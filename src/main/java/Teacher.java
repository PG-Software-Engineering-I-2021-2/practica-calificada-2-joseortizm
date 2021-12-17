abstract public  class Teacher {
    int _salarioBaseMensual =2000;
    int _comision = 500;
    int _bonus = 100;
    abstract int Sueldo() ;

}

class ProfesorTP extends  Teacher{
    private String _Nombre ;
    ProfesorTP(String nombre){
        this._Nombre =nombre;
    }
    public int Sueldo(){
        return _salarioBaseMensual;
    }
    public String Name(){
        return _Nombre;
    }
}
class ProfesorTC extends  Teacher{
    private String _Nombre ;
    ProfesorTC(String nombre){
        this._Nombre =nombre;
    }
    public int Sueldo(){
        return _salarioBaseMensual- _comision;
    }
    public String Name(){
        return _Nombre;
    }
}
class Administrativo extends  Teacher{
    private String _Nombre ;
    Administrativo(String nombre){
        this._Nombre =nombre;
    }
    public int Sueldo(){
        return _salarioBaseMensual+ _bonus;
    }
}
