package QaracterPractica1;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Equipos {                          //Clase Equipos
    private int id=0;                           //Atributos de Clase Equipos definidos (private)
    private static int contadorid=0;
    private String nombre;
    private String pais;
    private String equipoRivalHistoricamente;
    private String escudo;

    /**
     * Constructor por defecto.
     */

    public Equipos() {                          //Constructor por defecto (vacío)
       contadorid++;
       this.id = contadorid;
    }

    /**
     * Constructor con parámetros obligatorios.
     * @param nombre
     * @param pais
     * @param escudo
     */

    public Equipos(String nombre, String pais, String escudo) {     //Constructor con atributos obligatorios (sin rival histórico)
        contadorid++;
        this.id = contadorid;
        this.nombre = nombre;
        this.pais = pais;
        this.escudo = escudo;
    }

    /**
     * Constructor con todos los parámetros posibles, incluyendo Equipo Rival Históricamente.
     * @param nombre
     * @param pais
     * @param equipoRivalHistoricamente
     * @param escudo
     */

    public Equipos(String nombre, String pais, String equipoRivalHistoricamente, String escudo) {       //Constructor con todos los atributos (incluye rival histórico)
        contadorid++;
        this.id = contadorid;
        this.nombre = nombre;
        this.pais = pais;
        this.equipoRivalHistoricamente = equipoRivalHistoricamente;
        this.escudo = escudo;
    }

    /**
     * Este método muestra los equipos que tienen una ECL, especificando su cantidad y los años en las que fueron conseguidas.
     * @param equipo
     * @return void
     */

    public void trofeos(String equipo){
        switch (equipo){
            case "Madrid":
                System.out.println("Madrid ha ganado 13 Champions Leagues");
                System.out.println("En: 1955/56, 1956/57, 1957/58, 1958/59, 1959/60, 1965/66, 1997/98, 1999/2000, 2001/02, 2013/14, 2015/16, 2016/17, 2017/18.");
                break;
            case "Milan":
                System.out.println("Milan ha ganado 7 Champions Leagues");
                System.out.println("En: 1962/63, 1968/69, 1988/89, 1989/90, 1993/94, 2002/03, 2006/07.");
                break;
            case "Liverpool":
                System.out.println("Liverpool ha ganado 6 Champions Leagues");
                System.out.println("En: 1976/77, 1977/78, 1980/81, 1983/84, 2004/05, 2018/19.");
                break;
            case "Munich":
                System.out.println("Munich ha ganado 6 Champions Leagues");
                System.out.println("En: 1973/74, 1974/75, 1975/76, 2000/01, 2012/13, 2019/20.");
                break;
            case "Barcelona":
                System.out.println("Barcelona ha ganado 5 Champions Leagues");
                System.out.println("En: 1991/92, 2005/06, 2008/09, 2010/11, 2014/15.");
                break;
            case "Ajax":
                System.out.println("Ajax ha ganado 4 Champions Leagues");
                System.out.println("En: 1970/71, 1971/72, 1972/73, 1994/95.");
                break;
            case "Inter":
                System.out.println("Inter ha ganado 3 Champions Leagues");
                System.out.println("En: 1963/64, 1964/65, 2009/10.");
                break;
            case "ManUnited":
                System.out.println("ManUnited ha ganado 3 Champions Leagues");
                System.out.println("En: 1967/68, 1998/99, 2007/08.");
                break;
            case "Juventus":
                System.out.println("Juventus ha ganado 2 Champions Leagues");
                System.out.println("En: 1984/85, 1995/96.");
                break;
            case "Benfica":
                System.out.println("Benfica ha ganado 2 Champions Leagues");
                System.out.println("En: 1960/61, 1961/62.");
                break;
            case "Forest":
                System.out.println("Forest ha ganado 2 Champions Leagues");
                System.out.println("En: 1978/79, 1979/80.");
                break;
            case "Porto":
                System.out.println("Porto ha ganado 2 Champions Leagues");
                System.out.println("En: 1986/87, 2003/04.");
                break;
            case "Dortmund":
                System.out.println("Dortmund ha ganado 1 Champions Leagues");
                System.out.println("En: 1996/97.");
                break;
            case "Celtic":
                System.out.println("Celtic ha ganado 1 Champions Leagues");
                System.out.println("En: 1966/67.");
                break;
            case "Chelsea":
                System.out.println("Chelsea ha ganado 2 Champions Leagues");
                System.out.println("En: 2011/12, 2020/21.");
                break;
            case "Hamburgo":
                System.out.println("Hamburgo ha ganado 1 Champions League");
                System.out.println("En: 1982/83.");
                break;
            case "Marsella":
                System.out.println("Marsella ha ganado 1 Champions League");
                System.out.println("En: 1992/93.");
                break;
            case "Steaua":
                System.out.println("Steaua ha ganado 1 Champions League");
                System.out.println("En: 1985/86.");
                break;
            case "Aston":
                System.out.println("Aston ha ganado 1 Champions League");
                System.out.println("En: 1981/82.");
                break;
            case "Estrella":
                System.out.println("Estrella ha ganado 1 Champions League");
                System.out.println("En: 1990/91.");
                break;
            case "Feyenoord":
                System.out.println("Feyenoord ha ganado 1 Champions League");
                System.out.println("En: 1969/70.");
                break;
            case "Eindhoven":
                System.out.println("Eindhoven ha ganado 1 Champions League");
                System.out.println("En: 1987/88.");
                break;
            default:
                System.out.println("Este equipo no tiene ninguna Champions League :(");
        }
    }

    /**
     * Este método muestra el escudo de los equipos especificados, con la introduccion de un URL (String) donde se muestra dicho escudo.
     * @param escudo
     * @return void
     */

    public void observarEscudo(String escudo){
        Image image = null;
        try {
            URL url = new URL(escudo);
            image = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        JFrame frame = new JFrame();

        JLabel lblimage = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(lblimage, BorderLayout.CENTER);
        frame.setSize(300, 400);
        frame.setVisible(true);
    }

    /**
     * Este método devuelve el id de un equipo determinado.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Este método permite establecer un valor determinado al parámetro id.
     * @param id
     * @return void
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Este método devuelve el nombre de un equipo determinado.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este método permite establecer un valor determinado al parámetro nombre.
     * @param nombre
     * @return void
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este método devuelve el pais de un equipo determinado.
     * @return pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * Este método permite establecer un valor determinado al parámetro pais.
     * @param pais
     * @return void
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Este método devuelve el Equipo Rival Historicamente de un equipo determinado.
     * @return equipoRivalHistoricamente
     */
    public String getEquipoRivalHistoricamente() {
        return equipoRivalHistoricamente;
    }

    /**
     * Este método permite establecer un valor determinado al parámetro equipoRivalHistoricamente.
     * @param equipoRivalHistoricamente
     * @return void
     */
    public void setEquipoRivalHistoricamente(String equipoRivalHistoricamente) {
        this.equipoRivalHistoricamente = equipoRivalHistoricamente;
    }

    /**
     * Este método devuelve el escudo de un equipo determinado.
     * @return escudo
     */
    public String getEscudo() {
        return escudo;
    }

    /**
     * Este método permite establecer un valor determinado al parámetro escudo.
     * @param escudo
     * @return void
     */
    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    /**
     * Este método muestra todos los parámetros del equipo especificado (id, nombre, pais, rival histórico y escudo)
     * @return void
     */
    public void mostrarTodo(){
        System.out.print("ID: " + id + ", Nombre: " + getNombre() + ", País: " + getPais() + ", Rival Histórico: " + getEquipoRivalHistoricamente() + ", Escudo: \n");
        observarEscudo(getEscudo());
    }


}
