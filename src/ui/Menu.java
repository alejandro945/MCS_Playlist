package ui;

import model.*;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private Mcs mcs;

    public Menu() {
        this.mcs = new Mcs();
    }

    public void showMenu() {
        System.out.println("MENU PRINCIPAL: Elija una opcion segun su requerimiento");
        System.out.println("-------------------------------CREAR-------------------------------");
        System.out.println("(1) Para crear un nuevo usuario");
        System.out.println("(2) Para crear un nuevo playlist");
        System.out.println("(3) Para crear un nueva cancion");
        System.out.println("------------------------------MOSTRAR------------------------------");
        System.out.println("(4) Para mostrar los usarios registrados en la aplicacion");
        System.out.println("(5) Para mostrar las playlist registradas en la aplicacion");
        System.out.println("(6) Para mostrar las canciones registradas en el pool");
        System.out.println("-----------------------------AUXILIARES----------------------------");
        System.out.println("(7) **SUBMENU** Accesos a Playlist");
        System.out.println("-----------------------------SALIR---------------------------------");
        System.out.println("(8) Salir de App");
    }

    
    
    /** 
     * @return int
     */
    public int readOption() {
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    
    /** 
     * @return String
     */
    public String readUser() {
        System.out.println("Ingrese el apodo del usuario sin espacios");
        String userNickName = sc.nextLine();
        System.out.println("Ingrese la contraseña del usuario");
        String password = sc.nextLine();
        System.out.println("Ingrese la edad del usuario");
        int age = sc.nextInt();
        return mcs.addUser(userNickName, password, age);
    }

    
    /** 
     * @return String
     */
    public String readSong() {
        String msg = "El usuario no existe o contrasena incorrecta";
        System.out.println("Ingrese el apodo del usuario que creara la cancion");
        String songOwner = sc.nextLine();
        System.out.println("Ingrese la contrasena del usuario");
        String ownerPassword = sc.nextLine();
        boolean exist = mcs.searchUser(songOwner, ownerPassword);
        if (exist) {
            System.out.println("Ingrese el titulo de la cancion");
            String title = sc.nextLine();
            System.out.println("Ingrese el nombre del artista o banda cantautora");
            String artistName = sc.nextLine();
            System.out.println("Ingrese la fecha de lanzamiento");
            String streamingDate = sc.nextLine();
            System.out.println("Elige una opcion del genero de la cancion\n" + "1-ROCK\n" + "2-HIP HOP\n"
                    + "3-CLASSIC\n" + "4-REGGAE\n" + "5-SALSA\n" + "6-METAL");
            int gne = sc.nextInt();
            Genre genre = null;
            switch (gne) {
                case 1:
                    genre = Genre.ROCK;
                    break;
                case 2:
                    genre = Genre.HIP_HOP;
                    break;
                case 3:
                    genre = Genre.CLASSIC;
                    break;
                case 4:
                    genre = Genre.REGGAE;
                    break;
                case 5:
                    genre = Genre.SALSA;
                    break;
                case 6:
                    genre = Genre.METAL;
                    break;
            }
            System.out.println("Ingrese la duracion de la cancion en segundos");
            int songLength = sc.nextInt();
            return mcs.addSong(title, artistName, streamingDate, songLength, genre, songOwner, ownerPassword);
        } else {
            return msg;
        }
    }

    
    /** 
     * @return String
     */
    public String readPlaylist() {
        System.out.println("Ingrese el nombre de la playlist");
        String playlistName = sc.nextLine();
        System.out.println("Elige una opcion segun el tipo de playlist\n1-Publico\n2-Restringido\n3-Privado");
        int playlistType = sc.nextInt();
        return mcs.addPlaylist(playlistName, playlistType);
    }

    public void showMenuPlaylist() {
        int option = 0;
        System.out.println("PLALIST MENU: Elija una opcion segun su requerimiento");
        System.out.println("-------------------------------ACCIONES-------------------------------");
        System.out.println("(1) Para agregar un usuario a un playlist");
        System.out.println("(2) Para agregar una cancion a un playlist");
        System.out.println("(3) Para agregar una calificacion a un playlist");
        System.out.println("-----------------------LISTAR PARTICULARMENTE--------------------------");
        System.out.println("(4) Para listar los playlist de manera especifica");
        System.out.println("(5) Volver");
        option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println(playlistRegistration());
                break;

            case 2:
                System.out.println(playlistSongs());
                break;
            case 3:
                System.out.println(scoresPlaylist());
                break;
            case 4:
                System.out.println(mcs.showPlaylists());
                break;
            case 5:
                showMenu();
                break;

        }
    }

    
    /** 
     * @return String
     */
    public String playlistRegistration() {
        String msg = "El playlist no existe o nombre incorrecto";
        System.out.println("Ingrese el nombre de la playlist a la cual quieres acceder");
        sc.nextLine();
        String playlistName = sc.nextLine();
        Playlist playExist = mcs.searchPlaylist(playlistName);
        if (playExist != null) {
            if (playExist.getPlaylistType() == 2 || playExist.getPlaylistType() == 3) {
                System.out.println("Ingrese el nombre del usuario a registrar");
                String userNickName = sc.nextLine();
                System.out.println("Ingrese la contrasena del usuario");
                String password = sc.nextLine();
                boolean exist = mcs.searchUser(userNickName, password);
                if (exist) {
                    return mcs.addUserToPlaylist(userNickName, playExist);
                }
            } else {
                String publicPlay = "El playlist es publico por lo tanto no necesitas registrarte";
                return publicPlay;
            }
        }
        return msg;
    }

    
    /** 
     * @return String
     */
    public String playlistSongs() {
        String msg = "El playlist no existe o usuario sin acceso";
        System.out.println("Ingrese el nombre de la playlist a la cual quieres acceder");
        sc.nextLine();
        String playlistName = sc.nextLine();
        Playlist playExist = mcs.searchPlaylist(playlistName);
        if (playExist != null && playExist.getPlaylistType() == 2 || playExist.getPlaylistType() == 3) {
            System.out.println("Ingrese el nombre del usuario con acceso");
            String userNickName = sc.nextLine();
            boolean userExist = mcs.searchPlaylistUser(userNickName, playExist);
            if (userExist) {
                System.out.println("Ingrese el nombre de la cancion a agregar");
                String title = sc.nextLine();
                boolean exist = mcs.searchSong(title);
                if (exist) {
                    return mcs.addSongToPlaylist(title, playExist);
                } else {
                    String nounSong = "No existe la canción mencionada";
                    return nounSong;
                }
            }
        }
        if (playExist != null && playExist.getPlaylistType() == 1) {
            System.out.println("Ingrese el nombre de la cancion a agregar");
            String title = sc.nextLine();
            boolean exist = mcs.searchSong(title);
            if (exist) {
                return mcs.addSongToPlaylist(title, playExist);
            } else {
                String nounSong = "No existe la canción mencionada";
                return nounSong;
            }
        } else {
            return msg;
        }
    }

    
    /** 
     * @return String
     */
    public String scoresPlaylist() {
        String msg = "El playlist no existe o no es publico";
        System.out.println("Ingrese el nombre de la playlist a la cual quieres acceder");
        sc.nextLine();
        String playlistName = sc.nextLine();
        Playlist playExist = mcs.searchPlaylist(playlistName);
        if (playExist != null && playExist.getPlaylistType() == 1) {
            System.out.println("Indicanos en la escala del 1 al 5 que tanto te gusto: " + playExist.getPlaylistName());
            int scores = sc.nextInt();
            return mcs.addScores(scores, playExist);
        }
        return msg;
    }

    
    /** 
     * @param choice
     */
    public void doOperation(int choice) {
        switch (choice) {
            case 1:
                System.out.println(readUser());
                break;

            case 2:
                System.out.println(readPlaylist());
                break;

            case 3:
                System.out.println(readSong());
                break;
            case 4:
                System.out.println(mcs.showUsers());
                break;

            case 5:
                System.out.println(mcs.showGenericPlaylists());
                break;

            case 6:
                System.out.println(mcs.showSongs());
                break;
            case 7:
                showMenuPlaylist();
                break;
            case 8:
                System.out.println("Gracias por utilizar nuestros servicios");
                break;

            default:
                System.out.println("Error, opción no válida");
        }
    }

    public void startProgram() {
        int option;
        do {
            showMenu();
            option = readOption();
            doOperation(option);
        } while (option != 8);
    }

}
