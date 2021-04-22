public class Cache extends Coordenadas_Gps {
String dificuldade;
    public Cache(double lat, double longi, String reg,String difi) {
        super(lat, longi, reg);
        this.dificuldade=difi;
        //historico de logs
        //lista de items
        //hisotrico de utilizadores
    }
}
