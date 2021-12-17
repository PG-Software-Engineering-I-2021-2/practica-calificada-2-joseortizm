abstract public class Student {
    //private String _Nombre;
    //private int _Tipo;
    int _notaBase = 11;
    abstract int Grado();
}

class Pregrado extends  Student{
    private String _Nombre ;
    Pregrado(String nombre){
        this._Nombre =nombre;
    }
    public int Grado(){
        return _notaBase;
    }
}

class Maestria extends  Student{
    private String _Nombre ;
    Maestria(String nombre){
        this._Nombre =nombre;
    }
    public int Grado(){
        return _notaBase + 1;
    }
}

class Doctorado extends  Student{
    private String _Nombre ;
    Doctorado(String nombre){
        this._Nombre =nombre;
    }
    public int Grado(){
        return _notaBase + 2;
    }
}


