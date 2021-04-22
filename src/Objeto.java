public abstract class Objeto extends Coordenadas_Gps {
private String name;


    public Objeto(double lat, double longi, String reg,String nome) {
        super(lat, longi, reg);
        this.name=nome;
    }
}
