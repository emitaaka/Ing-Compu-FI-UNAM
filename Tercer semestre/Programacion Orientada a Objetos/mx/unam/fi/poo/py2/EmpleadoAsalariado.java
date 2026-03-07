package mx.unam.fi.poo.py2;

public class EmpleadoAsalariado extends Empleado {
    private Double salarioSemanal;

    public EmpleadoAsalariado(String nombre, String apellido, String numSeguro, Double salarioSemanal){
        super(nombre, apellido, numSeguro);
        
        setSalarioSemanal(salarioSemanal);
    }

    public void setSalarioSemanal(Double salarioSemanal){
    if(salarioSemanal < 0){
        System.out.println("Salario inválido. Debe ser mayor o igual a 0.");
        this.salarioSemanal = 0.0;
    } else {
        this.salarioSemanal = salarioSemanal;
    }
}
    public Double getSalarioSemanal(){
        return this.salarioSemanal;  
    }

    @Override
    public String toString(){
        return super.toString() + "\nSalario semanal: " + getSalarioSemanal();
    }

    @Override
    public Double ingresos(){
        return getSalarioSemanal();
    }
}