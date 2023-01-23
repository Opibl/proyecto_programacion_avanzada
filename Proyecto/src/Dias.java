import java.util.*;
import java.io.*;

public class Dias extends Entradas implements Interface{
   
    private String dia;
    private String mes;
    private String anio;
    private ArrayList<Dias> listaDeDias = new ArrayList();
    private HashMap<String,Dias> mapaDeDias = new HashMap();
   
   
    public Dias(String d,String m,String a)
    {
        dia = d;
        mes = m;
        anio = a;
        listaDeDias = new ArrayList();
        mapaDeDias = new HashMap<>();
        
    }
    
    public Dias()
    {
        listaDeDias = new ArrayList();
        mapaDeDias = new HashMap<>();
        
        
    }

    
    public String getDia() {
        return dia;
    }
    public void setDia(String dia) {
        this.dia = dia;
    }
    public String getMes() {
        return mes;
    }
    public void setMes(String mes) {
        this.mes = mes;
    }
    public String getAnio() {
        return anio;
    }
    public void setAnio(String anio) {
        this.anio = anio;
    }
    
    
    public boolean agregarDias(Dias dd)
    {
        if(mapaDeDias.containsKey(dd.getDia()))
        {
            System.out.println("Ya existe este Dia");
            return false;
        }
     
        mapaDeDias.put(dd.getDia(), dd);
        listaDeDias.add(dd);
        
        return true;
    }
    
    public boolean agregarDias(String diaMain,String mesMain,String anioMain)
    {
        Dias dd = new Dias(diaMain,mesMain,anioMain){};
        if(mapaDeDias.containsKey(dd.getDia()))
        {
            System.out.println("Ya existe este Dia");
            return false;
        }
     
        mapaDeDias.put(dd.getDia(), dd);
        listaDeDias.add(dd);
        
        return true;
    }
    
    public void AgregarEntradasAlDia(Dias dd) throws IOException
    {
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String resp;
        int cont = 0;
        while(true)
        {
            String nombreMain;
            String tipoEntradaMain;
            String contraseniaMain;
            String costoMain;
            
            
            if(cont<=0) 
            {
                System.out.println("Desea agregarle Personas al dia");
                resp = lector.readLine();
                cont = 1;
            }
            else
            {
                System.out.println("Desea agregarle mas Personas al dia");
                resp = lector.readLine();
                
            }
            
            if(resp.equals("no")||resp.equals("No")||resp.equals("NO"))
            {
                break;
            }
            else
            {
                while(true)
                {
                    if(resp.equals("si")|| resp.equals("Si")|| resp.equals("SI"))
                    {
                        break;
                    }
                    
                    System.out.println("Ingrese una respuesta valida Porfavor");
                    resp = lector.readLine();
                }  
            }
                            
            System.out.println("Ingrese el nombre");
            nombreMain = lector.readLine();
            System.out.println("Ingrese el tipo de Entrada");
            tipoEntradaMain = lector.readLine();
            System.out.println("Ingrese el costo de la entrada");
            costoMain = lector.readLine();
            System.out.println("Ingrese la contraseña");
            contraseniaMain = lector.readLine();
                    
            dd.agregarEntradas(nombreMain,contraseniaMain,tipoEntradaMain,costoMain);
        }
    }
    
    public void agregarDiasPorConsola(String diaMain,String mesMain,String anioMain) throws IOException
    {
        if(!mapaDeDias.containsKey(diaMain))
            {
                Dias dd = new Dias(diaMain,mesMain,anioMain) {};
                AgregarEntradasAlDia(dd);
                listaDeDias.add(dd);
                mapaDeDias.put(diaMain, dd);
                
            }
            else
            {
                Dias dd = mapaDeDias.get(diaMain);
                AgregarEntradasAlDia(dd);
            }
    }
   
    
    @Override
    public void listar()
    {
        int i;
        System.out.println("Listado de Dias");
        for(i = 0 ; i < listaDeDias.size();i++)
        {
            System.out.println("Dia "+(i+1)+": "+"Fecha: "+listaDeDias.get(i).getDia()+"-"+listaDeDias.get(i).getMes()+"-"+listaDeDias.get(i).getAnio());
        }
    }
    
    public void listar(Dias dd)
    {
        dd.listar();
    }
    
    public void eliminarDia(String dia,String mes,String anio)
    {
        if(!mapaDeDias.containsKey(dia))
        {
            System.out.println("Este dia no existe");
            return;
           
        }
        
        Dias dd = mapaDeDias.remove(dia);
        listaDeDias.remove(dd);
        System.out.println("El dia con fecha: "+dd.getDia()+"-"+dd.getMes()+"-"+dd.getAnio()+" fue eliminado");
    }
    
    public void listarEntradasDeUnDia(String dia,String mes,String anio)
    {
        if(!mapaDeDias.containsKey(dia))
        {
            System.out.println("este dia no existe o no ha sido agregado con anterioridad");
        }
        else
        {
            Dias dd = mapaDeDias.get(dia);
            dd.listarEntradas();
        }
    }
    public void validarEntradaDeUndia(String dia,String mes,String anio) throws IOException
    {
        String nombre;
        String contrasenia;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        
        if(!mapaDeDias.containsKey(dia))
        {
            System.out.println("No existe el Dia");
        }
        else
        {
            Dias dd = mapaDeDias.get(dia);
            System.out.println("Ingrese el nombre a validar:");
            nombre = lector.readLine();
            System.out.println("Ingrese la contraseña");
            contrasenia = lector.readLine();
            dd.validarEntrada(contrasenia, nombre);
            
        }
    }
    
    public void eliminarEntradaDeUnDia(String dia,String mes, String anio) throws IOException
    {
        String nombre;
        String contrasenia;
        
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        if(mapaDeDias.containsKey(dia))
        {
            Dias dd = mapaDeDias.get(dia);
            System.out.println("Ingrese el nombre a validar:");
            nombre = lector.readLine();
            System.out.println("Ingrese la contraseña");
            contrasenia = lector.readLine();
            dd.eliminarEntradas(contrasenia, nombre);
        }
        else
        {
            
            System.out.println("No existe el Dia o no fue agregado con anterioridad");
        }
    }
    
    public void modificarDia(String dia,String mes, String anio,String modDia,String modMes,String modAnio)throws IOException
    {
         if(!mapaDeDias.containsKey(dia))
        {
            System.out.println("Este dia no existe,por lo tanto no puede ser modificado");
            return; 
           
        }
        
        Dias dd = mapaDeDias.remove(dia);
        listaDeDias.remove(dd);
        
        Dias newDD;
        newDD = new Dias(modDia,modMes,modAnio) {};
        agregarDias(newDD.getDia(),newDD.getMes(),newDD.getAnio());
        mapaDeDias.put(newDD.getDia(), dd);
        listaDeDias.add(newDD);
        
        System.out.println("El dia fue modificado con exito");
        System.out.println("El dia con fecha: "+dd.getDia()+"-"+dd.getMes()+"-"+dd.getAnio()+" fue modificado");
        
    }        
    

}