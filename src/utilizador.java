public class utilizador extends Person {

    private enum Tipo{BASICO,PREMIUM,ADMIN};
    public utilizador(String idNumber, String name, String address, Date birth,Tipo tipo) {
        super(idNumber, name, address, birth);
        Tipo nome_tipo=tipo;
        //lista de travel bugs
        //hisotrico de caches visitados
        //historico de cachcs escondidos

    }

}
