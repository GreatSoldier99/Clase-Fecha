import java.time.LocalDate;

public class Fecha {
    public static final int ENERO = 1;
    public static final int JULIO = 7;
    public static final int AGOSTO = 8;
    public static final int NOVIEMBRE = 11;

    private int anio;
    private int mes;
    private int dia;

    public Fecha() {
        anio = LocalDate.now().getYear();
        mes = LocalDate.now().getMonthValue();
        dia = LocalDate.now().getDayOfMonth();
    }

    public Fecha(int year, int month, int day) {
        anio=year;
        if (month >= 1 && month <= 12)
            mes = month;
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day <= 31)
            dia = day;
        else {
            if ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30)
                dia = day;
            else {
                if (month == 2) {
                    if (year % 4 == 0 && day <= 29)
                        dia = day;
                    else {
                        if (day <= 28)
                            dia = day;
                    }
                }
            }
        }
    }

    public boolean isValid(){
        if(anio == 0 || mes == 0 || dia == 0)
            return false;
        return  true;
    }

    public String format(String formatString) {
        if(isValid())
            return dia + "/" + mes + "/" + anio;
        return "FECHA INVALIDA";
    }

    public boolean esAntes(Fecha fecha){
        boolean band=false;
        if(anio<fecha.anio || (anio==fecha.anio && mes<fecha.mes) || (anio==fecha.anio && mes==fecha.mes && dia<fecha.dia))
            band=true;
        return band;
    }

    public boolean esDespues(Fecha fecha){
        boolean band=false;
        if(anio>fecha.anio || (anio==fecha.anio && mes>fecha.mes) || (anio==fecha.anio && mes==fecha.mes && dia>fecha.dia))
            band=true;
        return band;
    }

    public boolean esMismoDia(Fecha fecha){
        boolean band=false;
        if(mes==fecha.mes)
            band=true;
        return band;
    }

    public void avanzaDias(int dias){
    }

    public void retrocedeDias(int dias){
    }

    public int tiempoTranscurridoEnDias(Fecha fecha){
        int dias=10;
        return dias;
    }

    public int tiempoTranscurridoEnAnios(Fecha fecha){
        int difYears;
        difYears=Math.abs(fecha.anio-anio);
        return difYears;
    }
}