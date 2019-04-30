import model.Gyventojas;
import repository.GyventojasRepository;
import service.GyventojasService;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;


public class Main {


    MysqlConnector mysqlConnector = new MysqlConnector();
    GyventojasRepository gyventojasRepository =
            new GyventojasRepository(mysqlConnector.getConnection());

    GyventojasService gyventojasService = new GyventojasService(gyventojasRepository);

    /**statinis metodas uzkrauti duomenis
     *
     * @return
     * @throws SQLException
     */
    static List<Gyventojas> uzkrautiDuomenis() throws SQLException {

    Main main = new Main();

    List<Gyventojas> gyventojai = main.gyventojasRepository.findAll();

    return gyventojai;
}

 static Long gyventojaiGatve(String gatve) throws SQLException {
     List<Gyventojas> gyventojai = uzkrautiDuomenis();
     Long counts =
             gyventojai
                     .stream()
                     .filter(e->e.getGatve().equals(gatve))
                     .count();
     return counts;
 }
    public static void main(String[]args) throws Exception {
/**Array listas talpinantis kolekcija Gyventojas
 *
 */
        List<Gyventojas> gyventojai = uzkrautiDuomenis();
        System.out.println(gyventojai);

        /** 4 uzduotis
         *
         */
         gyventojai.sort(
                Comparator.comparing(Gyventojas::getTautybe)
                        .thenComparing(Gyventojas::getGatve)
                        .thenComparing(Gyventojas::getVardas)
                        );
        System.out.println(gyventojai);


        /** 5 uzduotis
         *
         */


        System.out.println(gyventojaiGatve("kalnakasiu"));
    }
}
