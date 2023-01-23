import java.util.ArrayList;
import java.util.HashMap;

public abstract class Entradas implements Interface 
{
    private String nombre;
    private String contrasenia;
    private String tipoEntrada;
    private String costoEntrada;
    private final ArrayList<Entradas> listaDeEntradas; 
    private final HashMap<String,Entradas> verificacionEntradasPorContrasenia;
    private final HashMap<String,Entradas> verificacionEntradasPorNombre;
        
    public Entradas(String nom,String con,String tE,String cost){
        nombre = nom;
        contrasenia = con;
        tipoEntrada = tE;
        costoEntrada = cost;
        listaDeEntradas = new ArrayList();
        verificacionEntradasPorContrasenia = new HashMap<>();
        verificacionEntradasPorNombre = new HashMap<>();
    }
    
    public Entradas(){
        listaDeEntradas = new ArrayList();
        verificacionEntradasPorContrasenia = new HashMap<>();
        verificacionEntradasPorNombre = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public String getTipoEntrada() {
        return tipoEntrada;
    }
    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }
    public String getCostoEntrada() {
        return costoEntrada;
    }
    public void setCostoEntrada(String costoEntrada) {
        this.costoEntrada = costoEntrada;
    }
    
    
    public boolean agregarEntradas(Entradas ent)
    {
        if(verificacionEntradasPorContrasenia.containsKey(ent.getContrasenia()) && verificacionEntradasPorNombre.containsKey(ent.getNombre()))
        {
            System.out.println("Ya existe esta Entrada");
            return false;
        }
     
        verificacionEntradasPorContrasenia.put(ent.getContrasenia(), ent);
        verificacionEntradasPorNombre.put(ent.getNombre(), ent);
        listaDeEntradas.add(ent);
        
        return true;
    }
    
    public void agregarEntradas(String nombre,String contrasenia,String tipoEntrada,String costo)
    {
        Entradas ent = new Entradas(nombre,contrasenia,tipoEntrada,costo){};
        this.agregarEntradas(ent);
    }
   
    public void listarEntradas()
    {
        int i;
        for(i = 0; i < listaDeEntradas.size(); i++)
        {
            System.out.println("nombre: "+listaDeEntradas.get(i).getNombre());
            System.out.println("tipo de Entrada: "+listaDeEntradas.get(i).getTipoEntrada());
            System.out.println("costo: "+listaDeEntradas.get(i).getCostoEntrada());
        }
    }
    
    
    public Entradas buscarEntradas(String contrasenia,String nombre)
    {
        if(!verificacionEntradasPorContrasenia.containsKey(contrasenia) && !verificacionEntradasPorNombre.containsKey(nombre))
        {
            return verificacionEntradasPorContrasenia.get(contrasenia);
        }
        return null;
    }
    
    public Entradas eliminarEntradas(String contrasenia,String nombre)
    {
        if(!verificacionEntradasPorContrasenia.containsKey(contrasenia) && !verificacionEntradasPorNombre.containsKey(nombre))
        {
            System.out.println("Esta entrada no existe");
            return null;
        }
        
        Entradas ent = verificacionEntradasPorContrasenia.remove(contrasenia);
        System.out.println("La entrada fue eliminada con exito");
        return ent;
    }
    
    
    public void validarEntrada(String contrasenia,String nombre)
    {
        if(!verificacionEntradasPorContrasenia.containsKey(contrasenia) && !verificacionEntradasPorNombre.containsKey(nombre))
        {
            System.out.println("Esta entrada no existe");
            return;
        }
        Entradas vr = verificacionEntradasPorContrasenia.get(contrasenia);
        System.out.println("Su entrada esta validada");
        System.out.println("Nombre: "+vr.getNombre());
        System.out.println("Tipo de Entrada: "+vr.getTipoEntrada());
        System.out.println("Costo de Entrada: "+vr.getCostoEntrada());
    }

    @Override
    public void listar()
    {
        int i;
        for(i = 0; i < listaDeEntradas.size(); i++)
        {
            System.out.println("nombre: "+listaDeEntradas.get(i).getNombre());
            System.out.println("tipo de Entrada: "+listaDeEntradas.get(i).getTipoEntrada());
            System.out.println("costo: "+listaDeEntradas.get(i).getCostoEntrada());
        }
    }
    
}
