package QaracterPractica1;

import java.util.*;

/**
 * Este método se encarga de iniciar la ejecución del programa
 * Éste es el método principal del proyecto
 * Permite al usuario Crear, Editar, Borrar equipos, Mostrar Equipos o Mostrar los Equipos que tengan alguna ECL
 * (métodos que se encuentran en la clase Equipos).
 */

public class MainEquipos {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean confirmacion = false;

        Equipos RealMadrid = new Equipos("Madrid", "España", "Barcelona", "https://pbs.twimg.com/profile_images/1284197749030887429/7n6w-Urk_400x400.jpg");
        Equipos Barcelona = new Equipos("Barcelona", "España", "Madrid", "https://www.pinclipart.com/picdir/big/370-3703211_escudo-fc-barcelona-png-fc-barcelona-escudo-png.png");
        Equipos BayernMunich = new Equipos("Munich", "Alemania", "Dortmund", "https://1.bp.blogspot.com/-um5PXx4iQ2I/XcHguqlUIRI/AAAAAAABWj0/hKJabU4vQzE8QHDo6-bQalZN-45Xdt9rgCLcBGAsYHQ/s1600/FC%2BBayern%2BMunchen.png");
        Equipos BorussiaDortmund = new Equipos("Dortmund", "Alemania", "Munich", "https://a.espncdn.com/i/teamlogos/soccer/500/124.png");
        Equipos ParisSaintGermain = new Equipos("PSG", "Francia", "Lyon", "https://m.media-amazon.com/images/I/61uc8HkaHKL._AC_SL1001_.jpg");
        Equipos OlympiqueDeLyon = new Equipos("Lyon", "Francia", "PSG", "https://www.designfootball.com/images/joomgallery/originals/football_crests_8/olympique_lyonnais_-_logo_concept_20190517_1670321325.png");
        Equipos Liverpool = new Equipos("Liverpool", "Inglaterra", "ManCity", "https://www.logoeps.net/wp-content/uploads/2011/09/liverpool_fc-logo.jpg");

        HashSet listaEquipos = new HashSet();
        listaEquipos.add(RealMadrid);
        listaEquipos.add(Barcelona);
        listaEquipos.add(BayernMunich);
        listaEquipos.add(BorussiaDortmund);
        listaEquipos.add(ParisSaintGermain);
        listaEquipos.add(OlympiqueDeLyon);
        listaEquipos.add(Liverpool);

        ArrayList<String> paises = new ArrayList<>(Arrays.asList("España", "Italia", "Alemania", "Inglaterra", "Francia", "Portugal", "Rusia", "Paises Bajos", "Grecia", "Turquia", "Ucrania", "Belgica", "Escocia", "Suiza", "Noruega", "Rumania", "Republica Checa", "Austria", "Dinamarca", "Suecia", "Croacia", "Israel", "Bielorrusia", "Chipre", "Serbia", "Eslovenia", "Eslovaquia", "Polonia", "Bulgaria", "Hungria", "Finlandia", "Kazajistan", "Azerbaiyan"));
        ArrayList<String> equiposTrofeos = new ArrayList<>(Arrays.asList("Madrid", "Milan", "Liverpool", "Munich", "Barcelona", "Ajax", "Inter", "ManUnited", "Juventus", "Benfica", "Forest", "Porto", "Dortmund", "Celtic", "Chelsea", "Hamburgo", "Marsella", "Steaua", "Aston", "Estrella", "Feyenoord", "Eindhoven"));

        List<Equipos> lista = new ArrayList<Equipos>(listaEquipos);

        System.out.println("¿Desea crear, editar, borrar, mostrar equipos o mostrar trofeos?");
        System.out.println("1: Crear Equipo.");
        System.out.println("2: Editar Equipo.");
        System.out.println("3: Borrar Equipo.");
        System.out.println("4: Mostrar Equipos.");
        System.out.println("5: Mostrar Trofeos de Equipo Elegido.");
        System.out.println("6: Mostrar Todos los Equipos con ECL.");

        int deseo = in.nextInt();
        if (deseo == 1) {
            System.out.println("¿Cuál es el nombre del equipo?");
            String nuevoNombre = in.next();
            for (int i = 0; i < lista.size(); i++) {                        //Comprobar si el nombre ya existe
                if (lista.get(i).getNombre().equals(nuevoNombre)) {
                    confirmacion = true;
                }
            }
            if(confirmacion){
                System.out.println("El equipo ya está registrado.");
            }else {
                System.out.println("¿De qué país es el equipo?");
                String nuevoPais = in.next();
                if (paises.contains(nuevoPais)) {                       //Comprobar si el pais esta en nuestra lista (ver si el equipo puede participar en ECL)
                    System.out.println("¿Cuál es el escudo?");
                    String nuevoEscudo = in.next();
                    System.out.println("¿Quieres añadir el equipo rival histórico?(Selecciona 1 si quieres añadir rival)");
                    int rival = in.nextInt();
                    if (rival == 1) {
                        System.out.println("¿Cuál es el nombre del equipo rival?");
                        String nuevoRival = in.next();
                        listaEquipos.add(new Equipos(nuevoNombre, nuevoPais, nuevoRival, nuevoEscudo));
                    } else {
                        listaEquipos.add(new Equipos(nuevoNombre, nuevoPais, nuevoEscudo));
                    }
                }else {
                    System.out.println("No es posible la creación de dicho equipo.");
                }
            }
        } else if (deseo==2){
            boolean emEncontrado = false;
            System.out.println("¿Qué equipo desea modificar?");
            String equipoModificar = in.next();
            Equipos emElegido = new Equipos();
            for(int i=0;i< lista.size();i++){
                if(lista.get(i).getNombre().equals(equipoModificar)){
                    emEncontrado=true;
                    emElegido=lista.get(i);
                }
            }
            if(emEncontrado) {
                System.out.println("¿Qué atributo desea modificar? Seleccione un número de los siguientes:");
                System.out.println("1: Nombre.");
                System.out.println("2: País.");
                System.out.println("3: Rival Histórico.");
                System.out.println("4: Escudo.");
                int atributoModificar = in.nextInt();
                switch (atributoModificar){
                    case 1:
                        System.out.println("Introduce nuevo nombre.");
                        emElegido.setNombre(in.next());
                        break;
                    case 2:
                        System.out.println("Introduce nuevo país.");
                        emElegido.setPais(in.next());
                        break;
                    case 3:
                        System.out.println("Introduce nuevo rival histórico.");
                        emElegido.setEquipoRivalHistoricamente(in.next());
                        break;
                    case 4:
                        System.out.println("Introduce nuevo escudo.");
                        emElegido.setEscudo(in.next());
                        break;
                    default:
                        System.out.println("¡Atributo no encontrado!");
                        break;

                }
                System.out.println(emElegido);
            }

        } else if(deseo==3){
            System.out.println("Sin eliminar equipo: "+ lista);
            System.out.println("¿Qué equipo desea eliminar?");
            String eliminar = in.next();
            for(int i=0;i< lista.size();i++) {
                if (lista.get(i).getNombre().equals(eliminar)) {
                    lista.remove(lista.get(i));
                }
            }
            System.out.println("Con equipo eliminado: "+ lista);

        }else if(deseo==4){
            for(int i=0; i<lista.size();i++){
                lista.get(i).mostrarTodo();
            }
        }else if(deseo==5){
            Scanner teamChosen = new Scanner(System.in);
            System.out.println("Introduce nombre del equipo: ");
            String equipoElegido = teamChosen.next();

            Equipos e = new Equipos();
            e.trofeos(equipoElegido);
        }else if(deseo==6){
            Equipos eTrofeos = new Equipos();
            for(int i=0;i< equiposTrofeos.size();i++){
                eTrofeos.trofeos(equiposTrofeos.get(i));        //Objeto creado (sin atributos) para acceder a metodo. Uso array list para comprobar cada equipo e imprimir su informacion (lista de equipos con ECL)
            }
        }

    }

}
