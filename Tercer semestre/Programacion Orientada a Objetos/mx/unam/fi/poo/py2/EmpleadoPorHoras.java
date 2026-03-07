package mx.unam.fi.poo.py2;

public class EmpleadoPorHoras extends Empleado {
    private Double salario;
    private Double horas;

    public EmpleadoPorHoras(String nombre, String apellido, String numSeguro, Double salario, Double horas){
        super(nombre, apellido, numSeguro);
        setSalario(salario);
        setHoras(horas);
    }

    public void setSalario(Double salario){
        if(salario < 0){
            System.out.println("Salario inválido. Debe ser mayor o igual a 0.");
            this.salario = 0.0;
        } else {
            this.salario = salario;
        }
    }

    public Double getSalario(){
        return this.salario;
    }

    public void setHoras(Double horas){
        if(horas < 0 || horas > 180){
            System.out.println("Horas inválidas. Deben estar entre 0 y 180.");
            this.horas = 0.0;
        } else {
            this.horas = horas;
        }
    }

    public Double getHoras(){
        return this.horas;
    }

    @Override
    public String toString(){
        return super.toString() + "\nSalario por hora: " + getSalario() + "\nHoras trabajadas: " + getHoras();
    }

    @Override
    public Double ingresos(){
        if(getHoras() <= 40){
            return getSalario() * getHoras();
        } else {
            Double horasExtra = getHoras() - 40;
            return (40 * getSalario()) + (horasExtra * getSalario() * 2);
        }
    }
}