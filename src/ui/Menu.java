package ui;
import model.*;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private Mcs mcs;

    public Menu(){
       this.mcs = new Mcs();
    }
    public void showMenu(){
        System.out.println("MENU: Elija una opcion segun su requerimiento");
        System.out.println("(1) Para crear un nuevo usuario");
        System.out.println("(2) Para crear un nuevo playlist");
        System.out.println("(3) Para crear un nueva cancion");
        System.out.println("(4) Para mostrar los usarios registrados en la aplicacion");
        System.out.println("(5) Para mostrar las playlist registradas en la aplicacion");
        System.out.println("(6) Para mostrar las canciones registradas en el pool");
        System.out.println("(7) Salir");
    }
    public int readOption(){
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    public String readUser(){
        System.out.println("Ingrese el apodo del usuario sin espacios");
        String userNickName = sc.nextLine();
        System.out.println("Ingrese la contraseña del usuario");
        String password = sc.nextLine();
        System.out.println("Ingrese la edad del usuario");
        int age = sc.nextInt();
        return mcs.addUser(userNickName, password, age);
    }

    public String readSong(){
            String msg="El usuario no existe o contrasena incorrecta";
            System.out.println("Ingrese el apodo del usuario que creara la cancion");
            String songOwner = sc.nextLine();
            System.out.println("Ingrese la contrasena del usuario");
            String ownerPassword = sc.nextLine();
            boolean exist = mcs.searchUser(songOwner,ownerPassword);
        if(exist){
            System.out.println("Ingrese el titulo de la cancion");
            String title = sc.nextLine();
            System.out.println("Ingrese el nombre del artista o banda cantautora");
            String artistName = sc.nextLine();
            System.out.println("Ingrese la fecha de lanzamiento");
            String streamingDate = sc.nextLine();
            System.out.println("Elige una opcion del genero de la cancion\n"+
            "1-ROCK\n"+
            "2-HIP HOP\n"+
            "3-CLASSIC\n"+
            "4-REGGAE\n"+
            "5-SALSA\n"+
            "6-METAL");
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
            return mcs.addSong(title,artistName,streamingDate,songLength,genre,songOwner,ownerPassword);
        }else{
            return msg;
        }
        }
        public String readPlaylist(){
            System.out.println("Ingrese el nombre de la playlist");
            String playlistName = sc.nextLine();
            System.out.println("Elige una opcion segun el tipo de playlist\n1-Publico\n2-Restringido\n3-Privado");
            int playlistType = sc.nextInt();
            return mcs.addPlaylist(playlistName, playlistType);
            }
        public String accessToPlaylist(){
            String msg="El playlist no existe o nombre incorrecto";
            System.out.println("Ingrese el nombre de la playlist a la cual quieres acceder");
            String playlistName = sc.nextLine();
            boolean playExist = mcs.searchPlaylist(playlistName);
            if(playExist){
                int type = mcs.getPlaylist(playlistName);
                switch(type){
                    case 1:
                    System.out.println("Estas en el playlist llamado " + playlistName +" de tipo publico");

                    break;
                    case 2:
                    System.out.println("Estas en el playlist llamado " + playlistName +" de tipo restringido");
                    break;
                    case 3:
                    System.out.println("Estas en el playlist llamado " + playlistName +" de tipo privado");
                    break;
                }
            }else{
            return msg;
            }
        }
    
        public void doOperation(int choice) {
            switch(choice) {
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
            System.out.println(mcs.showPlaylists());
                break;

            case 6:
            System.out.println(mcs.showSongs());
            break;

            case 7:
            System.out.println("Gracias por utilizar nuestros servicios");
            break; 

            default:
                System.out.println("Error, opción no válida");
            }
        }
        public void startProgram(){
            int option;
            do{
                showMenu();
                option = readOption();
                doOperation(option);
            }while(option != 7);
        }

    
}
