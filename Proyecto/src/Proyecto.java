import java.io.*;
/*
   Nombre: Pedro Ignacio Basualto Leon
*/

public class Proyecto 
{
    static FestivalMusical miFestivalM;
    
    public static void main(String[] args) throws IOException 
    {
        miFestivalM = new FestivalMusical(){
            @Override
            public void eliminarDia() {}
            @Override
            public void validarDia() {}
            @Override
            public void validarMes() {}
            @Override
            public void llamadaAeliminarUnDia() {}
            @Override
            public void llamadaAeliminarEntradaDeUnDia() {}
            @Override
            public void llamadaAvalidarEntradaDeUndia() {}
            @Override
            public void llamadaAlistarEntradasDeUnDia() {}
            @Override
            public void llamadaAgregarDiasPorConsola() {}
            @Override
            public void llamadaAllenarDatosDeLosDias() {}
            @Override
            public void llamadaAlistarDias() {}
            @Override
            public void llamadaMoficarDia() {}
        }; 
        
        /*
            este es el menu del programa
        */
       BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
       try
       {    
            do
            {   
                System.out.println("Menu: ");
                System.out.println("0.para salir");
                System.out.println("1.llenar datos en duro");
                System.out.println("2.agregar un dia y entradas para este dia");
                System.out.println("3.listar dias");
                System.out.println("4.listar Entradas de un dia");
                System.out.println("5.verificar una entrada de un dia");
                System.out.println("6.eliminar una entrada");
                System.out.println("7.eliminar un dia");
                System.out.println("8.modificar un dia");
            
                String op = lector.readLine();
                    
            
                if(op.equals("0"))
                {
                    break;
                }
                if(op.equals("1"))
                {
                    llamadaAllenarDatosDeLosDias();
                }
                if(op.equals("2"))
                {
                    llamadaAgregarDiasPorConsola();
                }
                if(op.equals("3"))
                {
                    llamadaAlistarDias();
                }
                if(op.equals("4"))
                {
                    llamadaAlistarEntradasDeUnDia();
                }
                if(op.equals("5"))
                {
                    llamadaAvalidarEntradaDeUndia();
                }
                if(op.equals("6"))
                {
                    llamadaAeliminarEntradaDeUnDia();
                }
                if(op.equals("7"))
                {
                    llamadaAeliminarUnDia();
                }
                if(op.equals("8"))
                {
                    llamadaModificarDia();
                }
            }while(true);
       }
       catch(IOException e)
       {
           System.out.println("tratando problema");
       }
       finally
       {
           System.out.println("Executado siempre");
       }
                
            
       
    }
    /*
        para validar que dia puede existir
       
    */
    public static String validarDia() throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String dia;
        int diaInt;
        System.out.println("Dia");
        dia = lector.readLine();
        diaInt = Integer.parseInt(dia);
            
        if(diaInt > 31 || diaInt < 1)
        {
            while(true)
            {
                System.out.println("ingrese un Dia valido porfavor");
                dia = lector.readLine();
                diaInt = Integer.parseInt(dia);
                if(diaInt <= 31 && diaInt >=1)
                {
                    break;
                }
            }
        }
        
        return dia;
    }
    
    public static String validarMes() throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Mes");
        String mes = lector.readLine();
        int diaInt = Integer.parseInt(mes);
        
        if(diaInt > 12 || diaInt < 1)
        {
            while(true)
            {
                System.out.println("ingrese un Dia valido porfavor");
                mes = lector.readLine();
                diaInt = Integer.parseInt(mes);
                if(diaInt <= 12 && diaInt >=1)
                {
                    break;
                }
            }
        }
        return mes;
    }
    /*
        elimina un dia completo
    */
    public static void llamadaAeliminarUnDia() throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String dia;
        String mes;
        String anio;
        
        System.out.println("Ingrese la fecha del dia que quiere eliminar");
        dia = validarDia();
        mes = validarMes();
        
        System.out.println("Año");
        anio = lector.readLine();
        miFestivalM.eliminarDia(dia,mes,anio);
    }
    /*
        elimina una entrada de un dia
    */
    public static void llamadaAeliminarEntradaDeUnDia() throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String dia;
        String mes;
        String anio;
        
        System.out.println("Ingresar la Fecha del dia en el que se encuentra la persona a la que desea  Eliminar la entrada: ");
        
        dia = validarDia();
        mes = validarMes();
        
        System.out.println("Año");
        anio = lector.readLine();
        miFestivalM.eliminarEntradaDeUnDia(dia,mes,anio);
        
    }
    
    /*
        valida si se puede entrar al festival
    */
    public static void llamadaAvalidarEntradaDeUndia() throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String dia;
        String mes;
        String anio;
        
        System.out.println("Ingresar la Fecha del dia en el que se encuentra la persona a la que desea validar la entrada: ");
        
        dia = validarDia();
        
        mes = validarMes();
        System.out.println("Año");
        anio = lector.readLine();
        
        
        miFestivalM.validarEntradaDeUndia(dia,mes,anio);
        
    }
   /*
        lista las entradas de un dia 
   */
    public static void llamadaAlistarEntradasDeUnDia() throws IOException
    {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String dia;
        String mes;
        String anio;
        
        System.out.println("Ingresar la Fecha del dia que quieres Listar: ");
       
        dia = validarDia();
        
        mes = validarMes();
        System.out.println("Año");
        anio = lector.readLine();
        
        miFestivalM.listarEntradasDeUnDia(dia,mes,anio);
    }
    
    /*
        agrega dias por consola y tambien se pueden agregar entradas si lo desea
    */
    public static void llamadaAgregarDiasPorConsola() throws IOException
    {
       BufferedReader lector = new BufferedReader(new InputStreamReader(System.in)); 
       
       while(true)
       {
            String resp;            
            String diaMain;
            String mesMain;
            String anioMain;
            
            System.out.println("Ingresar la fecha(formato dia,mes,año)");
            
            diaMain = validarDia();
            
            mesMain = validarMes();
            System.out.println("Ingresar el Año");
            anioMain = lector.readLine();
            
            miFestivalM.agregarDiasPorConsola(diaMain, mesMain, anioMain);
            
            System.out.println("Ingresar mas Dias?");
            resp = lector.readLine();
                    
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
       }
    }
    /*
        llenado de datos en duro
    */
    public static void llamadaAllenarDatosDeLosDias()
    {
        Dias dd = new Dias("10","04","2020") {};
       
        dd.agregarEntradas("Juan","pin", "Premium", "2000");
        dd.agregarEntradas("diego","pam","Platea", "1000");
        dd.agregarEntradas("Maria","pum","Premium", "2000");
        
        miFestivalM.agregarDias(dd);
        
        dd = new Dias("11","04","2020") {};
        
        dd.agregarEntradas("Teresa","in", "Premium", "2000");
        dd.agregarEntradas("diego","am","Platea", "1000");
        dd.agregarEntradas("Maria","pu","Premium", "2000");
        miFestivalM.agregarDias(dd);
        
        
        dd = new Dias("12","04","2020") {};
        dd.agregarEntradas("Pedro","ina", "Premium", "2000");
        dd.agregarEntradas("Felipe","ama","Platea", "1000");
        dd.agregarEntradas("Francisco","puma","Premium", "2000");
        miFestivalM.agregarDias(dd);
        
    }
    /*
        lista los dias
    */
    public static void llamadaAlistarDias()
    {
        miFestivalM.listar();
    }
    /*
        modifica un dia (le pasa una nueva fecha y le pasa todo sus datos al nuevo dia que quiere modificar)
    */
    public static void llamadaModificarDia() throws IOException{
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String dia;
        String mes;
        String anio;
        String modDia;
        String modMes;
        String modAnio;
                
        System.out.println("Ingrese la fecha del dia que quiere modificar");
        dia = validarDia();
        mes = validarMes();
        System.out.println("Año");
        anio = lector.readLine();
        
        System.out.println("Ingrese la nueva fecha: ");
        modDia = validarDia();
        modMes = validarMes();
        System.out.println("Año");
        modAnio = lector.readLine();
        
        miFestivalM.modificarDia(dia, mes, anio, modDia, modMes, modAnio);
    }
    
              
}