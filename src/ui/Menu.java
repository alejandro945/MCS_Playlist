package ui;
import model.*;
import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private Mcs mcs;

    public Menu(){
       Mcs mcs = new Mcs();
    }
    public void showMenu(){
        System.out.println("MENU: Elija una opcion segun su requerimiento");
        System.out.println("(1) Para crear un nuevo usuario");
        System.out.println("(2) Para crear un nuevo playlist");
        System.out.println("(3) Para crear un nueva cancion");
        System.out.println("(4) Para mostrar los usarios registrados en la aplicacion");
        System.out.println("(5) Para mostrar los playlist registrados en la aplicacion");
        System.out.println("(6) Salir");
    }
    public int readOption(){
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
    public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Gracias por utilizar nuestros servicios");
			break;
		case 1:
			readUser();
			break;
		case 2:
			collector.showAlbums();
			break;
	
		case 3:
			addPhotoInAlbum();
			break;

		case 4:
			editPhotoInAlbum();
			break;
		
		default:
			System.out.println("Error, opción no válida");
		
		}
	}
    private void showMenuUser() {
		int option=0;
		System.out.println(
				"Menu Usuario\n" +
				"(1) Para crear un nuevo usuario\n" +
				"(2) Para crear una cancion e incluirla en el pool\n"+
				"(3) Para eliminar un álbum\n"+
				"(0) Para volver"
				);
		option= sc.nextInt();
		sc.nextLine();
		
		switch(option) {
        case 0:
            showMenu();
		case 1:
			readUser();
			break;
		case 2:
			editAlbum();
			break;
		case 3: 
			deleteAlbum();
			break;
		
		}
		
    }
    public String readUser(){
        System.out.println("Ingrese el apodo del usuario sin espacios");
        String userNickName = sc.nextLine();
        System.out.println("Ingrese la contraseña del usuario");
        String password = sc.nextLine();
        System.out.println("Ingrese la edad del usuario");
        int age = sc.nextInt();
        return addUser(userNickName, password, age);
    }

    public String readSong(){
            String msg="El usuario no existe";
            System.out.println("Ingrese el apodo del usuario que creara la cancion");
            String songOwner = sc.nextLine();
            System.out.println("Ingrese la contraseña del usuario");
            String ownerPassword = sc.nextLine();
            boolean exist = mcs.searchUser(songOwner,ownerPassword);
        if(exist){
            System.out.println("Ingrese el titulo de la cancion");
            String title = sc.nextLine();
            System.out.println("Ingrese el nombre del artista o banda cantautora");
            String artistName = sc.nextLine();
            System.out.println("Ingrese la fecha de lanzamiento");
            String streamingDate = sc.nextLine();
            System.out.println("Ingrese el genero de la cancion");
            Genre genre = sc.nextLine();
            System.out.println("Ingrese la duracion de la cancion");
            int songLength = sc.nextInt();
            return users.addSong(title,artistName,streamingDate,genre,songLength,songOwner,ownerPassword);
        }else{
            return msg;
        }
        }

    
}
